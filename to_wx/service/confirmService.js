import api from '../utils/request.js'
const url = getApp().globalData.url;
//查询优惠方式
const findcou = function (data) {
  return api.request(url + 'order/findCou', data, "get");
}
//保存订单
//保存新增地址
const save = function (data) {
  return api.request(url + 'order/save', JSON.stringify(data), "post", 'application/json');
}
//websocket推送
const push = function (data) {
  return api.request(url + 'orderSocket/socket/push/21', data, "get");
}
module.exports = {
  findcou,
  save,
  push
}