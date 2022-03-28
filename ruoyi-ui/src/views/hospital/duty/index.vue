<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="医生名称" prop="docId" v-show="userRole">
        <el-select v-model="queryParams.docId" placeholder="请选择医生" clearable>
          <el-option
            v-for="item in docList"
            :key="item.docId"
            :label="item.docName"
            :value="item.docId"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="值班日期" prop="dutyTime">
        <el-select v-model="queryParams.dutyTime" placeholder="请选择值班日期" clearable>
          <el-option
            v-for="dict in dict.type.time_week"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="值班时间" prop="duringTime">
        <el-select v-model="queryParams.duringTime" placeholder="请选择值班时间" clearable>
          <el-option
            v-for="dict in dict.type.hos_change_day"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="值班状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择值班状态" clearable>
          <el-option
            v-for="dict in dict.type.hos_doc_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hospital:duty:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hospital:duty:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hospital:duty:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hospital:duty:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dutyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="值班编号" align="center" prop="dutyId" />
      <el-table-column label="医生名称" align="center" prop="hosDoc.docName" />
      <el-table-column label="预约人数" align="center" prop="orderNum" />
      <el-table-column label="值班日期" align="center" prop="dutyTime">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.time_week" :value="scope.row.dutyTime"/>
        </template>
      </el-table-column>
      <el-table-column label="值班时间" align="center" prop="duringTime">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hos_change_day" :value="scope.row.duringTime"/>
        </template>
      </el-table-column>
      <el-table-column label="值班状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hos_doc_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hospital:duty:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:duty:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改值班对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="docId">
          <el-select v-model="form.docId" placeholder="请选择医生" clearable>
          <el-option
            v-for="item in docList"
            :key="item.docId"
            :label="item.docName"
            :value="item.docId"
          />
        </el-select>
        </el-form-item>
        <el-form-item label="预约人数" prop="orderNum" >
          <el-input v-model="form.orderNum" placeholder="请输入显示顺序" />
        </el-form-item>
        <el-form-item label="值班日期" prop="dutyTime">
          <el-select v-model="form.dutyTime" placeholder="请选择值班日期">
            <el-option
              v-for="dict in dict.type.time_week"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="值班时间" prop="duringTime">
          <el-select v-model="form.duringTime" placeholder="请选择值班时间">
            <el-option
              v-for="dict in dict.type.hos_change_day"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="值班状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.hos_doc_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDuty, getDuty, delDuty, addDuty, updateDuty } from "@/api/hospital/duty";
import { listDoc } from "@/api/hospital/doc";
export default {
  name: "Duty",
  dicts: ['time_week', 'hos_change_day', 'hos_doc_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 值班表格数据
      dutyList: [],
      docList:[],
      userRole:true,
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        docId: null,
        dutyTime: null,
        duringTime: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        docId: [
          { required: true, message: "医生ID不能为空", trigger: "blur" }
        ],
        dutyTime: [
          { required: true, message: "值班日期不能为空", trigger: "change" }
        ],
        duringTime: [
          { required: true, message: "值班时间不能为空", trigger: "change" }
        ],
        status: [
          { required: true, message: "值班状态不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getList2();
    
  },
  methods: {
    /** 查询值班列表 */
    getList() {
      this.loading = true;
      listDuty(this.queryParams).then(response => {
        this.dutyList=response.rows
        this.total = response.total;
        this.loading = false;
      });
    },
    getList2() {
       this.loading = true;
      listDoc(this.queryParams).then(response => {
      this.docList = response.rows;
      const data=JSON.parse(sessionStorage.getItem("sessionObj")).data
      const userName=data.split("\"")[3]
      console.log(this.docList)
      this.docList.forEach(element => {
        console.log(element.docName)
        console.log(element.docName === userName)
      if(element.docName === userName){this.queryParams.docId = element.docId
      console.log(this.queryParams.docId)
      this.userRole=false
      this.handleQuery()
      }
      });
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        dutyId: null,
        docId: null,
        orderNum: null,
        dutyTime: null,
        duringTime: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.dutyId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加值班";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const dutyId = row.dutyId || this.ids
      getDuty(dutyId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改值班";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dutyId != null) {
            updateDuty(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDuty(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const dutyIds = row.dutyId || this.ids;
      this.$modal.confirm('是否确认删除值班编号为"' + dutyIds + '"的数据项？').then(function() {
        return delDuty(dutyIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hospital/duty/export', {
        ...this.queryParams
      }, `duty_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
