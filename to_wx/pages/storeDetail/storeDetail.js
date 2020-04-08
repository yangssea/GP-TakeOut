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
     cview: false,
     vtype: 0,
     scrolltop: 0,
     typeList:[{
       name: '第一分类'
     }, {
         name: '第二分类'
     },{
         name: '第三分类'
     }, {
      name: '第四分类'
     }, {
      name: '第五分类'
     }],
     i:0,
     goodsList:[{
       name: '包子',
       type: '1'
    },{
      name: '馒头',
      type: '1'
    }, {
      name: '米粥',
      type: '1'
    },{
      name: '的蛋炒饭',
      type: '1'
    },{
      name: '毛炒饭',
      type: '2'
    },{
      name: '小米粥',
      type: '2'
    }, {
      name: '可乐',
      type: '3'
    }, {
      name: '雪碧',
      type: '3'
    }, {
      name: 'sb',
      type: '3'
    }, {
      name: 'NIIT',
      type: '4'
    }, {
      name: '原子弹',
      type: '4'
    }, {
      name: '氢弹',
      type: '4'
    }],
    glength: [],
    //弹出框
    visible: false,
  },
  onopen: function(){
    this.setData({
      visible: true
    })
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
  //食物滚轮监听
  changeScroll: function (event){
    for(var i=0;i<this.data.glength.length;i++){
      if (event.detail.scrollTop / (80 * this.data.glength[i].sum) >= 1 && event.detail.scrollTop / (80 * this.data.glength[i].sum) <2) {
        this.setData({
          vtype: this.data.glength[i].type
        })
      } 
      if (parseInt(event.detail.scrollTop) -(80 * this.data.glength[0].sum)<=0){
        this.setData({
          vtype: this.data.glength[0].type-1
        })
      }
    }
   
  },
  //点击分类
  clicktype:function(event){
    if (event.currentTarget.dataset.type<this.data.glength.length){
      this.setData({
        scrolltop: (this.data.glength[event.currentTarget.dataset.type].sum-1)*80
      })
    }
  },
  //计算食物类型数组长度
  getLength: function(){
    var type = this.data.goodsList[0].type;
    var sum = 0;
    for (var i = 0; i < this.data.goodsList.length; i++) {
      if (type == this.data.goodsList[i].type) {
        sum++;
        if (i == this.data.goodsList.length-1){
          this.data.glength.push({ "type": this.data.goodsList[i - 1].type, "sum": sum });
        }
      } else {
        this.data.glength.push({ "type": this.data.goodsList[i-1].type, "sum": sum });
        type = this.data.goodsList[i].type;
        sum++;
      }
     
    }
    console.log(this.data.glength);
  },
   /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getLength();
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