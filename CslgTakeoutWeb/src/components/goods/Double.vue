<!--
   商品模块
   内容：商品模块中的双人多人套餐内容
   编写人：王高玲。
-->
<template>
  <div>
    <!--      标题内容-->
    <header>
          <span class="title">
            <h1>&nbsp;{{ value }}</h1>
          </span>
      <Button @click="handleRender" class="changetitle">
        <Icon type="md-settings" />
        <span>编辑</span>
      </Button>
      <Button class="allchange">批量管理</Button>
    </header>
    <!--      商品具体内容-->
      <div v-for="(a,i) in goodslist"  class="listcard">
        <Card style="width:320px;height: 240px">
          <div>
            <h3 >{{a.goodsname}}</h3>
            <p style="color: red">{{a.price}}</p>
            <img  :src=a.image class="jpgstyle">
            <span class="btnstyle">
                <div style="margin-left: 10%"><h4>{{a.remian}}/{{a.full}}</h4></div>
                <Button type="success">置满</Button>
                <Button type="dashed">估清</Button>
                <Button @click="changegoods" class="btnchange">编辑</Button>
              </span>
          </div>
        </Card>
      </div>
      <div class="operation">
        <Icon type="md-add-circle" @click="addgoods" class="addicon"/>
        <Icon type="md-backspace" class="subicon" @click="deletegoods" />
      </div>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        name: "Double",
        // 标题默认
        value:'双人及多人套餐',
        // 商品类别
        goodslist:[
          {
            goodsname:"鸭肉套餐",
            price:"￥10.00",
            full:100,
            remian:90,
            image:require('../../assets/food1.jpg')
          },
          {
            goodsname:"鸭肉套餐",
            price:"￥10.00",
            full:100,
            remian:90,
            image:require('../../assets/food1.jpg')
          },
          {
            goodsname:"鸭肉套餐",
            price:"￥10.00",
            full:100,
            remian:90,
            image:require('../../assets/food1.jpg')
          },
          {
            goodsname:"鸭肉套餐",
            price:"￥10.00",
            full:100,
            remian:90,
            image:require('../../assets/food1.jpg')
          },
          {
            goodsname:"鸭肉套餐",
            price:"￥10.00",
            full:100,
            remian:90,
            image:require('../../assets/food1.jpg')
          },


        ]
      }
    },
    methods: {
      // 修改标题
      handleRender () {
        this.$Modal.confirm({
          render: (h) => {
            return h('Input', {
              props: {
                value: this.value,
                autofocus: true,
                placeholder: 'Please enter your name...'
              },
              on: {
                input: (val) => {
                  this.value = val;
                }
              }
            })
          }
        })
      },
      // 修改商品标题
      changegoods(){
        this.$Modal.confirm({
          render: (h) => {
            return h('Input', {
              props: {
                goodsname: this.goodsname,
                autofocus: true,
                placeholder: 'Please enter your goodsid...'
              },
              on: {
                input: (val) => {
                  this.goodsname = val;
                }
              }
            })
          }
        })
      },
      // 添加食品
      addgoods(){
        this.$Modal.confirm({
          render: (h) => {
            return h('Input', {
              props: {
                goodsname: this.goodsname,
                autofocus: true,
                placeholder: '请添加菜品！！！'
              },
              on: {
                input: (val) => {
                  this.goodsname = val;
                }
              }
            })
          }
        })
      },
      // 删除食品
      deletegoods(){
        this.$Modal.confirm({
          render: (h) => {
            return h('span', {
              props: {
                goodsname: this.goodsname,
                autofocus: true,
                action:"确认要删除这个商品吗！！！"
              },
            })
          }
        })
      }
    }
  }
</script>

<style scoped>
  .title{
    float: left;
  }
  .changetitle{
    margin-left: 1%;
    margin-top: 0.4%;
    background-color: #eee;
  }
  .allchange{
    float: right;
    margin-top: 0.4%;
  }
  /*商品div的总体大小*/
  .articlecard{
    margin-left: 25%;
    margin-top: 2%;
    overflow: scroll;
    height: 480px;
    width: 900px;
    /*background-color: #CC3333;*/
  }
  .listcard{
    float: left;
    margin-left: 5%;
    margin-top: 2%;
  }
  /*图片样式*/
  .jpgstyle{
    height: 150px;
    float: right;
    margin-top: -15%;
  }
  /*商品内按钮样式及数量*/
  .btnstyle{
    float: left;
    width: 100%;
    margin-top: -3%;
  }
  .btnchange{
    background-color: #eee;
    float: right;
  }
  /*添加删除操作页面*/
  .operation{
    margin-left: 10%;
  }
  /*删除icon的样式*/
  .subicon{
    font-size: 40px;
    color: skyblue;
    margin-top: 30%;
    position: fixed;
    margin-left: 5%;
  }
  /*添加按钮样式*/
  .addicon{
    font-size: 40px;
    color: skyblue;
    position: fixed;
    margin-top: 25%;
    margin-left: 5%;
  }
</style>





