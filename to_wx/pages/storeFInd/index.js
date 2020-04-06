// pages/storeFInd/index.js
//获取应用实例
import api from '../../service/indexService.js'
import create from '../../utils/create'
import store from '../../store/index'

const app = getApp();
create.Page(store, {

  /**
   * 页面的初始数据
   */
  data: {
    imgUrl: app.globalData.imgUrl,
    storeList: [],
    page: 1,
    type: 1,
    vmore: true,
    name: ''
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.findTo(1,1,"");
  },
  onConfirm(e) {
    console.log('onConfirm',);
    this.findTo(1, 1, e.detail.value)
  },
  findTo:function(page,type,name){
    let that = this;
    api.findTo({ page: page, type: type, lat: this.store.data.lat, lng: this.store.data.lng,find:name}).then((res) => {
      if (res.result.length < 10) {
        this.data.vmore = false;
        that.setData({
          vmore: this.data.vmore
        })
      }   
      if(page===1){
        that.setData({
          storeList: res.result
        })
      }else if(page>1){
        for(var i=0;i<res.result.length;i++){
          this.data.storeList.push(res.result[i]);
        }
        that.setData({
          storeList: this.data.storeList
        })
      }
    }, (error) => {
      console.log(error);
    });
  },
  findType: function (event){
    this.findTo(this.data.page, event.currentTarget.dataset.type,"");
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  loadingMore:function(){
    this.data.page+=1;
    this.findTo(this.data.page,this.data.type,"");

  },
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