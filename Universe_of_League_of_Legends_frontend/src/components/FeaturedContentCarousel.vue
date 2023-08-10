<template>
    <div class='FC_mind'>
        <!-- 轮播图 -->
        <ul class="posterList">
            <li
                v-for="(Pitem,index) in CarouselList"
                :key="index"
                :class="{'special_poster':this.count==index,'grayscale':this.count!=index}"
            >
                <img
                    :src="require(`../assets/img/carousel_poster/${Pitem.posters}`)"
                    alt=""
                >
            </li>
        </ul>
        <ul class="textList">
            <li
                v-for="(Titem,index) in CarouselList"
                :key="index"
            >
                <div :class="{'special_text':this.count==index,'brightness':this.count!=index}">
                    <h2>作者：{{ Titem.writer }}</h2>
                    <h1>{{ Titem.title }}</h1>
                    <p v-html="Titem.description.replace(/<\/?(?!em|\/em|strong|\/strong)[^>]+>/g, '')"></p>
                </div>
            </li>
        </ul>
        <svg
            class="DirectionButton_2dc5 prev"
            x="0px"
            y="0px"
            @click="prev()"
            viewBox="0 0 100 100"
            style="width: 54px; height: 54px;"
        >
            <defs>
                <linearGradient
                    id="center_gradient"
                    gradientUnits="userSpaceOnUse"
                    x1="12.6005"
                    y1="47.5209"
                    x2="86.6005"
                    y2="47.5209"
                >
                    <stop
                        offset="0"
                        style="stop-color: rgb(137, 107, 55);"
                    ></stop>
                    <stop
                        offset="0.5"
                        style="stop-color: rgb(200, 180, 86);"
                    ></stop>
                    <stop
                        offset="1"
                        style="stop-color: rgb(137, 107, 55);"
                    ></stop>
                </linearGradient>
                <linearGradient
                    id="top_gradient"
                    gradientUnits="userSpaceOnUse"
                    x1="53.4222"
                    y1="27.9995"
                    x2="53.4222"
                    y2="67.0005"
                >
                    <stop
                        offset="0"
                        style="stop-color: rgb(195, 165, 93);"
                    ></stop>
                    <stop
                        offset="1"
                        style="stop-color: rgb(104, 74, 32);"
                    ></stop>
                </linearGradient>
            </defs>
            <circle
                fill="url(#top_gradient)"
                class="outerRing_YuAX"
                cx="50"
                cy="50"
                r="43.5"
            ></circle>
            <circle
                class="outerRingBackground_2wCm"
                cx="50"
                cy="50"
                r="41"
            ></circle>
            <g>
                <circle
                    fill="url(#center_gradient)"
                    class="innerRing_3clI"
                    cx="50"
                    cy="50"
                    r="34"
                ></circle>
                <circle
                    class="innerRingBackground_17Cy"
                    cx="50"
                    cy="50"
                    r="30"
                ></circle>
                <path
                    fill="url(#top_gradient)"
                    class="Arrow_2_gT PreviousDirectionTranslateHack_1tV9"
                    d="M48.78,28l-19,19l19,20l6-5l-10-11l21-0.07V43h-21l10-10L48.78,28z"
                ></path>
            </g>
        </svg>
        <svg
            class="DirectionButton_2dc5 next"
            x="0px"
            y="0px"
            @click="next()"
            viewBox="0 0 100 100"
            style="width: 54px; height: 54px;"
        >
            <defs>
                <linearGradient
                    id="center_gradient"
                    gradientUnits="userSpaceOnUse"
                    x1="12.6005"
                    y1="47.5209"
                    x2="86.6005"
                    y2="47.5209"
                >
                    <stop
                        offset="0"
                        style="stop-color: rgb(137, 107, 55);"
                    ></stop>
                    <stop
                        offset="0.5"
                        style="stop-color: rgb(200, 180, 86);"
                    ></stop>
                    <stop
                        offset="1"
                        style="stop-color: rgb(137, 107, 55);"
                    ></stop>
                </linearGradient>
                <linearGradient
                    id="top_gradient"
                    gradientUnits="userSpaceOnUse"
                    x1="53.4222"
                    y1="27.9995"
                    x2="53.4222"
                    y2="67.0005"
                >
                    <stop
                        offset="0"
                        style="stop-color: rgb(195, 165, 93);"
                    ></stop>
                    <stop
                        offset="1"
                        style="stop-color: rgb(104, 74, 32);"
                    ></stop>
                </linearGradient>
            </defs>
            <circle
                fill="url(#top_gradient)"
                class="outerRing_YuAX"
                cx="50"
                cy="50"
                r="43.5"
            ></circle>
            <circle
                class="outerRingBackground_2wCm"
                cx="50"
                cy="50"
                r="41"
            ></circle>
            <g>
                <circle
                    fill="url(#center_gradient)"
                    class="innerRing_3clI"
                    cx="50"
                    cy="50"
                    r="34"
                ></circle>
                <circle
                    class="innerRingBackground_17Cy"
                    cx="50"
                    cy="50"
                    r="30"
                ></circle>
                <path
                    fill="url(#top_gradient)"
                    class="Arrow_2_gT NextDirectionTranslateHack_1U8x"
                    d="M44.42,33l10,10h-21v7.93l21,0.07l-10,11l6,5l19-20l-19-19L44.42,33z"
                ></path>
            </g>
        </svg>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "ContentCarousel",
    components: {},
    props: [],
    setup() {
        const doms = {};
        //这里存放数据
        const data = reactive({
            CarouselList: [
                {
                    posters: "Carousel_poster1.jpg",
                    title: "风车",
                    writer: "Jared Rosen",
                    description:
                        "<p>“好吧。”卡莎重重地叹了口气，看着那形体在自己四周和头顶一齐展开……</p>",
                    type: "story-preview",
                },
                {
                    posters: "Carousel_poster2.jpg",
                    title: "毕来牡蛎店中的畅情一夜",
                    writer: "Jared Rosen",
                    description:
                        "<p>允你快意纵情</p>\n<br>许你名就功成<br>\n<br>送你荣登殿堂，同侪英烈<br>",
                    type: "story-preview",
                },
                {
                    posters: "Carousel_poster3.jpg",
                    title: "眼眸，微火",
                    writer: "Conor Sheehy",
                    description: "<p><strong><em>跑。</em></strong></p>",
                    type: "story-preview",
                },
                {
                    posters: "Carousel_poster4.jpg",
                    title: "织星",
                    writer: "",
                    description:
                        "为了将爱人从黑暗中拯救出来，霞踏上穿越银河系的征程，展开了一段招募队友的奇妙之旅。",
                    type: "link-out",
                },
                {
                    posters: "Carousel_poster5.jpg",
                    title: "他们俩，还有崩布里尼",
                    writer: "Jared Rosen",
                    description:
                        "<p>比尔吉沃特形形色色的海运仓库里，大多充斥着腐锈的匕首和人类手臂一样长的食肉硕鼠，但也有一个仓库是例外。</p>",
                    type: "story-preview",
                },
            ],
            count: 1,
        });
        return {
            ...toRefs(data),
            doms,
        };
    },
    //计算属性
    computed: {},
    //监听属性
    watch: {},
    //方法集合
    methods: {
        move() {
            var posterListLiWidth = document.querySelector(
                ".posterList>li:first-child"
            ).offsetWidth;
            var textListLiWidth = document.querySelector(
                ".textList>li:first-child"
            ).offsetWidth;
            this.doms.posterList.style.transform = `translateX(-${
                (this.count - 1) * posterListLiWidth
            }px)`;
            this.doms.textList.style.transform = `translateX(-${
                (this.count - 1) * textListLiWidth
            }px)`;
        },
        next() {
            this.count +=
                this.count + 1 < this.CarouselList.length - 1
                    ? 1
                    : -Math.abs(this.count - 1);
            this.move();
        },

        prev() {
            this.count -=
                this.count - 1 > 0
                    ? 1
                    : -Math.abs(this.CarouselList.length - 2 - 1);
            this.move();
        },

        disposeCarouselList() {
            var firstItem = this.CarouselList[0];
            var lastItem = this.CarouselList[this.CarouselList.length - 1];
            this.CarouselList.unshift(lastItem);
            this.CarouselList.push(firstItem);
        },
        getDoms() {
            this.doms.posterList = document.querySelector(".posterList");
            this.doms.textList = document.querySelector(".textList");
        },
    },
    beforeCreate() {}, //生命周期 - 创建之前
    created() {}, //生命周期 - 创建之后（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {
        this.disposeCarouselList();
        this.getDoms();
    }, //生命周期 - 挂载之后（可以访问DOM元素）
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeUnmount() {}, //生命周期 - 卸载之前
    unmounted() {}, //生命周期 - 卸载之后
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='less' scoped>
.FC_mind {
    position: relative;
    width: 100vw;
    height: 775px;
    overflow: hidden;
    svg {
        user-select: none;
        position: absolute;
        z-index: 999;
        top: calc(30% - 27px);
        .outerRing_YuAX,
        .outerRingBackground_2wCm,
        .innerRingBackground_17Cy,
        .innerRing_3clI,
        .NextDirectionTranslateHack_1U8x {
            transition: all 0.2s ease-in-out;
        }
        &:hover .outerRing_YuAX,
        &:hover .outerRingBackground_2wCm {
            transform-origin: center;
            transform: scale(1.1);
        }
        &:active .innerRingBackground_17Cy,
        &:active .innerRing_3clI,
        &:active .NextDirectionTranslateHack_1U8x {
            filter: brightness(80%);
        }
    }
    .prev {
        left: 20%;
    }
    .next {
        right: 20%;
    }
    .posterList {
        position: absolute;
        transition: all 0.3s ease-in-out;
        bottom: 160px;
        display: flex;
        left: calc(-100vw / 4);
        z-index: 9;
        li {
            transition: all 0.3s ease-in-out;
            img {
                width: calc(100vw / 2);
            }
        }
        .special_poster {
            transform: scale(1.2) translateY(-30px);
            box-shadow: 0 0 100px 10px black;
            z-index: 99;
        }
    }
    .textList {
        position: relative;
        display: flex;
        top: calc(100% - 270px);
        z-index: 99;
        box-shadow: 0 0 50px 5px black;
        transition: all 0.3s ease-in-out;
        li {
            .special_text {
                z-index: 99;
                &::after {
                    position: absolute;
                    content: "";
                    z-index: 8;
                    height: 180px;
                    width: calc(100vw / 3 - 1px);
                    transform: scale(1.1, 1.5);
                    top: -4px;
                    background-image: linear-gradient(
                        to right,
                        #937341,
                        #917240
                    );
                    clip-path: polygon(
                        50% 0%,
                        100% 15%,
                        100% 85%,
                        50% 100%,
                        0% 85%,
                        0% 15%
                    );
                }
                &::before {
                    position: absolute;
                    content: "";
                    z-index: 9;
                    height: 180px;
                    width: calc(100vw / 3);
                    transform: scale(1.1, 1.5);
                    background-color: #16171b;
                    clip-path: polygon(
                        50% 0%,
                        100% 15%,
                        100% 85%,
                        50% 100%,
                        0% 85%,
                        0% 15%
                    );
                }
                h2 {
                    &::after {
                        position: absolute;
                        content: "";
                        z-index: -2;
                        height: 180px;
                        width: calc(100vw / 3);
                        left: 0;
                        top: 0;
                        transform: scale(1.15, 1.5) scale(0.9);
                        background-color: #1c1c1d;
                        clip-path: polygon(
                            50% 0%,
                            100% 15%,
                            100% 85%,
                            50% 100%,
                            0% 85%,
                            0% 15%
                        );
                    }
                    &::before {
                        position: absolute;
                        content: "";
                        z-index: -1;
                        height: 175px;
                        width: calc(100vw / 3 - 5px);
                        left: 2.5px;
                        top: 2.5px;
                        transform: scale(1.15, 1.5) scale(0.9);
                        background-color: #16171b;
                        clip-path: polygon(
                            50% 0%,
                            100% 15%,
                            100% 85%,
                            50% 100%,
                            0% 85%,
                            0% 15%
                        );
                    }
                }
            }
            div {
                position: relative;
                height: 180px;
                width: calc(100vw / 3);
                display: flex;
                flex-flow: column;
                justify-content: center;
                background-color: #16171b;
                border-top: solid 2px #3b3b3b;
                text-align: center;
                transition: all 0.5s ease-in-out;

                h1 {
                    color: #937341;
                    font-size: 30px;
                    letter-spacing: 3px;
                    margin: 10px 0;
                    z-index: 99;
                }
                h2 {
                    text-transform: uppercase;
                    color: #c4b998;
                    font-size: 14px;
                    letter-spacing: 4px;
                    z-index: 99;
                }
                p {
                    color: #c4b998;
                    font-size: 12px;
                    line-height: 1.1;
                    margin-top: 10px;
                    z-index: 99;
                }
            }
        }
    }
}
.grayscale {
    filter: grayscale(100%);
}
.brightness {
    filter: brightness(50%) grayscale(50%);
}
</style>