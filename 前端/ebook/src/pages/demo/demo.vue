<template>
  <div id="demo">
    <button @click="getjson()">显示书单</button>
    <button @click="getorderjson()">显示订单</button>
    <button @click="getorderjson1()">统计订单</button>
    <div v-if="ifbook">
    <input type="text" v-model="searchName" placeholder="输入书名" /><br />
    <div id="demotable">
      <button @click="setOrderType(2)">日期升序</button>
      <button @click="setOrderType(1)">日期降序</button>
      <button @click="setOrderType(4)">价格升序</button>
      <button @click="setOrderType(3)">价格降序</button>
      <button @click="setOrderType(0)">原本顺序</button>
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in title">
          {{ tl }}
        </td>
      </tr>

      <tr v-for="(p, index) in filterPersons" :key="index">
        <td><img :src="p.cover" height="20" width="20"/></td>
        <td color="#ff9955">
          <router-link :to="{ name: 'detail', params: { id: p } }">{{
            p.bookName
          }}</router-link>
        </td>
        <td>{{ p.author }}</td>
        <td>{{ p.language }}</td>
        <td>{{ p.date }}</td>
        <td>{{ p.num }}</td>
        <td>{{ p.sales }}</td>
        <td>
          <button  @click="evaluate(p)">评论</button>
          <el-dialog
            title="提示"
            :visible.sync="dia"
            width="30%"
            :before-close="handleClose">
            <div class="addbook">
              <h2>商品信息</h2>
              <div>
                <span><label>书名</label></span>
                <span><input type="button" class="textbox" v-model="evabook" ></span>
              </div>
              <div >
                <span><label>评论</label></span>
                <span><input name="1" type="text" class="textbox" v-model="evation"></span>
              </div>
            </div>
            <el-button @click="dia = false">取 消</el-button>
            <el-button type="primary"  @click="commiteva">确 定</el-button>
          </el-dialog>
          <button>
            <router-link :to="{ name: 'car', params: { id: p } }"
              >购买</router-link
            >
          </button>
        </td>
      </tr>
    </div>
      </div>
    <div v-if="iforder">
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in titleo">
          {{tl}}</td>
      </tr>
      <!--eslint-disable-next-line-->
      <tr v-for="p in orderList">
        <td color="#ff9955">{{p.orderid}}</td>
        <td>{{ p.id }}</td>
        <td>{{ (p.time.month+1).toString()+"."+p.time.day.toString()+"."+p.time.hours.toString()+':'+p.time.minutes.toString() }}</td>
        <td>{{ p.address }}</td>
        <td>{{ p.num }}</td>
        <button @click="getitem(p.orderid)">详细</button>
      </tr>
      </div>
      <div id="oitemList" v-if="ifitem">
        <tr>
          <!--eslint-disable-next-line-->
          <td v-for="tl in titleoi">
            {{tl}}</td>
        </tr>
        <!--eslint-disable-next-line-->
        <tr v-for="s in oitemList">
        <td>{{s.bookname}}</td>
          <td>{{s.num}}</td>
        </tr>
      </div>
    <div id="forder" v-if="iftime">
      <input type="text" placeholder="起始时间" v-model="begintime">
      <input type="teext" placeholder="终止时间" v-model="endtime">
      <button @click="timeslice" id="timebutton"> 修改</button>
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in titleo">
          {{tl}}</td>
      </tr>
      <!--eslint-disable-next-line-->
      <tr v-for="t2 in timeList">
        <td>{{t2.id}}</td>
        <td>{{t2.phone}}</td>
        <td>{{ (t2.time.month+1).toString()+"."+t2.time.day.toString()+"."+t2.time.hours.toString()+':'+t2.time.minutes.toString() }}</td>
        <td>{{t2.address}}</td>
      </tr>
    </div>
  </div>
</template>
<script type="text/javascript">
export default {
  name: 'demo',
  data () {
    return {
      dia: false,
      evation: '',
      evabook: '',
      begintime: 0,
      endtime: 60,
      iforder: false,
      ifbook: true,
      titleo: ['订单号', '电话', '创建时间', '地址'],
      title: ['', '书名', '作者', '语言', '日期', '数量', '价格'],
      titleoi: ['书名', '数量'],
      ifitem: false,
      iftime: false,
      searchName: '',
      orderType: 0,
      itemList: [],
      orderList: [],
      photoList: [],
      oitemList: [],
      timeList: []
    }
  },

  computed: {
    filterPersons () {
      //        debugger
      // 取出相关数据
      const {searchName, itemList, orderType} = this
      let arr = [...itemList]
      // 过滤数组
      if (searchName.trim()) {
        arr = itemList.filter(p => p.bookName.indexOf(searchName) !== -1)
      }
      // 排序
      if (orderType) {
        arr.sort(function (p1, p2) {
          if (orderType === 1) { // 降序
            return p2.date - p1.date
          } else if (orderType === 2) { // 升序
            return p1.date - p2.date
          } else if (orderType === 3) {
            return p2.sales - p1.sales
          } else if (orderType === 4) {
            return p1.sales - p2.sales
          }
        })
      }
      return arr
    }
  },

  methods: {
    commiteva () {
      this.dia = false
      let url = '/mongosave'
      this.$axios.get(url, {
        params: {
          bookname: this.evabook,
          eva: this.evation,
          username: localStorage.getItem('id')
        }
      })
        .then(function (res) {
          alert('添加成功')
          console.log(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    },
    evaluate (p) {
      this.evabook = p.bookName
      this.dia = true
    },
    timeslice () {
      this.timeList = []
      var i = 0
      var p = 0
      var arr = this.orderList
      console.log(arr)
      for (i; i < arr.length; i++) {
        if (arr[i].time.hours > this.begintime && arr[i].time.hours < this.endtime) {
          this.timeList[p] = arr[i]
          p++
        }
      }
      console.log(this.timeList)
    },
    tos (item) {
      item = 'data:image/png;base64,' + item.toString()
      return item
    },
    setOrderType (orderType) {
      this.orderType = orderType
    },
    getjson () {
      this.iftime = false
      this.ifitem = false
      this.ifbook = true
      this.iforder = false
      this.itemList = []
      var self = this
      let url = '/mybook/bookjson'
      this.$axios.get(url)
        .then(function (res) {
          var itemlist = res.data
          self.itemList = itemlist
          console.log(self.itemList)
        })
        .catch(err => {
          console.log(err)
        })
    },
    getorderjson () {
      this.ifbook = false
      this.iforder = true
      this.iftime = false
      var self = this
      let url = '/mybook/myorders'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id')
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
    getorderjson1 () {
      this.ifbook = false
      this.iforder = false
      this.iftime = true
      this.ifitem = false
      var self = this
      let url = '/mybook/myorders'
      this.$axios.get(url, {
        params: {
          id: localStorage.getItem('id')
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
          self.oitemList = res.data
          console.log(self.oitemList)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>
<style src="./demo.css"></style>
