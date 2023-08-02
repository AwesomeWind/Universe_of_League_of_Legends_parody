<template>
    <div id="nav_xl">
        <div class="nav_xl_top">
            <div class="logo">
                <a href="https://lol.qq.com/">
                    <div><img src="../assets/img/logo.jpg"></div>
                    <div>
                        <p>探索</p>
                        <img src="../assets/img/League_of_Legends.png">
                    </div>
                </a>
            </div>
            <ul class="link">
                <li><img
                        src="../assets//img/universe_logo.png"
                        alt=""
                    ></li>
                <li><router-link to="/">专题<br><small>FEATURED</small></router-link></li>
                <li><router-link to="/HeroShowCase">英雄<br>CHAMPIONS</router-link></li>
                <li><router-link to="/RegionShowCase">地区<br>REGIONS</router-link></li>
                <li><router-link to="/">装备<br>EQUIP</router-link></li>
                <li><router-link to="/">集锦<br>COLLECTIONS</router-link></li>
                <li><router-link to="/">另一个宇宙<br>ALT UNIVERSE</router-link></li>
                <li><a href="https://yz.lol.qq.com/zh_CN/map/index.html">地图<br>MAP</a></li>
            </ul>
            <div class="signin"></div>
        </div>
    </div>
</template>
<script>
export default {
    name: "Myheader",
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
<style lang='css' src="../assets/css/Clear_style.css" scoped></style>
<style lang="css" src="../assets/css/header.css" scoped></style>
