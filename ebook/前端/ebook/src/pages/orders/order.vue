<template>
  <div id="order">
    <div>
      <input type="text" v-model="searchName" placeholder="输入书名"><br>
      <table id="demotable">
        <button @click="setOrderType(4)">订单id升序</button>
        <button @click="setOrderType(3)">订单id降序</button>
        <button @click="setOrderType(0)">原本顺序</button>
        <button @click="getorderjson()">所有订单</button>
        <tr v-if=post>
          <!--eslint-disable-next-line-->
          <td v-for="tl in title">
            {{tl}}</td>
        </tr>
        <tr v-for="(p, index) in filterPersons" :key="index">
          <td>{{p.orderid}}</td>
          <td v-if="show">{{p.address}}</td>
          <td v-if="show"><el-input placeholder="请输入地址"></el-input></td>
          <button @click="getitem(p.orderid)">详细</button>
          <button @click="changeitem(p.orderid,p.address)">修改</button>
          <button @click="clearitem(p.orderid)">删除</button>
        </tr>
      </table>
    </div>
    <div id="detail">
      <div v-if=detailpost>
      <a>订单信息</a>
      <tr >
        <!--eslint-disable-next-line-->
        <td v-for="t2 in title2">{{t2}}</td>
      </tr>
      </div>
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
      post: false,
      detailpost: false,
      change: false,
      show: true,
      title: ['订单号', '地址'],
      title2: ['书名', '数量'],
      searchName: '',
      orderType: 0,
      itemList: [],
      orderList: [],
      carList: []

    }
  },
  computed: {
    filterPersons () {
      //        debugger
      // 取出相关数据
      const {searchName, orderList, orderType} = this
      let arr = [...orderList]
      // 过滤数组
      if (searchName.trim()) {
        arr = orderList.filter(p => p.address.indexOf(searchName) !== -1)
      }
      // 排序
      if (orderType) {
        arr.sort(function (p1, p2) {
          if (orderType === 1) { // 降序
            return p2.date - p1.date
          } else if (orderType === 2) { // 升序
            return p1.date - p2.date
          } else if (orderType === 3) {
            return p2.orderid - p1.orderid
          } else if (orderType === 4) {
            return p1.orderid - p2.orderid
          }
        })
      }
      return arr
    }
  },
  methods: {
    setOrderType (orderType) {
      this.orderType = orderType
    },
    getorderjson () {
      this.post = true
      var self = this
      let url = '/mybook/order'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id'),
          method: 'all'
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
      this.detailpost = true
      this.itemList = ''
      var self = this
      let url = '/mybook/order'
      this.$axios.get(url, {
        params: {
          id: orderid,
          method: 'detail'
        }
      })
        .then(function (res) {
          var itemlist = res.data
          self.itemList = itemlist
          console.log(self.itemList)
        })
        .catch(err => {
          console.log(err)
        })
    },
    clearitem (orderid) {
      this.itemList = ''
      this.orderList = ''
      var self = this
      let url = '/mybook/order'
      this.$axios.get(url, {
        params: {
          id: orderid,
          method: 'clear'
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
    }
  }
}
</script>
<style src="./order.css">
</style>
