import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import BeerReviewView from '../views/BeerReviewView.vue';
import MyBeerReviewsView from '../views/MyBeerReviewsView.vue';
import AddBeerReviewView from '../views/AddBeerReviewView.vue';
import UpdateBeerReviewView from '../views/UpdateBeerReviewView.vue';
import BreweryReviewView from '../views/BreweryReviewView.vue';
import MyBreweryReviewsView from '../views/MyBreweryReviewsView.vue';
import AddBreweryReviewView from '../views/AddBreweryReviewView.vue';
import UpdateBreweryReviewView from '../views/UpdateBreweryReviewView.vue';
import BeerList from '../components/BeerList.vue';
import BeerDetails from '../components/BeerDetails.vue';
import BreweryList from '../components/BreweryList.vue';


/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/beer-list",
    component: BreweryList
  },
  {
    path: '/beer-details/:id',
    component: BeerDetails
  },
  {
    path: '/brewery-list',
    component: BreweryList
  },
  {

    path: '/beers/reviews',
    component: BeerReviewView
  },
  {
    path: '/beers/myreviews',
    component: MyBeerReviewsView
  },
  {
    path: '/beers/reviews/add',
    component: AddBeerReviewView
  },
  {
    path: '/beers/reviews/update/:id',
    component: UpdateBeerReviewView
  },
  {
    path: '/breweries/reviews',
    component: BreweryReviewView
  },
  {
    path: '/breweries/myreviews',
    component: MyBreweryReviewsView
  },
  {
    path: '/breweries/reviews/add',
    component: AddBreweryReviewView
  },
  {
    path: '/breweries/reviews/update/:id',
    component: UpdateBreweryReviewView

  }

];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;

router.beforeEach((to) => {

  const store = useStore();

  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
});

