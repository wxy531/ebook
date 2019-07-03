<template>
<div>
  <div id="title">
  <img :src="this.$route.params.id.cover" height="30px" width="30px">
    <a>{{this.$route.params.id.bookName}}</a>
</div>
<div id="more_msg">
  <h>详细信息：</h>
    <h >{{this.$route.params.id.detail}}</h>
</div>
  <div>
    <button @click="geteva" class="debutton">书评</button>
    <div v-if="book">
      <tr v-for="(p, index) in itemList" :key="index">
        <td>用户：</td>
        <td>{{p.username}}</td>
        <td>评论：</td>
        <td>{{p.eva}}</td>
      </tr>
    </div>
  </div>
 </div>
</template>
<script>
export default {
  name: 'detail',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      itemList: [],
      book: false
    }
  },
  methods: {
    geteva () {
      this.book = true
      let self = this
      let url = '/mongofind'
      this.$axios.get(url, {
        params: {
          bookname: this.$route.params.id.bookName
        }
      })
        .then(function (res) {
          self.itemList = res.data
          console.log(self.book)
          console.log(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
<style src="./detail.css">

</style>
