import { createStore } from 'vuex'
import axios from "axios";

export default createStore({
  state: {
    heroes: [],
    regional: [],
    races: [],
    roles: [],
  },
  getters: {
  },
  mutations: {
    //条件筛选功能【
    sortHeroesByFormerly(state) {
      state.heroes.sort((a, b) => a.formerly.localeCompare(b.formerly));
    },
    sortHeroesByReleaseDate(state) {
      state.heroes.sort((a, b) => b.releaseDate.localeCompare(a.releaseDate));
    },
    sortHeroesByRelevantRegion(state) {
      state.heroes.sort((a, b) => a.relevantRegion.localeCompare(b.relevantRegion));
    },
    //】
    SET_HEROES(state, heroes) {
      state.heroes = heroes;
    },
    SET_REGIONAL(state, regional) {
      state.regional = regional;
    },
    SET_RACES(state, races) {
      state.races = races;
    },
    SET_ROLES(state, roles) {
      state.roles = roles;
    },
  },
  actions: {
    //获取heroes数组
    fetchHeroes({ commit }) {
      axios.get(`http://localhost:8089/api/heroes`)
        .then((response) => {
          commit('SET_HEROES', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    //获取region数组
    fetchRegional({ commit }) {
      axios.get(`http://localhost:8089/api/region`)
        .then((response) => {
          commit('SET_REGIONAL', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    //获取races数组
    fetchRaces({ commit }) {
      axios
        .get(`http://localhost:8089/api/races`)
        .then((response) => {
          commit('SET_RACES', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    //获取roles数组
    fetchRoles({ commit }) {
      axios
        .get(`http://localhost:8089/api/roles`)
        .then((response) => {
          commit('SET_ROLES', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    //获取fuzzyQuery数组
    heroesFuzzyQuery({ commit }, keyword) {
      axios.get(`http://localhost:8089/api/fuzzyQuery?keyword=${keyword}`)
        .then((response) => {
          commit('SET_HEROES', response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  modules: {
  },
})
