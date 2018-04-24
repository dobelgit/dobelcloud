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

public class HttpUrlConnectionDemo {

	public static String requestUrl(String requestUrl,String headerkey,String headerValue)
	{
		InetSocketAddress addr = new InetSocketAddress("http-proxy-sg1.dobel.cn",9180);//代理服务器地址,端口
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
		try {
			URL url = new URL(requestUrl);
			URLConnection conn = url.openConnection(proxy);
			conn.setRequestProperty(headerkey, headerValue);
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
			String headerkey = "Proxy-Authorization";
			final String text = "udgw3:udss3";//账号:密码
			final byte[] textByte = text.getBytes();
			String headerValue = "Basic "+Base64.encodeBase64String(textByte);
			//System.out.println(headerValue);

                        //访问目标url
                        String s = requestUrl("http://www.taobao.com/help/getip.php",headerkey,headerValue);
			System.out.println("目标网站访问成功："+s);
                        //切换IP
                        String ss = requestUrl("http://ip.dobel.cn/switch-ip",headerkey,headerValue);
			System.out.println("IP切换成功："+ss);
                        //再次访问目标网站
                        String sss = requestUrl("http://www.taobao.com/help/getip.php",headerkey,headerValue);
			System.out.println("目标网站再次访问成功： "+sss);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
