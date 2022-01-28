<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="25" :lg="24">
        <blockquote class="text-warning" style="font-size: 20px"  >
        <h1></h1>
          <br />
         <h1> </h1>

        </blockquote>
        <hr />
      </el-col>
    </el-row>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log" style="width: 300%">
          <div slot="header" class="clearfix">
            <span>合肥安美眼科医院简介</span>
          </div>
          <el-collapse accordion>
           <p><span style="font-size: 16px;">合肥安美眼科医院是集医疗、教学、科研、预防、康复、急救为一体的大型综合性教学医院，为国家卫生应急医疗移动救治中心和安徽省紧急医疗救治基地。医院前身为上海东南医学院附属东南医院，创办于1926年。1949年内迁至安徽怀远县，1952年迁至合肥市。1993年成为卫生部首批三级甲等医院。医院连续11年入围中国最佳医院百强榜，科研学术排名全国50位，综合实力稳居安徽前茅。在国家三级公立医院绩效考核中，医院排名全国第42位，评价等级A+。</span></p>
           <p><span style="font-size: 16px;">目前，医院共开放床位4990张，年门诊量超556万人次，年出院病人超24万人次，年标准手术约12万台次，医院拥有卫生部重点实验室数1个，省部重点实验室数10个，国家药物临床试验机构16个，国家卫健委专科、住院医师培训基地共42个,获批10个国家临床医学研究分中心和5个安徽省临床医学研究中心。</span></p>
           <p><span style="font-size: 16px;">医院现有博士生导师100余人，高级职称专家900余人，享受国务院和省政府特殊津贴130多人，全国“百千万人才工程”8人，全国“有突出贡献的中青年专家”8人，国家百千万工程领军人才1人，长江学者2人、青年长江学者1人，国家万人计划中组部青年拔尖人才1人，皖江学者3人，一级主任医师30人，安徽省特支计划4人，省厅以上跨世纪学术技术带头人、骨干教师300余人，“江淮名医”61人，担任中华医学会、中国医师协会等省级以上医学学术团体负责人100多人，人才实力位居安徽省医疗机构第一。</span></p>
           <p><span style="font-size: 16px;">医院坚持科教兴院战略，银屑病的遗传学研究和红斑狼疮基因研究处于国际领先水平。医院拥有安徽省首台达芬奇手术机器人，目前机器人手术已经在泌尿外科、普外科、妇产科、心脏大血管外科广泛应用，处于国内领先水平。新增合肥市首台骨科机器人，机器人家族不断壮大。3D腹腔镜手术技术、辅助生殖技术、体外循环和心脏不停跳冠脉搭桥、心脑血管介入治疗、胸腔镜和腹腔镜微创手术、自体、异体造血干细胞移植、小儿先心病介入治疗、小儿脑瘫的康复治疗、电子耳蜗技术、中西医结合治疗肿瘤等专业技术水平达到国内先进水平。在肝肾联合移植、婴幼儿肾脏捐献移植等复杂器官移植领域，取得了积极成效，达到国内领先水平；在中西医结合治疗大面积烧伤、微粒皮移植、角膜移植术、颅底肿瘤临床手术和立体定向放射外科等方面积累了丰富的经验,处省内领先地位。</span></p>
           <p><span style="font-size: 16px;">医院高度重视医学教育工作。年教学工作量超1.9万学时，留学生教学约1100学时，年接收实习生、进修医生1000多人，每年承担国家级和省级继续教育项目60余项，每年培训近万人，为基层医院人才培养做出了积极贡献。</span></p>
           <p><span style="font-size: 16px;">近年来，医院承担国家科技重大专项、国家重点研发计划项目、国家自然科学基金项目等纵向科研课题近600项，获省部级以上奖项100余项，其中获国家科技进步二等奖1项，国家自然科学二等奖1项,教育部自然科学一等奖1项，三获中华医学科技一等奖，华夏医学科技奖一等奖1项，安徽省科学技术奖几十项。主编和参编国家级规划教材30余部，每年发表SCI收录论文500余篇。</span></p>
           <p><span style="font-size: 16px;">医院主办5种国内外公开发行杂志：《肝胆外科杂志》、《临床骨科杂志》、《临床眼科杂志》、《临床护理杂志》、《临床肺科杂志》。医院与美国、荷兰、德国、日本、香港等国家和地区的科学研究机构建立了密切的科研合作关系。</span></p>
           <p><span style="font-size: 16px;">医院近年来荣获全国抗击新冠肺炎疫情先进集体、全国五一劳动奖状、全国援外先进集体、中华全国总工会“模范职工之家”、全国青年文明号、全国百姓放心示范医院、全国卫生系统“巾帼建功标兵”、全国城市医院思想政治工作先进集体、全国人文爱心医院等多项荣誉。</span></p>
            <p><span style="font-size: 16px;">医院精神与院训： 逊志时敏 弘德善医</span></p>
            <p><span style="font-size: 16px;">医院宗旨：德高术精 济世康民</span></p>
            <p><span style="font-size: 16px;">医院愿景：建设国内先进、特色鲜明的现代化综合性医院</span></p>       
          </el-collapse>
        </el-card>
      </el-col>
    
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.0",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    background-image:url("../assets/images/hospital.png");
    background-size:100% 100%;
    padding: 30px 30px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  span{
    font-size:25px;
    color:#007FA9;
  }
  h1{
   font-size:17px;
   color:white;
   line-height:5px;

  }

  h3{
    font-size:20px;
    color:#676a6c;
    line-height:60px;
    line-width:30px;
  }

  h2{
  font-size:18px;
      color:#676a6c;
      line-height:50px;
      line-width:30px;
  }
}
</style>

