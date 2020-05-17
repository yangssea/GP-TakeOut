import create from '../../utils/create'
import store from '../../store/index'
import Toast from '../../static/vant/toast/toast'
import api from '../../service/indexService.js'
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
    vmore: true,
    page:1,
    lat: 0,
    lng: 0,
    type: 0,
    storeList: [],
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgPath: imgUrl,
    foodType: [{
      imgPath: imgUrl+"s1.png",
      sum:0,
      name: "美食"
    }, {
        imgPath: imgUrl +"s2.png",
        name: "超市便利",
        sum: 0
    }, {
        imgPath: imgUrl +"s3.png",
        name: "水果",
        sum: 0
    }, {
        imgPath: imgUrl +"s4.png",
        sum: 0,
        name: "晚餐"
    }, {
        imgPath: imgUrl +"s5.png",
        sum: 0,
        name: "汉堡披萨"
    }, {
        imgPath: imgUrl +"s6.png",
        sum: 0,
        name: "速食简餐"
    }, {
        imgPath: imgUrl +"s7.png",
        sum: 0,
        name: "买菜"
    }, {
        imgPath: imgUrl +"s8.png",
        sum: 0,
        name: "大牌惠吃"
    }, {
        imgPath: imgUrl +"s9.png",
        sum: 0,
        name: "炸鸡烤串"
    }, {
        imgPath: imgUrl +"s10.png",
        sum: 0,
        name: "包子粥店"
    }],
    storeType: [{
      name: "全部商家"
    }, {
        name: "商家红包"
    }, {
        name: "折扣优惠"
    }, {
        name: "限时满减"
      }, {
        name: "首单优惠"
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
    //定位当前页面位置
    const that = this;
    if(this.store.data.address==''){
      wx.getLocation({
        success: function(res) {
          console.log(res);
          let lat = res.latitude;
          let lng = res.longitude;
          wx.request({
            url: 'https://api.map.baidu.com/reverse_geocoding/v3/?ak=dzYLWMF8oLGLIh4z5fb9N8EejGijf5PM&coordtype=wgs84ll&location=' + res.latitude + ',' + res.longitude + '&output=json',
            method: 'get',
            success: function (res) {
              that.store.set(that.store.data, 'address', res.data.result.formatted_address);
              that.store.set(that.store.data, 'lat', res.data.result.location.lat);
              that.store.set(that.store.data, 'lng', res.data.result.location.lng);
              that.data.lat = res.data.result.longitude;
              //获取商店
              console.log(res.data.result.location.lng)
              api.findAll({ page: 1, type: 0, lat:lat, lng: lng}).then((res) => {
                that.setData({
                  storeList: res.result
                })
              }, (error) => {
                console.log(error);
              });
            }
          })    
        },
      })
    }
  
  },
  //选择商店类型
  storeType:function(event){
    this.data.type = event.currentTarget.dataset.type;
    this.setData({
      type: event.currentTarget.dataset.type
    })
    var that=this;
    api.findAll({ page: 1, type: event.currentTarget.dataset.type, lat:this.store.data.lat,lng: this.store.data.lng}).then((res) => {
      that.setData({
        storeList: res.result
      })
    }, (error) => {
      console.log(error);
    });
  },
  //加载更多
  loadingMore: function() {
    var that = this;
    api.findAll({ page: this.data.page + 1, type: this.data.type, lat: this.store.data.lat, lng: this.store.data.lng}).then((res) => {
      if (res.result.length<10){
        this.data.vmore=false;
        that.setData({
          vmore: this.data.vmore
        })
      }
      that.data.page += 1;
      for (var i = 0; i < res.result.length; i++) {
        this.data.storeList.push(res.result[i])
      }
      that.setData({
        storeList: this.data.storeList
      })
    }, (error) => {
      console.log(error);
    });
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  goLink: function(event){
    var data = JSON.stringify(event.currentTarget.dataset.entity); 
    wx.navigateTo({
      url: "/pages/storeDetail/storeDetail?data="+data
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
