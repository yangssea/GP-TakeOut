import create from '../../utils/create'
import store from '../../store/index'
import Toast from '../../static/vant/toast/toast';
//index.js
//获取应用实例
const app = getApp()
const imgUrl =app.globalData.imgUrl;
create.Page(store, {
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    tviews: true,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgPath: imgUrl,
    foodType: [{
      imgPath: imgUrl+"s1.png",
      name: "美食"
    }, {
        imgPath: imgUrl +"s2.png",
        name: "超市便利"
    }, {
        imgPath: imgUrl +"s3.png",
        name: "水果"
    }, {
        imgPath: imgUrl +"s4.png",
        name: "晚餐"
    }, {
        imgPath: imgUrl +"s5.png",
        name: "汉堡披萨"
    }, {
        imgPath: imgUrl +"s6.png",
        name: "速食简餐"
    }, {
        imgPath: imgUrl +"s7.png",
        name: "买菜"
    }, {
        imgPath: imgUrl +"s8.png",
        name: "大牌惠吃"
    }, {
        imgPath: imgUrl +"s9.png",
        name: "炸鸡烤串"
    }, {
        imgPath: imgUrl +"s10.png",
      name: "包子粥店"
    }],
    storeType: [{
      name: "生活周"
    }, {
        name: "首单立减"
    }, {
        name: "津贴优惠"
    }, {
        name: "满减优惠"
    }]
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    //响应式，自动更新视图
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
    const that = this;
    if(this.store.data.address==''){
      wx.getLocation({
        success: function(res) {
          console.log(res);
          wx.request({
            url: 'https://api.map.baidu.com/reverse_geocoding/v3/?ak=dzYLWMF8oLGLIh4z5fb9N8EejGijf5PM&coordtype=wgs84ll&location=' + res.latitude + ',' + res.longitude + '&output=json',
            method: 'get',
            success: function (res) {
              that.store.set(that.store.data, 'address', res.data.result.formatted_address);
              that.store.set(that.store.data, 'lat', res.data.result.latitude);
              that.store.set(that.store.data, 'lng', res.data.result.longitude);
            }
          })
          
        },
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
  },
  goLink: function(){
    wx.navigateTo({
      url: "/pages/storeDetail/storeDetail"
    });
  }, 
  goLink1:function(){
    wx.navigateTo({
      url: "/pages/storeFInd/index"
    });
  },
  goLink3: function () {
    wx.navigateTo({
      url: "/pages/findAdd/findAdd"
    });
  }
})
