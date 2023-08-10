<template>
    <div class='featured_mind'>
        <ContentCarousel></ContentCarousel>
        <div class="bk _1">
            <img
                src="../assets/img/public_img/featured_bk_1.jpg"
                alt=""
            >
        </div>
        <Latest></Latest>
        <div class="bk _2">
            <img
                src="../assets/img/public_img/featured_bk_2.jpg"
                alt=""
            >
        </div>
        <Selected></Selected>
        <CarouselHero></CarouselHero>
        <img
            src="../assets/img/public_img/featured_bk_3.png"
            alt=""
            class="_3"
        >
        <CarouselRegiona></CarouselRegiona>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import ContentCarousel from "@/components/FeaturedContentCarousel.vue";
import Latest from "@/components/FeaturedLatest.vue";
import Selected from "@/components/FeaturedSelected.vue";
import CarouselHero from "@/components/FeaturedCarouselHero.vue";
import CarouselRegiona from "@/components/FeaturedCarouselRegional.vue";
export default {
    name: "featured",
    components: {
        ContentCarousel,
        Latest,
        Selected,
        CarouselHero,
        CarouselRegiona,
    },
    props: [],
    setup() {
        //这里存放数据
        const data = reactive({});
        return {
            ...toRefs(data),
        };
    },
    //计算属性
    computed: {},
    //监听属性
    watch: {},
    //方法集合
    methods: {},
    beforeCreate() {}, //生命周期 - 创建之前
    created() {}, //生命周期 - 创建之后（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {}, //生命周期 - 挂载之后（可以访问DOM元素）
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeUnmount() {}, //生命周期 - 卸载之前
    unmounted() {}, //生命周期 - 卸载之后
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='less' scoped>
.featured_mind {
    background-color: #0a0a0c;
    position: relative;
    width: 100vw;
    overflow: hidden;
    .bk {
        width: 100vw;
        position: absolute;
        > img {
            opacity: 0.2;
            width: 100%;
        }
        &::before {
            content: "";
            position: absolute;
            width: 100%;
            height: 100%;
            z-index: 1;
            background: radial-gradient(
                transparent 10%,
                #0a0a0c 80%,
                #0a0a0c 100%
            );
        }
    }
    ._1 {
        top: 300px;
    }
    ._2 {
        top: 1200px;
    }
    ._3 {
        position: absolute;
        width: 464px;
        left: calc(50vw - 232px);
        top: 3600px;
    }
}
</style>