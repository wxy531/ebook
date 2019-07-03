<template>
  <div id="app">
    <div id="title">
      <el-menu :default-active="$route.path" router mode="horizontal" >
        <el-menu-item class="shouye" index="/" v-if="demo"> 首页</el-menu-item>
        <el-menu-item class="shouye" index="/manager" v-if="mana"> 管理</el-menu-item>
        <el-menu-item id="denglu"  @click="change">{{message}}</el-menu-item>
        <el-menu-item class="gouwu" index="/mycar"  >购物车</el-menu-item>
      </el-menu>
    </div>
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  data () {
    return {
      demo: true,
      mana: false,
      message: localStorage.getItem('username'),
      itemList: []
    }
  },
  mounted () {
    if (localStorage.getItem('manager') === '1') {
      this.demo = false
      this.mana = true
    } else {
      this.demo = true
      this.mana = false
    }
  },
  methods: {
    change () {
      var self = this
      localStorage.setItem('for', 1)
      localStorage.setItem('username', '登陆')
      self.$router.push({name: 'register'})
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#title{

}
.shouye{
  position: relative;
  left:20px;
  font-size: 20px;
  background: #ffec58;
  color: #ff6332;
  letter-spacing: 20px;
  vertical-align: middle;
}
#denglu{
  position: relative;
  left:970px;
  font-size: 20px;
  background: #ffec58;
  color: #ff6332;
  letter-spacing: 20px;
  vertical-align: middle;
}
.gouwu{
  position: relative;
  left:1020px;
  font-size: 20px;
  background: #ffec58;
  color: #ff6332;
  letter-spacing: 10px;
  vertical-align: middle;
}
.order{
  position: relative;
  left:450px;
  font-size: 20px;
  background: #ffec58;
  color: #ff6332;
  letter-spacing: 20px;
  vertical-align: middle;
}
</style>
