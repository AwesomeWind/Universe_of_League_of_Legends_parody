<template>
    <div>
        <div
            class="scroll-container"
            ref="scrollContainer"
        >
            <div
                v-for="(item, index) in items"
                :key="index"
                :class="['item', { 'pot': index === currentIndex }]"
            >
                <!-- Your item contents -->
            </div>
        </div>
        <div
            class="progress-bar"
            :style="{ width: progressWidth + '%' }"
        ></div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            items: [], // 页面中具有 "pot" 类属性的元素数组
            currentIndex: 0, // 当前滚轮滚动到的元素索引
            progressWidth: 0, // 进度条的宽度百分比
        };
    },
    mounted() {
        const scrollContainer = this.$refs.scrollContainer;

        const handleScroll = (event) => {
            // 获取具有 "pot" 类属性的元素列表
            const potItems = Array.from(
                scrollContainer.querySelectorAll(".pot")
            );

            // 计算当前滚轮滚动到的元素索引
            const scrollTop = scrollContainer.scrollTop;
            const containerHeight = scrollContainer.clientHeight;
            const itemHeight = scrollContainer.scrollHeight / potItems.length;
            const newIndex = Math.floor(
                (scrollTop + containerHeight / 2) / itemHeight
            );

            // 更新当前元素索引和进度条的宽度百分比
            this.currentIndex = newIndex;
            this.progressWidth = (newIndex / potItems.length) * 100;
        };

        // 监听滚轮事件
        scrollContainer.addEventListener("scroll", handleScroll);

        // 获取页面中具有 "pot" 类属性的元素数组
        this.items = Array.from(document.querySelectorAll(".pot"));
    },
};
</script>

<style scoped>
.scroll-container {
    width: 100%;
    height: 300px;
    overflow-x: scroll;
    scroll-snap-type: x mandatory;
    white-space: nowrap;
}

.item {
    display: inline-block;
    width: 200px;
    height: 100%;
    scroll-snap-align: start;
}

.progress-bar {
    width: 0;
    height: 5px;
    background-color: blue;
}
</style>