import api from '../utils/request.js'
const url = getApp().globalData.url;
//查询商店信息
const find = function (data) {
  return api.request(url + 'goods/find', data, "get");
}
//查询食物类型
const findType = function (data) {
  return api.request(url + 'goods/findType', data, "get");
}
//查询商店评分
const findGrade = function (data) {
  return api.request(url + 'goods/findGrade', data, "get");
}
//查询商店评论列表
const findComment = function (data) {
  return api.request(url + 'goods/findComment', data, "get");
}
module.exports = {
  find,
  findType,
  findGrade,
  findComment
}