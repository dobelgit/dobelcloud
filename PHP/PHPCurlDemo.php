<?php

// 要访问的页面
$Url = "https://pv.sohu.com/cityjson?ie=utf-8";

// 设置代理服务器域名和端口，注意，具体的域名要依据据开通账号时分配的而定
$proxyServer = "http://域名:端口";

// 代理账号密码信息
$proxyUser   = "账号";
$proxyPass   = "密码";

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
