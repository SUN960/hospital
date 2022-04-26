<template>
    <el-container>
            <el-aside width="200px" >
                <el-menu>
                <el-menu-item :index="item.userId" v-for="item in all_user" :key="item.userId" @click="getMessage(item.userId)">
        <i class="el-icon-user"></i>
            {{item.userName}}
            <span style="color:#7f7f7f;font-size:12px">{{getDate(item.createTime)}}</span>
           <el-badge class="mark" :value="item.unreadMess"  style="marginBottom:10px" v-show="item.unreadMess!='0'"/>
      </el-menu-item>
      
      </el-menu>
            </el-aside>
            <el-main>
                <el-card class="box-card" style="  overflow-y: visible;">
  <div v-for="(item,index) in all_text" :key="index" class="text item">
    <p style="color:#7f7f7f;font-size:12px">{{getDate(item.createTime)}}</p>
  <p  style="text-align:right" v-show="item.createBy=='1'"> <span class="bubble1">{{item.message}}</span> <i class="el-icon-user"></i></p>
  <p  style="text-align:left" v-show="item.createBy=='0'"> <i class="el-icon-user"></i> <span class="bubble2">{{item.message}}</span></p>  
  </div>
</el-card>
 <el-card class="box-card" style="height: 120px ">
<textarea class="textareaUser" v-model="form.message"></textarea>
<el-button type="success" style="float:right" @click="sendMessage()">发送</el-button>
 </el-card>

  </el-main>
    </el-container>
</template>
<script>
import { listMess,  addMess ,updateMess,getUser} from "@/api/chat/mess";
export default{
    name: "chatPeople",
    data() {
        return {
            userName: [1,2,3,4,5,6,7,8,9,0],
            all_text:[],
            // 表单参数
            form: {
              userId:"",
              message:"",
              createBy: "1"
            },
            update: {
              userId:"",
              status: "1"
            },
            all_user:[],
          queryParams:{userId:''}
        }
    },
    created() {
    // this.getList()
    this.getUser()
  },
    methods:{
      sendMessage(){
        // this.all_text.push({text:this.form.message,float:1});
        addMess(this.form).then(response => {
              this.$modal.msgSuccess("发送成功");
              this.getList();
            });
        this.form.message="";
      },
       /** 查询消息列表 */
    getList() {
      // this.loading = true;
      listMess(this.queryParams).then(response => {
        this.all_text=response.rows
      });
    },
    getUser(){
      getUser().then(response=>{
        console.log(response.rows)
        this.all_user=response.rows
      })
    },getMessage(userId){
      this.form.userId=userId
      this.queryParams.userId=userId
      this.update.userId=userId
      this.getList()
      updateMess(this.update).then(response=>{
        this.$modal.msgSuccess("获取成功");
        this.getUser()
      })
    },
    getDate(strDate) { 
  var st = strDate; 
  var a = st.split(" "); 
  var b = a[0].split("-"); 
  var c = a[1].split(":"); 
  var date = new Date(b[0], b[1], b[2], c[0], c[1], c[2]);
  var now=new Date();
  if(date.getMonth()==now.getMonth()+1 && date.getDate()==now.getDate())
  return c[0]+':'+c[1]; 
  else return date.getMonth()+'-'+date.getDate();
} 
    }
}
</script>
<style lang="scss" scoped>

.el-aside {
    background-color: white;
    color: #333;
    text-align: center;
    line-height: 550px;
    height: 550px;
    margin: 0px;
    padding: 0;
  
  }
   .el-main {
    background-color: #fff;
    color: #333;
    text-align: center;
    // line-height: 550px;
    height: 550px;
  }
  .text {
    font-size: 14px;
    line-height: 20px;
  }

  .item {
    padding: 3px 0;
  }
.textareaUser{
  width: 100%;
  border-style: none;
}
.textareaUser:focus{
  outline: none;
}

  .box-card {
    width: 96%;
    height: 400px;
  }
  .el-input{
    width: 96%;
  }
  .bubble1{
padding:8px; 
background-color:#12b7f5;
color:#fff;
border-radius: 5px;
  }
  .bubble2{
padding:8px;
 background-color: #e5e5e5;
 border-radius: 5px;
  }
</style>>

