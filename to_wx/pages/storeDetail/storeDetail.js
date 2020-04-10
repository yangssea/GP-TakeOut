// pages/storeDetail/storeDetail.js
import api from '../../service/storeDetailService.js'
import { $wuxToast } from '../../static/lib/index'
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrl: app.globalData.imgUrl,
    //三视图控制变量
    a1: true,
    a2: false,
    a3: false,
    aview:true,
    bview: false,
    cview: false,
    vtype: 0,
    scrolltop: 0,
    typeName:["全部 5628","最新 23","好评 10","差评 5","有图 23"],
    cviews: 0,
    typeList:[],
    //食物列表
     goodsList:[],
    //列表长度计算
    glength: [],
    //弹出框
    visible: false,
    //商店详细
    storeMsg: null,
    //购物车
    cartList: [],
    //总价
    allPrice: 0,
    //总量： 
    allSum: 0,
    //商家评分
    grade: [],
    //评论列表
    commentList: [],
    ctype: 0,
    avgGrade: 0.0,
    toOrders: {}

  },
  //跳转确定订单
  toOrder: function(){
    if (!this.data.cartList||this.data.cartList.length==0){
      $wuxToast().show({
        type: 'cancel',
        duration: 1500,
        color: '#fff',
        text: '请选择商品',
        success: () => console.log('已完成')
      })
    }else{
      this.data.toOrders.storeMsg = this.data.storeMsg;
      this.data.toOrders.list = this.data.cartList;
      this.data.toOrders.price = this.data.allPrice;
      var data = JSON.stringify(this.data.toOrders);
      wx.navigateTo({
        url: '/pages/confirmOrder/confirmOrder?data='+data,
      })
    }
   
  },
  //评价类型改变
  changectype: function(event){
    var sum = event.currentTarget.dataset.type;
    this.setData({
      cviews: sum
    })
    this.getclist(this.data.storeMsg.storeDetail.id,sum);
  },
  onopen: function(){
    this.setData({
      visible: true
    })
  },
  onclose: function () {
    this.setData({
      visible: false
    })
  },
  //切换视图
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
          vtype: i+1
        })
      } 
      if (parseInt(event.detail.scrollTop) -(80 * this.data.glength[0].sum)<=0){
        this.setData({
          vtype: 0
        })
      }
    }
   
  },
  //点击分类
  clicktype:function(event){
    if (event.currentTarget.dataset.type<this.data.glength.length){
      if(event.currentTarget.dataset.type==0){
        this.setData({
          scrolltop: 0
        })
      }else{
        this.setData({
          scrolltop: (this.data.glength[event.currentTarget.dataset.type - 1].sum) * 83
        })
      }
    }
  },
  //计算食物类型数组长度
  getLength: function(){
    var type = this.data.goodsList[0].goods.typeId;
    var sum = 0;
    for (var i = 0; i < this.data.goodsList.length; i++) {
      if (type == this.data.goodsList[i].goods.typeId) {
        sum++;
        if (i == this.data.goodsList.length-1){
          this.data.glength.push({ "type": this.data.goodsList[i - 1].goods.typeId, "sum":sum});
        }
      } else {
        this.data.glength.push({ "type": this.data.goodsList[i - 1].goods.typeId, "sum": sum });
        if (i == this.data.goodsList.length - 1) {
          this.data.glength.push({ "type": this.data.goodsList[i].goods.typeId, "sum":sum+1});
        }
        type = this.data.goodsList[i].goods.typeId;
        sum++;
      }
    }
  },
  //获取食物列表
  getList: function(){
     var that=this;
    api.find({id:1}).then((res) => {
      that.setData({
        storeList: res.result
      })
    }, (error) => {
      console.log(error);
    });
  },
  //点击加入购物车
  addCart: function(event){
    this.data.goodsList[event.currentTarget.dataset.key].sum = parseInt(this.data.goodsList[event.currentTarget.dataset.key].sum)+1;
    this.setData({
      goodsList: this.data.goodsList
    })
    //购物车增加
    var item = event.currentTarget.dataset.dao;
    var boo=false;
    var price=0;
    for (var i = 0; i < this.data.cartList.length;i++){
      if (this.data.cartList[i].id == item.goods.id){
        this.data.cartList[i].sum+=1;
        boo=true;
      }
    }
    if(boo==false){
      this.data.cartList.push({ "id": item.goods.id, "name":item.goods.name,"price": item.goods.price, "sum": parseInt(item.sum)+1 });
    } 
    for (var i = 0; i < this.data.cartList.length; i++) {
      price += this.data.cartList[i].price * this.data.cartList[i].sum;
    }
    this.setData({
      allSum: this.data.cartList.length,
      cartList: this.data.cartList,
      allPrice: price.toFixed(1)
    })
  },
  //点击取消加入购物车
  subCart: function (event){
    this.data.goodsList[event.currentTarget.dataset.key].sum = parseInt(this.data.goodsList[event.currentTarget.dataset.key].sum) - 1;
    this.setData({
      goodsList: this.data.goodsList
    });
    //购物车减少
    var item = event.currentTarget.dataset.dao;
    var index;
    var price=0;
    for (var i = 0; i < this.data.cartList.length; i++) {
      if (this.data.cartList[i].id == item.goods.id  ) {
        this.data.cartList[i].sum -= 1;
        index = i;
      }
    }
    if (this.data.cartList[index].sum <=0) {
      this.data.cartList.splice(index,1);
    } 
    for (var i = 0; i < this.data.cartList.length; i++) {
      price += this.data.cartList[i].price * this.data.cartList[i].sum;
    }
    this.setData({
      cartList:this.data.cartList,
      allSum: this.data.cartList.length,
      allPrice: price.toFixed(1)
    })
  },
  //减少cart数量
  subclist: function(event){
    var index = event.currentTarget.dataset.index
    if (this.data.cartList[index].sum==1){
      this.data.cartList.splice(index, 1);
    }else{
      this.data.cartList[index].sum -= 1;
    }
    var price = 0;
    for (var i = 0; i < this.data.cartList.length; i++) {
      price += this.data.cartList[i].price * this.data.cartList[i].sum;
    }
    this.setData({
      cartList: this.data.cartList,
      allSum: this.data.cartList.length,
      allPrice: price.toFixed(1)
    })
  },
  addclist: function (event){
    var index = event.currentTarget.dataset.index
    this.data.cartList[index].sum += 1;
    var price=0;
    for (var i = 0; i < this.data.cartList.length;i++){
      price += this.data.cartList[i].price * this.data.cartList[i].sum;
    }
    this.setData({
      cartList: this.data.cartList,
      allSum: this.data.cartList.length,
      allPrice: price.toFixed(1)
    })
  },
  //清空购物车
  clearCar: function(){
    for(var i=0;i<this.data.goodsList.length;i++){
      this.data.goodsList[i].sum=0;
    }
    this.setData({
      cartList: [],
      allPrice: 0.0,
      allSum: 0,
      goodsList: this.data.goodsList
    });
  },
  //获取商店评分
  getGrade: function(id){
    var that = this;
    api.findGrade({ id: id }).then((res) => {
      var list = res.result.split(",");
      that.setData({
         grade: list,
        avgGrade: ((parseFloat(list[0]) + parseFloat(list[1]) + parseFloat(list[2])) /3).toFixed(1)
      });
      
    }, (error) => {
      console.log(error);
    });
  },
  //获取商店评论
  getclist: function(id,type){
    var that=this;
    api.findComment({ id: id ,type: type}).then((res) => {
      //结果整理
      var list=res.result;
      var listnew=[];
      var view = true;
      for(var i=0;i<list.length;i++){
        for (var j = 0; j < list.length; j++) {
          if(list[i].orderId==list[j].orderId&&i!=j){
            for (var z = 0; z < listnew.length;z++){
              if (list[i].orderId == listnew[z].to.orderId){
                view=false;
              }
            }
            if(view){
              if (list[i].isReply==0){
                listnew.push({ to: list[i], from: list[j] });
              }else{
                listnew.push({ to: list[j], from: list[i] });
              }
            }
            view = true;
          }
        }
      }
      that.setData({
        commentList: listnew
      });
    
    }, (error) => {
      console.log(error);
    });
  },
   /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getGrade(JSON.parse(options.data).storeDetail.id);
    this.getclist(JSON.parse(options.data).storeDetail.id, this.data.ctype);
    this.setData({
      storeMsg: JSON.parse(options.data)
    });
    var that= this;
    api.find({ id: JSON.parse(options.data).storeDetail.id}).then((res) => {
      that.setData({
        goodsList: res.result
      });
      this.getLength();
    }, (error) => {
      console.log(error);
    });

    api.findType({ id: JSON.parse(options.data).storeDetail.id }).then((res) => {
      that.setData({
        typeList: res.result
      });
    }, (error) => {
      console.log(error);
    });
  },
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})