module.exports = {
  chainWebpack: config => {
    config.module
      .rule('ico')
      .test(/\.ico$/)
      .use('file-loader')
      .loader('file-loader')
      .end();
  },
  devServer: {
    proxy: {
      // 将前端请求中以 /api 开头的请求代理至后端接口服务器
      // 例如：/api/heroes 将被代理至 http://localhost:8089/api/heroes
      "/api": {
        target: "http://localhost:8089",
        changeOrigin: true,
        pathRewrite: {
          "^/api": "",
        },
      },
    },
  },
};