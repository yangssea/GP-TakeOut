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
    s3: false,
    list: [],
    list1: [],
    list2: [],
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
  getAll: function () {
    wx.request({
      url: 'http://192.168.43.236:8090/order/getAll',
      data:{
        id: 0
      },
      success: res=> {
        console.log(res.data)
        let rs = res.data.result;
        this.data.list=[];
        this.data.list1 = [];
        this.data.list2 = [];
        for(var i=0;i<rs.length;i++){
          if (rs[i].orders.status==1){
            this.data.list.push(rs[i])
          }else if (rs[i].orders.status == 2) {
            this.data.list1.push(rs[i])
          }else if (rs[i].orders.status == 3) {
            this.data.list2.push(rs[i])
          }
        }
        this.setData({
          list: this.data.list
        });
        this.setData({
          list1: this.data.list1
        });
        this.setData({
          list2: this.data.list2
        });
      }
    })
  },
  news: function (event) {
    var id = event.currentTarget.dataset.id;
    var st = event.currentTarget.dataset.st;
    wx.request({
      url: 'http://192.168.43.236:8090/order/update?st='+st+'&id='+id+'',
      success: res => {
       console.log("neworder");
        this.socket();
        this.getAll();
      }
    })
  }, 
  socket: function () {
    wx.request({
      url: 'http://192.168.43.236:8090/orderSocket/socket/push/21',
      data: {
        message: "push"
      },
      success: res => {
        console.log("neworder");
      }
    })
  }, 
  onLoad: function () {
    this.getAll();
    //一下为系统代码
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
