//package com.partern.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.partern.utils.HttpHelper;
//import com.partern.utils.JwtToken;
//import com.partern.utils.ResultEnum;
//import com.partern.utils.ResultVO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import sun.net.httpserver.AuthFilter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLDecoder;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//import java.util.Enumeration;
//import java.util.Map;
//
//@WebFilter("/*")
//public class AuthenticationFilter implements Filter {
//
//    private static Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
//
//    private static final String POST = "POST";
//    private static final String GET = "GET";
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        log.info("Auth init -------");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("Auth doFilter -------");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        String uri = httpServletRequest.getRequestURI();
//        //设置放行的页面请求
//        if(uri.contains("login")){
//            //get请求直接放行
//            try {
//                filterChain.doFilter(servletRequest, servletResponse);
//            } catch (Exception e) {
//                log.error("filter 放行doFilter失败 " + e.getMessage());
//            }
//        }else{
//            String reqMethod = httpServletRequest.getMethod();
//            if (POST.equals(reqMethod)) {
//                PrintWriter out = null;
//                HttpServletResponse response = (HttpServletResponse) servletResponse;
//                response.setCharacterEncoding("UTF-8");
//                response.setContentType("application/json; charset=utf-8");
//
//                ServletRequestWrapper wapper = new AuthHttpServletResquestWrapper(httpServletRequest);
//                String body = HttpHelper.getBodyString(wapper);
//
//                //如果是POST请求则需要获取 param 参数
//                String param = null;
//                try {
//                    param = URLDecoder.decode(body, "utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    log.error("fliter 解析POST请求时发生不支持的解码格式" + e.getMessage());
//                }
//                //json串 转换为Map
//                Map<String,Object> map = (Map) JSONObject.parse(param);
//                String token = (String) map.get("token");
//                if(JwtToken.verifyToken(token) != null) {
//                    try {
//                        filterChain.doFilter(wapper, servletResponse);
//                    } catch (Exception e) {
//                        log.error("filter token放行doFilter失败" + e.getMessage());
//                    }
//                } else {
//                    Map<String, Object> result = ResultVO.result(ResultEnum.FAILURE, token, false);
//                    PrintWriter writer = null;
//                    OutputStreamWriter osw = null;
//                    try {
//                        osw = new OutputStreamWriter(response.getOutputStream(),
//                                "UTF-8");
//                    } catch (IOException e) {
//                        log.error("获取OutputStreamm失败" + e.getMessage());
//                    }
//                    writer = new PrintWriter(osw, true);
//                    String jsonStr = JSON.toJSONString(result);
//                    writer.write(jsonStr);
//                    writer.flush();
//                    writer.close();
//                    try {
//                        osw.close();
//                    } catch (IOException e) {
//                        log.error("OutputStreamWriter 关闭失败 : " + e.getMessage());
//                    }
//                }
//
//            }else{
//                //get请求直接放行
//                try {
//                    filterChain.doFilter(servletRequest, servletResponse);
//                } catch (Exception e) {
//                    log.error("filter 放行doFilter失败 " + e.getMessage());
//                }
//            }
//
//        }
//
//
//    }
//
//    @Override
//    public void destroy() {
//        log.info("Auth destroy -------");
//    }
//
//    /**
//     * 从Filter获取post参数时，当请求格式为application/json时，
//     * 当从请求中获取流以后，流被filter中的这个 inputStreamToString(InputStream in) 这个方法处理后就被“消耗”了，
//     * 这会导致，chain.doFilter(request, res)这个链在传递 request对象的时候，
//     * 里面的请求流为空，导致责任链模式下，其他下游的链无法获取请求的body,
//     * 从而导致程序无法正常运行，这也使得我们的这个filter虽然可以获取请求信息，
//     * 但是它会导致整个应用程序不可用，那么它也就失去了意义
//     * 所以需要将取出来的字符串，再次转换成流，然后把它放入到新request 对象中，
//     * 在chain.doFiler方法中 传递新的request对象；要实现这种思路，需要自定义一个类
//     * AuthHttpServletResquestWrapper
//     *
//     * @author MR.ZHANG
//     * @create 2018-08-30 10:49
//     */
//    private class AuthHttpServletResquestWrapper extends HttpServletRequestWrapper {
//
//        private byte[] body = null;
//
//        public AuthHttpServletResquestWrapper(HttpServletRequest request) {
//            super(request);
//            System.out.println("-------------------------------------------------");
//            Enumeration<String> e = request.getHeaderNames();
//            while(e.hasMoreElements()){
//                String name = (String) e.nextElement();
//                String value = request.getHeader(name);
//                System.out.println(name+" = "+value);
//
//            }
//            body = HttpHelper.getBodyString(request).getBytes(Charset.forName("UTF-8"));
//            System.out.println("body="+ body.length);
//
//        }
//        @Override
//        public BufferedReader getReader() throws IOException {
//            return new BufferedReader(new InputStreamReader(getInputStream()));
//        }
//
//        @Override
//        public ServletInputStream getInputStream() throws IOException {
//
//            final ByteArrayInputStream bais = new ByteArrayInputStream(body);
//
//            return new ServletInputStream() {
//                @Override
//                public boolean isFinished() {
//                    return false;
//                }
//
//                @Override
//                public boolean isReady() {
//                    return false;
//                }
//
//                @Override
//                public void setReadListener(ReadListener readListener) {
//
//                }
//
//                @Override
//                public int read() throws IOException {
//                    return bais.read();
//                }
//            };
//        }
//
//        @Override
//        public String getHeader(String name) {
//            return super.getHeader(name);
//        }
//
//        @Override
//        public Enumeration<String> getHeaderNames() {
//            return super.getHeaderNames();
//        }
//
//        @Override
//        public Enumeration<String> getHeaders(String name) {
//            return super.getHeaders(name);
//        }
//    }
//
//}
//
//
