<!--
   订单模块
   内容：为订单-新订单模块
   编写人：杨志学。
-->
<template >
  <div class="layout-content" style="background: white">
    <div class="card1" style="background: white">
      <Card v-for="(list,index) in showList">
        <p slot="title">
          {{list.to_order_id}}&nbsp;&nbsp;11.50前送达
          <span style="float:right;">等待接单</span>
        </p>
        <p>
        <div>
          <strong>{{list.name}}</strong>
          <span class="float2">
            <Icon type="md-call"/>
            {{list.phone}}
          </span>
          <div style="clear: both"></div>
        <Collapse v-model="value2" simple>
          <Panel name="index">
            {{list.sum}}件商品
            <div slot="content" >
              <div v-for="(list1,index1) in orderdetaillist" v-if="list1.to_order_id==list.to_order_id">
                {{list1.name}}x{{list1.acount}}<span style="float: right">{{list1.price}}元</span>
              </div><br>
            </div>
          </Panel>
        </Collapse>
          <span>东南校区{{list.address}}</span><br><br>
          <span class="color1">备注：</span>
          <span>暂无</span><br>
          <span class="color1">发票：</span>
          <span>常熟理工</span>
      </div>
        </p>
      </Card>
      <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changepage"></Page>

    </div>
    <div class="card2"  style="background: white">
      <div>
        <Card >
          <p slot="title">今日营业总览</p>
          <p>
            <strong>订单量:</strong>
            <span>20&nbsp;单</span><br>
            <strong>营业额:</strong>
            <span>200&nbsp;元</span>
          </p>
        </Card>
      </div>
      <div style="margin-top: 20px;">
        <Card>
          <p slot="title">小贴士</p>
          <p>暂无数据</p>
        </Card>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        goods: [
          {
            name: "麻婆豆腐",
            sum: "2",
            price: 102.5,
          },
          {
            name: "麻婆豆腐",
            sum: "2",
            price: 102.5,
          },
          {
            name: "麻婆豆腐",
            sum: "2",
            price: 102.5,
          }
        ],
        orderall:null,
        sortlist:null,
        orderlist:null,
        orderdetaillist:null,
        //分页数组
        showList:[],
        //总长度
        dataCount:0,
        // 每页显示多少条
        pageSize:2,
      }
    },
    mounted:function(){
      this.getorder();
      this.getorderdetail();
    },
    methods:{
      //订单大类
      getorder(){
        let Order = this;
        let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=showorder';
        axios.get(url)
        // 获取成功
          .then(function (response) {
            Order.orderlist=response.data;
            Order.dataCount = Order.orderlist.length;
            if(Order.dataCount < Order.pageSize){
              Order.showList = Order.orderlist;
            }
            else{
              Order.showList = Order.orderlist.slice(0,Order.pageSize);
            }
          })
          // 获取失败
          .catch(function (error) {

          });
      },
      //订单详细
      getorderdetail(){
        let Order = this;
        let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=showorderdetail';
        axios.get(url)
        // 获取成功
          .then(function (response) {
            Order.orderdetaillist=response.data;
          })
          // 获取失败
          .catch(function (error) {

          });
      },
      //分页详细
      changepage(index){
        var _start = (index - 1) * this.pageSize;
        var _end = index * this.pageSize;
        this.dataCount = this.orderlist.length;
        if(this.dataCount<=4)
          this.showList=this.orderlist;
        else
          this.showList = this.orderlist.slice(_start,_end);
      },
    }
  }
</script>
<style scoped>
  .layout-content {
    margin: 15px;
    overflow: hidden;
    background: #eee;
    border-radius: 4px;
  }

  .goodslist{
    margin-top: 15px;
    font-size: 15px;
  }
  hr {
    height: 2px;
    background: lightgray;
    margin-top: 20px;
  }

  .color1 {
    color: rgb(255, 148, 48, 1);
  }

  .float2 {
    float: right;
  }

  .card1 {
    width: 60%;
    background: #eee;
    padding: 20px;
    float: left;
  }

  .card2 {
    width: 35%;
    padding: 20px;
    float: left;
  }
</style>
