<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="docName">
        <el-input
          v-model="queryParams.docName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职称" prop="prot">
        <el-input
          v-model="queryParams.prot"
          placeholder="请输入职称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择用户性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期" prop="birthTime">
        <el-input
          v-model="queryParams.birthTime"
          placeholder="请输入出生日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="科室名称" prop="adoId">
        <el-select v-model="queryParams.adoId" placeholder="请选择科室名称" clearable>
          <el-option
            v-for="ado in adoList"
            :key="ado.adoId"
            :label="ado.adoName"
            :value="ado.adoId"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="医生状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择医生状态" clearable>
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
          v-hasPermi="['hospital:doc:add']"
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
          v-hasPermi="['hospital:doc:edit']"
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
          v-hasPermi="['hospital:doc:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hospital:doc:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="docList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工作证号" align="center" prop="docId" />
      <el-table-column label="姓名" align="center" prop="docName" />
      <el-table-column label="职称" align="center" prop="prot" />
      <el-table-column label="用户性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="出生日期" align="center" prop="birthTime" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="手机号码" align="center" prop="phonenumber" />
      <el-table-column label="科室名称" align="center" prop="hosAdo.adoName" />
      <el-table-column label="医生状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.hos_doc_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark"  show-overflow-tooltip/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hospital:doc:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:doc:remove']"
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

    <!-- 添加或修改医生对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="docName">
          <el-input v-model="form.docName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="图像地址" prop="avatar">
          <el-input v-model="form.avatar" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="职称" prop="prot">
          <el-input v-model="form.prot" placeholder="请输入职称" />
        </el-form-item>
        <el-form-item label="用户性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择用户性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthTime">
          <el-input v-model="form.birthTime" placeholder="请输入出生日期" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="手机号码" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入手机号码" />
        </el-form-item>
        <el-form-item label="科室名称" prop="adoId">
         <el-select v-model="form.adoId" placeholder="请选择科室名称" clearable>
          <el-option
            v-for="ado in adoList"
            :key="ado.adoId"
            :label="ado.adoName"
            :value="ado.adoId"
          />
        </el-select>
        </el-form-item>
        <el-form-item label="显示顺序" prop="orderNum">
          <el-input v-model="form.orderNum" placeholder="请输入显示顺序" />
        </el-form-item>
        <el-form-item label="医生状态">
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
import { listDoc, getDoc, delDoc, addDoc, updateDoc } from "@/api/hospital/doc";
import { listAdo } from "../../../api/hospital/ado";
export default {
  name: "Doc",
  dicts: ['sys_user_sex', 'hos_doc_status'],
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
      // 医生表格数据
      docList: [],
      adoList:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        docName: null,
        prot: null,
        sex: null,
        birthTime: null,
        adoId: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        docName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        prot: [
          { required: true, message: "职称不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "用户性别不能为空", trigger: "change" }
        ],
        birthTime: [
          { required: true, message: "出生日期不能为空", trigger: "blur" }
        ],
        phonenumber: [
          { required: true, message: "手机号码不能为空", trigger: "blur" }
        ],
        adoId: [
          { required: true, message: "科室ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getList2();
  },
  methods: {
    /** 查询医生列表 */
    getList() {
      this.loading = true;
      listDoc(this.queryParams).then(response => {
        this.docList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getList2(){
      listAdo(this.queryParams).then(response => {
        this.adoList = response.rows;
        
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
        docId: null,
        docName: null,
        avatar: null,
        prot: null,
        sex: null,
        birthTime: null,
        email: null,
        phonenumber: null,
        adoId: null,
        orderNum: null,
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
      this.ids = selection.map(item => item.docId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医生";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const docId = row.docId || this.ids
      getDoc(docId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改医生";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.docId != null) {
            updateDoc(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDoc(this.form).then(response => {
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
      const docIds = row.docId || this.ids;
      this.$modal.confirm('是否确认删除医生编号为"' + docIds + '"的数据项？').then(function() {
        return delDoc(docIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hospital/doc/export', {
        ...this.queryParams
      }, `doc_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
