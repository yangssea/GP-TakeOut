<!--
   订单模块
   内容：为订单处理的导航栏，和子路由组件
   编写人：杨志学。
-->
<template>
  <div>
    <ul class="header">
      <!--遍历数据，与下标记-->
      <router-link :to=list.path  v-for="(list,index) in menu"   :style="{color:(changed==index?'#000':'gray')}">
        <li :class="{'li-sign':changed==index}" class="li-style"  @click="change(index)">
          {{list.title}}
        </li>
      </router-link>
    </ul>
    <div style="clear:both;"></div>
    <!--子路由-->
    <router-view></router-view>
  </div>
</template>

<script>
    export default {
        name: "Order",
        data(){
          return{
            /*导航栏处数据*/
            menu:[
              {"title":"新订单","path":"/main/Order/"},
              {"title":"预订单提醒","path":"/main/Order/throw"},
              {"title":"取消订单","path":"/main/Order/throw"},
              {"title":"配送异常","path":"/main/Order/throw"},
              {"title":"催单","path":"/main/Order/throw"},
              {"title":"售后退款","path":"/main/Order/throw"}
            ],
            changed:0
          }
        },
      methods:{
        change(index){
          this.changed = index;
        }

      }
    }
</script>

<style scoped>
  .li-sign{
    border-bottom: 2px solid black;
    color:black;
  }
  .header{
    margin-top: 10px;
  }
  .header .li-style{
    color:gray;
    font-family: Algerian;
    margin-left: 20px;
    font-size: 15px;
    float: left;
    list-style-type:none;
  }
</style>
