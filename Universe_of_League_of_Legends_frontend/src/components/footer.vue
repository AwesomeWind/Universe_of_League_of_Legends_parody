<template>
    <div id="foot">
        <div class="tencent_logo">
            <a href="https://ieg.tencent.com/">
                <img
                    src="../assets/img/tencentLogo.png"
                    alt=""
                >
            </a>
        </div>
        <p>
            <a href="">腾讯互动娱乐</a>
            <a href="">广告服务</a>
            <a href="">腾讯游戏招聘</a>
            <a href="">腾讯游戏客服</a>
            <a href="">游戏地图</a>
            <a href="">成长守护平台</a>
            <a href="">商务合作</a>
            <a href="">网站导航</a>
        </p>
        <p>COPYRIGHT © 1998 – 2018 TENCENT. ALL RIGHTS RESERVED.</p>
        <p>
            <a href="">腾讯公司 版权所有</a>
        </p>
    </div>
</template>
<script>
export default {
    name: "Myfooter",
    components: {},
    setup() {
        //这里存放数据
        return {};
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {},
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {},
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
<style lang='less' scoped>
@import url(../assets/css/Clear_style.css);
@import url(../assets/css/footer.css);
</style>