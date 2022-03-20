<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户账号" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户账号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医生姓名" prop="docId">
        <el-select v-model="queryParams.docId" placeholder="请选择医生" clearable>
          <el-option
            v-for="item in docList"
            :key="item.docId"
            :label="item.docName"
            :value="item.docId"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="病情" prop="illSituation">
        <el-input
          v-model="queryParams.illSituation"
          placeholder="请输入病情"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
     
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.hos_appointment"
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
          v-hasPermi="['hospital:info:add']"
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
          v-hasPermi="['hospital:info:edit']"
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
          v-hasPermi="['hospital:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hospital:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="预约编号" align="center" prop="appointId" />
      <el-table-column label="用户账号" align="center" prop="userId" />
      <el-table-column label="医生姓名" align="center" prop="hosDoc.docName" />
      <el-table-column label="病情" align="center" prop="illSituation" show-overflow-tooltip/>
      <el-table-column label="预约日期" align="center" prop="dateTime" width="120"/>
        
      <el-table-column label="挂号号码" align="center" prop="number" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hos_appointment" :value="scope.row.status"/>
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
            v-hasPermi="['hospital:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:info:remove']"
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

    <!-- 添加或修改预约信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户账号" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户账号" />
        </el-form-item>
        <el-form-item label="医生名称" prop="docId">
          <el-select v-model="form.docId" placeholder="请选择医生" clearable>
          <el-option
            v-for="item in docList"
            :key="item.docId"
            :label="item.docName"
            :value="item.docId"
          />
        </el-select>
        </el-form-item>
        <el-form-item label="病情" prop="illSituation">
          <el-input v-model="form.illSituation" placeholder="请输入病情" />
        </el-form-item>
        <el-form-item label="预约日期" prop="dateTime">
          <el-input v-model="form.dataTime" placeholder="请输入时间YYYY/MM/DD AM or PM" />
        </el-form-item>
        <el-form-item label="挂号号码" prop="number">
          <el-input v-model="form.number" placeholder="请输入挂号号码" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.hos_appointment"
              :key="dict.value"
:label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="值班id" prop="dutyId">
          <el-input v-model="form.dutyId" placeholder="请输入值班id" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-input v-model="form.endTime" placeholder="请输入结束时间" />
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
import { listInfo, getInfo, delInfo, addInfo, updateInfo } from "@/api/hospital/info";
import {listDoc} from "@/api/hospital/doc";
export default {
  name: "Info",
  dicts: ['hos_appointment'],
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
      // 预约信息表格数据
      infoList: [],
      docList:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        docId: null,
        illSituation: null,
        dateTime: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户账号不能为空", trigger: "blur" }
        ],
        docId: [
          { required: true, message: "医生id不能为空", trigger: "blur" }
        ],
        illSituation: [
          { required: true, message: "病情不能为空", trigger: "blur" }
        ],
        dateTime: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
        number: [
          { required: true, message: "挂号号码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getList2();
  },
  methods: {
    /** 查询预约信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },getList2() {
      this.loading = true;
      listDoc(this.queryParams).then(response => {
        this.docList = response.rows;
      
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
        appointId: null,
        userId: null,
        docId: null,
        illSituation: null,
        dateTime: null,
        number: null,
        status: "0",
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        dutyId: null,
        endTime: null
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
      this.ids = selection.map(item => item.appointId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加预约信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const appointId = row.appointId || this.ids
      getInfo(appointId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改预约信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.appointId != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInfo(this.form).then(response => {
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
      const appointIds = row.appointId || this.ids;
      this.$modal.confirm('是否确认删除预约信息编号为"' + appointIds + '"的数据项？').then(function() {
        return delInfo(appointIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hospital/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
