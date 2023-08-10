<template>
    <div class='FCR_maind'>
        <div class="title">
            <img
                src="../assets/img/public_img/carouselregional_icon.png"
                alt=""
            >
            <h1>亮点地区</h1>
        </div>
        <SingleRegionElementCarouselVue :CarouselList="RegionalArray"></SingleRegionElementCarouselVue>
        <span class="top_left"></span>
        <span class="top_right"></span>
        <span class="left_top"></span>
        <span class="left_bottom"></span>
        <span class="right_top"></span>
        <span class="right_bottom"></span>
        <div class="bottom"></div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import SingleRegionElementCarouselVue from "./SingleRegionElementCarousel.vue";

export default {
    name: "CarouselRegional",
    components: { SingleRegionElementCarouselVue },
    props: [],
    setup() {
        //这里存放数据
        const data = reactive({
            RegionalArray: [
                {
                    formerly: "shurima",
                    translation: "恕瑞玛",
                    icon: "shurima_crest_icon.png",
                    posters: "shurima_posters.png",
                    width: 1920,
                    height: 1080,
                    x: 1861,
                    y: 93,
                },
                {
                    formerly: "bandle-city",
                    translation: "班德尔城",
                    icon: "bandle-city_crest_icon.png",
                    posters: "bandle-city_posters.png",
                    width: 1904,
                    height: 1076,
                    x: 800,
                    y: 550,
                },
                {
                    formerly: "zaun",
                    translation: "祖安",
                    icon: "zaun_crest_icon.png",
                    posters: "zaun_posters.png",
                    width: 1730,
                    height: 1080,
                    x: 1199,
                    y: 991,
                },
                {
                    formerly: "void",
                    translation: "虚空之地",
                    icon: "void_crest_icon.png",
                    posters: "void_posters.png",
                    width: 1920,
                    height: 1064,
                    x: 0,
                    y: 0,
                },
                {
                    formerly: "freljord",
                    translation: "弗雷尔卓德",
                    icon: "freljord_crest_icon.png",
                    posters: "freljord_posters.png",
                    width: 1920,
                    height: 1019,
                    x: 177,
                    y: 987,
                },
            ],
        });
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
.FCR_maind {
    margin-top: 200px;
    position: relative;
    z-index: 9;
    width: 100vw;
    .title {
        position: absolute;
        text-align: center;
        left: calc(50% - 66px);
        top: -150px;
        img {
            height: 32px;
        }
        h1 {
            color: #c4b998;
            font-size: 24px;
            letter-spacing: 7px;
            position: relative;
            text-indent: 8px;
            top: 4px;
        }
    }
    span {
        display: block;
        position: absolute;
        background-color: #927345;
        opacity: 0.4;
        &::after {
            content: "";
            display: block;
            position: absolute;
            height: 3px;
            width: 3px;
            border: solid 1px #927345;
            transform: rotate(45deg);
        }
    }
    .top_left,
    .top_right {
        top: -11%;
        width: 600px;
        height: 1px;
    }
    .top_left {
        left: 5.4%;
        &::after {
            top: -2px;
            right: -4px;
        }
    }
    .top_right {
        right: 5.4%;
        &::after {
            top: -2px;
            left: -4px;
        }
    }
    .left_top,
    .left_bottom {
        left: calc(5.4% - 2px);
        width: 1px;
        height: 300px;
    }
    .left_top {
        top: -11%;
        &::after {
            left: -2px;
            bottom: -4px;
        }
    }
    .left_bottom {
        bottom: 1px;
        &::after {
            left: -2px;
            top: -4px;
        }
    }
    .right_top,
    .right_bottom {
        right: 5.4%;
        width: 1px;
        height: 300px;
    }
    .right_top {
        top: calc(-11% + 1px);
        &::after {
            left: -2px;
            bottom: -4px;
        }
    }
    .right_bottom {
        bottom: 0;
        &::after {
            left: -2px;
            top: -4px;
        }
    }
    .bottom {
        position: absolute;
        background-color: #927345;
        opacity: 0.4;
        width: calc(100% - 5.4% * 2);
        height: 1px;
        left: 5.4%;
        bottom: 0;
    }
}
</style>