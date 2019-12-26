
//解析性别
export function parseSex(sex){
  if(sex==1){
    return "男"
  }else if(sex==2){
    return "女"
  }else{
    return "未知";
  }
}

//解析学历
export function parseEducate(educate){
  switch (educate){
    case 1: return "无"
    case 2: return "小学"
    case 3: return "初中"
    case 4: return "高中"
    case 5: return "本科"
    case 6: return "硕士"
    case 7: return "博士"
    default: return "无"
  }
}

//解析收入
export function parseIncome(income){
  switch (income) {
    case 1: return "5000-";
    case 2: return "5000~10000";
    case 3: return "10000~20000";
    case 4: return "20000~50000";
    case 5: return "50000+";
    case 6: return "X二代";
    default: return "其他";
  }
}

//解析婚姻状况
export function parseMarrage(marrage){
  switch (marrage) {
    case 1: return "未婚";
    case 2: return "已有朋友";
    case 3: return "已婚";
    case 4: return "离异";
    case 5: return "其他";
    default: return "其他";
  }
}

export default{
  parseSex,
  parseEducate,
  parseIncome,
  parseMarrage,
}