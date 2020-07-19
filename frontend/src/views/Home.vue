<template>
  <div class="home">
    <div id="header">
      <button id="login" @click="$router.push('LoginPage')">Login</button>
      <button id="login" @click="$router.push('AdminSetupPage')">Register Admin</button>
      <router-link :to="{ name: 'About' }" class="nav-link" active-class="active">
        About Us
      </router-link>
      <router-link :to="{ name: 'Test' }" class="nav-link" active-class="active">
        Test
      </router-link>
      <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
        Home
      </router-link>
      <router-link :to="{ name: 'Todo' }" class="nav-link" active-class="active">
        Todo
      </router-link>
      <router-link :to="{ name: 'BoardListPage' }" class="nav-link" active-class="active">
        Board
      </router-link>
    </div>
    <div align="right">

    </div>
    <h1>This is an Home page</h1>
    <div id="app">
      {{ message }}<br>
      <p>{{ getTime() }}</p>
    </div>
  </div>
</template>

<script>

/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  data: function () {
    return {
      message: 'test'
    }
  },
  methods: {
    getTime () {
      return new Date().toString()
    }
  }
}

</script>

<style scoped>
div {
  border: 1px solid #ccc;
}
#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}
img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}
#login {
  background-color: #4485f3;
  color: #ffffff;
  border: 3px;
  border: none;
  font-weight: bold;
  font-size: 12pt;
  float: right;
}
.fileName {
  width: 30px;
  float: right;
}
label { display: block; }
.table_layout { width: 98%; }
table { width: 100%; }
</style>
#login {
  background-color: #4485f3;
  color: #ffffff;
  border: 3px;
  border: none;
  font-weight: bold;
  font-size: 12pt;
  float: right;
}
