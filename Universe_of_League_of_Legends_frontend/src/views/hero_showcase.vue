<template>
    <div id="bk">
    </div>
    <div class="search_bar">
        <div class="search_input">
            <img src="@/assets/img/public_img/hero_crest_icon.png">
            <input
                type="text"
                v-model="keyword"
                placeholder="找到一个英雄"
            >
        </div>
        <div
            class="sort"
            @click="showMenu()"
        >
            <img
                src="../assets/img/public_img/下拉菜单.png"
                alt=""
            >
            <p>筛选方式<span>：{{ sortBy }}</span></p>
            <ul ref="sortmenu">
                <li @click="sortBy='A-Z'">A-Z</li>
                <li @click="sortBy='最新'">最新</li>
                <li @click="sortBy='地区'">地区</li>
            </ul>
        </div>
    </div>
    <div id="box_head">
        <img src="@/assets/img/public_img/hero_crest_icon.png">
        <div>
            <h1><span class="_left_"><span></span></span>英雄<span class="_right_"><span></span></span></h1>
        </div>
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
                  'background-image': 'url(' + require(`@/assets/img/hero_posters/${hero.posters}`) + ')',
                  'background-position': `${hero.x*1.0/hero.width*100}% ${hero.y*1.0/hero.height*100}%`,
                  'background-size': 'cover',
                  }"
            >
                <div>
                    <div>
                        <h2>{{ hero.translation }}</h2>
                        <h1>{{ regional.find(item => item.formerly === hero.relevantRegion).translation }}</h1>
                    </div>
                    <div>
                        <p>探索<span>⇢</span></p>
                    </div>
                </div>
            </div>
        </router-link>
    </div>

</template>
<script>
import { reactive, ref, toRefs } from "vue";
import { mapState, mapActions } from "vuex";

export default {
    name: "hero_showcase",
    components: {},
    setup() {
        const data = reactive({
            sortBy: "A-Z",
            menuShow: false,
            keyword: "",
        });
        return {
            ...toRefs(data),
        };
    },
    //计算属性 类似于data概念
    computed: {
        //映射sorte仓库中的变量,相当于直接在组件中声明了该变量（仅能读取不能操作）
        ...mapState(["heroes"]),
        ...mapState(["regional"]),
    },
    //监听data中的数据变化
    watch: {
        sortBy(n, o) {
            if (n === "A-Z") {
                this.$store.commit("sortHeroesByFormerly");
            } else if (n === "最新") {
                this.$store.commit("sortHeroesByReleaseDate");
            } else if (n === "地区") {
                this.$store.commit("sortHeroesByRelevantRegion");
            }
        },
        keyword(n, o) {
            if (typeof n === "string" && n.trim() !== "") {
                this.heroesFuzzyQuery(n);
            } else {
                this.fetchHeroes();
            }
        },
    },
    //方法集合
    methods: {
        //映射sorte仓库中的方法让其可以在组件中读取
        ...mapActions(["heroesFuzzyQuery"]),
        ...mapActions(["fetchHeroes"]),
        //下拉菜单
        showMenu() {
            if (!this.menuShow) {
                this.$refs.sortmenu.style.transform = "scaleY(1)";
            } else {
                this.$refs.sortmenu.style.transform = "scaleY(0)";
            }
            this.menuShow = !this.menuShow;
        },
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {},
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {},
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
<style lang="css" src="../assets/css/hero_showcase.css" scoped></style>
<style>
body {
    background: black;
}
</style>