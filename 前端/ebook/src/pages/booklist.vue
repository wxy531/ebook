<template>
  <div>
    <div id="table">
      <table >
        <tr>
          <th id="book" onclick="changecolor()">书名</th>
          <th>作者</th>
          <th>售价</th>
          <th>库存</th>
          <th>数量</th>
        </tr>
        <tr>
          <td>活着</td>
          <td>余华</td>
          <td>26</td>
          <td>20</td>
          <td width="100px"><input>+1</td>
        </tr>
        <tr>
          <td>活着</td>
          <td>余华</td>
          <td>26</td>
          <td>20</td>
          <td><input>+1</td>
        </tr>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  name: 'booklist',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
<style>
  table,td,th
  {
    background-color: #fffee2;
    border:1px solid black;
    color: #ff7e1f;
  }
  table
  {

    margin-top: 100px;
    width:100%;

  }
  th
  {
    height:50px;
  }
  input{
    width: 50px;

  }

</style>
