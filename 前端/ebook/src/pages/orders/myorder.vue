<template>
  <div id="myorder">
    <div>
    <input type="text" v-model="searchName" placeholder="输入书名"><br>
    <table id="demotable">
      <button @click="getorderjson()">我的订单</button>
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in title">
          {{tl}}</td>
      </tr>
      <!--eslint-disable-next-line-->
      <tr v-for="p in orderList">
        <td>{{p.orderid}}</td>
        <td>{{p.address}}</td>
        <button @click="getitem(p.orderid)">详细</button>
      </tr>
      </table>
    </div>
      <div id="detail" v-if="ifitem">
        <a>订单信息</a>
        <tr>
      <!--eslint-disable-next-line-->
      <td v-for="t2 in title2">{{t2}}</td>
    </tr>
      <!--eslint-disable-next-line-->
          <tr v-for="q in itemList">
            <td>{{q.bookname}}</td>
            <td>{{q.num}}</td>
          </tr>
        </div>
    </div>
</template>
<script type="text/javascript">
export default {
  name: 'demo',
  data () {
    return {
      title: ['订单号', '地址'],
      title2: ['书名', '数量'],
      searchName: '',
      orderType: 0,
      itemList: [],
      orderList: [],
      carList: [],
      ifitem: false

    }
  },
  methods: {
    getorderjson () {
      var self = this
      let url = 'mybook/myorders'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id'),
          method: 'my'
        }
      })
        .then(function (res) {
          var itemlist = res.data
          self.orderList = itemlist
          console.log(self.orderList)
        })
        .catch(err => {
          console.log(err)
        })
    },
    getitem (orderid) {
      this.ifitem = true
      this.itemList = ''
      var self = this
      let url = 'mybook/showmyorderitem'
      this.$axios.get(url, {
        params: {
          id: orderid
        }
      })
        .then(function (res) {
          self.itemList = res.data
          console.log(self.itemList)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
<style src="./myorder.css">
</style>
