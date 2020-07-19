<template>
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>Title</td>
        <td><input type="text" v-model="title"></td>
      </tr>
      <tr>
        <td>Writer</td>
        <td><input type="text" v-model="writer"></td>
      </tr>
      <tr>
        <td>Content</td>
        <td><textarea v-model="content" rows="5"></textarea></td>
      </tr>
    </table>

    <div>
      <button type="submit">Register</button>
      <router-link :to="{ name: 'BoardListPage' }">Cancel</router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      content: '',
      writer: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, content, writer } = this
      this.$emit('submit', { title, content, writer })
    }
  }
}
</script>
