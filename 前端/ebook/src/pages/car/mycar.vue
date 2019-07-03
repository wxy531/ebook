<template>
  <div id="mycar">
    <div id="demotable">
      <button @click="getcarjson()">显示购物车</button>
      <button @click="submitcar()">提交订单</button>
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in title">
          {{tl}}</td>
      </tr>
      <!--eslint-disable-next-line-->
      <tr v-for="p in carList">
        <td>{{p.carid}}</td>
        <td>{{p.id}}</td>
        <td>{{p.bookname}}</td>
        <td>{{p.num}}</td>
        <button @click="deleteitem(p.carid)">删除</button>
      </tr>
    </div>
  </div>
</template>
<script type="text/javascript">
export default {
  name: 'demo',
  data () {
    return {
      title: ['carid', 'ID', '书名', '数量'],
      searchName: '',
      orderType: 0,
      itemList: [],
      orderList: [],
      carList: []

    }
  },
  methods: {
    getcarjson () {
      var self = this
      let url = '/mybook/carServlet'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id'),
          bookname: '',
          num: 1,
          method: 'all'
        }
      })
        .then(function (res) {
          var itemlist = res.data
          self.carList = itemlist
          console.log(self.carList)
        })
        .catch(err => {
          console.log(err)
        })
    },
    submitcar () {
      let url = '/mybook/carServlet'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id'),
          bookname: localStorage.getItem('address'), // address
          num: 1,
          method: 'submit'
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
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    deleteitem (itemid) {
      this.carList = ''
      var self = this
      let url = 'mybook/carServlet'
      this.$axios.get(url, {
        params: {
          id: itemid,
          bookname: localStorage.getItem('id'), // address
          num: 1,
          method: 'delete'
        }
      })
        .then(function (res) {
          var itemlist = res.data
          self.carList = itemlist
          console.log(self.carList)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
<style src="./mycar.css">
</style>
