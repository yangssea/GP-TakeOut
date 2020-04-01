// pages/addAddress/addAddress.js
import api from '../../service/findAddservice.js'
import {$wuxForm} from '../../static/lib/index'
import {$wuxToast} from '../../static/lib/index'
Page({

  /**
   * 页面的初始数据
   */
  data: {
      name: '',
      phone: '',
      address: '',
      remarks: '',
      latitude: '',
      longitude: '',
      aView: false,
  },
  //选择地址
  onChangeAddress() {
    var that = this;
    wx.chooseLocation({
      success: (res) => {
        console.log(res);
        that.setData({
          latitude: res.latitude,
          longitude : res.longitude,
          address: res.name,
          aView: true
          
        })
        console.log(that.data.lat)
      },
      fail: (err) => {
        console.log(err);
      }
    });
   
  },
  //表单提交
  onSubmit() {
    const { getFieldsValue, getFieldValue, setFieldsValue } = $wuxForm()
    const value = getFieldsValue();
    value.address=this.data.address;
    value.latitude=this.data.latitude;
    value.longitude=this.data.longitude;
    value.userId = wx.getStorageSync('userId');
    console.log('Wux Form Submit \n', value);
    api.save(value).then((success) => {
      wx.navigateTo({
        url: "/pages/findAdd/findAdd"
      });
    }, (error) => {
      console.log(error);
    });

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