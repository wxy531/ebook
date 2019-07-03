<template>
  <div>
    <el-input v-model="search" style="width: 600px"
              placeholder="请输入书名" prefix-icon="el-icon-search"/>
    <el-table :data="tableData.filter(data=>!search || data.bookName.includes(search))"
              stripe
              style="width: 100%">
      <el-table-column>
        <el-table-column
          type="index"
        >
        </el-table-column>
        <el-table-column
          prop="bookName"
          label="书名"
          sortable
        >
        </el-table-column>
        <el-table-column
          prop="author"
          label="作者"
          sortable
        ></el-table-column>
        <el-table-column
          prop="language"
          label="语言"
          sortable
        ></el-table-column>
        <el-table-column
          prop="date"
          label="出版日期"
          sortable
        ></el-table-column>
        <el-table-column
          prop="sales"
          label="销量"
          sortable
        ></el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'Table',
  data () {
    return {
      search: '',
      tableData: [{
        bookName: '为什么我不是web课助教',
        author: '陈俊',
        language: 'Chinese',
        date: 2019,
        sales: 38

      }, {
        bookName: '2020年我会是web课助教吗',
        author: '陈俊',
        language: 'Chinese',
        date: 2019,
        sales: 44

      }, {
        bookName: '我一个能顶研二八个',
        author: '陈俊',
        language: 'Chinese',
        date: 2019,
        sales: 66

      }, {
        bookName: '我和陈俊不得不说的故事',
        author: '董继堂',
        language: 'Chinese',
        date: 2019,
        sales: 88

      }, {
        bookName: 'Java程序设计',
        author: '埃里克罗伯茨',
        language: 'Chinese',
        date: 2017,
        sales: 2147483648

      }, {
        bookName: 'Java核心技术 卷II',
        author: '霍斯特曼',
        language: 'Chinese',
        date: 2017,
        sales: 65536
      }]
    }
  }
}
</script>

<style scoped>

</style>
