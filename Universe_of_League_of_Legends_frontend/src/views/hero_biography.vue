<template>
    <div
        class="mind"
        v-if="update"
    >
        <transition name="bk_posters">
            <div
                v-show="scroll==0"
                class="posters"
                :style="{
              'background-image': `url(${require(`../assets/img/hero_posters/${hero.posters}`)})`,
              'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.x*100}%`}"
            ></div>
        </transition>
        <ProgressBar :Scroll="scroll">
            <template v-slot:name>{{ hero.translation }}</template>
            <template v-slot:title>{{ hero.title }}</template>
        </ProgressBar>
        <HeadPoster :Scroll="scroll">
            <template v-slot:name>{{ hero.translation }}</template>
            <template v-slot:title>{{ hero.title }}</template>
        </HeadPoster>
        <BodyText
            :Scroll="scroll"
            :Text="hero.biography"
        >
            <template v-slot:name>{{ hero.translation }}</template>
            <template v-slot:title>{{ hero.title }}</template>
        </BodyText>
        <ExtendedReading :relatedpeople="hero.relatedPeople.slice(0,4)"></ExtendedReading>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import axios from "axios";
import HeadPoster from "@/components/BiographyHeadPoster.vue";
import BodyText from "@/components/BiographyBodyText.vue";
import ExtendedReading from "@/components/BiographyExtendedReading.vue";
import ProgressBar from "@/components/BiographyProgressBar.vue";

export default {
    name: "",
    components: { HeadPoster, BodyText, ExtendedReading, ProgressBar },
    setup() {
        //这里存放数据
        const data = reactive({
            hero: {},
            scroll: 0,
            update: false,
        });
        return {
            ...toRefs(data),
        };
    },
    //计算属性
    computed: {},
    //监听属性
    watch: {
        async hero(n, o) {
            document.title = n.translation + " - " + this.$route.meta.title;
            if (this.hero.relatedPeople != "") {
                this.hero.relatedPeople = await Promise.all(
                    this.hero.relatedPeople
                        .split(",")
                        .map(async function (formerly) {
                            try {
                                const response = await axios.get(
                                    `http://localhost:8089/api/findHero?formerly=${formerly}`
                                );
                                return response.data;
                            } catch (error) {
                                console.error(error);
                            }
                        })
                );
            }
            this.update = true;
        },
    },
    //方法集合
    methods: {
        findHero(formerly) {
            axios
                .get(`http://localhost:8089/api/findHero?formerly=${formerly}`)
                .then((response) => {
                    this.hero = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        },
    },
    beforeCreate() {}, //生命周期 - 创建之前
    created() {
        this.findHero(this.$route.params.heroId);
    }, //生命周期 - 创建之后（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {
        window.addEventListener("scroll", () => {
            this.scroll = document.documentElement.scrollTop;
        });
    }, //生命周期 - 挂载之后（可以访问DOM元素）
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeUnmount() {}, //生命周期 - 卸载之前
    unmounted() {}, //生命周期 - 卸载之后
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='less' scoped>
.mind {
    position: relative;
    background-color: #111315;
    width: 100vw;
    display: flex;
    flex-flow: column;
    z-index: 9;
    .posters {
        height: 969px;
        width: 100vw;
        position: fixed;
        background-size: cover;
        z-index: 1;
        top: -15px;
    }
}
.bk_posters-enter-active {
    animation: hide 0.5s ease-in reverse;
}
.bk_posters-leave-active {
    animation: hide 0.5s ease-out;
}
@keyframes hide {
    100% {
        opacity: 0;
    }
}
</style>