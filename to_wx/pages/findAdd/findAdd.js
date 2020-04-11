// pages/findAdd/findAdd.js
import store from '../../store/index'
import create from '../../utils/create'
import api from '../../service/findAddservice.js'

const app = getApp();
create.Page(store, {
  /**
   * 页面的初始数据
   */
  data: {
    address: '',
    imgUrl: app.globalData.imgUrl,
    aList: []
  },
  onChangeAddress() {
    var _page = this;
    wx.chooseLocation({
      success: (res) => {
        console.log(res);
        this.store.set(this.store.data, 'address', res.name);
      },
      fail: (err) => {
        console.log(err);
      }
    });
    wx.switchTab({
      url: "/pages/index/index"
    });
  },
  onChangeAddress1(){
      wx.navigateTo({
        url: "/pages/addAddress/addAddress"
      });
  },
  changeAdd(event){
    console.log(event.currentTarget.dataset.list.address);
    this.store.set(this.store.data, 'address', event.currentTarget.dataset.list.address);
    this.store.set(this.store.data, 'lat', event.currentTarget.dataset.list.latitude);
    this.store.set(this.store.data, 'lng', event.currentTarget.dataset.list.longitude);
    wx.switchTab({
      url: "/pages/index/index"
    });
  },
  freshLocal(){
    console.log('hi测试');
    let that=this;
    wx.getLocation({
      success: function (res) {
        console.log(res);
        wx.request({
          url: 'https://api.map.baidu.com/reverse_geocoding/v3/?ak=dzYLWMF8oLGLIh4z5fb9N8EejGijf5PM&coordtype=wgs84ll&location=' + res.latitude + ',' + res.longitude + '&output=json',
          method: 'get',
          success: function (res) {
            that.store.set(that.store.data, 'address', res.data.result.formatted_address);
            that.store.set(that.store.data, 'lat', res.data.result.latitude);
            that.store.set(that.store.data, 'lng', res.data.result.longitude);
            wx.switchTab({
              url: "/pages/index/index"
            });
          }
        })
      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //查询地址
    let that = this;
    api.findAll({id: wx.getStorageSync('userId')}).then((res) => {
      that.setData({
        aList: res.result
      })
    }, (error) => {
      console.log(error);
    });
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