<template>
    <div class='FL_maind'>
        <ul>
            <li
                v-for="(hero,index) in HeroesList.slice(0,1)"
                :key="index"
            >
                <router-link :to="`/HeroInfo/${hero.formerly}`">
                    <div
                        class="card"
                        :style="{
                  'background-image': 'url(' + require(`@/assets/img/hero_posters/${hero.posters}`) + ')',
                  'background-position': `${hero.x*1.0/hero.width*100}% ${hero.y*1.0/hero.height*100}%`,
                  'background-size': 'cover',
                  }"
                    >
                        <div class="text">
                            <div>
                                <div><img
                                        src="../assets/img/public_img/hero_crest_icon.png"
                                        alt=""
                                    > </div>
                                <h2>{{ hero.title }}</h2>
                                <h1>{{ hero.translation }}</h1>
                            </div>
                            <div>了解更多<span>⇢</span></div>
                        </div>
                    </div>
                </router-link>
            </li>
            <li>
                <ul>
                    <li
                        v-for="(hero,index) in HeroesList.slice(1)"
                        :key="index"
                    >
                        <router-link :to="`/HeroInfo/${hero.formerly}`">
                            <div
                                class="card"
                                :style="{
                  'background-image': 'url(' + require(`@/assets/img/hero_posters/${hero.posters}`) + ')',
                  'background-position': `${hero.x*1.0/hero.width*100}% ${hero.y*1.0/hero.height*100}%`,
                  'background-size': 'cover',
                  }"
                            >
                                <div class="text">
                                    <div>
                                        <div><img
                                                src="../assets/img/public_img/hero_crest_icon.png"
                                                alt=""
                                            > </div>
                                        <h2>{{ hero.title }}</h2>
                                        <h1>{{ hero.translation }}</h1>
                                    </div>
                                    <div>了解更多<span>⇢</span></div>
                                </div>
                            </div>
                        </router-link>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "FlexLayout4-1",
    components: {},
    props: { HeroesList: [Array] },
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
.FL_maind {
    width: 1290px;
    height: 700px;
    margin: 0 auto;
    font-size: 8px;
    > ul {
        display: flex;
        flex-direction: row-reverse;
        justify-content: space-between;
        height: 100%;
        > li {
            width: calc(50% - 1em);
            &:hover > a > .card > .text {
                transform: translateX(0);
            }
            &:hover > a > .card {
                border: solid 1px #937341;
                transform: scale(1.1);
                box-shadow: 0 0 50px 5px black;
                z-index: 99;
            }
            .card {
                position: relative;
                overflow: hidden;
                z-index: 9;
                width: 100%;
                height: 100%;
                background-color: red;
                transition: all 0.3s ease-in-out;

                .text {
                    position: absolute;
                    bottom: 0;
                    width: 100%;
                    transition: all 0.3s ease-in-out;
                    background-color: #101217;
                    text-align: center;
                    color: white;
                    transform: translateY(54px);

                    > div:nth-child(1) {
                        height: 110px;
                        padding: 37px 25px;
                        border-top: 1px solid #7e633b;
                        div {
                            position: absolute;
                            top: -31px;
                            background-color: #101217;
                            border-radius: 50%;
                            right: calc(50% - 31px);
                            height: 62px;
                            width: 62px;
                            &::after {
                                position: absolute;
                                top: -2px;
                                right: -2px;
                                bottom: -2px;
                                left: -2px;
                                background-image: linear-gradient(
                                    180deg,
                                    #3e3310,
                                    #806734,
                                    #c6b98b,
                                    #806734,
                                    #3e3310
                                );
                                border-radius: 50%;
                                box-shadow: 0 0 20px 12px rgba(0, 0, 0, 0.2);
                                content: "";
                                z-index: -1;
                            }
                            img {
                                position: relative;
                                width: 17px;
                                top: calc(31px - 15px);
                            }
                        }
                        h2 {
                            padding: 9px 0 6px;
                            font-weight: 700;
                            font-size: 12px;
                            color: #937341 !important;
                            letter-spacing: 2px;
                            text-align: center;
                        }
                        h1 {
                            font-weight: 400;
                            font-size: 14px;
                            color: #c4b998;
                            letter-spacing: 2px;
                        }
                    }
                    > div:nth-child(2) {
                        border-top: 1px solid #7e633b;
                        height: 54px;
                        line-height: 54px;
                        color: #937341;
                        font-weight: 400;
                        font-size: 11px;
                        letter-spacing: 0.3em;
                        user-select: none;
                        span {
                            display: inline-block;
                            transform: translateX(20px);
                        }
                        &:hover span {
                            animation: jtmove 0.5s ease-out;
                        }
                    }
                }
            }
            > ul {
                display: flex;
                width: 100%;
                height: 100%;
                flex-wrap: wrap;
                justify-content: space-between;
                font-size: 8px;
                > li {
                    height: calc(50% - 1em);
                    width: calc(50% - 1em);
                    margin-bottom: 16px;
                    &:hover > a > .card > .text {
                        transform: translateX(0);
                    }
                    &:hover > a > .card {
                        border: solid 1px #937341;
                        transform: scale(1.1);
                        box-shadow: 0 0 50px 5px black;
                        z-index: 99;
                    }
                    .card {
                        position: relative;
                        width: 100%;
                        height: 100%;
                        background-color: red;
                        z-index: 9;
                        overflow: hidden;
                        .text {
                            position: absolute;
                            bottom: 0;
                            width: 100%;
                            transition: all 0.3s ease-in-out;
                            background-color: #101217;
                            text-align: center;
                            color: white;
                            transform: translateY(54px);

                            > div:nth-child(1) {
                                height: 80px;
                                padding: 20px 12px;
                                border-top: 1px solid #7e633b;
                                div {
                                    position: absolute;
                                    top: -21px;
                                    right: calc(50% - 21px);
                                    background-color: #101217;
                                    border-radius: 50%;
                                    height: 42px;
                                    width: 42px;
                                    &::after {
                                        position: absolute;
                                        top: -2px;
                                        right: -2px;
                                        bottom: -2px;
                                        left: -2px;
                                        background-image: linear-gradient(
                                            180deg,
                                            #3e3310,
                                            #806734,
                                            #c6b98b,
                                            #806734,
                                            #3e3310
                                        );
                                        border-radius: 50%;
                                        box-shadow: 0 0 20px 12px
                                            rgba(0, 0, 0, 0.2);
                                        content: "";
                                        z-index: -1;
                                    }
                                    img {
                                        position: relative;
                                        width: 13px;
                                        top: calc(21px - 11px);
                                    }
                                }
                                h2 {
                                    padding-bottom: 3px;
                                    font-weight: 700;
                                    font-size: 12px;
                                    color: #937341 !important;
                                    letter-spacing: 2px;
                                    text-align: center;
                                }
                                h1 {
                                    font-weight: 400;
                                    font-size: 14px;
                                    color: #c4b998;
                                    letter-spacing: 2px;
                                }
                            }
                            > div:nth-child(2) {
                                border-top: 1px solid #7e633b;
                                height: 54px;
                                line-height: 54px;
                                color: #937341;
                                font-weight: 400;
                                font-size: 11px;
                                letter-spacing: 0.3em;
                                user-select: none;
                                span {
                                    display: inline-block;
                                    transform: translateX(20px);
                                }
                                &:hover span {
                                    animation: jtmove 0.5s ease-out;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
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