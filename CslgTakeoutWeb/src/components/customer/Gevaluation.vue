<template>
  <div class="layout-content">
    <Card :bordered="false">
      <p slot="title">
        <span>顾客评价</span>
        <a style="font-size: 5px">查看评价报告</a>
      </p>
      <div>
        <div>
          <table style="width:75%;">
            <tr >
              <td>
              <div >饿了么</div>
              <div style="float: left">
                <h1>4.8</h1>
              </div>
              <div style="margin-left: 15%">
              <div >
              <Icon type="md-star" />
              <Icon type="md-star" />
              <Icon type="md-star" />
              <Icon type="md-star" />
              <Icon type="md-star" />
              </div>
              <div >
                <span >味道：4.8</span>
                <span>包装：4.8</span>
                <span>配送：5.0</span>
              </div>
              </div>
              </td>
              <td style="border-left: #5b6270 1px dashed;padding-left: 2%">
                <div>饿了么星选</div>
                <div style="float: left">
                  <h1>4.8</h1>
                </div>
                <div style="margin-left: 15%">
                  <div >
                    <Icon type="md-star" />
                    <Icon type="md-star" />
                    <Icon type="md-star" />
                    <Icon type="md-star" />
                    <Icon type="md-star" />
                  </div>
                  <div>
                    <span >味道：4.8</span>
                    <span>包装：4.8</span>
                    <span>配送：5.0</span>
                  </div>
                </div>
              </td>
            </tr>

          </table>
        </div>
        <Tabs value="name1" >
          <TabPane label="全部评价" name="name1">
              <table style="width: 90%">
               <!-- <tr>
                <td>评价日期</td>
                <td>
                  <button @click="evalTypes(0,0)">今天</button>
                  <button @click="evalTypes(0,1)">近7天</button>
                  <button @click="evalTypes(0,2)">近30天</button>
                  <DatePicker :value="value2" format="yyyy/MM/dd" type="daterange" placement="bottom-end" placeholder="选择日期" style="width: 200px"></DatePicker>
                </td>
              </tr>-->
                <tr>
                  <td>回复情况</td>
                  <td>
                    <button @click="evalTypes(1,0)">全部</button>
                    <button @click="evalTypes(1,1)">未回复</button>
                    <button @click="evalTypes(1,2)">已回复</button>
                  </td>
                </tr>
                <tr>
                  <td>评价类型</td>
                  <td>
                    <button @click="evalTypes(2,0)">全部</button>
                    <button @click="evalTypes(2,1)">差评(1-2星)</button>
                    <button @click="evalTypes(2,3)">中评(3星)</button>
                    <button @click="evalTypes(2,4)">好评(4-5星)</button>
                  </td>
                <tr>
                  <td>评价内容</td>
                  <td>
                    <button>全部</button>
                    <button>有内容评价</button>
                    <button >有图片评价</button>
                  </td>
                </tr>
              </table>
<!--            评价的最大div-->
            <div style="margin-top: 1%;" v-for="(cus,index) in showList">
<!--              小层div-->
              <div>
<!--                头像div-->
                <div style="float: left">
                  <img :src=getUrl(index) style="width: 70px;height: 70px;border-radius: 50%">
                </div>
<!--                评价内容div-->
                <div>
                  <table>
                    <tr>
                      <td><h3>{{cus.name}}</h3></td>
                    </tr>
                    <tr>
                      <td>
                        <span v-for="(cuss,indexs) in parseInt(cus.score)" >
                        <Icon type="md-star"  @click="$Message.info(cus.score)" />
                        </span>
                      </td>
                    </tr>
                    <tr>
                      <span>味道：{{cus.score}}星 &nbsp;</span>
                      <span>包装：{{cus.score}}星</span>
                    </tr>
                    <tr>
                      <span style="font-size:10px">{{cus.content}}</span>
                    </tr>
                    <tr>
                      <Icon type="md-thumbs-up" />
                      <span style="font-size:10px">炸鸡</span>
                    </tr>
                  </table>
                </div>
              </div>
              <div style="clear: both"></div>
            </div>
<!--            分页-->
            <Page :total="dataCount" :page-size="pageSize" show-total @on-change="changepage"></Page>
          </TabPane>
          <TabPane label="优质评价" name="name2">
<!--            <table style="width: 90%">-->
<!--              <tr>-->
<!--                <td>评价日期</td>-->
<!--                <td>-->
<!--                  <button >今天</button>-->
<!--                  <button >近7天</button>-->
<!--                  <button >近30天</button>-->
<!--                  <button >近90天</button>-->
<!--                  <DatePicker :value="value2" format="yyyy/MM/dd" type="daterange" placement="bottom-end" placeholder="选择日期" style="width: 200px"></DatePicker>-->
<!--                </td>-->
<!--              </tr>-->
<!--              <tr>-->
<!--                <td>回复情况</td>-->
<!--                <td>-->
<!--                  <button >全部</button>-->
<!--                  <button >未回复</button>-->
<!--                  <button >已回复</button>-->
<!--                </td>-->
<!--              </tr>-->
<!--              <tr>-->
<!--                <td>评价类型</td>-->
<!--                <td>-->
<!--                  <button >全部</button>-->
<!--                  <button >差评(1-2星)</button>-->
<!--                  <button >中评(3星)</button>-->
<!--                  <button >好评(4-5星)</button>-->
<!--                </td>-->
<!--              </tr>-->
<!--              <tr>-->
<!--                <td>评价内容</td>-->
<!--                <td>-->
<!--                  <button >全部</button>-->
<!--                  <button >有内容评价</button>-->
<!--                  <button >有图片评价</button>-->
<!--                </td>-->
<!--              </tr>-->
<!--              <tr>-->
<!--                <td>评价来源</td>-->
<!--                <td>-->
<!--                  <button >全部</button>-->
<!--                  <button >饿了么</button>-->
<!--                  <button >饿了么星选</button>-->
<!--                </td>-->
<!--              </tr>-->
<!--            </table>-->
<!--            <span>共50条相关评价</span>-->
<!--            &lt;!&ndash;            评价的最大div&ndash;&gt;-->
<!--            <div style="margin-top: 1%" v-for="(cus,index) in cevaluation">-->
<!--              &lt;!&ndash;              小层div&ndash;&gt;-->
<!--              <div>-->
<!--                &lt;!&ndash;                头像div&ndash;&gt;-->
<!--                <div style="float: left">-->
<!--                  <img src="@/assets/logo.png" style="width: 70px;height: 70px;border-radius: 50%">-->
<!--                </div>-->
<!--                &lt;!&ndash;                评价内容div&ndash;&gt;-->
<!--                <div>-->
<!--                  <table>-->
<!--                    <tr>-->
<!--                      <td><h3>{{cus.name}}</h3></td>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                      <td>-->
<!--                        <Icon type="md-star" />-->
<!--                        <Icon type="md-star" />-->
<!--                        <Icon type="md-star" />-->
<!--                        <Icon type="md-star" />-->
<!--                        <Icon type="md-star" />-->
<!--                      </td>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                      <span>味道：{{cus.taste}}星 &nbsp;</span>-->
<!--                      <span>包装：{{cus.pack}}星</span>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                      <span style="font-size:10px">购买了{{cus.food1}}{{cus.food2}}{{cus.food3}}</span>-->
<!--                    </tr>-->
<!--                    <tr>-->
<!--                      <Icon type="md-thumbs-up" />-->
<!--                      <span style="font-size:10px">{{cus.food1}}{{cus.food2}}{{cus.food3}}</span>-->
<!--                    </tr>-->
<!--                  </table>-->
<!--                </div>-->
<!--              </div>-->
<!--              <div style="clear: both"></div>-->

<!--            </div>-->
          </TabPane>
          <TabPane label="回复设置" name="name3">

          </TabPane>
          <TabPane label="申诉历史" name="name4">

          </TabPane>
        </Tabs>
      </div>
    </Card>

  </div>
</template>

<script>
    // import DatePicker from "iview/src";
    import axios from 'axios'
    export default {
        name: "Gevaluation",
      // components: {DatePicker},
      data(){
          return{
            value2: ['2019-05-01', '2019-06-01'],
            // 用户评价数组
            customerlist:[],
            //分页数组
            showList:[],
            //总长度
            dataCount:0,
            // 每页显示多少条
            pageSize:4,
            // 评价日期的值
            evalDate:null,
            // 回复情况的值
            reply:null,
            // 评价类型的值
            evalType:1,
            // 评价内容
            evalContent:null
          }
      },
      mounted:function(){
        this.getlist();
      },
      computed:{
        filteredBlogs(){
          return this.customerlist.filter((blog)=>{
            let a=true,b=true,c=true;
            if(this.evalType==0){
              a= true;
            }else if(this.evalType==1){
              a= parseInt(blog.score)==1||parseInt(blog.score)==2;
            }else if(this.evalType==3){
              a= parseInt(blog.score)==3;
            }else if(this.evalType==4){
              a= parseInt(blog.score)==4||parseInt(blog.score)==5;
            }else{
              a= false;
            }
            if(this.reply==0)
              b=true;
            else if(this.reply==1){
              b=blog.respond_sign=="not_read";
            }else if(this.reply==2){
              b=blog.respond_sign=="is_read";
            }
            return a&&b;
          });
         /*  if(this.customerlist.length!=0) {
             this.dataCount = this.customerlist.length;
             this.showList = this.customerlist
           }*/
        /*   this.customerlist;*/
        }
      },
      methods:{
          //点击改变数组
        evalTypes(sign,value){
          if(sign==0){
            this.evalDate=value;
          }else if(sign==1){
            this.reply=value;
          }else if(sign==2){
            this.evalType=value;
          }
          this.dataCount = this.filteredBlogs.length;
          if(this.dataCount<=4)
            this.showList=this.filteredBlogs;
          else
            this.showList = this.filteredBlogs.slice(0,4);
        },
          // 获取用户评价信息
        getlist(){
          let Customer1 = this;
          let url=this.url;
          let url2=url+'/Controller/store/Customer.php?storeId='+this.storeid+'&store=showgrade';
          axios.get(url2)
          // 获取成功
            .then(function (response) {
              Customer1.customerlist=response.data;
              // 获取总条数
              Customer1.dataCount = Customer1.customerlist.length;
              if(Customer1.dataCount < Customer1.pageSize){
                Customer1.showList = Customer1.customerlist;
              }
              else{
                Customer1.showList = Customer1.customerlist.slice(0,Customer1.pageSize);
              }
            })
            // 获取失败
            .catch(function (error) {
              Customer1.$Message.info("失败");
            })
        },
        //拼接图片地址
        getUrl(i){
          return this.url+'/'+this.customerlist[i].img_path;
        },
        // 获取页数后改变页数
        changepage(index){
          var _start = (index - 1) * this.pageSize;
          var _end = index * this.pageSize;
          this.dataCount = this.filteredBlogs.length;
          if(this.dataCount<=4)
            this.showList=this.filteredBlogs;
          else
          this.showList = this.filteredBlogs.slice(_start,_end);
        },


      }
    }
</script>

<style scoped>
  .layout-content {
    margin: 15px;
    background:#eee;
    border-radius: 4px;
    overflow:scroll;
  }
  button{
    background-color:white;
    border: none;
    width: auto;
    padding: 0.5%;
  }
  button :hover :active{
    background-color: #eeeeee;
    color: #2b85e4;
  }
</style>
