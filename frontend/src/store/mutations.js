import {
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL,
  successGenerateRandomNumber,
  failGenerateRandomNumber,
  RESTORE,
  EDIT_TODO,
  SET_EDITING_ID,
  RESET_EDITING_ID,
  TOGGLE_TODO_STATUS,
  SET_FILTER,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO
} from './mutation-types'

import axios from 'axios'
import cookies from 'vue-cookies'

export default {
  [ADD_TODO] (state, payload) {
    const { content } = payload
    state.todoItems.push({ id: state.nextTodoId, content, done: false })
    state.nextTodoId++
  },
  [REMOVE_TODO] (state, id) {
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    state.todoItems.splice(targetIndex, 1)
  },
  [CLEAR_ALL] (state) {
    console.log('CLEAR_ALL')
    state.todoItems = []
  },
  [successGenerateRandomNumber] (state, payload) {
    console.log('payload = ' + payload)
    state.random = payload
  },
  [failGenerateRandomNumber] () {
    console.log('Error')
  },
  increment (state) {
    state.count++
  },
  decrement (state) {
    state.count--
  },
  [RESTORE] (state, { todoItems, nextTodoId }) {
    state.todoItems = todoItems
    state.nextTodoId = nextTodoId
  },
  [EDIT_TODO] (state, payload) {
    const { id, content } = payload
    const targetIndex = state.todoItems.findIndex(v => v.id === id)
    const targetTodoItem = state.todoItems[targetIndex]
    state.todoItems.splice(targetIndex, 1, { ...targetTodoItem, content })
  },
  [SET_EDITING_ID] (state, id) {
    state.editingId = id
  },
  [RESET_EDITING_ID] (state) {
    state.editingId = 0
  },
  [TOGGLE_TODO_STATUS] (state, id) {
    const filtered = state.todoItems.filter(todoItem => {
      return todoItem.id === id
    })

    filtered.forEach(todoItem => {
      todoItem.done = !todoItem.done
    })
  },
  [SET_FILTER] (state, filter) {
    state.filter = filter
  },
  [FETCH_BOARD_LIST] (state, boards) {
    console.log('FETCH_BOARD_LIST: ' + boards)
    state.boards = boards
  },
  [FETCH_BOARD] (state, board) {
    console.log('FETCH_BOARD: ' + board)
    state.board = board
  },
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [SET_MY_INFO] (state, myinfo) {
    if (myinfo) {
      state.myinfo = myinfo
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken = ''
    delete axios.defaults.headers.common.Authorization
    cookies.remove('accessToken')
  },
  [DESTROY_MY_INFO] (state) {
    state.myinfo = null
  }
}
