// pages/storeDetail/storeDetail.js
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
     imgUrl: app.globalData.imgUrl,
     a1: true,
     a2: false,
     a3: false,
     aview:true,
     bview: false,
     cview: false
  },
  btn: function(event){
    var index = event.currentTarget.dataset.gid;
    if(index===1){
      this.setData({ a1: true, a2: false, a3: false, aview: true, bview: false, cview: false,});
    }
    if (index === 2) {
      this.setData({ a1: false, a2: true, a3: false, aview: false, bview: true, cview: false});  
    }
    if (index === 3) {
      this.setData({ a1: false, a2: false, a3: true, aview: false, bview: false, cview: true }); 
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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