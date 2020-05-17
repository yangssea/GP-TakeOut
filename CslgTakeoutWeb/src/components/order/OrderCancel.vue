<!--
   订单模块
   内容：订单-预订单模块
   编写人：杨志学。
-->
<template>
  <div class="layout-content">
    <!--依次的三个卡片-->
    <div class="card1">
      <Card :bordered="false" >
        <p slot="title">取消订单</p>
        <p>
        <div v-for="(list,index) in wlist" class="wlist">
          <span>{{list.id}}&nbsp;{{list.name}}&nbsp;&nbsp;{{list.time}}</span>
          <span style="margin-left: 50%">{{list.add}}</span>
          <span style="float: right">{{list.price}}&nbsp;元</span>
        </div>
        </p>
      </Card>
    </div>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        wlist:[
          {
            id:2,
            name:"老王",
            price:25,
            time:"13.30",
            add:"东湖校区哈哈哈"
          },{
            id:"3",
            name:"老王",
            price:"25",
            time:"13.30",
            add:"东湖校区哈哈哈"
          },{
            id:"4",
            name:"老王",
            price:"25",
            time:"13.30",
            add:"东湖校区哈哈哈"
          },
        ]
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

  .wlist{
    margin-top: 10px;
  }

  .card1{
    width:50%;
    background:#eee;
    padding: 20px;
    float: left;
  }

  .card2{
    width:35%;
    padding: 20px;
    float: left;
  }
</style>
