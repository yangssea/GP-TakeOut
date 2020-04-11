import api from '../utils/request.js'
const url = getApp().globalData.url;
//查询商店信息
const findAll = function (data) {
  return api.request(url + 'store/find', data, "get");
}
const findTo = function(data) {
  return api.request(url + 'store/findTo', data, "get");
}
module.exports = {
  findAll,
  findTo
}