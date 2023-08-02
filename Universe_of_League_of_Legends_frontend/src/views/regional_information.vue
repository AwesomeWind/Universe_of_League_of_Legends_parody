<template>
    <div
        id="rogein"
        v-if="newRegion"
    >
        <div
            id="head"
            :style="{
          'background-image': `url(${require(`@/assets/img/regional_posters/${region.posters}`)})`,
          'background-size': 'cover',
        }"
        >
            <div class="head_bk"></div>
            <div>
                <img
                    class="icon"
                    :src="require(`@/assets/img/crest_icon/${region.icon}`)"
                >
                <h1>
                    {{ region.translation }}
                </h1>
                <img
                    src="@/assets/img/public_img/t1HeaderDivider.png"
                    style="width: 100vw"
                >
            </div>
        </div>
        <div id="mind">
            <div class="description">
                <p v-html="region.description"></p>
            </div>
            <div class="heroes_box">
                <img src="@/assets/img/public_img/hero_crest_icon.png">
                <img
                    id="emblem"
                    :src="require(`@/assets/img/emblem/${region.emblem}`)"
                    alt=""
                >
                <div class="em_heroes">
                    <span class="_left_"><span></span></span>
                    <em>{{region.translation}}的英雄们</em>
                    <span class="_right_"><span></span></span>
                </div>
                <div id="hero_list">
                    <router-link
                        v-for="(hero,index) in heroes"
                        :key="index"
                        :to="`/HeroInfo/${hero.formerly}`"
                    >
                        <div
                            class="hero_card"
                            :style="{
                  'background-image': `url(${require(`@/assets/img/hero_posters/${hero.posters}`)})`,
                  'background-position': `${hero.x*1.0/hero.width*100}% ${hero.y*1.0/hero.height*100}%`,
                  'background-size': 'cover',
                  }"
                        >
                            <div>
                                <div>
                                    <h2>{{ hero.translation }}</h2>
                                    <h1>{{ region.translation }}</h1>
                                </div>
                                <div>
                                    <p>探索<span>⇢</span></p>
                                </div>
                            </div>
                        </div>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import axios from "axios";

export default {
    name: "regional_information",
    components: {},
    setup() {
        //这里存放数据
        const data = reactive({
            region: {},
            heroes: [],
            newRegion: false,
        });
        return {
            ...toRefs(data),
        };
    },
    //计算属性
    computed: {},
    //监听属性
    watch: {
        region(n, o) {
            this.newRegion = !this.newRegion;
            document.title = n.translation + " - " + this.$route.meta.title;
        },
    },
    //方法集合
    methods: {
        findRegion() {
            axios
                .get(
                    `http://localhost:8089/api/findRegion?formerly=${this.$route.params.regionId}`
                )
                .then((response) => {
                    this.region = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        findHeroesByRegion() {
            axios
                .get(
                    `http://localhost:8089/api/findHeroesByRegion?region=${this.$route.params.regionId}`
                )
                .then((response) => {
                    this.heroes = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        },
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.findRegion();
        this.findHeroesByRegion();
    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {
        const link = document
            .querySelector(".link")
            .querySelectorAll("li")[3]
            .querySelector("a");
    },
    beforeCreate() {}, //生命周期 - 创建之前
    beforeMount() {}, //生命周期 - 挂载之前
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeDestroy() {}, //生命周期 - 销毁之前
    destroyed() {}, //生命周期 - 销毁完成
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='css' src="../assets/css/Clear_style.css" scoped></style>
<style lang="css" src="../assets/css/regional_information.css" scoped></style>
<style>
body {
    background-color: #09090c;
}
</style>