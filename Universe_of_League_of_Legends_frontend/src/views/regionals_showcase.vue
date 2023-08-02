<template>
    <div id="bk">
        <div class="main">
            <h1>地区</h1>
            <div id="regional_list">
                <router-link
                    v-for="(region,index) in regional.filter(item => item.formerly != 'unaffiliated').sort((a,b) => a.formerly.localeCompare(b.formerly))"
                    :key="index"
                    :to="`/RegionInfo/${region.formerly}`"
                >
                    <div
                        class="regional_card"
                        :style="{'background-image': 'url(' + require(`@/assets/img/regional_posters/${region.posters}`) + ')',
                        'background-position': `${region.x*1.0/region.width*100}% ${region.y*1.0/region.height*100}%`,
                        'background-size': 'cover'}"
                    >
                        <div class="mb"></div>
                        <img
                            :src="require(`@/assets/img/crest_icon/${region.icon}`)"
                            alt=""
                        >
                        <div class="title">
                            <p>{{ region.translation }}</p>
                        </div>
                    </div>
                </router-link>
            </div>
        </div>
    </div>
</template>
<script>
import { mapState } from "vuex";

export default {
    name: "regionals_showcase",
    components: {},
    setup() {
        //这里存放数据
        return {};
    },
    //监听属性 类似于data概念
    computed: {
        ...mapState(["regional"]),
    },
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
<style lang="less" src="../assets/css/regional_showcase.less" scoped></style>