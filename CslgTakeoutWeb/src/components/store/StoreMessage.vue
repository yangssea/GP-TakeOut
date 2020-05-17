<!--
   门店信息模块
   内容：添加门店信息，展示门店信息，修改门店信息
   编写人：封宣海
   时间：2019.5.20
-->
<template>
  <div class="layout-content" style="background:#fff;overflow: scroll">
    <!-- flag==true展示添加商店页面-->
      <div class="card1" v-if="flag">
        <Card :bordered="false" style="float: left;height: 600px;">
          <p slot="title">门店基本信息</p>
            <form>
              <div class="mess"><label>店铺名称</label><input class="messInput" v-model="formValidate.store_name" type="text" placeholder="请输入店铺名称" value="" maxlength="60"></div>
              <div class="mess"><label>店主名字</label><input class="messInput" v-model="formValidate.store_host" type="text" placeholder="请输入店主名字" value="" maxlength="10"></div>
              <div class="mess"><label>联系电话</label><input class="messInput" v-model="formValidate.host_phone" type="number" placeholder="请输入联系电话"value="" maxlength="40"></div>
              <div class="mess"><label>店铺地址</label><input class="messInput" v-model="formValidate.xiaoqu" type="text" value="" placeholder="请输入店铺地址" maxlength="60"></div>
              <div class="mess"><label>营业时间</label><input class="messInput" v-model="formValidate.store_time" type="text" placeholder="请输入营业时间" value="" maxlength="40"></div>
              <div class="mess1"><label>店铺简介</label><textarea  class="mytextarea" v-model="formValidate.introduction" placeholder="请输入店铺简介" rows="3" cols="4" value=""></textarea></div>
              <div class="mess"><label>店铺图片</label><input id="imgfile" class="messInput" @input="fileImage" style="padding: 0" placeholder="请上传一张店铺图片" type="file" accept="image/*"  maxlength="40"></div>
              <div class="mess">
                <Button type="primary" @click="handleSubmit">提交</Button>
              </div>
            </form>
        </Card>
      </div>
    <!-- flag==true 展示结束-->

    <!-- flag==false时展示 -->
      <div class="card2" v-else>
        <Card :bordered="false" style="float: left;height: 600px;width: 630px">
          <p slot="title">门店基本信息</p>
          <form id="showMess">
              <img :src="this.formValidate.store_image"  class="store_image" style="margin-bottom: 20px"/>
            <div class="mess"><label>店铺ID</label><span>{{formValidate.store_id}}</span></div>
            <div class="mess"><label>店铺名称</label><span>{{formValidate.store_name}}</span></div>
            <div class="mess"><label>店主名字</label><span>{{formValidate.store_host}}</span></div>
            <div class="mess"><label>联系电话</label><span>{{formValidate.host_phone}}</span></div>
            <div class="mess"><label>店铺地址</label><span>{{formValidate.xiaoqu}}</span></div>
            <div class="mess"><label>营业时间</label><span>{{formValidate.store_time}}</span></div>
            <div class="mess"><label>店铺简介</label><span>{{formValidate.introduction}}</span></div>
            <div class="mess"></div>
            <div class="mess" style="text-align: center"><Button type="primary" @click="updateStoreMess">修改</Button></div>
          </form>
        </Card>
      </div>
    </div>
    <!-- flag==false 展示结束-->
</template>
<script>
   import axios from 'axios'
  export default {
    name: "StoreMessage",
    data () {
      return {
        flag:false,
        formValidate: {
          store_id:'',
          store_name: '',//店铺名称
          store_host: '',//店主名字
          host_phone:'',//联系电话
          xiaoqu: '',//地址
          store_time:'',//营业时间
          introduction:'',//简介
          store_image:null,//图片
        },
      }
    },
    mounted:function(){
      this.getMess();
    },
    methods: {
      //创建表单并通过ajax提交，与“提交”按钮绑定
      handleSubmit(){
        let param = new FormData(); //创建form对象
        let from=this.formValidate;
        /*let addurl=this.url+"/api/store/addMsg";*/
        let addurl=this.url+'/Controller/store/store.php?store=updatestore';
        let config = {
          headers:{'Content-Type':'multipart/form-data'}
        };
        let that=this;
        if(!from.store_name&& !from.store_host && !from.host_phone && !from.xiaoqu && !from.store_time && !from.introduction){
          window.alert("输入不能为空！");
        }else {
          param.append('storeid',this.storeid);

          param.append('store_name', from.store_name);

          param.append('store_host', from.store_host);

          param.append('host_phone', from.host_phone);

          param.append('xiaoqu', from.xiaoqu);

          param.append('store_time', from.store_time);

          param.append('introduction', from.introduction);


          param.append('goodImg', from.store_image);//通过append向form对象添加数据

          axios.post(addurl, param, config,{
            "store_id":this.storeid
          })
            .then(function (response) {
              that.flag=false;
              that.$Message.info("修改成功");
              window.location.reload();
            })
            .catch(function (error) {
              console.log(error);
              this.$Message.info("error");
            })
        }
      },
      //获取图片文件
      fileImage(){
        this.formValidate.store_image=window.document.getElementById("imgfile").files[0];
        let file = this.formValidate.store_image;
        var imgSize=file.size/1024;
        if(imgSize>1024*2){
          window.alert('请上传大小不要超过2M的图片');
          this.formValidate.store_image=null;
        }
      },
      //获取后台传来的信息
      getMess(){
       /* let addurl=this.url+"/api/store/getMsg";*/
        let addurl=this.url+'/Controller/store/store.php?store=showstore&storeid='+this.storeid+'';
        let store=this;
        let that=this;
        /*  axios.get(addurl,{
            "store_id":this.storeid
          })*/
         axios.get(addurl)
            .then(function (response) {
             /* store.formValidate.store_id=response.data.data.to_store_id;
              store.formValidate.host_phone=response.data.data.phone;
              store.formValidate.store_host=response.data.data.host_name;
              store.formValidate.store_name=response.data.data.name;
              store.formValidate.xiaoqu=response.data.data.address;
              store.formValidate.store_time=response.data.data.store_time;
              store.formValidate.introduction=response.data.data.introduction;
              store.formValidate.store_image=that.url+'/'+response.data.data.storeImage;*/
              store.formValidate.store_id=response.data[0].to_store_id;
              store.formValidate.host_phone=response.data[0].phone;
              store.formValidate.store_host=response.data[0].host_name;
              store.formValidate.store_name=response.data[0].name;
              store.formValidate.xiaoqu=response.data[0].address;
              store.formValidate.store_time=response.data[0].store_time;
              store.formValidate.introduction=response.data[0].introduction;
              store.formValidate.store_image=that.url+'/'+response.data[0].img_path;
            })
            .catch(function (error) {
              this.$Message.info(error);
            })
      },
      updateStoreMess(){
        this.flag=true;
      }
    }
  }
</script>
<style scoped>
  .card1{
    width: 50%;
    float: left;
  }

  .card2{
    width: 100%;
    float: left;
  }
  .store_image{
    width: 100px;
    height: 100px;
    background: #eee;
  }
  #showMess p{
    padding-left: 16px;
  }
  .mess{
    width: 100%;
    height: 32px;
    margin: 4px;
    float: left;
    /*text-align: center;*/
  }
  .mess1{
    width: 100%;
    margin: 4px;
    float: left;
    text-align: center;
  }
  .mess1 label{
    width: 80px;
    height: 100%;
    display: inline-block;
    float: left;
    line-height: 32px;
    text-align: center;
    background: rgba(70,76,91,.7);
    color: rgba(255, 255, 255, .7);
  }
  .mess label{
    width: 80px;
    height: 100%;
    display: inline-block;
    float: left;
    line-height: 32px;
    text-align: center;
    /*background: rgba(70,76,91,.7);*/
    /*color: rgba(255, 255, 255, .7);*/
  }

  .mess>span{
    text-align: left;
    width: 480px;
    height: 100%;
    line-height: 32px;
    display: inline-block;
    box-sizing: border-box;
  }
.messInput{
  width: 480px;
  display: block;
  float: left;
  line-height: 28px;
  margin-left: 2px;
  padding:0 8px;
  border-radius: 4px;
  border:1px solid #c8cccf;
  box-sizing: border-box;
  -web-kit-appearance:none;
  -moz-appearance: none;
  outline:0;
  text-decoration:none;
  font-size:1.0em;
  color:#6a6f77;
}
  .mytextarea{
    width: 480px;
    height: 100px;
    float: left;
    outline:0;
    padding: 2px 6px;
    margin-left: 2px;
  }
</style>
