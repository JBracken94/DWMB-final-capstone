<template> 
<!-- HEADER (FIXED) -->
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{name: 'beers'}" v-if="$store.state.token"> Beers &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'breweries' }" v-if="$store.state.token"> Breweries &nbsp;|&nbsp;</router-link>
      <router-link v-bind:to="{ name: 'saved' }" v-if="$store.state.token"> My APP NAME </router-link>
      

    </div>
    <router-view />
  </div>
  <!-- FOOTER -->
</template>
