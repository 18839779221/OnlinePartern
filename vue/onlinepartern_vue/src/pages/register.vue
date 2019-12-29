<template>
  <div id="d-main">
    <!-- <div class="d-step">
      <el-steps :active="1" finish-status="success" simple style="margin-top: 20px">
        <el-step title="步骤 1"></el-step>
        <el-step title="步骤 2"></el-step>
        <el-step title="步骤 3"></el-step>
      </el-steps>
    </div>-->
    <div class="d-form">
      <el-card class="box-card">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="e-form">
          <el-form-item label="手机号码" prop="phone">
            <el-input v-model="ruleForm.phone"></el-input>
          </el-form-item>

          <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password" show-password></el-input>
          </el-form-item>

          <el-form-item label="昵称" prop="nick">
            <el-input v-model="ruleForm.nick"></el-input>
          </el-form-item>

          <el-form-item label="性别" prop="sex">
            <el-radio v-model="ruleForm.sex" label="1">男</el-radio>
            <el-radio v-model="ruleForm.sex" label="2">女</el-radio>
          </el-form-item>

          <el-form-item label="婚姻状况" prop="marrage">
            <el-select v-model="ruleForm.marrage" placeholder="请选择">
              <el-option
                v-for="item in maroptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>

          <!-- <el-form-item label="生日">
            <el-col>
              <el-form-item prop="birthday">
                <el-date-picker
                  type="date"
                  placeholder="选择生日"
                  v-model="ruleForm.birthday"
                  style="width: 100%;"
                ></el-date-picker>
              </el-form-item>
            </el-col>
          </el-form-item> -->

          <el-form-item label="学历" prop="educate">
            <el-select v-model="ruleForm.educate" placeholder="请选择">
              <el-option
                v-for="item in eduoptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="专业" prop="prof">
            <el-input v-model="ruleForm.prof"></el-input>
          </el-form-item>

          <el-form-item label="收入" prop="income">
            <el-select v-model="ruleForm.income" placeholder="请选择">
              <el-option
                v-for="item in incoptions"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="身高" prop="height">
            <el-input v-model.number="ruleForm.height" placeholder="单位:cm"></el-input>
          </el-form-item>

          <el-form-item label="照片上传">
            <imgUpload ref="imgRef" />
          </el-form-item>

          <el-form-item label="地址" prop="addr">
            <el-input v-model="ruleForm.addr"></el-input>
          </el-form-item>

          <el-form-item label="个性签名" prop="note">
            <el-input type="textarea" v-model="ruleForm.note" placeholder="快来介绍下自己吧，让更多优秀的人认识你！"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即注册</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
            <!-- <el-button @click="test()">测试</el-button> -->
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script>
import validate from "@/utils/customerValidate";
import imgUpload from "@/components/imgupload";
import http from "../http.js";

export default {
  
  name: "register",
  components: { imgUpload },
  data() {
    return {
      maroptions: [
        {
          value: 1,
          label: "未婚"
        },
        {
          value: 2,
          label: "已有朋友"
        },
        {
          value: 3,
          label: "已婚"
        },
        {
          value: 4,
          label: "离异"
        },
        {
          value: 5,
          label: "其他"
        }
      ],
      eduoptions: [
        {
          value: 1,
          label: "无"
        },
        {
          value: 2,
          label: "小学"
        },
        {
          value: 3,
          label: "初中"
        },
        {
          value: 4,
          label: "高中"
        },
        {
          value: 5,
          label: "本科"
        },
        {
          value: 6,
          label: "硕士"
        },
        {
          value: 7,
          label: "博士"
        }
      ],
      incoptions: [
        {
          value: 1,
          label: "5000-"
        },
        {
          value: 2,
          label: "5000~10000"
        },
        {
          value: 3,
          label: "10000~20000"
        },
        {
          value: 4,
          label: "20000~50000"
        },
        {
          value: 5,
          label: "50000以上"
        },
        {
          value: 6,
          label: "X 二代"
        }
      ],
      ruleForm: {
        phone: "18839779221",
        password: "ewqewq",
        nick: "",
        sex: "1",
        marrage: 1,
        // birthday: "",
        educate: 1,
        prof: "",
        height: 170,
        income: 1,
        addr: "",
        note: ""
      },
      rules: {
        phone: [
          { required: true, message: "请输入正确的手机号", trigger: "blur" },
          { validator: validate.isMobile, trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { validator: validate.isPasswd, trigger: "blur" }
        ],
        nick: [
          { required: false, message: "请输入昵称", trigger: "blur" },
          { validator: validate.isNick, trigger: "blur" }
        ],
        // birthday: [
        //   { type: "date", required: false, message: "请选择日期", trigger: "change"}
        // ],
        educate: [
          {
            required: false,
            message: "请选择学历，以帮助您更好匹配合适的伴侣",
            trigger: "change"
          }
        ],
        height: [
          { required: false, message: "请输入合适的身高" },
          { type: "number", message: "请输入合适的身高" }
        ],
        note: [
          { required: false, message: "请好好描述下自己吧", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    register() {
      console.log(this.ruleForm)
      http
        .fetchPost("/user/register", {
          phone: this.ruleForm.phone,
          password: this.encode(this.ruleForm.password),
          nick: this.ruleForm.nick,
          prof: this.ruleForm.prof,
          income: this.ruleForm.income,
          addr: this.ruleForm.addr,
          height: this.ruleForm.height,
          img: this.$refs.imgRef.imageUrl,
          marrage: this.ruleForm.marrage,
          sex: this.ruleForm.sex,
          birthday: this.ruleForm.birthday,
          educate: this.ruleForm.educate,
          note: this.ruleForm.note
        })
        .then(data => {
          this.$message({
            type: 'success',
            message: '注册成功，即将跳转到主页！'
          }); 
          console.log(data);
          this.$router.push('/')
        })
        .catch(err => console.log(err));
    },
    submitForm(formName) {
      var reg = this.register;
      this.$refs[formName].validate(valid => {
        if (valid) {
          reg();
        } else {
          this.$message({
            type: 'warning',
            message: '提交失败，请检查信息是否填写完整！'
          }); 
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    encode(str){
      return this.$md5(str)
    },
    test(){
      console.log(this.ruleForm.birthday.toLocaleDateString())
    }
  }
};
</script>

<style>
#d-main {
  display: flex;
  flex-direction: column;
  align-items: stretch;
  justify-content: space-around;
  margin-top: 30px;
  margin-left: 25%;
  margin-right: 25%;
}
/* #d-step {
  order: 1;
} */
#d-form {
  order: 2;
}
.e-form {
  padding-top: 10%;
  padding-left: 5%;
  padding-right: 5%;
}
</style>
