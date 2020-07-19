<template>
  <div align="center">
    <h2>Board Register</h2>
    <board-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import BoardRegisterForm from '@/components/BoardRegisterForm'

export default {
  name: 'BoardRegisterPage',
  components: {
    BoardRegisterForm
  },
  methods: {
    onSubmit (payload) {
      console.log('BoardRegisterPage onSubmit() - payload: ' + payload)
      const { title, content, writer } = payload
      axios.post('http://localhost:7777/boards', { title, content, writer })
        .then(res => {
          console.log(res)
          alert('Register Success')
          this.$router.push({
            name: 'BoardReadPage',
            params: { boardNo: res.data.boardNo }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
