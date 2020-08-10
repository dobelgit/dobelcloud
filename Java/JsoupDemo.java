 
import java.io.IOException;
 
import org.jsoup.Jsoup;
 
public class JsoupSetProxyExample {
 
    public static void main(String[] args) {
        
        try{
            
            //http代理服务器地址
            System.setProperty("http.proxyHost", "域名");
            
            //http代理服务器端口
            System.setProperty("http.proxyPort", "端口");
            //代理账号密码
	        System.setProperty("https.proxyUser", "账号");
	        System.setProperty("https.proxyPassword", "密码");

            String strText = 
                    Jsoup
                    //.connect("https://myip.ipip.net")
                    .connect("https://pv.sohu.com/cityjson?ie=utf-8")
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000)
                    .get()
                    .text();
            
            System.out.println(strText);
            
        }catch(IOException ioe){
            System.out.println("Exception: " + ioe);
        }
 
    }
}
