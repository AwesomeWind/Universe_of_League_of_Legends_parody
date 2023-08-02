import { createRouter, createWebHistory } from 'vue-router'
import featured from '../views/featured.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    meta: {
      title: '《英雄联盟》宇宙',
    },
    component: featured
  },
  {
    path: '/HeroShowCase',
    name: 'heroshowcase',
    meta: {
      title: '英雄 -《英雄联盟》宇宙',
    },
    component: () => import('../views/hero_showcase.vue'),
  },
  {
    path: '/HeroInfo/:heroId',
    name: 'heroinfo',
    meta: {
      title: '英雄 -《英雄联盟》宇宙',
    },
    component: () => import('../views/hero_information.vue')
  },
  {
    path: '/HeroBiograpghy/:heroId',
    name: 'herobiograpghy',
    meta: {
      title: '英雄传记 -《英雄联盟》宇宙'
    },
    component: () => import('../views/hero_biography.vue')
  },
  {
    path: '/RegionShowCase',
    name: 'regionshowcase',
    meta: {
      title: '地区 -《英雄联盟》宇宙',
    },
    component: () => import('../views/regionals_showcase.vue')
  },
  {
    path: '/RegionInfo/:regionId',
    name: 'regioninfo',
    meta: {
      title: '地区 -《英雄联盟》宇宙',
    },
    component: () => import('../views/regional_information.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
