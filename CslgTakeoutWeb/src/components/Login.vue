<template>
  <div class="container demo-1" style="margin-top: 300px;" :style="{backgroundImage: 'url('+img+')'}" >
    <div class="content"  style="opacity:0.6;">
      <div  class="large-header">
        <div class="logo_box">
          <div style="text-align: center">
            <h1>欢迎登录</h1>
          </div>
          <div class="demon-box" @click="layout='namedemo'">
            <a><h3>账号密码登录</h3></a>
          </div>
          <div class="demon-box2" @click="layout='teldemo'">
            <a><h3>手机验证码登录</h3></a>
          </div>
          <div style="clear: both"></div>
          <form action="#" name="f" method="post" style="margin-top: 2%">
            <div v-if="layout==='namedemo'">
            <div class="input_outer">
              <Icon type="ios-contact" slot="prefix" style="font-size: 30px;margin-top: -10px"/>
              <input name="logname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户"  v-model.lazy.trim="username" :blur="checkName()">
              <div  v-if="errorName">
                <Icon type="md-close-circle" style="color: darkred;font-size: 20px;float: right;margin-top: -35px"/>
              </div>
            </div>
            <div class="input_outer">
              <Icon type="ios-lock-outline" slot="prefix" style="font-size: 30px;margin-top: 5px"/>
              <input name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码" v-model.lazy.trim="password" :blur="checkPass()">
              <Icon type="md-close-circle" style="color: darkred;font-size: 20px;float: right;margin-top: 10px" v-if="errorPass"/>
            </div>
            <div style="margin-top: -15px;color: #9ba7b5;">
              <checkbox >记住密码</checkbox>
            </div>
            <div class="other">
              <span><a style=" color: #9ba7b5;">注册账号</a></span>
              <span style="float:right"><a style=" color: #9ba7b5;">忘记密码？</a></span>
            </div>
            </div >
            <div v-if="layout==='teldemo'">
              <div class="input_outer" style=" margin-bottom: 45px;">
                <Icon type="ios-contact" slot="prefix" style="font-size: 30px;margin-top: -10px"/>
                <input name="logname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入手机号码">
                <Button type="default" ghost style="float: right;margin-top: 5px;">获取手机验证码</Button>
              </div>
              <div class="input_outer" >
                <Icon type="ios-lock-outline" slot="prefix" style="font-size: 30px;margin-top: 5px"/>
                <input name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入验证码" >
              </div>
            </div>
            <div>
              <div class="input_outer" style="width:180px;float: left">
                <input name="logpass" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入验证码" >
              </div>
              <div class="input_outer" style="width:120px;float: right;background-color: #eeeeee;text-align: center">
                <span style="z-index:100;color: #0096e6;font-size:30px">
                  <a>eb68</a>
                </span>
              </div>
            </div>
            <div style="clear: both"></div>
            <div class="mb2" style="margin-top: -20px">
              <a class="act-but submit" href="javascript:;" style="color: #FFFFFF;" @click="onRegiste">登录</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
    export default {
        name: "Login",
      data(){
          return{
            username:'',
            password:'',
            errorName:false,
            errorPass:false,
            isOk:true,
            layout:'namedemo',
            img:require('@/assets/back.jpg')
          }
      },
      methods:{
          // 检查用户名
        checkName:function(){
          var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
          if (patrn.exec(this.username)) {
            this.errorName=true;
            return true;
          }
          else{
            this.errorName=false;
            return false;
          }
        },
        // 检查密码
        checkPass:function(){
          var patrn=/^(\w){6,20}$/;
          if (patrn.exec(this.password))
          {
            this.errorPass=true;
            return true;
          }
          else{
            this.errorPass=false;
            return false;
          }
        },
        // 登录确认
        onRegiste:function(){
          if(this.checkName()&&this.checkPass()){
            this.isOk = false;
          }
          else{
            this.isOk = true;
          }
        },

      },
    }
</script>
<style scoped>
  .large-header {
    position: relative;
    width: 100%;
    overflow: hidden;
    background-repeat:no-repeat;
    background-position: center center;
    z-index: 1;
    height:935px;
    margin-top: -300px;
  }
  .logo_box{
    width: 400px;
    height: 500px;
    padding: 35px;
    color: #EEE;
    position: absolute;
    left: 50%;
    top:50%;
    margin-left: -200px;
    margin-top: -250px;
  }

  .input_outer{
    height: 46px;
    padding: 0 5px;
    margin-bottom: 30px;
    border-radius: 50px;
    position: relative;
    border:#bbbbbb  2px solid !important;
  }
  .text{
    width: 220px;
    height: 46px;
    outline: none;
    display: inline-block;
    font: 14px "microsoft yahei",Helvetica,Tahoma,Arial,"Microsoft jhengHei";
    margin-left: 50px;
    border: none;
    background: none;
    line-height: 46px;
  }
  .mb2{
    margin-bottom: 20px
  }
  .mb2 a{
    text-decoration: none;
    outline: none;
  }
  .submit {
    padding: 15px;
    margin-top: 20px;
    display: block;
  }
  .act-but{
    line-height: 20px;
    text-align: center;
    font-size: 20px;
    border-radius: 50px;
    background: #0096e6;
  }

  .other{
    color: #9ba7b5;
    margin-top: 10px;
    margin-bottom: 10px;
  }
  .demon-box{
    float: left;
  }
  .demon-box2{
    float: right;
  }
</style>

