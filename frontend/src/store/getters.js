export default {
  random (state /* getters */) {
    return state.random
  },
  filteredTodoItems (state) {
    if (!state.filter) {
      return state.todoItems
    }

    if (state.filter === 'A') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === false
      })
    }

    if (state.filter === 'B') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === true
      })
    }
  },
  isAuthorized (state) {
    return state.accessToken.length > 0 && !!state.myinfo
  },
  isAdmin (state, getters) {
    return getters.isAuthorized && state.myinfo.authList[0].auth === 'ROLE_ADMIN'
  },
  isMember (state, getters) {
    return getters.isAuthorized && state.myinfo.authList[0].auth === 'ROLE_MEMBER'
  }
}
