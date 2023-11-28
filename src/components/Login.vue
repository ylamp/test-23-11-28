<template>
  <div>
    <h1>图书借阅系统</h1>
    <div>登录账号：<input type="text" v-model="account" /></div>
    <div>登录密码：<input type="password" v-model="password" /></div>
    <div>
      <input type="button" value="登录｜Login" @click="login" />
      <input type="button" value="注册用户" @click="toRegister" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      account: "",
      password: ""
    };
  },
  methods: {
    toRegister() {
      this.$router.push("/register");
    },
    login() {
      if ("" !== this.account && this.account.length >= 5) {
        if ("" !== this.password && this.password.length >= 5) {
          fetch("http://127.0.0.1:28801/users/api/login", {
            method: "post",
            headers: {
              "Content-Type": "application/json"
            },
            body: JSON.stringify({
              userCode: this.account,
              password: this.password
            })
          })
            .then(resultObj => {
              return resultObj.json();
            })
            .then(result => {
              if ("1001" !== result.code) {
                localStorage.setItem("userInfo", JSON.stringify(result.data));
                this.$router.push("/home");
              } else {
                alert(result.msg);
              }
            });
        } else {
          alert("密码的长度最低为5位");
        }
      } else {
        alert("账号的长度最低为5位");
      }
    }
  }
};
</script>

<style>
* {
  margin: 10px;
}
</style>
