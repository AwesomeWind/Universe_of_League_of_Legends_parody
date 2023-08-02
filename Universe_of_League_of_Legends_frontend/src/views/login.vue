<template>
    <div class="container">
        <div
            :style="{ transform: transformStyle }"
            class="form-box"
        >
            <div
                class="enroll-box"
                v-show="show === 'signup'"
            >
                <img
                    src="../assets/img/League_of_Legends.png"
                    alt=""
                >
                <input
                    type="text"
                    placeholder="Nema"
                >
                <input
                    type="text"
                    placeholder="Emil"
                >
                <input
                    type="password"
                    placeholder="Password"
                >
                <input
                    type="password"
                    placeholder="Confirm Password"
                >
                <input
                    type="button"
                    value="signup"
                    @click="handleRegister()"
                >
            </div>
            <div
                class="login-box "
                v-show="show === 'signing'"
            >
                <img
                    src="../assets/img/League_of_Legends.png"
                    alt=""
                >
                <input
                    type="text"
                    placeholder="Nema"
                >
                <input
                    type="password"
                    placeholder="Password"
                >
                <input
                    type="button"
                    value="signing"
                    @click="handleLogin()"
                >
            </div>
        </div>
        <div class="con-box l">
            <h2>Welcome to the <span>League of Legends universe</span></h2>
            <p>Already have an account?</p>
            <button
                id="login"
                @click="toSigning()"
            >Go to Login</button>
        </div>
        <div class="con-box r">
            <h2>Welcome to the <span>League of Legends universe</span></h2>
            <p>Don't have an account?</p>
            <button
                id="enroll"
                @click="toSignup()"
            >Go to Register</button>
        </div>
    </div>
</template>
<script>
import { reactive, toRefs } from "vue";
export default {
    name: "login",
    components: {},
    setup() {
        const data = reactive({
            transformStyle: "translateX(0)",
            show: "signing",
        });
        return {
            ...toRefs(data),
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        toSigning() {
            this.show = "signing";
            this.transformStyle = "translateX(0)";
        },
        toSignup() {
            this.show = "signup";
            this.transformStyle = "translateX(330px)";
        },
        handleLogin() {
            this.$router.push('/HeroShowCase')
            // 发送登录请求
            // this.$axios
            //     .post("/user/login", this.loginForm)
            //     .then((response) => {
            //         // 登录成功，进行跳转到首页
            //         if (response.status === 200 && response.data === 1) {
            //             this.$router.push("/home");
            //         } else {
            //             // 登录失败，显示错误提示信息
            //             this.errorMsg = "用户名或密码错误！";
            //         }
            //     })
            //     .catch((error) => {
            //         // 发送请求失败，显示错误提示信息
            //         this.errorMsg = "登录请求发送失败！";
            //     });
        },
        handleRegister() {
            // 发送注册请求
            this.$axios
                .post("/user/register", this.registerForm)
                .then((response) => {
                    if (response.status === 200) {
                        if (response.data === 1) {
                            // 注册成功，进行跳转到首页
                            this.$router.push("/home");
                        } else {
                            // 注册失败，显示错误提示信息
                            this.errorMsg = "该用户名已被注册！";
                        }
                    }
                })
                .catch((error) => {
                    // 发送请求失败，显示错误提示信息
                    this.errorMsg = "注册请求发送失败！";
                });
        },
    },
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
@import url(../assets/css/login.css);
</style>