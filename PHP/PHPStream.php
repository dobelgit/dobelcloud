<?php




$auth = base64_encode('UFLFIJ1:LFJN09J0YO84J');//LOGIN:PASSWORD 这里是你的账户名及密码    
$aContext = array(    
    'http' => array(    
        'proxy' => 'tcp://http-proxy-sg1.dobel.cn:9180',//这里设置你要使用的代理ip及端口号    
        'request_fulluri' => true,    
        'header' => "Proxy-Authorization: Basic $auth",    
    ),    
);    
$cxContext = stream_context_create($aContext);    
$sFile = file_get_contents('https://www.taobao.com/help/getip.php', False, $cxContext);    

echo "headers:".$auth."\n";

echo $sFile;  





?>
