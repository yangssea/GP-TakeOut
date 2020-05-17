<!--
   商品模块
   内容：为商品模块的导航栏和子路由组件
   其中文件上传为重点
   编写人：王高玲
   修改人：杨志学
-->
<template>
  <div class="layout-content">
    <Modal
      v-model="modal1"
      title="添加大类"
      @on-ok="ok"
      @on-cancel="cancel">
      <label for="g-name">大类名称&nbsp;:&nbsp;</label>
      <Input id="g-name" v-model="postData.goodName" name="goodName" placeholder="请输入名称" style="width: 300px" />
    </Modal>
    <Modal
      v-model="modal2"
      title="修改大类"
      @on-ok="ok2"
      @on-cancel="cancel2">
      <label for="g-names6">大类名称&nbsp;:&nbsp;</label>
      <Input id="g-names6" v-model="goodName1" name="goodName" placeholder="请输入名称" style="width: 300px" />
    </Modal>
    <Modal
      v-model="modal3"
      title="删除大类"
      @on-ok="deletes"
      @on-cancel="cancel">
      <label>确定删除吗？&nbsp;:&nbsp;</label>
    </Modal>
    <Modal
      v-model="modal4"
      :title=gsupname
      @on-ok="addsg"
      @on-cancel="cancel">
      <label for="g-namese">商品名:&nbsp;</label>
      <Input id="g-namese" type="text" v-model="sgnmae" name="goodNamesg" placeholder="请输入名称" style="width: 300px" />
      <br><br><label for="g-namest">价格&nbsp;:&nbsp;</label>
      <Input type="number" id="g-namest"  v-model="sgprice" name="sggoodName" placeholder="请输入价格" style="width: 300px" />
      <br><br><label for="g-names2">库存&nbsp;:&nbsp;</label>
      <Input type="number" id="g-names2" v-model="sgkucun" name="goodName" placeholder="请输入库存数" style="width: 300px" />
      <br><br> <label for="gnames3">图片&nbsp;:&nbsp;</label>
      <Input id="gnames3" type="file" @input="uploadImg"  style="width: 300px"   accept="image/jpg" />
    </Modal>
    <Modal
      v-model="modal5"
      title="删除小类"
      @on-ok="gsdeletes"
      @on-cancel="cancel">
      <label>确定删除吗？&nbsp;:&nbsp;</label>
    </Modal>
    <Tabs value="name1">
      <TabPane label="菜品管理" name="name1">
        <!--    菜单区域  模块来自ivew-->
        <Menu active-name="1" class="menu_goods">
          <MenuItem v-for="(list,index) in list" :name="index">
              <menu   @click="clickGlist(list.id,list.name)">
                <Icon type="md-chatbubbles" />
                <span>{{list.name}}</span>
              </menu>
          </MenuItem>
          <Button type="primary" @click="modal1 = true" style="margin-left: 5%">添加商品</Button>
        </Menu>
        <!--    内容区域-->
        <div class="content">
          <!--          子路由-->
          <div>
            <!--      标题内容-->
            <header>
          <span class="title">
            <h1>&nbsp;{{ goodsdname }}</h1>
          </span>
                 <Icon type="md-trash" @click="modal3= true"  size="15" />
                 <Icon type="md-settings" @click="modal2= true" size="15"/>
                 <Button class="allchange">批量管理</Button>
            </header>
            <!--      商品具体内容-->
             <div style="overflow: scroll;height:500px;">
             <!-- <div v-for="(a,i) in dlist"  class="listcard">
              <Card v-if="a.to_goods_id==goodsid" style="width:320px;height: 240px">
                <div>
                  <Icon type="md-trash" @click="aheaddelete(a.img_path,a.to_goods_detail_id)"  size="15" style="float: left"/>
                  <h3 >{{a.name}}</h3>
                  <p style="color: red;margin-left: 10px;">¥&nbsp;{{a.price}}</p>

                  <img :src=getUrl(i)  class="jpgstyle">
                  &lt;!&ndash;商品底部按钮模块&ndash;&gt;
                  <span class="btnstyle">
                <div style="margin-left: 10%">
                  <h4>{{a.remanent}}/{{a.remanent}}</h4>
                </div>
                <Button type="success">置满</Button>
                <Button type="dashed">估清</Button>
                <Button @click="changegoods(a,i)" class="btnchange">编辑</Button>
              </span>
                </div>
              </Card>
            </div>-->
               <div v-for="(list,index) of dlist"  class="listcard">
                 <Card v-if="1==1" style="width:320px;height: 240px">
                   <div>
                     <Icon type="md-trash"  @click="aheaddelete(list.img,list.id)"  size="15" style="float: left"/>
                     <h3 >{{list.name}}</h3>
                     <p style="color: red;margin-left: 10px;">¥&nbsp;{{list.price}}</p>

                     <img :src="img+list.img"  class="jpgstyle">
                     <!--商品底部按钮模块-->
                     <span class="btnstyle">
                <div style="margin-left: 10%">
                  <h4>4/5</h4>
                </div>
                <Button type="success">置满</Button>
                <Button type="dashed">估清</Button>
                <Button @click="changegoods(a,i)" class="btnchange">编辑</Button>
              </span>
                   </div>
                 </Card>
               </div>
                <!--        右侧添加删除按钮部分-->
                 <div class="operation">
                  <Icon type="md-add-circle" @click="modal4= true" class="addicon"/>
                  <Icon type="md-backspace" class="subicon"  />
               </div>
             </div>
          </div>


        </div>
      </TabPane>
      <TabPane label="回收站" name="name2">
        <img class="imga" src="../../assets/null.png" height="200" width="200"/>
        <div class="spana">暂无数据</div>
      </TabPane>
    </Tabs>
  </div>
</template>
<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        name: "Goods",
        //删除小类的id和图片url
        dtid:"",
        dturl:"",
        modal5:false,
        changed: 0,
        /*绑定goodId*/
        goodId:0,
        /*绑定图片路径*/
        imgpath:"",
        /*确认框绑定元素*/
        goodName1:"",
        /*确认框*/
        modal1: false,
        /*确认框*/
        modal2:false,
        /*确认框*/
        modal3:false,
        /*确认框*/
        modal4:false,
        /*绑定添加商品信息*/
        sgnmae:"",
        sgprice:'',
        sgkucun:'',
        sgimg:null,
        /*确认框绑定元素*/
        goodsdname:"",
        //大类id
        goodsid:0,
        //修改名字
        upGoodsName:"",
        //修改小类的名字
        gsupname:"添加商品",
        /*确认框绑定元素*/
        postData: {
        storeid: 1,
        goodName: ""
      },
        // 导航栏的具体内容数组
        list:[],
        //小类数组
        alldlist:[],
        dlist:[],
         /*
         * right model
        * */
        name: "Saleprice",
         // 标题默认
        value: '天天特价',
        // 商品类别
        goodslist1: [
        {
          goodsname1: "鸭肉套餐",
          price: "￥10.00",
          full: 100,
          remian: 90,
          image: require('../../assets/food1.jpg')
        },
        {
          goodsname1: "鸭肉套餐",
          price: "￥10.00",
          full: 100,
          remian: 90,
          image: require('../../assets/food1.jpg')
        },
        {
          goodsname1: "鸭肉套餐",
          price: "￥10.00",
          full: 100,
          remian: 90,
          image: require('../../assets/food1.jpg')
        },
        {
          goodsname1: "鸭肉套餐",
          price: "￥10.00",
          full: 100,
          remian: 90,
          image: require('../../assets/food1.jpg')
        },
        {
          goodsname1: "鸭肉套餐",
          price: "￥10.00",
          full: 100,
          remian: 90,
          image: require('../../assets/food1.jpg')
        },
      ]
      }
    },
    mounted:function(){
      this.getlist();
    },
    methods:{
      /*拿到商品大类信息*/
      getlist(){
        let Goods = this;
        let url=this.url;
        let url2=url+'GoodsType/findAll';
        axios.get(url2,{
          params: {
            id: this.storeid
          }
        }).then(function (response) {
            Goods.goodsdname=response.data.result[0].name;
            Goods.goodsid=response.data.result[0].id;
            Goods.list=response.data.result;
            Goods.getAllList(response.data.result[0].id,"");
            console.log(response.data.result);
        })
        .catch(function (error) {
          Goods.$Message.info("error");
        });

      },
      //小类数据
      getAllList(types,name){
         let Goods1 = this;
         let url=this.url;
         let url2=url+'goods/findAll';
         axios.get(url2, {
           params: {
             id: this.storeid,
             type: types
           }
         }).then(function (response) {
           if(name!=''&&name!=null){
             Goods1.goodsdname=name;
           }
            Goods1.goodsid=types;
            Goods1.dlist=response.data.result;
         }).catch(function (error) {
           Goods1.$Message.info("失败");
         })
      },
      //筛选食品列表
      clickGlist(types,name){
        this.getAllList(types,name)
      },
      /*点击大类添加确定*/
      ok() {
        let Goods = this;
         let url=this.url+'GoodsType/save';
         axios.post(url,{
            "storeId":this.storeid,
            "name":this.postData.goodName
         }).then(function (response) {
              Goods.$Message.info("添加成功");
              this.getlist();
          })
          .catch(function (error) {
            Goods.$Message.info(error);
          })
      },
      /*点击大类添加取消*/
      cancel() {
        this.$Message.info('操作取消');
      },
      /*小类展示*/
      goodsDetail(id,name){
        this.goodsdname=name;
        this.goodsid=id;
      },
      /*编辑大类*/
      ok2(){
        let Goods = this;
       let url=this.url;
         axios.post(url+'/GoodsType/save',
           {
             "id": this.goodsid,
             "storeId":this.storeid,
             "name":this.goodName1,
           })
          .then(function (response) {
            Goods.$Message.info("修改成功");
            setTimeout(function(){
              window.location.reload();
            }, 1000);
          })
          .catch(function (error) {
            Goods.$Message.info("error");
          })
      },
      cancel2(){
        this.$Message.info('操作取消');
      },
      /*删除大类*/
      deletes(){
        let Goods = this;
        let url=this.url+'GoodsType/delete?id='+this.goodsid+'';
        axios.get(url)
          .then(function (response) {
            Goods.$Message.info("删除成功");
            setTimeout(function(){
              window.location.reload();
            }, 1000);
          })
          .catch(function (error) {
            Goods.$Message.info("error");
          })
      },
     changegoods(list,index){
       this.sgnmae=list.name;
       this.sgprice=list.price;
       this.sgkucun=list.remanent;
       this.gsupname="修改商品";
       this.goodId=list.to_goods_detail_id;
       this.modal4=true;
       this.imgpath=list.img_path;
     },
      //图片处理
      uploadImg(){
        this.sgimg=window.document.getElementById("gnames3").children[1].files[0];

      },
      //添加商品(创建表单对象传输数据)
      //修改商品信息（使用同一个madel）
      addsg(){
        let Goods = this;
        let url1="";
        let file =  this.sgimg;
        let param = new FormData(); //创建form对象
        if(file!=null) {
          param.append('fileName', file, file.name);//通过append向form对象添加数据
        }
        else
          param.append('fileName',null);
        param.append('name',this.sgnmae);//添加form表单中其他数据
        param.append('price',this.sgprice);//添加form表单中其他数据
        param.append('remark',this.sgkucun);//添加form表单中其他数据
        param.append('goodsid',this.goodsid);
        param.append('storeId',this.storeid);//添加form表单中其他数据
       /* if(this.gsupname=="修改商品"){
         /!* url1=this.url+'/api/good/updateGood';*!/
          url1=this.url+'/Controller/goods/Gpath.php?good=updategood';
          param.append("goodId",this.goodId);
          param.append("p",this.imgpath);
        }else{
          /!*url1=this.url+'/api/good/addGood';*!/
          url1=this.url+'goods/fileUpload';
        }*/
        url1=this.url+'goods/fileUpload';
        let config = {
          headers:{'Content-Type':'multipart/form-data'}
        };  //添加
        if((this.gsupname=="添加商品"&&file==null)||this.sgnmae==""||this.sgnmae==null||this.getsum1(this.sgprice)==0||this.getsum1(this.sgkucun)==0||this.getsum1(this.sgkucun)==2){
          this.$Message.info('请输入正确的数据');
        }else {
          axios.post(url1, param, config)
            .then(function (response) {
              if (response.data.code == 0) {
                Goods.$Message.info("操作成功");
              } else {
                Goods.$Message.info("操作成功");
              }
              setTimeout(function () {
                window.location.reload();
              }, 1000);
            })
            .catch(function (error) {
              console.log(error);
              Goods.$Message.info("error");
            })
        }
      },
      //拼接图片地址
      getUrl(i){
        return this.url+'/'+this.dlist[i].img_path;
      },
      //判断是否合法数字
      getsum1(sum){
        sum=sum+"";
        if(sum.substr(0, 1)!='-'){
          if(sum.indexOf(".")==-1)
             return 1;
          else
             return 2;
        }else
          return 0;
      },
      //删除准备
      aheaddelete(url,id){
        this.dtid=id;
        this.dturl=url;
        this.modal5=true;

      },
      //删除小类
      gsdeletes(){
        let Goods = this;
        let url=this.url+'goods/delete?id='+this.dtid+'';
        axios.get(url)
          .then(function (response) {
            Goods.$Message.info("删除成功");
            setTimeout(function(){
              window.location.reload();
            }, 1000);
          })
          .catch(function (error) {
            Goods.$Message.info("error");
          })
      }

    },
  }
</script>

<style scoped>
  .imga{
    margin-left: 40%;
    margin-top: 10%;
  }

  .spana{
    margin-left: 43%;
    font-size: 18px;
  }
  .layout-content {
    margin: 15px;
    overflow: hidden;
    background: #eee;
    border-radius: 4px;
  }

  /*添加按钮样式*/
  .addicon {
    font-size: 40px;
    color: skyblue;
    position: fixed;
    margin-top: 2%;
    margin-left: 2%;
  }

  .menu_goods {
    height: 600px;
    float: left;
  }

  .content {
    background-color: white;
    height: 600px;
  }

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
    width:180px;
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
  .addicon1{
    font-size: 30px;
    color: skyblue;
    position: fixed;
    margin-top: 1%;
    margin-left: 5%;
  }

</style>
