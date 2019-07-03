<template>
  <body>
  <!-- start main1 -->
  <div class="main_bg1">
    <div class="wrap">
      <div class="main1">
        <h2>添加商品</h2>
      </div>
    </div>
  </div>
  <!-- start main -->
  <div class="main_bg">
    <div class="wrap">
      <div class="main">
        <div class="contact">
          <div class="contact-form">
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
            <div>
              <span><input type="submit" @click="addGoods()" class="" value="添加商品"></span>
            </div>
          </div>
          <div class="clear"></div>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
export default {
  name: 'pic',
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
      pi: ''
    }
  },
  mounted () {

  },
  methods: {
    addGoods () {
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
          if (response.data) { alert('添加商品成功') }
        })
        .catch(function (error) {
          console.log(bodyFormData)
          console.log(error)
        })
        .then(function () {
          // always executed
        })
    }
  }
}

</script>

<style scoped>

</style>
