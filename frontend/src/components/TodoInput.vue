<template>
  <div>
    <input type="text" v-model="newTodoItem" v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== '') {
        var value = this.newTodoItem && this.newTodoItem.trim()
        console.log('addTodo')
        this.$emit('addTodo', value)
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  },
  clearInput () {
    this.newTodoItem = ''
  }
}

</script>

<style scoped>
  div {
    background-color: #ff00ff;
  }
</style>
