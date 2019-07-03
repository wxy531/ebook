<template>
  <div>
    <div id="title">
      <span>{{this.$route.params.id.bookName}}</span>
      <textarea v-model="booknum"></textarea>
      <button @click="addcar">提交订单</button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'car',
  data () {
    return {
      booknum: 1,
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    /* 提交进行判断的函数 */
    addcar: function () {
      console.log(localStorage.getItem('id'))
      console.log(this.$route.params.id.bookName)
      const self = this
      let url = '/mybook/carServlet'
      this.$axios.get(url,
        {
          params: {
            id: localStorage.getItem('id'),
            bookname: this.$route.params.id.bookName.toString(),
            num: this.booknum,
            method: 'add'
          }
        })
        .then(function (res) {
          var itemlist = res.data
          self.itemList = itemlist
          if (self.itemList[0].addSuccess === 1) {
            alert('添加成功')
            self.$router.push({name: 'demo'})
          } else {
            alert('添加失败')
            console.log(res.data)
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
<style src="./car.css">

</style>
