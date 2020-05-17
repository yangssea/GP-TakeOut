<template>
  <div class="layout-content">
    <div class="head">
      <div class="left">
      <div class="headline">
        <span class="colora">订单类型：</span>
        <Button size="small">全部</Button>
        <strong class="headlinespan">预订单</strong>
      </div>
      <div class="headline">
        <strong class="colora">下单日期：</strong>
        <Button size="small">近两日</Button>
        <strong class="headlinespan">具体时间</strong>
      </div>
      <div class="headline">
        <strong class="colora">订单状态：</strong>
        <Button size="small">全部</Button>
        <strong class="headlinespan">进行中</strong>
        <strong class="headlinespan">已完成</strong>
        <strong class="headlinespan">已取消/退单</strong>
        <strong class="headlinespan">出餐慢</strong>
      </div>
        <div style="width: 100%;height:700px;overflow:scroll;">
           <Card v-for="(list,index) in showList">
        <p slot="title" class="firtitle">
         {{list.to_order_id}}&nbsp;&nbsp;[预]&nbsp;已完成
          <span style="color: black"></span>
          <span style="float: right">自动接单</span>
        </p>
        <div>
          <Icon type="md-contact" size="18"/>
          <span>&nbsp;用户:{{list.name}}&nbsp;&nbsp;手机号：{{list.phone}}</span>
        </div>
        <div style="margin-top: 15px;">
          <Collapse v-model="value2" simple>
            <Panel name="1">
              {{list.sum}}件商品
              <div slot="content" >
                <div v-for="(list1,index1) in orderdetaillist" v-if="list1.to_order_id==list.to_order_id">
                  {{list1.name}}x{{list1.acount}}<span style="float: right">{{list1.price}}元</span>
                </div><br>
              </div>
            </Panel>
          </Collapse>
        </div>
        <div style="margin-top: 15px;">
          <Icon type="md-trending-up" />
          <span>顾客实付</span>
          <span style="float: right"><Icon type="logo-yen" />{{list.price}}</span><br><br>
          <span>本单预计收入</span>
          <span style="float: right"><Icon type="logo-yen" />{{list.price-5}}</span>
        </div>
        <Divider />
        <div>
          <span>下单时间：{{list.time}}</span>
          <Button style="float: right;margin-right: 10px;">打印</Button>
          <Button style="float: right;margin-right: 10px;">取消订单</Button>

        </div>
      </Card><br>
          <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changepage"></Page>
        </div>
    </div>
      <div class="right">
        <Card :bordered="false">
          <p slot="title">今日总览</p>
          <div>
            <span>预计总收入：{{orderall[0].allprice}}元</span>
            <div class="leftview">
              <Icon type="md-time" />
              <span>已完成：{{orderall[0].sum}}单（预{{orderall[0].allprice-50}}元）</span>
            </div>
            <div class="leftview">
              <Icon type="md-time" />
              <span>进行中：0单</span>
            </div>
            <div class="leftview">
              <Icon type="md-time" />
              <span>超时未接单：0单</span>
            </div>
          </div>
        </Card>
        <Divider/>
        <Card :bordered="false">
          <p slot="title">今日销量前十排行</p>
          <div class="sort">
            <div v-if="index<10" v-for="(list,index) in sortlist">{{list.name}}<span style="float: right">x{{list.sum}}</span></div>
          </div>
        </Card>
      </div>
    </div>
  </div>
</template>

<script>
    import axios from 'axios'
    export default {
      data(){
        return {
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
        this.getsortlist();
        this.getorder();
        this.getorderdetail();
        this.orderalls();
      },
      methods:{
        //获取排行
        getsortlist(){
          let Order = this;
          let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=showsort';
          /* let url=this.url;
           axios.post(url+'/api/order/sort',{
             "storeId":this.storeid
           })*/
          // 获取成功
          axios.get(url)
            .then(function (response) {
              Order.sortlist=response.data;
            })
            // 获取失败
            .catch(function (error) {
              Order.$Message.info("error");
            });

        },
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
        //订单总情况
        orderalls(){
          let Order = this;
          let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=showallorder';
          axios.get(url)
            .then(function (response) {
              Order.orderall=response.data;

            })
            .catch(function (error) {

            });
        }

      }
    }
</script>

<style scoped>
  .sort div{
    margin: 5px;
  }
  .leftview{
    margin: 5px;
  }

  .firtitle{
    color: rgb(255,148,48);
  }

  .head{
    width: 100%;
  }

  .left{
    width:75%;
    float: left;

  }

  .right{
    width:25%;
    float: left;
  }

  .headlinespan{
     margin-left: 10px;
  }

  .layout-content {
    margin: 15px;
    overflow: hidden;
    background:#fff;
    border-radius: 4px;
  }

  .headline{
    margin: 20px;
  }

  .colora{
    color: lightgray;
    font-size: 15px;
  }
</style>
