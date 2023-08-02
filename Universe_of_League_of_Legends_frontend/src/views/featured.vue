<template>
    <div class='featured_mind'>
        <ContentCarousel></ContentCarousel>
        <LatestHero></LatestHero>
        <CarouselHero></CarouselHero>
        <CarouselRegiona></CarouselRegiona>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import ContentCarousel from "@/components/FeaturedContentCarousel.vue";
import LatestHero from "@/components/FeaturedLatestHero.vue";
import CarouselHero from "@/components/FeaturedCarouselHero.vue";
import CarouselRegiona from "@/components/FeaturedCarouselRegional.vue";
export default {
    name: "featured",
    components: {
        ContentCarousel,
        LatestHero,
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
    background-color: wheat;
}
</style>