<!--
    首页路由模块
    内容：主要是各种订单状态的一些总数
    编写人：杨志学、王高玲
-->
<template>
  <div class="layout-content">
    <div class="card1">
      <Card :bordered="false">
        <p slot="title">待处理订单</p>
        <ul class="pending-order">
          <li v-for="(a,i) in list">
            <div v-bind:class="a.number>0 ? 'card1-font':'card1-font zero'">{{a.number}}</div>
            <div>{{a.name}}</div>
          </li>
        </ul>
      </Card>
    </div>
    <div class="card2">
      <Card :bordered="false">
        <p slot="title">待处理反馈</p>
        <ul class="pending-order2">
          <li v-for="(a,i) in feedpack">
            <div v-bind:class="a.number>5 ? 'card1-font no-bad':'card1-font no-evaluate'">{{a.number}}</div>
            <div>{{a.name}}</div>
          </li>
        </ul>
      </Card>
    </div>
    <!--第二行卡片-->
    <div style="clear: both"></div>
    <div class="card1">
      <Card :bordered="false">
        <p slot="title">今日总览</p>
        <ul class="pending-order3">
          <li v-for="(a,i) in total" style="margin-left: 2%;">
            <div v-bind:class="a.number<500 ? 'card1-font no-bad':'card1-font'">{{a.number}}</div>
            <div>{{a.name}}</div>
          </li>
        </ul>
      </Card>
    </div>
    <div class="card2">
      <Card :bordered="false">
        <p slot="title">活动</p>
        <ul class="pending-order4">
          <li v-for="(a,i) in active"  style="margin-left: 2%;">
            <div v-bind:class="a.number>15 ? 'card1-font ':'card1-font no-bad'">{{a.number}}</div>
            <div>{{a.name}}</div>
          </li>
        </ul>
      </Card>
    </div>
    <!--第三行卡片-->
    <div style="clear: both"></div>
    <div class="card3">
      <Card :bordered="false">
        <p slot="title">任务中心</p>
      </Card>
    </div>
  </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "Home",
      data(){
          return{
// 待处理订单数组
            list:[
              {
                number:0,
                name:"新订单"
              },
              {
                number:0,
                name:"异常订单"
              },
              {
                number:0,
                name:"催单"
              },
              {
                number:0,
                name:"退单"
              }
            ],
            // 待处理反馈数组
            feedpack:[
              {
                number:24,
                name:"未回复差评"
              },
              {
                number:3,
                name:"未回复评价"
              }
            ],
            // 今日总览数组
            total:[
              {
                number:"324",
                name:"今日订单"
              },
              {
                number:"￥6038",
                name:"今日营业额"
              }
            ],
            // 活动数组
            active:[
              {
                number:3,
                name:"已报名"
              },
              {
                number:18,
                name:"可报名"
              }
            ]
          }
      },
      mounted:function(){
        this.orderalls();
      },
      methods:{
        orderalls(){
          let Order = this;
          let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=showallorder';
          axios.get(url)
            .then(function (response) {
              Order.total[0].number=response.data[0].sum;
              Order.total[1].number=response.data[0].allprice;
              Order.list[0].number=response.data[0].sum;
            })
            .catch(function (error) {
            });
        }
      }
    }
</script>

<style scoped>
  .layout-content {
    margin: 15px;
    overflow: hidden;
    background:#eee;
    border-radius: 4px;
  }
  .card1{
    width:60%;
    background:#eee;
    padding: 20px;
    float: left;
  }

  .card2{
    width:35%;
    padding: 20px;
    float: left;
  }

  .card3{
    width:95%;
    padding: 20px;
  }

  .pending-order li{
    list-style: none;
    display: inline;
    float: left;
    padding: 4%;
    margin: 4%;
  }
  .pending-order{
    text-align: center;
    padding: 0;
    height: 170px;
    margin-top: -8%;
    margin-left: 5%;
  }
  .pending-order2 li{
    list-style: none;
    display: inline;
    float: left;
    margin: 4%;
    padding: 4%;
  }
  .pending-order2{
    text-align: center;
    padding: 0;
    height: 140px;
    margin-top: -8%;
    margin-left: 20%;
  }
  .pending-order3 li{
    list-style: none;
    display: inline;
    float: left;
    padding: 7%;
    margin: 7%;
  }
  .pending-order3{
    text-align: center;
    padding: 0;
    height: 220px;
    margin-top: -13%;
    margin-left: 5%;
  }
  .pending-order4 li{
    list-style: none;
    display: inline;
    float: left;
    padding: 7%;
    margin: 7%;
  }
  .pending-order4{
    text-align: center;
    padding: 0;
    height: 170px;
    margin-top: -13%;
    margin-left: 15%;
  }
  .card1-font{
    font-size:50px;
    font-family: "arial";
    color: #0099FF;
  }
  .two{
    color:#FF9966;
  }
  .zero{
    color: #9ea7b4;
  }
  .no-bad{
    color: #666666;
  }
  .no-evaluate{
    color: #CC3333;
  }

</style>
