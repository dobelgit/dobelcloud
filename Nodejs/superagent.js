// 安装superagent 命令: npm install superagent
// 安装superagent-proxy 命令: npm install superagent-proxy

// 引入superagent
let request = require('superagent')
// 引入superagent-proxy
require('superagent-proxy')(request)

// 目标网站
let targetUrl = '目标网站'

// 代理服务器信息
// 代理账号密码信息 如：account:password
let auth = '账号:密码'
// 设置代理服务器域名和端口 如：example.cn:8888  注意：此处域名不能带协议，具体的域名要依据据开通账号时分配的而定
let proxy_server = '域名:端口'
// 代理验证url 如：http://account:password@example.cn:8888
let proxyUrl = 'http://' + auth + '@' + proxy_server

// 请求目标网站
request.get(targetUrl)
    .proxy(proxyUrl)
    .then(res => {
        console.log(res.text)
    }).catch(err => {
        console.log(err.message)
    })

