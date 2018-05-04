注意：

对于某些特殊的https网站，需要安装该网站的根证书，不然会提示“Caused by: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target”

如果遇到这种情况，需要预先安装目标网站的根证书：

用InstallCert.java这个脚本进行安装，编译 javac InstallCert.java  运行 java InstallCert（该类为包含main方法的入口类，直接运行即可）

在出现提示后，输入1后回车完成（如果你要放弃并退出输入q即可）。

执行完毕后，在执行该类的当然目录中找到生成的 jssecacerts 文件，然后拷贝该文件到JDK中，如我的是放到：……\jdk1.8.0_60\jre\lib\security 中。

最后再使用之前的Java代码请求HTTPS接口，就不会出现错误了
