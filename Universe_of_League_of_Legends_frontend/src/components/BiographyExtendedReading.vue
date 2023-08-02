<template>
    <div class="ER_mind">
        <ul>

            <li
                v-for="
            (hero,index)
            in
            relatedpeople"
                :key="index"
            >
                <transition name="emerge">
                    <router-link
                        :to="`/HeroInfo/${hero.formerly}`"
                        v-if="show"
                        :style="{'animation-duration': index*0.1+0.4+'s'}"
                    >
                        <div
                            class="poster_box"
                            :style="{
              'background-image': `url(${require(`../assets/img/hero_posters/${hero.posters}`)})`,
              'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.x*100}%`}"
                        >
                        </div>
                        <div class="_poster_box_"></div>
                        <h1>{{ hero.translation }}</h1>
                        <h2>{{ this.regional.find((item)=>item.formerly==hero.relevantRegion).translation }}</h2>
                    </router-link>
                </transition>

            </li>
        </ul>

    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import { mapState } from "vuex";
export default {
    name: "Extendedreading",
    components: {},
    props: {
        relatedpeople: [Array],
    },
    setup() {
        //这里存放数据
        const data = reactive({
            ScrollHeight: 0,
            show: false,
        });
        return {
            ...toRefs(data),
        };
    },
    //计算属性
    computed: {
        ...mapState(["regional"]),
    },
    //监听属性
    watch: {
        ScrollHeight(n, o) {
            if (n < 600) {
                this.show = true;
            }
        },
    },
    //方法集合
    methods: {},
    beforeCreate() {}, //生命周期 - 创建之前
    created() {}, //生命周期 - 创建之后（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {
        window.addEventListener("scroll", () => {
            this.ScrollHeight =
                document.documentElement.scrollHeight -
                (document.documentElement.clientHeight +
                    document.documentElement.scrollTop);
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
.ER_mind {
    z-index: 9;
    width: 100vw;
    background-color: #111315;
    ul {
        padding: 80px 0;
        width: 1400px;
        height: 382px;
        margin: 0 auto;
        display: flex;
        justify-content: space-around;
        li {
            z-index: 9;
            position: relative;
            a {
                display: inline-block;
                text-decoration: none;
                h1 {
                    font-size: 18px;
                    color: #8a6c3c;
                    padding: 35px 0 8px;
                    font-weight: 400;
                    text-align: center;
                }
                h2 {
                    font-size: 12px;
                    color: #d3c7aa;
                    line-height: 11px;
                    font-weight: 400;
                    text-align: center;
                }
                .poster_box {
                    position: relative;
                    width: 150px;
                    height: 150px;
                    border-radius: 50%;
                    background-size: cover;
                    background-blend-mode: color;
                    text-align: center;
                    transition: all 0.3s ease-in-out;
                }
                ._poster_box_ {
                    position: absolute;
                    text-align: center;
                    top: 0;
                    left: 0;
                    width: 150px;
                    height: 150px;
                    border-radius: 50%;
                    border: solid 1px#8a6c3c;
                    z-index: 99;
                    opacity: 0;
                    transition: all 0.3s ease-in-out;
                    font-weight: 400;
                    font-size: 14px;
                }
            }
        }
        li:hover .poster_box {
            filter: grayscale(100);
            opacity: 0.2;
        }
        li:hover ._poster_box_ {
            transform: scale(1.2);
            opacity: 1;
            &:before {
                content: "探索";
                display: inline-block;
                z-index: 99;
                color: #937341;
            }
            &::after {
                content: "⇢";
                display: inline-block;
                z-index: 99;
                line-height: 150px;
                color: #d3c7aa;
                transform: translateX(5px);
            }
        }
    }
}
@keyframes emerge_up {
    0% {
        transform: translateY(200px);
        opacity: 0;
    }
    80% {
        transform: translateY(-20px);
    }
    90% {
        transform: translateY(10px);
    }
    100% {
        transform: translateY(0);
        opacity: 1;
    }
}
.emerge-leave {
    opacity: 1;
}
.emerge-enter-active {
    animation: emerge_up 0.8s ease-out;
}
</style>