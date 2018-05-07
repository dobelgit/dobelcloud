<?php

// 要访问的页面
$Url = "https://www.taobao.com/help/getip.php";

//切换IP的URL
$switchUrl = "http://ip.dobel.cn/switch-ip";

// 接入服务器
$proxyServer = "http://http-proxy-sg1.dobel.cn:9180";

// 代理账号密码信息
$proxyUser   = "IFLlIUr22";
$proxyPass   = "u2lgKegg";

$ch = curl_init();


// 设置代理服务器
curl_setopt($ch, CURLOPT_PROXYTYPE, CURLPROXY_HTTP);
curl_setopt($ch, CURLOPT_PROXY, $proxyServer);

// 设置隧道验证信息
curl_setopt($ch, CURLOPT_PROXYAUTH, CURLAUTH_BASIC);
curl_setopt($ch, CURLOPT_PROXYUSERPWD, "{$proxyUser}:{$proxyPass}");


curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 3);
curl_setopt($ch, CURLOPT_TIMEOUT, 6);

curl_setopt($ch, CURLOPT_HEADER, true);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

curl_setopt($ch, CURLOPT_URL, $Url);

$result = curl_exec($ch);

curl_close($ch);

var_dump($result); 
?>
