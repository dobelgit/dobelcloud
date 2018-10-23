import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;



public class JsoupDemo {
    // 目标页面
    final static String targetUrl = "https://www.taobao.com/help/getip.php";
    // 代理服务器
    final static String ProxyHost = "http-proxy-sg1.dobel.cn";
    final static Integer ProxyPort = 9180;
    // 代理账号密码
    final static String ProxyUser = "user";
    final static String ProxyPass = "passwd";


    private static void getUrl(String url) {
        Authenticator.setDefault(new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ProxyUser, ProxyPass.toCharArray());
            }
        });

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ProxyHost, ProxyPort));

        try {
            Document doc = Jsoup.connect(url).timeout(4000).proxy(proxy).get();

            if (doc != null) {
                System.out.println(doc.body().html());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] args) throws Exception {

        getUrl(targetUrl);
    }
}
