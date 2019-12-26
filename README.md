#进度
##1.前端
1.已有框架的页面，包括登陆(对话框)，注册，首页，个人主页<br>
2.个人主页已进行数据适配<br>
3.注册请求能够正常响应(头像上传并未完成)<br>

##2.后端
1.注册，登陆，获取用户信息的接口完成<br>
2.密码加密功能<br>

#约定
0.前端技术栈 vue + element UI , 后端技术栈，spring boot + mybatis<br>
1.前端访问端口3000，后端访问端口8080，默认地址以/api开始<br>
2.获取数据用GET请求，数据传到服务器用POST请求<br>
3.响应报文格式(responsebo.ResponseEntity.java),Controller采用@RestController注解