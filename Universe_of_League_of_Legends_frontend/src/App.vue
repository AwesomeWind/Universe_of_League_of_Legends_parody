<template>
    <Myheader></Myheader>
    <router-view />
    <Myfooter></Myfooter>
</template>
<script>
import Myheader from "@/components/header.vue";
import Myfooter from "@/components/footer.vue";
import { reactive, toRefs } from "vue";
import { mapActions } from "vuex";

export default {
    name: "app",
    components: { Myfooter, Myheader },
    setup() {
        //这里存放数据
        const data = reactive({});
        return {
            ...toRefs(data),
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {
        //监听路由变化更新title
        $route(n, o) {
            document.title = n.meta.title;
        },
    },
    //方法集合
    methods: {
        ...mapActions(["fetchHeroes"]),
        ...mapActions(["fetchRegional"]),
        ...mapActions(["fetchRaces"]),
        ...mapActions(["fetchRoles"]),
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.fetchHeroes();
        this.fetchRegional();
        this.fetchRaces();
        this.fetchRoles();
    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {},
    beforeCreate() {}, //生命周期 - 创建之前
    beforeMount() {}, //生命周期 - 挂载之前
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeDestroy() {}, //生命周期 - 销毁之前
    destroyed() {}, //生命周期 - 销毁完成
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang='css' scoped>
body {
    width: 100vw;
    background-color: #09090c;
}
</style>