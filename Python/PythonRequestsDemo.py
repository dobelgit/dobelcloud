#! -*- encoding:utf-8 -*-

import requests

#目标网址
targetUrl = "https://www.taobao.com/help/getip.php"

#http代理接入服务器地址端口
proxyHost = "http-proxy-sg1.dobel.cn"
proxyPort = "9180"

#账号密码
proxyUser = "user"
proxyPass = "passwd"

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
