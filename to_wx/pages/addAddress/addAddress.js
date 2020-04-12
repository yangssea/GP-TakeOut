// pages/addAddress/addAddress.js
import api from '../../service/findAddservice.js'
import {$wuxForm} from '../../static/lib/index'
import Toast from '../../static/vant/toast/toast'
import util from '../../utils/pattern.js'

Page({
  /**
   * 页面的初始数据
   */
  data: {
      name: '',
      phone: '',
      address: '',
      remark: '',
      latitude: '',
      longitude: '',
      aView: false,
      item: {},
      id: null
  },
  //选择地址
  onChangeAddress() {
    var that = this;
    wx.chooseLocation({
      success: (res) => {
        console.log(res);
        Toast.success('选择成功');
        that.setData({
          latitude: res.latitude,
          longitude : res.longitude,
          address: res.name,
          aView: true
        })
      },
      fail: (err) => {
        Toast.fail('选择失败')
        console.log(err);
      }
    });
   
  },
  //表单提交
  onSubmit() {
    const { getFieldsValue, getFieldValue, setFieldsValue } = $wuxForm()
    const value = getFieldsValue();
    console.log(value);
    value.address=this.data.address;
    value.latitude=this.data.latitude;
    value.longitude=this.data.longitude;
    if(this.data.id!=null){
      value.id=this.data.id;
    }
    value.userId = wx.getStorageSync('userId');
    console.log('Wux Form Submit \n', value);
    if(util.checkPhone(value.phone)&&value.name&&value.address){
      api.save(value).then((success) => {
        Toast.success('添加成功');
        wx.navigateTo({
          url: "/pages/findAdd/findAdd"
        });
      }, (error) => {
        Toast.success('添加失败');
        console.log(error);
      });
    }else{
      Toast.fail("字段不符合规则");
    }
   
  
   

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var data=JSON.parse(options.data);
    if(options.data){
      this.setData({
        id: data.id,
        item: data,
        name: data.name,
        phone:data.phone,
        address: data.address,
        remark: data.remark,
        latitude: data.latitude,
        longitude: data.longitude
      })
    }
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