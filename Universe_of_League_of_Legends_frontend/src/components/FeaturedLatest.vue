<template>
    <div class='FLH_maind'>
        <img
            src="../assets/img/public_img/Latest_icon.png"
            alt=""
        >
        <div class="topic">
            <h1><span class="_left_"><span></span></span>最新<span class="_right_"><span></span></span></h1>
        </div>
        <FlexLayout41Vue :HeroesList="this.HeroesList"></FlexLayout41Vue>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import FlexLayout41Vue from "./FlexLayout4-1.vue";

export default {
    name: "Latest",
    components: { FlexLayout41Vue },
    props: [],
    setup() {
        //这里存放数据
        const data = reactive({
            HeroesList: [
                {
                    formerly: "nilah",
                    releaseDate: "2022-06-22 17:00:00",
                    translation: "尼菈",
                    title: "不羁之悦",
                    races: "null",
                    relevantRegion: "bilgewater",
                    role: "marksman",
                    relatedPeople: "graves,illaoi,viego,fiddlesticks",
                    posters: "nilah_尼菈.jpg",
                    width: 1920,
                    height: 1080,
                    x: 1200,
                    y: 300,
                },
                {
                    formerly: "belveth",
                    releaseDate: "2022-05-20 17:00:00",
                    translation: "卑尔维斯",
                    title: "虚空女皇",
                    races: "null",
                    relevantRegion: "void",
                    role: "fighter",
                    relatedPeople: "kaisa,lissandra,malzahar,velkoz",
                    posters: "belveth_卑尔维斯.jpg",
                    width: 1920,
                    height: 1080,
                    x: 900,
                    y: 300,
                },
                {
                    formerly: "renataglasc",
                    releaseDate: "2022-02-01 09:00:00",
                    translation: "烈娜塔·戈拉斯克",
                    title: "炼金男爵",
                    races: "null",
                    relevantRegion: "zaun",
                    role: "support",
                    relatedPeople: "camille,ekko,viktor,zeri",
                    posters: "renataglasc_烈娜塔·戈拉斯克.jpg",
                    width: 1920,
                    height: 1080,
                    x: 1000,
                    y: 150,
                },
                {
                    formerly: "zeri",
                    releaseDate: "2022-01-05 18:00:00",
                    translation: "泽丽",
                    title: "祖安花火",
                    races: "null",
                    relevantRegion: "zaun",
                    role: "marksman",
                    relatedPeople: "ekko",
                    posters: "zeri_泽丽.jpg",
                    width: 1920,
                    height: 1080,
                    x: 1100,
                    y: 300,
                },
                {
                    formerly: "vex",
                    releaseDate: "2021-09-08 19:43:26",
                    translation: "薇古丝",
                    title: "愁云使者",
                    races: "null",
                    relevantRegion: "shadow-isles",
                    role: "mage",
                    relatedPeople: "lucian,senna,thresh,viego",
                    posters: "vex_薇古丝.jpg",
                    width: 1920,
                    height: 1064,
                    x: 1250,
                    y: 150,
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
.FLH_maind {
    position: relative;
    z-index: 9;
    text-align: center;
    img {
        height: 28px;
        margin-bottom: 10px;
    }
    .topic {
        h1 {
            color: #c4b998;
            font-size: 24px;
            letter-spacing: 7px;
            // opacity: 0;
            position: relative;
            text-indent: 8px;
            margin-bottom: 50px;
        }
        ._left_ {
            display: inline-block;
            position: relative;
            transform: translateX(-80px);
            height: 2px;
            width: 450px;
            opacity: 0.4;
            top: -5px;
            background-image: linear-gradient(
                to left,
                #927345 50%,
                transparent 100%
            );
        }

        ._left_ > span {
            position: absolute;
            display: inline-block;
            right: -3px;
            transform: rotate(45deg) translateY(-2px);
            height: 5px;
            width: 5px;
            border: solid 1px #927345;
        }

        ._right_ {
            display: inline-block;
            position: relative;
            transform: translateX(80px);
            height: 2px;
            width: 450px;
            opacity: 0.4;
            top: -5px;
            background-image: linear-gradient(
                to right,
                #927345 50%,
                transparent 100%
            );
        }

        ._right_ > span {
            position: absolute;
            display: inline-block;
            left: -7px;
            transform: rotate(45deg) translateY(-2px);
            height: 5px;
            width: 5px;
            border: solid 1px #927345;
        }
    }
}
</style>