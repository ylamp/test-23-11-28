<template>
  <div>
    <h1>图书借阅系统</h1>
    <div>
      图书分类：
      <select v-model="bookType">
        <option value="0">请选择</option>
        <option
          v-for="(bookType, id) in bookTypes"
          :value="bookType.id"
          :key="id"
          >{{ bookType.typeName }}</option
        >
      </select>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      图书名称：<input type="text" v-model="bookName" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      是否借阅：<select name="" id="" v-model="isBorrow">
        <option value="-1">请选择</option>
        <option value="1">是</option>
        <option value="0">否</option>
      </select>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="查询" @click="page(currentPage)" />
    </div>
    <div
      style="height: 50px;line-height: 50px;text-align: right;padding-right: 500px;"
    >
      当前用户：{{ userCode }}
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="javascript:void(0)" @click="logout">退出</a>
    </div>
    <div>
      <div style="width: 720px;margin: 0 auto;">
        <table border="1px">
          <tr>
            <th style="width: 100px;">图书编号</th>
            <th style="width: 100px;">图书分类</th>
            <th style="width: 180px;">图书名称</th>
            <th style="width: 160px;">作者</th>
            <th style="width: 150px;">出版社</th>
            <th style="width: 80px;">操作</th>
          </tr>
          <tr v-for="(book, id) in bookList.records" :key="id">
            <td>{{ book.bookCode }}</td>
            <td>{{ book.typeName }}</td>
            <td>{{ book.bookName }}</td>
            <td>{{ book.userCode }}</td>
            <td>{{ book.publishPress }}</td>
            <td>
              <span v-if="book.isBorrow == 1" style="color: red;">已借阅</span>
              <a
                href="javascript:void(0)"
                v-else-if="book.isBorrow == 0"
                @click="borrow(book.bookId, 1)"
                >申请借阅</a
              >
            </td>
          </tr>
        </table>
      </div>
      <div style="height: 20px;"></div>
      <div>
        <a
          href="javascript:void(0)"
          @click="page(currentPage > 0 ? currentPage - 1 : 1)"
          >上一页</a
        >
        <a href="javascript:void(0)" @click="page(currentPage + 1)">下一页</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span
          >到第<input v-model="goPage" style="width: 20px;" type="text"/>页面
          <input type="button" value="确定" @click="page(goPage)"
        /></span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userCode: "加载中",
      bookTypes: "",
      bookList: "",
      currentPage: 1,
      bookType: 0,
      bookName: "",
      isBorrow: -1,
      goPage: 1
    };
  },
  methods: {
    page(page) {
      fetch(
        "http://127.0.0.1:28803/bookInfo/api/getList?bookType=" +
          this.bookType +
          "&bookName=" +
          this.bookName +
          "&isBorrow=" +
          this.isBorrow +
          "&currentPage=" +
          page
      )
        .then(resultObj => {
          return resultObj.json();
        })
        .then(result => {
          this.bookList = result.data;
        });
    },
    logout() {
      localStorage.removeItem("userInfo");
      this.$router.push("/");
    },
    borrow(bookId, status) {
      fetch(
        "http://127.0.0.1:28803/bookInfo/api/borrow?bookId=" +
          bookId +
          "&status=" +
          status
      )
        .then(resultObj => {
          return resultObj.json();
        })
        .then(result => {
          if (result.code == 200) {
            alert("借阅成功");
            this.bookList.records.filter(t => {
              if (bookId === t.bookId) {
                t.isBorrow = 1;
              }
            });
          } else {
            alert("借阅失败，请重试");
          }
        });
    }
  },
  mounted() {
    let userInfo = JSON.parse(localStorage.getItem("userInfo"));
    this.userCode = userInfo.userCode;
    fetch("http://127.0.0.1:28802/bookType/api/getList")
      .then(resultObj => {
        return resultObj.json();
      })
      .then(result => {
        this.bookTypes = result.data;
      });

    fetch(
      "http://127.0.0.1:28803/bookInfo/api/getList?bookType=" +
        this.bookType +
        "&bookName=" +
        this.bookName +
        "&isBorrow=" +
        this.isBorrow +
        "&currentPage=" +
        this.currentPage
    )
      .then(resultObj => {
        return resultObj.json();
      })
      .then(result => {
        this.bookList = result.data;
      });
  }
};
</script>

<style></style>
