// 安装执行: npm install axios-https-proxy-fix
// 引入 axios-https-proxy-fix
let axios = require('axios-https-proxy-fix')

let targetUrl = '目标网站'
let proxy = {
    host: '代理服务器域名',
    port: '代理服务器端口',
    auth: {
        username: '代理账号',
        password: '代理密码'
    }
}
axios.get(targetUrl, {proxy: proxy})
    .then((res) => {
        console.log(res.data)
    }).catch((err) => {
        console.log(err.message)
    })
