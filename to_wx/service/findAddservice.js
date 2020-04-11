import api from  '../utils/request.js'
const url = getApp().globalData.url;
//查询所有地址
const findAll =function(data){
  return api.request(url + 'userAddress/findAll',data,"get");
}
//保存新增地址
const save = function (data) {
  return api.request(url + 'userAddress/save', JSON.stringify(data), "post", 'application/json');
}
module.exports = {
  findAll,
  save
}