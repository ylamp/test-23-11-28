<template>
  <div>
    <h1>会员注册</h1>
    <div>
      登录账号：<input type="text" id="account" v-model="account" /><span
        class="color-red"
        >*</span
      >
    </div>
    <div>
      密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input
        type="password"
        id="password"
        v-model="password"
      /><span class="color-red">*</span>
    </div>
    <div>
      确认密码：<input
        type="password"
        id="password2"
        v-model="password2"
      /><span class="color-red">*</span>
    </div>
    <div>
      性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
      <select name="" id="gender" style="width: 140px;" v-model="gender">
        <option value="-1">请选择</option>
        <option value="1">男</option>
        <option value="0">女</option>
      </select>
      <span class="color-red">*</span>
    </div>
    <div>
      电子邮箱：<input type="text" id="email" v-model="email" />
      <span>&nbsp;&nbsp;</span>
    </div>
    <div>
      <input type="button" value="注册" @click="register" />
      <input type="button" value="返回" @click="back" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      account: "",
      password: "",
      password2: "",
      gender: -1,
      email: ""
    };
  },
  methods: {
    back() {
      this.$router.go(-1);
    },
    register() {
      new Promise((a, reject) => {
        if (this.account.length >= 5) {
          a(true);
        } else {
          reject("账号最低为5位");
        }
      })
        .then(r => {
          if (this.password.length >= 5) {
            return true;
          } else return Promise.reject("密码最低为5位");
        })
        .then(r => {
          if (this.password2 === this.password) {
            return true;
          } else return Promise.reject("再次密码不一致，请检查");
        })
        .then(r => {
          if (this.gender !== -1) {
            return true;
          } else return Promise.reject("请选择性别");
        })
        .then(r => {
          fetch("http://127.0.0.1:28801/users/api/register", {
            method: "post",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              userCode: this.account,
              password: this.password2,
              gender: this.gender,
              email: this.email
            })
          })
            .then(resultObj => {
              return resultObj.json();
            })
            .then(result => {
              if ("1001" !== result.code) {
                if (confirm("注册成功，是否跳转登录")) {
                  this.$router.push("/");
                }
              } else {
                alert("注册失败，请重试");
              }
            });
        })
        .catch(error => {
          alert(error);
        });
    }
  }
};
</script>

<style>
* {
  margin: 10px;
}
.color-red {
  color: red;
}
</style>
