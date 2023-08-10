<template>
    <div class='FCH_maind'>
        <div class="title">
            <img
                src="../assets/img/public_img/hero_crest_icon.png"
                alt=""
            >
            <h1>亮点英雄</h1>
        </div>
        <SingleHeroElementCarousel :CarouselList="HeroArray"></SingleHeroElementCarousel>
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
import SingleHeroElementCarousel from "./SingleHeroElementCarousel.vue";

export default {
    name: "CarouselHero",
    components: { SingleHeroElementCarousel },
    props: [],
    setup() {
        //这里存放数据
        const data = reactive({
            HeroArray: [
                {
                    formerly: "talon",
                    releaseDate: "2011-08-24 00:00:00",
                    translation: "泰隆",
                    title: "刀锋之影",
                    races: "null",
                    relevantRegion: "noxus",
                    role: "assassin",
                    relatedPeople: "katarina,quinn,cassiopeia",
                    posters: "talon_泰隆.jpg",
                    width: 1215,
                    height: 717,
                    x: 893,
                    y: 121,
                },
                {
                    formerly: "jinx",
                    releaseDate: "2013-10-10 00:00:00",
                    translation: "金克丝",
                    title: "暴走萝莉",
                    races: "null",
                    relevantRegion: "zaun",
                    role: "marksman",
                    relatedPeople: "caitlyn,vi,ekko",
                    posters: "jinx_金克丝.jpg",
                    width: 1215,
                    height: 717,
                    x: 901,
                    y: 82,
                },
                {
                    formerly: "brand",
                    releaseDate: "2011-04-12 00:00:00",
                    translation: "布兰德",
                    title: "复仇焰魂",
                    races: "null",
                    relevantRegion: "unaffiliated",
                    role: "mage",
                    relatedPeople:
                        "ryze,anivia,lissandra,nasus,renekton,xerath",
                    posters: "brand_布兰德.jpg",
                    width: 1215,
                    height: 717,
                    x: 1074,
                    y: 50,
                },
                {
                    formerly: "blitzcrank",
                    releaseDate: "2009-09-02 00:00:00",
                    translation: "布里茨",
                    title: "蒸汽机器人",
                    races: "null",
                    relevantRegion: "zaun",
                    role: "tank",
                    relatedPeople: "orianna,viktor",
                    posters: "blitzcrank_布里茨.jpg",
                    width: 1215,
                    height: 717,
                    x: 953,
                    y: 113,
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
.FCH_maind {
    margin-top: 200px;
    position: relative;
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