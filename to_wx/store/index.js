export default {
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    address: '淞泽家园四区东',
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    logs: []
  },
  //无脑全部更新，组件或页面不需要声明 use
  updateAll: true,
  //debug: true
}