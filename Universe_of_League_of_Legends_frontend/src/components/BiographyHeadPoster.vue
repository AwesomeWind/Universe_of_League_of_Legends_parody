<template>
    <div class="HP_mind">
        <div>
            <transition name="goneToTop">
                <h1 v-show="Scroll==0">
                    <slot name="name"></slot>
                </h1>
            </transition>
            <transition name="goneTop">
                <h2 v-show="Scroll==0">
                    <slot name="title"></slot>
                </h2>
            </transition>
            <transition name="gone">
                <div v-show="Scroll==0">
                    <p>滚动以开始</p>
                    <img
                        src="../assets/img/public_img/down.png"
                        alt=""
                    >
                </div>
            </transition>
        </div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "Headposter",
    components: {},
    props: ["Scroll"],
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
.HP_mind {
    position: relative;
    width: 100vw;
    height: 100vh;
    background: linear-gradient(to bottom, rgba(0, 0, 0, 0), #111315);
    z-index: 9;
    > div {
        position: relative;
        margin: 0 auto;
        text-align: center;
        top: 60%;
        > h1 {
            font-weight: 800;
            letter-spacing: 0.05em;
            line-height: 100%;
            font-size: 60px;
            color: #f0e6d2;
            text-shadow: 0 0 20px rgba(1, 10, 19, 0.7);
            filter: hue-rotate(360deg);
        }
        > h2 {
            font-weight: 800;
            letter-spacing: 0.05em;
            line-height: 100%;
            font-size: 18px;
            margin-top: 19px;
            color: #c8aa6e;
            text-shadow: 0 0 20px rgba(1, 10, 19, 0.7);
        }
        > div {
            width: 100px;
            font-weight: 800;
            letter-spacing: 0.05em;
            line-height: 100%;
            font-size: 12px;
            color: #a09b8c;
            margin: 0 auto;
            margin-top: 150px;
            position: relative;
            > img {
                display: inline-block;
                margin: 25px auto;
                width: 18px;
            }
        }
    }
}
@keyframes gone_top {
    100% {
        transform: translateY(-150px);
        opacity: 0;
    }
}
@keyframes gone {
    100% {
        opacity: 0;
    }
}
.goneToTop-enter-active {
    animation: gone_top 0.5s ease-in reverse;
}
.goneToTop-leave-active {
    animation: gone_top 0.5s ease-in;
}
.goneTop-enter-active {
    animation: gone_top 0.5s ease-in reverse;
}
.goneTop-leave-active {
    animation: gone_top 0.5s ease-in 0.1s;
}
.gone-enter-active {
    animation: gone 0.5s ease-in reverse;
}
.gone-leave-active {
    animation: gone 0.5s ease-in;
}
</style>