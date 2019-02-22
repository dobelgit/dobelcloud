import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;  
import java.net.*;
import org.apache.commons.codec.binary.Base64; 
import java.net.PasswordAuthentication;

class ProxyAuthenticator extends Authenticator {
	private String user, password;

	public ProxyAuthenticator(String user, String password) {
		this.user     = user;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password.toCharArray());
	}
}
 

public class HttpUrlConnectionDemo {


	public static String requestUrl(String requestUrl)
	{
		// 代理服务器
		String proxyServer = "域名";
		int proxyPort      = 端口;
		// 代理隧道验证信息
		String proxyUser  = "账号";
		String proxyPass  = "密码";

		Authenticator.setDefault(new ProxyAuthenticator(proxyUser, proxyPass));

		InetSocketAddress addr = new InetSocketAddress(proxyServer,proxyPort);//代理服务器地址,端口
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);


		try {
			URL url = new URL(requestUrl);
			// 设置通过代理访问目标页面
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
			InputStream in = conn.getInputStream();
			String s = IOUtils.toString(in, "utf-8");
			return s;
	       } catch (Exception e) {
		       e.printStackTrace();
                       return null;
	       }
	}

	public static void main(String[] args) {
		try {

                        //访问目标url
                        String s = requestUrl("http://www.taobao.com/help/getip.php");
			System.out.println("目标网站访问成功："+s);
                        //切换IP
                        String ss = requestUrl("http://ip.dobel.cn/switch-ip");
			System.out.println("IP切换成功："+ss);
                        //再次访问目标网站
                        String sss = requestUrl("https://www.baidu.com");
			System.out.println("目标网站再次访问成功： "+sss);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
