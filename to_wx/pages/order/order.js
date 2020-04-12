// pages/order/order.js
import api from '../../service/orderService.js'
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrl: app.globalData.imgUrl,
    orderList: [],
    height: ''

  },
  goLink: function (event) {
    var index=event.currentTarget.dataset.index;
    var data=JSON.stringify(this.data.orderList[index]);
    wx.navigateTo({
      url: "/pages/oDetail/oDetail?data="+data
    });
  }, 

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    api.findAll({ id: wx.getStorageSync('userId')}).then((res) => {
      var data=res.result;
      for(var i=0;i<data.length;i++){
        var date1 = new Date(data[i].orders.orderTime).toJSON();
        var date = new Date(+new Date(date1) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
        data[i].orders.orderTime=date;
      }
      that.setData({
        orderList: data
      })
      console.log(res.result);
    }, (error) => {
      console.log(error);
    });
    this.setData({
      height: wx.getSystemInfoSync().windowHeight
    })
    console.log(wx.getSystemInfoSync().windowHeight,"高度");
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})