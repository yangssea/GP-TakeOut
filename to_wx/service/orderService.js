import api from '../utils/request.js'
const url = getApp().globalData.url;
//查询订单
const findAll = function (data) {
  return api.request(url + 'order/findAll', data, "get");
}

module.exports = {
  findAll
}