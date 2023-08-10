<template>
    <div class="HI_maind" v-if="update">
        <div
            id="head"
            :style="{
              'background-image': `url(${require(`@/assets/img/hero_posters/${hero.posters}`)})`,
              'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.x*100}%`,
              'background-size':'cover'}"
        >
            <div class="head_bk"></div>
            <div>
                <h1>
                    {{ hero.translation }}
                </h1>
                <img
                    src="@/assets/img/public_img/t1HeaderDivider.png"
                    style="width: 100vw"
                >
                <h2>
                    {{ hero.title }}
                </h2>
            </div>
        </div>
        <div id="mind">
            <div class="left">
                <div
                    v-show="hero.races!='null'"
                    class="left_1"
                >
                    <h2>种族</h2>
                    <span>
                        {{ race.translation }}
                    </span>
                </div>
                <div
                    :style="{'height': race.formerly === 'null' ? '635px' : ''}"
                    class="left_2"
                >
                    <div>
                        <span class="box_title">相关英雄</span>
                    </div>
                    <div class="related_people">
                        <ul ref="sibling">
                            <li
                                v-for="(people,index) in this.hero.relatedPeople"
                                :key="index"
                            >
                                <router-link :to="`/HeroInfo/${people.formerly}`">
                                    <div>
                                        <div :style="{
                          'background-image': `url(${require(`../assets/img/hero_posters/${people.posters}`)})`,
                          'background-position': `${people.x/people.width*100}% ${people.y/people.height*100}%`,
                          'background-size':'250%'}"></div>
                                    </div>
                                    <span>{{ people.translation }}</span>
                                </router-link>
                            </li>
                        </ul>
                        <div class="scroll_bar">
                        </div>
                    </div>
                </div>
            </div>
            <div class="min">
                <div class="min_1">
                    <div class="round_logo">
                        <div class="poster_img">
                            <div :style="{
                          'background-image': `url(${require(`@/assets/img/hero_posters/${hero.posters}`)})`,
                          'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.height*100}%`,
                          'background-size':'350%'}"></div>
                        </div>
                        <img
                            class="poster_border"
                            src="../assets/img/public_img/HeroFrame.jpg"
                        >
                    </div>
                    <h1>{{ hero.quote }}</h1>
                    <h2>~ {{ hero.translation }}</h2>
                </div>
                <div class="min_2">
                    <div class="min_2_text">
                        <p v-html="hero.synopsis">
                        </p>
                        <button @click="toBiograpghy(hero.formerly)">阅读传记<span>⇢</span></button>
                    </div>
                    <div
                        class="min_2_bk"
                        :style="{
                          'background-image': `url(${require(`@/assets/img/hero_posters/${hero.posters}`)})`,
                          'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.height*100}%`,
                          'background-size':'cover'}"
                    >
                    </div>
                </div>
            </div>
            <div class="right">
                <div class="right_1">
                    <div class="right_1_logo">
                        <img
                            class="role_icon"
                            :src="require(`@/assets/img/public_img/${role.icon}`)"
                        >
                    </div>
                    <div class="right_1_role">
                        <p class="title_p">角色定位</p>
                        <span class="tile_span">
                            {{ role.name }}
                        </span>
                    </div>
                </div>
                <div class="right_2">
                    <div class="right_2_bk"></div>
                    <div
                        class="right_2_text"
                        :class="{'view_regions':region.formerly!='unaffiliated'}"
                    >
                        <img
                            class="faction_logo"
                            :src="require(`@/assets/img/emblem/${region.emblem}`)"
                        >
                        <div>
                            <div class="region_title">
                                <p class="title_p">相关地区</p>
                                <span class="tile_span">
                                    {{ region.translation }}
                                </span>
                            </div>
                            <div v-if="region.icon!=''">
                                <img
                                    class="faction_icon"
                                    :src="require(`@/assets/img/crest_icon/${region.icon}`)"
                                >
                            </div>
                        </div>
                        <router-link
                            class="relevant_region"
                            :to="`/RegionInfo/${region.formerly}`"
                        >
                            <div>
                                <p>查看地区<span>⇢</span></p>
                            </div>
                        </router-link>
                    </div>
                </div>
                <div class="right_3">
                    <div
                        class="right_3_bk"
                        :style="{
                          'background-image': `url(${require(`@/assets/img/hero_posters/${hero.posters}`)})`,
                          'background-position': `${hero.x/hero.width*100}% ${hero.y/hero.height*100}%`,
                        }"
                    ></div>
                    <img
                        src="@/assets/img/public_img/LOL.png"
                        alt=""
                    >
                    <ul>
                        <li>
                            <p>游戏信息</p>
                        </li>
                        <li>
                            <a href="https://lol.qq.com/main.shtml">
                                <p>查看游戏信息<span>⇢</span></p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
import { mapState } from "vuex";
import axios from "axios";

export default {
    name: "hero_information",
    components: {},
    setup() {
        //这里存放数据
        const data = reactive({
            hero: {},
            region: {},
            race: {},
            role: {},
            update: false,
            parentHeight: 0,
            siblingHeight: 0,
        });
        return {
            ...toRefs(data),
        };
    },
    //计算属性
    computed: {
        ...mapState(["regional"]),
        ...mapState(["races"]),
        ...mapState(["roles"]),
        //滚动条高度
    },
    //监控data中的数据变化
    watch: {
        $route(to, from) {
            this.findHero(to.params.heroId);
        },
        async hero(n, o) {
            this.update = false;
            document.title = n.translation + " - " + this.$route.meta.title;
            this.region = this.regional.find(
                (item) => item.formerly === this.hero.relevantRegion
            );
            this.race = this.races.find(
                (item) => item.formerly === this.hero.races
            );
            this.role = this.roles.find(
                (item) => item.title === this.hero.role
            );
            if (this.hero.relatedPeople != "") {
                this.hero.relatedPeople = await Promise.all(
                    this.hero.relatedPeople
                        .split(",")
                        .map(async function (formerly) {
                            try {
                                const response = await axios.get(
                                    `http://localhost:8089/api/findHero?formerly=${formerly}`
                                );
                                return response.data;
                            } catch (error) {
                                console.error(error);
                            }
                        })
                );
            }
            this.update = true;
            this.$nextTick(() => {
                this.addmousemove();
                this.getscroolBarHeight();
            });
        },
    },
    //方法集合
    methods: {
        findHero(formerly) {
            axios
                .get(`http://localhost:8089/api/findHero?formerly=${formerly}`)
                .then((response) => {
                    this.hero = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        addmousemove() {
            const draggableElement = document.querySelector(".scroll_bar");
            let startY; // 初始 Y 坐标
            let originalTop; // 元素初始的 top 值
            let parentElement; // 父元素
            // 获取父元素
            parentElement = draggableElement.parentNode.parentNode;
            // 鼠标按下时触发
            draggableElement.addEventListener("mousedown", (event) => {
                // 获取元素和父元素的相关信息
                startY = event.clientY;
                originalTop = draggableElement.offsetTop;
                // 鼠标移动时触发
                document.addEventListener("mousemove", handleMouseMove);
                // 鼠标松开时触发
                document.addEventListener("mouseup", handleMouseUp);
            });
            // 处理鼠标移动事件
            function handleMouseMove(event) {
                event.preventDefault();
                const deltaY = event.clientY - startY;
                let newTop = originalTop + deltaY;
                if (parentElement) {
                    const parentHeight = parentElement.offsetHeight - 80;
                    const draggableHeight = draggableElement.offsetHeight;
                    // 限制元素的 top 值在父元素的高度范围内
                    newTop = Math.max(
                        0,
                        Math.min(newTop, parentHeight - draggableHeight)
                    );
                    // 应用新的 top 值
                    draggableElement.style.top = newTop + "px";
                    // 反向更新ul元素的 top 值
                    const parentTop = -newTop;
                    parentElement.querySelector("ul").style.top =
                        parentTop + "px";
                }
            }
            // 处理鼠标松开事件
            function handleMouseUp() {
                document.removeEventListener("mousemove", handleMouseMove);
                document.removeEventListener("mouseup", handleMouseUp);
            }
        },
        getscroolBarHeight() {
            const parentHeight = document.querySelector(".left_2").offsetHeight;
            const siblingHeight =
                document.querySelector(".related_people>ul").offsetHeight;
            const scroll_bar = document.querySelector(".scroll_bar");
            scroll_bar.style.height =
                (parentHeight - 80) * 2 - siblingHeight + "px";
        },
        toBiograpghy(heroId) {
            this.$router.push(`/HeroBiograpghy/${heroId}`);
        },
    },
    beforeCreate() {}, //生命周期 - 创建之前
    created() {
        this.findHero(this.$route.params.heroId);
    }, //生命周期 - 创建完成（可以访问当前this实例）
    beforeMount() {}, //生命周期 - 挂载之前
    mounted() {}, //生命周期 - 挂载完成（可以访问DOM元素）
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {}, //生命周期 - 更新之后
    beforeDestroy() {}, //生命周期 - 销毁之前
    destroyed() {}, //生命周期 - 销毁完成
    activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
};
</script>
<style lang="css" src="../assets/css/Clear_style.css" scoped></style>
<style lang="css" src="../assets/css/hero_information.css" scoped></style>
<style>
</style>