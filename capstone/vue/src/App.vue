<template>
  <div id="capstone-app">
    
    <aside>
      <nav>
        <ul class="nav-list">
          <li><router-link v-bind:to="{ name: 'home' }">
          <img src="src\assests\images\logo\logo.png" :to="{ name: 'home' }" class="logo">
          </router-link>  </li>
          <li><router-link v-bind:to="{ name: 'beers' }" v-if="$store.state.token">Beers</router-link> </li>
          <li><router-link v-bind:to="{ name: 'breweries' }" v-if="$store.state.token">Breweries</router-link> </li>
          <li><router-link v-bind:to="{ name: 'saved' }" v-if="$store.state.token">My D.W.M.B</router-link> </li>
          <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> </li>
        </ul>   
      </nav>
    </aside>

    <!-- notification handling -->
    <div v-bind:class="notificationClass" v-show="notification" v-on:click="clearNotification">
      {{ notification?.message }}
    </div>

    <router-view class="views"/>
  </div>
</template>

<script>

export default {
  data() {
    return {
    };
  },
  computed: {
    notification() {
      return this.$store.state.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    }
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    }
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  background-color: rgb(34, 31, 31); 
  background-size: auto;
  height: 100%;
  margin-left: 500px;
 
}

aside {
  width: 200px;
  height: 100%;
}
nav {
  background-color: #e79115;
  position: fixed;
}
.nav-list {
  list-style: none;
  height: 100vh;
}

/* this is remove that whitespace gap and it reflects to all the components */
body, html, #app {
  margin: 0;
  padding: 0;
}

.status-message {
  background-color: #bababa;
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
  cursor: pointer;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}


</style>