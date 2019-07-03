<template>
  <div id="manager">
    <button @click="getjson()" value="所有用户">所有用户</button>
    <button @click="getorderjson()" value="所有订单">所有订单</button>
    <button @click="getbookjson()" value="所有图书" id="allbook">所有图书</button>
    <div id="demotable">
      <div v-if="ifuser">
      <tr>
        <!--eslint-disable-next-line-->
        <td v-for="tl in title">
          {{tl}}</td>
      </tr>
      <!--eslint-disable-next-line-->
      <tr v-for="(p, index) in itemList" :key="index">
        <td >{{p.id}}</td>
        <td>{{p.password}}</td>
        <td>{{p.name}}</td>
        <td>{{p.phone}}</td>
        <td>{{p.email}}</td>
        <td>{{p.address}}</td>
        <button @click="open(p.id)" value="启用用户">启用用户</button>
        <button @click="close(p.id)" value="禁用用户">禁用用户</button>
      </tr>
      </div>
      <div v-if="iforder">
        <input type="text" v-model="search" placeholder="输入用户名" class="width:500px"><br>
        <tr>
          <!--eslint-disable-next-line-->
          <td v-for="tl in titleo">
            {{tl}}</td>
        </tr>
        <!--eslint-disable-next-line-->
      <tr v-for="p in filterOrders" :key="index">
        <td>{{p.id}}</td>
        <td >{{p.orderid}}</td>
        <td>{{p.address}}</td>
        <td>{{p.phone}}</td>
      </tr>
        </div>
      <div v-if="ifbook">
        <input type="text" v-model="searchName" placeholder="输入书名" class="width:500px"><br>
        <button  @click="dialogVisible = true">添加新书</button>
        <el-dialog
          title="提示"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
          <div class="addbook">
                    <h2>商品信息</h2>

                    <div>
                      <span><label>封面</label></span>
                      <span><input type='file' accept="image/*" id="file" ref="file"></span>
                    </div>
                    <div>
                      <span><label>书名</label></span>
                      <span><input type="text" class="textbox" v-model="bookname"></span>
                    </div>
                    <div>
                      <span><label>作者</label></span>
                      <span><input type="text" class="textbox" v-model="author"></span>
                    </div>
                    <div>
                      <span><label>语言</label></span>
                      <span><input name="1" type="text" class="textbox" v-model="language"></span>
                    </div>
                    <div>
                      <span><label>日期</label></span>
                      <span><input name="2" type="text" class="textbox" v-model="date"></span>
                    </div>
                    <div>
                      <span><label>库存</label></span>
                      <span><input name="3" type="text" class="textbox" v-model="num"></span>
                    </div>
                    <div>
                      <span><label>价格</label></span>
                      <span><input name="4" type="text" class="textbox" v-model="price"></span>
                    </div>
            <div>
                      <span><label>详细</label></span>
                      <span><input name="5" type="text" class="textbox" v-model="detail"></span>
                    </div>
                </div>
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary"  @click="addGoods()">确 定</el-button>
        </el-dialog>
        <el-dialog
          title="提示"
          :visible.sync="diaVisible"
          width="30%"
          :before-close="handleClose">
          <div class="addbook">
            <h2>商品信息</h2>
            <div>
              <span><label>书名</label></span>
              <span><input type="text" class="textbox" v-model="mbookname" value="hihih"></span>
            </div>
            <div>
              <span><label>作者</label></span>
              <span><input type="text" class="textbox" v-model="mauthor"></span>
            </div>
            <div>
              <span><label>语言</label></span>
              <span><input name="1" type="text" class="textbox" v-model="mlanguage"></span>
            </div>
            <div>
              <span><label>日期</label></span>
              <span><input name="2" type="text" class="textbox" v-model="mdate"></span>
            </div>
            <div>
              <span><label>库存</label></span>
              <span><input name="3" type="text" class="textbox" v-model="mnum"></span>
            </div>
            <div>
              <span><label>价格</label></span>
              <span><input name="4" type="text" class="textbox" v-model="mprice"></span>
            </div>
          </div>
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary"  @click="commitGoods()">确 定</el-button>
        </el-dialog>
        <button @click="setOrderType(2)">日期升序</button>
          <button @click="setOrderType(1)">日期降序</button>
          <button @click="setOrderType(4)">价格升序</button>
          <button @click="setOrderType(3)">价格降序</button>
        <button @click="setOrderType(0)">原本顺序</button>
          <tr>
            <!--eslint-disable-next-line-->
            <td v-for="tl in titleb">
              {{tl}}</td>
          </tr>
          <tr v-for="(p, index) in filterPersons" :key="index">
            <td><img :src="p.cover" height="20" width="20"/></td>
            <td color="#ff9955"><router-link :to="{name:'detail',params:{ id:p}}">{{p.bookName}}</router-link></td>
            <td>{{p.author}}</td>
            <td>{{p.language}}</td>
            <td>{{p.date}}</td>
            <td>{{p.num}}</td>
            <td>{{p.sales}}</td>
            <button  @click="modibook(p)">修改书籍</button>
            <td><button @click="deletebook(p.id)">删除</button></td>
          </tr>
      </div>
    </div>
    </div>
</template>

<script>
export default {
  name: 'manager',
  inject: 'reload',
  data () {
    return {
      bookname: '',
      cover: '',
      author: '',
      language: '',
      date: '',
      num: '',
      price: '',
      detail: '',
      pi: '',
      mbookname: '',
      mcover: '',
      mauthor: '',
      mlanguage: '',
      mdate: '',
      mnum: '',
      mprice: '',
      mid: '',
      dialogVisible: false,
      diaVisible: false,
      title: ['用户名', '密码', '名字', '电话', '邮件', '地址'],
      titleo: ['用户名', '订单号', '电话', '地址'],
      titleb: ['', '书名', '作者', '语言', '日期', '数量', '价格'],
      searchName: '',
      search: '',
      orderType: 0,
      orderType1: 1,
      itemList: [],
      orderList: [],
      bookList: [],
      ifuser: true,
      iforder: false,
      ifbook: false
    }
  },
  created () {
    var i = localStorage.getItem('for')
    if (i === '1') {
      localStorage.setItem('for', 2)
      this.flu()
    }
  },
  methods: {
    modibook (p) {
      this.diaVisible = true
      this.mid = p.id
      this.mbookname = p.bookName
      this.mauthor = p.author
      this.mlanguage = p.language
      this.mdate = p.date
      this.mprice = p.sales
      this.mnum = p.num
    },
    commitGoods () {
      this.diaVisible = false
      let url = '/mybook/modibook'
      this.$axios.get(url, {
        params: {
          id: this.mid,
          bookname: this.mbookname,
          author: this.mauthor,
          language: this.mlanguage,
          date: this.mdate,
          num: this.mnum,
          price: this.mprice
        }
      })
        .then(function () {
          alert('修改成功')
          document.getElementById('allbook').click()
        })
    },
    addGoods () {
      this.dialogVisible = false
      let imagFile = this.$refs.file.files[0]
      let bodyFormData = new FormData()
      bodyFormData.set('bookname', this.bookname)
      bodyFormData.set('author', this.author)
      bodyFormData.set('language', this.language)
      bodyFormData.set('date', this.date)
      bodyFormData.set('num', this.num)
      bodyFormData.set('price', this.price)
      bodyFormData.set('detail', this.detail)
      bodyFormData.append('cover', imagFile)
      this.$axios({method: 'post',
        url: '/saveGoods',
        data: bodyFormData,
        config: {headers: {'Content-Type': 'multipart/form-data'}}}
      )
        .then(function (response) {
          console.log(response)
          if (response.data) {
            alert('添加商品成功')
            document.getElementById('allbook').click()
          }
        })
        .catch(function (error) {
          console.log(bodyFormData)
          console.log(error)
        })
        .then(function () {
          // always executed
        })
    },
    getjson () {
      this.ifuser = true
      this.ifbook = false
      this.iforder = false
      this.itemList = []
      var self = this
      let url = '/mybook/manager'
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
    open (item) {
      var manager = 0
      let url = '/mybook/setmanager'
      this.$axios.get(url, {
        params: {
          id: item,
          manager: manager
        }
      })
        .then(function () {
          alert('启用成功')
        })
        .catch(err => {
          console.log(err)
        })
    },
    close (item) {
      var manager = 2
      let url = '/mybook/setmanager'
      this.$axios.get(url, {
        params: {
          id: item,
          manager: manager
        }
      })
        .then(function () {
          alert('禁用成功')
        })
        .catch(err => {
          console.log(err)
        })
    },
    getorderjson () {
      this.ifuser = false
      this.ifbook = false
      this.iforder = true
      this.orderList = []
      var self = this
      let url = '/mybook/allorders'
      this.$axios.get(url, {
        params: {
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
    setOrderType (orderType) {
      this.orderType = orderType
    },
    getbookjson () {
      this.ifuser = false
      this.ifbook = true
      this.iforder = false
      var self = this
      let url = '/mybook/bookjson'
      this.$axios.get(url)
        .then(function (res) {
          var itemlist = res.data
          self.bookList = itemlist
          console.log(self.bookList)
        })
        .catch(err => {
          console.log(err)
        })
    },
    deletebook (id) {
      let url = '/mybook/deletebook'
      this.$axios.get(url, {
        params: {
          id: id
        }
      })
        .then(function () {
          alert('删除成功')
          document.getElementById('allbook').click()
        })
        .catch(err => {
          console.log(err)
        })
    },
    flu () {
      location.reload()
    }
  },
  computed: {

    filterOrders () {
      //        debugger
      // 取出相关数据
      const {search, orderList, orderType1} = this
      let brr = [...orderList]
      console.log(brr)
      // 过滤数组
      if (search.trim()) {
        brr = orderList.filter(p => p.id.indexOf(search) !== -1)
      }
      if (orderType1) {
        brr.sort(function (p1, p2) {
          if (orderType1 === 1) { // 降序
            return p2.orderid - p1.orderid
          }
        })
      }
      return brr
    },
    filterPersons () {
      //        debugger
      // 取出相关数据
      const {searchName, bookList, orderType} = this
      let arr = [...bookList]
      // 过滤数
      if (searchName.trim()) {
        arr = bookList.filter(p => p.bookName.indexOf(searchName) !== -1)
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
  }
}
</script>

<style src="./manager.css">

</style>
