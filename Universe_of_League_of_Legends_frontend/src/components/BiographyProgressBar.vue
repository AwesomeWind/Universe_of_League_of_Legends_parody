<template>
    <transition name="PB">
        <div
            class="PB_mind"
            :style="{'position': this.Scroll>66?'fixed':'absolute'}"
            v-show="this.Scroll>66"
        >
            <h2>SHORT STORY</h2>
            <h1>
                <slot name="name"></slot>
            </h1>
            <h3>
                <slot name="title"></slot>
            </h3>
            <div>
                <div
                    class="progressBar"
                    :style="{'width': PBheight}"
                ></div>
            </div>
            <span></span>
        </div>
    </transition>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "Progressbar",
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
    computed: {
        PBheight() {
            const ScrollHeight =
                document.documentElement.scrollHeight -
                document.documentElement.clientHeight;
            return (this.Scroll / ScrollHeight) * 100 + "%";
        },
    },
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
.PB_mind {
    position: relative;
    top: 66px;
    left: 60px;
    display: flex;
    flex-flow: column;
    z-index: 99;
    h1 {
        font-family: microsoft yahei, Helvetica, tahoma, simsun, sans-serif;
        font-weight: 800;
        font-size: 24px;
        color: #f0e6d2;
        letter-spacing: 0.05em;
        line-height: 100%;
        margin-bottom: 15px;
    }
    h2 {
        color: #f0e6d2;
        font-weight: 400;
        letter-spacing: 0.05em;
        line-height: 100%;
        text-transform: uppercase;
        font-size: 12px;
        margin-bottom: 5px;
    }
    h3 {
        font-size: 12px;
        color: #c8aa6e;
        margin-bottom: 30px;
        font-weight: 800;
        letter-spacing: 0.05em;
        line-height: 100%;
    }
    > div {
        height: 2px;
        background-color: rgba(200, 170, 110, 0.2);
        width: 240px;
    }
    span {
        align-items: center;
        display: flex;
        justify-content: flex-start;
        margin-top: 26px;
    }
    .progressBar {
        height: 2px;
        background-color: #c8aa6e;
    }
}

@keyframes emerge {
    0% {
        opacity: 0;
        transform: translateX(-60px);
    }
    100% {
        opacity: 1;
        transform: translateX(0);
    }
}
.PB-enter-active {
    animation: emerge 0.8s ease-out;
}
.PB-leave-active {
    animation: emerge 0.8s ease-in reverse;
}
</style>