<template>
  <div class="test">
    <div id="header">
      <router-link :to="{ name: 'About' }" class="nav-link" active-class="active">
        About Us
      </router-link>
      <router-link :to="{ name: 'Test' }" class="nav-link" active-class="active">
        Test
      </router-link>
      <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
        Home
      </router-link>
    </div>
    <h1>This is an Test page</h1>
    <div id="app">
      <local-component v-bind:num="value"></local-component>
      <button v-on:click="plus">Click</button><br>
      <global-component v-bind:initial-counter="counter"></global-component>
    </div>
  </div>
</template>

<script>

/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import cookies from 'vue-cookies'
import LocalComponent from '../components/LocalComponent.vue'
import GlobalComponent from '../components/GlobalComponent.vue'

Vue.component(GlobalComponent.name, GlobalComponent)

Vue.use(cookies)

export default {
  data: function () {
    return {
      counter: 3,
      value: 1
    }
  },
  components: {
    'local-component': LocalComponent
  },
  methods: {
    plus: function () {
      this.value++
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
a {
  text-decoration: none;
  font-size: 12pt;
  margin: 0px 10px;
  color: grey;
  float: right;
}
a:hover {
  text-decoration: underline;
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
