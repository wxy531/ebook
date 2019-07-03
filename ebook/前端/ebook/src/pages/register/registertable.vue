<template>
  <div>
    <h1 id="title1">注册</h1>
    <el-form ref="form" :model="form" label-width="100px">
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item label-width="70px"> </el-form-item>
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
          <el-form-item label="重复密码：" prop="password">
            <el-input :type="this.show.new?'text':'password'" v-model="form.passworda" size="small" @blur="checkdouble"></el-input><span v-if="this.check.doublepass"  style="text-size:12pt;color:red;">两次密码不一样”</span>

          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item label="姓名：" prop="password">
            <el-input v-model="form.name" size="small"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item label="电话：" prop="password">
            <el-input v-model="form.phone" size="small"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item label="地址：" prop="name">
            <el-input v-model="form.address" size="small"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item label="邮箱：" prop="name">
            <el-input v-model="form.email" size="small" @blur="checkemail"></el-input><span v-if="this.check.rightemail"  style="text-size:12pt;color:red;">请输入正确的邮箱格式，例如“***@abc.com”</span>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center">
        <el-col :span="5">
          <el-form-item>
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
  data () {
    return {
      form: {
        id: '',
        name: '',
        password: '',
        phone: '',
        address: '',
        email: '',
        passworda: ''
      },
      show: {
        old: false,
        new: false,
        check: false
      },
      check: {
        doublepass: false,
        rightemail: false
      }
    }
  },
  mounted () {
    localStorage.clear()
    localStorage.setItem('username', '登陆')
  },
  methods: {
    /* 提交进行判断的函数 */
    register: function () {
      if (this.form.password === this.form.passworda) {
        const self = this
        let url = '/mybook/register'
        this.$axios
          .get(url, {
            params: {
              id: this.form.id,
              password: this.form.password,
              name: this.form.name,
              phone: this.form.phone,
              address: this.form.address,
              email: this.form.email,
              method: 'register'
            }
          })
          .then(function (res) {
            var itemlist = res.data
            self.itemList = itemlist
            if (res.data.regsuccess === 1) {
              alert('注册成功')
              self.$router.push({ name: 'register' })
            }
          })
          .catch(err => {
            console.log(err)
          })
      } else {
        alert('密码两次不同')
      }
    },
    checkemail: function () {
      var myemail = this.form.email
      var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/

      if (myReg.test(myemail)) {
        this.check.rightemail = false
      } else {
        this.check.rightemail = true
        return false
      }
    },
    checkdouble: function () {
      if (this.form.password === this.form.passworda) {
        this.check.doublepass = false
      } else {
        this.check.doublepass = true
      }
    }
  }
}
</script>
<style src="./register.css"></style>
