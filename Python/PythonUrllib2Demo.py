#!/usr/bin/python
#coding:utf-8


import urllib2


# 要访问的页面
Url = "http://myip.ipip.net"

#切换IP的URL
switchUrl = "http://ip.dobel.cn/switch-ip"

# 接入服务器地址信息
proxyServer = "域名"
proxyPort = "端口"

# 代理账号密码信息
proxyUser = "账号"
proxyPass = "密码"

proxyInfo = "http://%(account)s:%(password)s@%(host)s:%(port)s" % {
	"host" : proxyServer,
        "port" : proxyPort,
        "account" : proxyUser,
        "password" : proxyPass,
}

proxy_handler = urllib2.ProxyHandler({
	"http"  : proxyInfo,
	"https" : proxyInfo,
})

opener = urllib2.build_opener(proxy_handler)

urllib2.install_opener(opener)

#访问目标页面
resp = urllib2.urlopen(Url).read()
print resp   

#切换IP
resp = urllib2.urlopen(switchUrl).read()
print resp   

#再次访问目标页面，验证IP是否切换成功
resp = urllib2.urlopen(Url).read()
print resp   
