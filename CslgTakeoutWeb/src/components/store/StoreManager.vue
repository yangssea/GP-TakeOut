<!--
   门店模块
   内容：门店设置信息
   编写人：杨志学。
-->
<template>
  <div class="layout-content">
    <div class="card1">
      <Card :bordered="false" style="float: left;width: 100%;">
        <p slot="title">
          设置
        </p>
          <div class="store_img"><img width="100%" height="100%"></div>
          <div class="store_mess">
            <span><p>店铺名</p></span>
            <span style="margin:2px 0 2px 0;"><p>店铺ID：907417</p></span>
            <span><p>店主：杨志学/18852975678</p></span>
          </div>
          <div class="store_set">
            <Dropdown trigger="click" @on-click="changeStatus">
              <Button type="primary" style="width: 200px">
                营业状态：{{store_status}}
                <Icon type="ios-arrow-down"></Icon>
              </Button>
              <DropdownMenu slot="list" style="width: 200px">
                <DropdownItem name="营业中">营业中</DropdownItem>
                <DropdownItem name="休息中">休息中</DropdownItem>
                <DropdownItem name="已打烊">已打烊</DropdownItem>
              </DropdownMenu>
            </Dropdown>
          </div>
      </Card>
    </div>
    <div class="card2">
      <div class="bank">
        <Card :bordered="false" style="float: left;">
          <p slot="title">银行卡总览</p>
          <p>
            <span><strong>银行卡号：</strong>1919&nbsp;1919&nbsp;6666&nbsp;8888&nbsp;123</span>
            <span style="margin: 8px 0 8px 0"><strong>开户行：</strong>常熟建设银行</span>
            <span style="margin-bottom: 16px"><strong>开户人：</strong>杨志学</span>
          </p>
        </Card>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        store_status:'',//营业状态
        store_image:''
      }
    },
    methods:{
      changeStatus(name){
        this.store_status=name;
      }
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
  .bank span{
    width: 100%;
    float: left;
  }
  .store_img{
    width: 100px;
    height: 100px;
    background:red;
    float: left;
    margin-bottom: 16px;
  }
  .store_mess{
    width: 300px;
    height: 100px;
    float: left;
    margin-left: 16px;
    margin-bottom: 16px;
  }
  .store_mess>span{
    width: 100%;
    height: 32px;
    float: left;
  }
  .store_set{
    float: right;
    height: 100px;
    //background: #2b85e4;
  }
</style>
