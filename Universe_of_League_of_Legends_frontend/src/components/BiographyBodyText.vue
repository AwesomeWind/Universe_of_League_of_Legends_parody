<template>
    <div class="BT_mind">
        <div>
            <transition name="gone">
                <span
                    v-show="Scroll!=0"
                    class="DownArrow"
                ></span>
            </transition>
            <h1>
                <slot name="name"></slot>
            </h1>
            <h2>
                <slot name="title"></slot>
            </h2>
            <div
                class="textbox"
                v-html="Text"
            >
            </div>
        </div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "Bodytext",
    components: {},
    props: ["Scroll", "Text"],
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
.BT_mind {
    background-color: #111315;
    z-index: 9;
    width: 100vw;
    > div {
        position: relative;
        width: 600px;
        text-align: center;
        margin: 0 auto;
        .DownArrow {
            position: absolute;
            display: inline-block;
            top: -180px;
            width: 2px;
            height: 50px;
            background-color: #c8aa6e;
            &::before {
                border: 2px solid #c8aa6e;
                content: "";
                display: block;
                position: absolute;
                box-sizing: inherit;
                height: 10px;
                width: 10px;
                bottom: -10px;
                left: -4px;
                transform: rotate(45deg);
            }
        }
        > h1 {
            color: #f0e6d2;
            font-weight: 800;
            letter-spacing: 0.05em;
            line-height: 100%;
            font-size: 24px;
            align-items: center;
            display: flex;
            flex-direction: column;
            margin-top: 50px;
        }
        > h2 {
            color: #c8aa6e;
            font-weight: 400;
            letter-spacing: 0.02em;
            line-height: 140%;
            font-size: 12px;
            font-weight: 700;
            margin-top: 15px;
        }
        > .textbox {
            margin-top: 150px;
            color: #f0e6d2;
            font-weight: 400;
            letter-spacing: 0.02em;
            line-height: 140%;
            font-size: 18px;
            letter-spacing: -0.004em;
            line-height: 1.58;
            text-align: left;
            /deep/ p {
                padding: 10px 0;
            }
        }
    }
}
@keyframes gone {
    100% {
        opacity: 0;
    }
}
.gone-enter-active {
    animation: gone 0.5s ease-in reverse;
}
.gone-leave-active {
    animation: gone 0.5s ease-in;
}
</style>