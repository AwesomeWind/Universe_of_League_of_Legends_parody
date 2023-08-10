<template>
    <div class='FS_maind'>
        <img
            src="../assets/img/public_img/Selected_icon.png"
            alt=""
        >
        <div class="topic">
            <h1><span class="_left_"><span></span></span>精选<span class="_right_"><span></span></span></h1>
        </div>
        <FlexLayout41Vue :HeroesList="this.HeroesList"></FlexLayout41Vue>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import FlexLayout41Vue from "./FlexLayout4-1.vue";
export default {
    name: "name",
    components: { FlexLayout41Vue },
    props: {},
    setup() {
        //这里存放数据
        const data = reactive({
            HeroesList: [
                {
                    formerly: "kaisa",
                    releaseDate: "2018-03-02 00:00:00",
                    translation: "卡莎",
                    title: "虚空之女",
                    races: "null",
                    relevantRegion: "void",
                    role: "marksman",
                    relatedPeople: "malzahar",
                    posters: "kaisa_卡莎.jpg",
                    width: 1920,
                    height: 1133,
                    x: 950,
                    y: 200,
                },
                {
                    formerly: "twistedfate",
                    releaseDate: "2009-02-21 00:00:00",
                    translation: "崔斯特",
                    title: "卡牌大师",
                    races: "null",
                    relevantRegion: "bilgewater",
                    role: "mage",
                    relatedPeople: "graves,gangplank,missfortune",
                    posters: "twistedfate_崔斯特.jpg",
                    width: 1215,
                    height: 717,
                    x: 1006,
                    y: 37,
                },
                {
                    formerly: "graves",
                    releaseDate: "2011-10-19 00:00:00",
                    translation: "格雷福斯",
                    title: "法外狂徒",
                    races: "null",
                    relevantRegion: "bilgewater",
                    role: "marksman",
                    relatedPeople: "twistedfate,gangplank,missfortune",
                    posters: "graves_格雷福斯.jpg",
                    width: 1215,
                    height: 717,
                    x: 1021,
                    y: 0,
                },
                {
                    formerly: "pantheon",
                    releaseDate: "2010-02-02 00:00:00",
                    translation: "潘森",
                    title: "不屈之枪",
                    races: "null",
                    relevantRegion: "mount-targon",
                    role: "fighter",
                    relatedPeople: "aatrox,aurelionsol,leona",
                    posters: "pantheon_潘森.jpg",
                    width: 1080,
                    height: 637,
                    x: 556,
                    y: 230,
                },
                {
                    formerly: "annie",
                    releaseDate: "2009-02-21 00:00:00",
                    translation: "安妮",
                    title: "黑暗之女",
                    races: "null",
                    relevantRegion: "unaffiliated",
                    role: "mage",
                    relatedPeople: "",
                    posters: "annie_安妮.jpg",
                    width: 1215,
                    height: 717,
                    x: 1161,
                    y: 145,
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
.FS_maind {
    margin-top: 80px;
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