<template>
    <div class='SREC_maind'>
        <ul>
            <li
                v-for="(regional,index) in CarouselList"
                :key="index"
            >
                <div :style="{
                  'background-image': 'url(' + require(`@/assets/img/regional_posters/${regional.posters}`) + ')',
                  'background-position': `${regional.x*1.0/regional.width*100}% ${regional.y*1.0/regional.height*100}%`,
                  }">
                    <div class="text">
                        <div>
                            <div>
                                <div>
                                    <img
                                        :src="require(`../assets/img/crest_icon/${regional.icon}`)"
                                        alt=""
                                    >
                                </div>
                                <div>
                                    <h1>{{regional.translation}}</h1>
                                </div>
                                <div>
                                    <router-link :to="`/RegionInfo/${regional.formerly}`">
                                        了解更多<span class="right_arrow">⇢</span>
                                    </router-link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <div class="prev">
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
            <p>上一个地区</p>
        </div>
        <div class="next">
            <p>下一个地区</p>
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
        <router-link to="/RegionShowCase">查看所有地区<span class="right_arrow">⇢</span></router-link>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "SingleRegionElementCarousel",
    components: {},
    props: { CarouselList: [Array] },
    setup() {
        //这里存放数据
        const data = reactive({
            doms: {},
            count: 1,
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
    methods: {
        move() {
            var moveWidth =
                document.querySelector(".SREC_maind>ul>li:first-child")
                    .offsetWidth + 200;
            this.doms.carousel.style.transform = `translateX(-${
                (this.count - 1) * moveWidth
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
                    : -Math.abs(this.CarouselList.length - 3);
            this.move();
        },

        disposeCarouselList() {
            var firstItem = this.CarouselList[0];
            var lastItem = this.CarouselList[this.CarouselList.length - 1];
            this.CarouselList.unshift(lastItem);
            this.CarouselList.push(firstItem);
        },
        getDoms() {
            this.doms.carousel = document.querySelector(".SREC_maind ul");
        },
    },
    beforeCreate() {}, //生命周期 - 创建之前
    created() {
        this.disposeCarouselList();
    }, //生命周期 - 创建之后（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {
        this.getDoms();
        console.log(this.doms);
    }, //生命周期 - 挂载之后（可以访问DOM元素）
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeUnmount() {}, //生命周期 - 卸载之前
    unmounted() {}, //生命周期 - 卸载之后
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='less' scoped>
.SREC_maind {
    position: relative;
    width: 100vw;
    height: 900px;
    overflow: hidden;
    > ul {
        position: absolute;
        display: flex;
        flex-wrap: nowrap;
        left: -1475px;
        transition: all 0.3s ease-in-out;
        > li {
            margin: 0 100px;
            > div {
                position: relative;
                width: 1400px;
                height: 746px;
                background-color: #5d5b5b;
                background-size: 100%;
                transition: all 0.3s ease-in-out;
                &:hover {
                    background-size: 105%;
                }
                .text {
                    overflow: hidden;
                    position: absolute;
                    background: #131315;
                    border: 1px solid #342b20;
                    width: 90%;
                    height: 175px;
                    bottom: -80px;
                    left: calc(50% - 45%);
                    z-index: 9;
                    &::before {
                        content: "";
                        position: absolute;
                        height: 100%;
                        width: 100%;
                        background: #131315;
                        border: 1px solid #342b20;
                        left: -75%;
                        top: 50%;
                    }
                    &::after {
                        content: "";
                        position: absolute;
                        height: 100%;
                        width: 100%;
                        background: #131315;
                        border: 1px solid #342b20;
                        z-index: -1;
                        top: -17%;
                        right: -50%;
                    }
                    > div {
                        position: absolute;
                        top: 14px;
                        right: 14px;
                        bottom: 14px;
                        left: 14px;
                        background: #131315;
                        border: 1px solid #342b20;

                        > div {
                            position: absolute;
                            display: flex;
                            border: 1px solid #c4b998;
                            top: 22px;
                            right: 22px;
                            bottom: 22px;
                            left: 22px;
                            > div:nth-child(1) {
                                position: relative;
                                display: flex;
                                justify-content: center;
                                height: 100%;
                                width: 13%;
                                border-right: solid 1px #c4b998;
                                img {
                                    position: absolute;
                                    height: 80%;
                                    top: 10%;
                                }
                            }
                            > div:nth-child(2) {
                                height: 100%;
                                width: 60%;
                                border-right: solid 1px #c4b998;
                                text-align: center;
                                h1 {
                                    font-weight: 400;
                                    font-size: 38px;
                                    color: #d3c7aa;
                                    letter-spacing: 0.14em;
                                    line-height: 94px;
                                }
                            }
                            > div:nth-child(3) {
                                height: 100%;
                                width: 27%;
                                text-align: center;
                                a {
                                    font-weight: 400;
                                    font-size: 15px;
                                    color: #b59758;
                                    letter-spacing: 4px;
                                    line-height: 94px;
                                    text-decoration: none;
                                }
                                &:hover span {
                                    animation: jtmove 0.5s ease-out;
                                }
                                &:hover h1 {
                                    color: #fad27b;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    > div {
        top: calc(45% - 30px);
        position: absolute;
        display: flex;
        svg {
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
            transform: scale(1.2);
        }
        p {
            transform-origin: 36px 6px;
            color: #876d3e;
            font-size: 12px;
            font-weight: 600;
            letter-spacing: 0.2em;
            font-style: italic;
            transform: rotate(-90deg) translateX(-15px);
        }
    }
    .prev {
        left: calc(5.4% - 33px);
        svg {
            margin-right: 10px;
        }
    }
    .next {
        right: calc(5.4% - 33px);
        svg {
            margin-left: 10px;
        }
    }
    > a {
        position: absolute;
        bottom: 37px;
        letter-spacing: 0.25em;
        left: calc(50% - 78px);
        color: #8a6c3c;
        text-decoration: none;
        &:hover span {
            animation: jtmove 0.5s ease-out;
        }
        &:hover {
            color: #c89d57;
        }
    }
}
.right_arrow {
    display: inline-block;
    transform: translateX(20px);
}
@keyframes jtmove {
    40% {
        transform: translateX(40px);
        opacity: 0;
    }
    50% {
        transform: translateX(0);
    }
    100% {
        transform: translateX(20px);
        opacity: 1;
    }
}
</style>