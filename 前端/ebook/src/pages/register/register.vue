<template>
<div>
  <h1 id="title1">登陆界面</h1>
  <el-form ref="form" :model="form" label-width="100px">
    <el-row type="flex" justify="center">
      <el-col :span="5">
        <el-form-item label-width="70px">
        </el-form-item>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :span="5">
        <el-form-item label="账户：" prop="name">
          <el-input v-model="form.id" size="small"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :span="5">
        <el-form-item label="密码：" prop="password">
          <el-input v-model="form.password" size="small" :type="this.show.new?'text':'password'"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row type="flex" justify="center">
      <el-col :span="5">
        <el-form-item>
          <el-button  @click="submit">登录</el-button>
          <el-button @click="register">注册</el-button>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</div>
</template>
<script>
export default {
  name: 'register',
  props: ['message'],
  loginsuccess: 0,
  data () {
    return {
      form: {
        id: '',
        password: ''
      },
      show: {
        new: false
      }
    }
  },
  mounted () {
    localStorage.clear()
    localStorage.setItem('username', '登陆')
  },
  created () {
    var i = localStorage.getItem('for')
    if (i === '1') {
      localStorage.setItem('for', 2)
      this.flu()
    }
  },
  methods: {
    flu () {
      location.reload()
    },
    /* 提交进行判断的函数 */
    submit: function () {
      const self = this
      let url = '/mybook/login'
      this.$axios.get(url,
        {
          params: {
            id: this.form.id,
            password: this.form.password
          }
        })
        .then(function (res) {
          var itemlist = res.data
          self.itemList = itemlist
          console.log(self.itemList)
          if (res.data.loginsuccess === 0) {
            alert('密码错误')
          } else if (res.data.manager === 2) {
            alert('该账号已被禁用')
          } else if (res.data.manager === 1) {
            alert('登陆成功')
            localStorage.setItem('username', res.data.name)
            localStorage.setItem('id', res.data.id)
            localStorage.setItem('address', res.data.address)
            localStorage.setItem('manager', res.data.manager)
            localStorage.setItem('for', 1)
            console.log(res.data)
            self.$router.push({name: 'manager'})
          } else {
            alert('登陆成功')
            localStorage.setItem('username', res.data.name)
            localStorage.setItem('id', res.data.id)
            localStorage.setItem('address', res.data.address)
            localStorage.setItem('manager', res.data.manager)
            console.log(res.data)
            location.href = '/'
            self.$router.push({name: 'demo'})
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    register: function () {
      const self = this
      self.$router.push({name: 'registertable'})
    }
  }
}
</script>
<style src="./register.css">
</style>
