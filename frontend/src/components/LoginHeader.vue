<template>
  <div align="center">
  <!--
    <router-link :to="{ name: 'Home' }">Home</router-link>
  -->
    <div v-if="isAuthroized">
      <span>{{ myinfo.userName }} 님 환영합니다.</span>
    </div>
    <div v-else>
      <router-link :to="{ name: 'LoginPage' }">Login</router-link>
    </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'

export default {
  name: 'LoginHeader',
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthroized', 'isAdmin'])
  }
}
</script>
