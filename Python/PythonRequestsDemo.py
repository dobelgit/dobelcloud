#! -*- encoding:utf-8 -*-

import requests

#目标网址
targetUrl = "http://myip.ipip.net"

#http代理接入服务器地址端口
proxyHost = "域名"
proxyPort = "端口"

#账号密码
proxyUser = "账号"
proxyPass = "密码"

proxyMeta = "http://%(user)s:%(pass)s@%(host)s:%(port)s" % {
        "host" : proxyHost,
        "port" : proxyPort,
        "user" : proxyUser,
        "pass" : proxyPass,
}

proxies = {
        "http"  : proxyMeta,
        "https" : proxyMeta,
}

result = requests.get(targetUrl, proxies=proxies)

print result.status_code
print result.text
