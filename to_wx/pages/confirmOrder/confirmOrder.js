// pages/confirmOrder/confirmOrder.js
import { $wuxSelect } from '../../static/lib/index'
import create from '../../utils/create'
import store from '../../store/index'
import api from '../../service/findAddservice.js'
import api2 from '../../service/confirmService.js'
import { $wuxToast } from '../../static/lib/index'
const app = getApp();
create.Page(store, {

  /**
   * 页面的初始数据
   */
  data: {
    imgUrl: app.globalData.imgUrl,
    confirm: false,
    value1: '',
    value2: '',
    orderMsg: {},
    address:"",
    addList: [],
    nameList: [],
    name: '',
    phone: '',
    couList: [],
    couname: [],
    couview: '',
    allPrice: 0.0,
    wareSum: 0,
    cindex: 0,
    remark: ''
  },
  onClick1() {
    var that=this;
    $wuxSelect('#wux-select1').open({
      value: this.data.value1,
      options: this.data.nameList,
      onConfirm: (value, index, options) => {
        that.setData({
          address: value,
          name: that.data.addList[index].name,
          phone:that.data.addList[index].phone
        })
      },
    })
  },
  onclick2() {
    var that = this;
    $wuxSelect('#wux-select2').open({
      value: this.data.value2,
      options: this.data.couname,
      onConfirm: (value, index, options) => {
        var price = this.data.allPrice;
        var allPrice = this.data.orderMsg.price;
        var data=this.data.couList[index];
        if (data.type == 1) {
          if (price >= parseInt(data.start)) {
            allPrice = (price - parseInt(data.end)).toFixed(1);
          }
        } else if (data.type == 2) {
          allPrice = (price * parseFloat(data.discount)).toFixed(1);
        } else if (data.type == 3) {
          if (price >= parseInt(data.start)) {
            allPrice = (price - parseInt(data.end)).toFixed(1);
          }
        } else if (data.type == 4) {
          if (price >= 15) {
            allPrice = (price - 15).toFixed(1);
          } else {
            allPrice = 0.0;
          }
        } else {
          allPrice = price;
        }
        this.setData({
          couview: value,
          allPrice: allPrice,
          cindex:index
        });
      },
    })
  },
  //获取地址列表
  getAddList:function(data){
    var that = this;
    api.findAll(data).then((res) => {
      var data=res.result;
      var list=[];
      for(var i=0;i<data.length;i++){
        list.push(data[i].address);
      }
      that.setData({
        addList: res.result,
        nameList: list,
        name: res.result[0].name,
        phone: res.result[0].phone
      })
      console.log(res.result)
    }, (error) => {
      console.log(error);
    });
  },
  //获取优惠列表
  getCon:function(data,price){
    var that = this;
    var allPrice = price;
    api2.findcou(data).then((res) => {
      for(var i=0;i<res.result.length;i++){
        that.data.couname.push(res.result[i].name)
      }
      var data=res.result[0];
      if(data.type==1){
        if(price>=parseInt(data.start)){
          allPrice = (price - parseInt(data.end)).toFixed(1);
        }
      }else if(data.type==2){
        allPrice=(price*parseFloat(data.discount)).toFixed(1);
      }else if(data.type==3){
        if (price >= parseInt(data.start)){
          allPrice = (price - parseInt(data.end)).toFixed(1);
        }
      }else if(data.type==4){
        if (price >= 15) {
          allPrice = (price - 15).toFixed(1);
        }else{
          allPrice=0.0;
        }
      }else{
        allPrice=price;
      }
      that.setData({
        couList: res.result,
        couname: that.data.couname,
        couview: that.data.couname[0],
        allPrice: allPrice
      })
      console.log(res.result,that.data.couname)
    }, (error) => {
      console.log(error);
    });
  },
  //提交订单
  submitOrder: function(){
    //创建订单对象
    var order={};
    order.list=[];
    var now = new Date();
    var year = now.getFullYear();    
    var month = now.getMonth() + 1;  
    var day = now.getDate();   
    order.orders={
      OrderTime:year+"-"+month+"-"+day+" "+"12:00:00",
      address :this.store.data.address,
      price : this.data.allPrice,
      storeId : this.data.orderMsg. storeMsg.storeDetail.id,
      userId : wx.getStorageSync('userId'),
      riderId : 8,
      wareSum : this.data.wareSum,
      couponstype : this.data.couname[this.data.cindex],
      deliveryFee : this.data.orderMsg.storeMsg.storeDetail.shippingFee,
      couponsMoney : this.data.allPrice - this.data.orderMsg.price,
      remark: this.data.remark
    }
    var odata = this.data.orderMsg.list;
    var that=this;
    for (var i = 0; i < odata.length;i++){
      var goods = {
         OrderId: "0",
         goodsId: odata[i].id,
         priceName: odata[i].name,
         sum : odata[i].sum,
         price: odata[i].price
      };
      order.list.push(goods);
    }
    api2.save(order).then((res) => {
      $wuxToast().show({
        type: 'success',
        duration: 1500,
        color: '#fff',
        text: '支付成功等待配送',
        success: () => {
          that.changeWeb();
          that.pushMsg();
          wx.switchTab({
            url: '/pages/index/index',
          });
        }

      });
      
    }, (error) => {
      console.log(error);
    });
  },
  //websocket
  changeWeb: function () {
    console.log("???")
    let socketOpen = false
    wx.connectSocket({
      url: 'ws://192.168.43.236:8090/orderSocket/socket/21',
      fail: function (e) {
        console.log(e);
      }
    })
    wx.onSocketOpen(function (res) {
      socketOpen = true

    })
    //接收数据
    wx.onSocketMessage(function (data) {
      if (data.data === "连接成功" || data.data == "stock") {
        console.log(data.data);
        return false
      } else {
        console.log(data);
        console.log(data.data);

      }
    })
  },
  //发送请求
  pushMsg: function(){
    let data = {message: "push"};
    api2.push(data).then((res) => {
      console.log(res);
    }, (error) => {
      console.log(error);
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var orderMsg = JSON.parse(options.data);
    orderMsg.price =parseFloat(orderMsg.price)+parseFloat(orderMsg.storeMsg.storeDetail.shippingFee);
    this.setData({
      orderMsg: orderMsg,
      address:this.store.data.address,
    })
    this.getCon({ id: orderMsg.storeMsg.storeDetail.id }, orderMsg.price)
    this.getAddList({id: wx.getStorageSync('userId') });
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