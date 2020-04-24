//index.js
//获取应用实例
const app = getApp()
//获取图片地址
const imgUrl = app.globalData.imgUrl;
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    imgUrl: imgUrl,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    s1: true,
    s2: false,
    s3: false
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  change(event){
    var id = event.currentTarget.dataset.id;
    if(id==1){
      this.setData({
        s1: true,
        s2: false,
        s3: false
      })
    }else if(id==2){
      this.setData({
        s1: false,
        s2: true,
        s3: false
      })
    }else if(id==3){
      this.setData({
        s1: false,
        s2: false,
        s3: true
      })
    }
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
