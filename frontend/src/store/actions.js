import {
  ADD_TODO,
  REMOVE_TODO,
  CLEAR_ALL,
  successGenerateRandomNumber,
  failGenerateRandomNumber,
  RESTORE,
  EDIT_TODO,
  TOGGLE_TODO_STATUS,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  SET_ACCESS_TOKEN
  // SET_MY_INFO
} from './mutation-types'

import axios from 'axios'

export default {
  fetchBoardList ({ commit }) {
    console.log('fetchBoardList: ' + commit)
    return axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log('fetchBoardList - res: ' + res.data)
        commit(FETCH_BOARD_LIST, res.data)
      })
  },
  fetchBoard ({ commit }, boardNo) {
    console.log('fetchBoard: ' + commit + ', boardNo: ' + boardNo)
    return axios.get(`http://localhost:7777/boards/${boardNo}`)
      .then(res => {
        console.log('fetchBoard - res: ' + res.data)
        commit(FETCH_BOARD, res.data)
      })
  },
  generateRandomNumber ({ commit }) {
    console.log(arguments)
    axios.get('http://localhost:7777/random')
      .then((res) => {
        // console.log(res)
        // console.log(parseInt(res.data.randNumber))
        commit(successGenerateRandomNumber, parseInt(res.data.randNumber))
      })
      .catch((res) => {
        commit(failGenerateRandomNumber, res)
      })
  },
  addTodo ({ commit }, payload) {
    commit(ADD_TODO, payload)
  },
  removeTodo ({ commit }, id) {
    commit(REMOVE_TODO, id)
  },
  clearAll ({ commit }) {
    console.log('Is it in ?')
    commit(CLEAR_ALL)
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  },
  restore ({ commit }) {
    const data = localStorage.getItem('todo-app-data')

    if (data) {
      commit(RESTORE, JSON.parse(data))
    }
  },
  editTodo ({ commit }, payload) {
    commit(EDIT_TODO, payload)
  },
  toggleTodoStatus ({ commit }, id) {
    commit(TOGGLE_TODO_STATUS, id)
  },
  login ({ commit }, payload) {
    console.log('actions login')
    return axios.post(`http://localhost:7777/api/authenticate?username=${payload.userid}&password=${payload.password}`, {
      username: payload.userid,
      password: payload.password
    }).then(res => {
      console.log('actions after post')
      const { authorization } = res.headers
      const accessToken = authorization.substring(7)

      commit(SET_ACCESS_TOKEN, accessToken)

      // return axios.get('http://localhost:7777/users/myinfo')
    }).then(res => {
      // commit(SET_MY_INFO, res.data)
    })
  }
}
