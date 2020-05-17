
<template>
  <div class="layout-content">
    <div class="card">
      <div class="span1">财务统计:</div><br>
       <Table :columns="columns1" :data="finance" width="200px"></Table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: "Finance",
    data(){
      return{
        columns1: [
          {
            title: '订单号',
            key: 'to_order_id'
          },
          {
            title: '订单收入',
            key: 'price'
          },
          {
            title: '时间',
            key: 'time'
          },{
            title:'骑手',
            key:'name'
          }

        ],
        finance: [
          {
            name: 'John Brown',
            age: 18,
            address: 'New York No. 1 Lake Park',
            date: '2016-10-03'
          },
        ],
      }
    },
    mounted:function () {
      this.getsortlist();
    },
    methods:{
      getsortlist(){
        let Order = this;
        let url=this.url+'/Controller/store/Order.php?storeid='+this.storeid+'&order=finance';
        axios.get(url)
          .then(function (response) {
            Order.finance=response.data;
          })
          // 获取失败
          .catch(function (error) {
            Order.$Message.info("error");
          });

      },
    }
  }
</script>

<style scoped>
  .layout-content {
    margin: 15px;
    overflow: hidden;
    background:#eee;
    width:100%;
    border-radius: 4px;
  }
  .card{
    width:100%;
    height:700px;
    background:white;
    padding-top: 20px;
  }
  .span1{
    font-size: 20px;
    margin-left:1%;
  }
</style>

