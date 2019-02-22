
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * A simple example that uses HttpClient to execute an HTTP request
 * over a secure connection tunneled through an authenticating proxy.
 */
public class JavaHttpClientDemo {

    //目标网址 
    final static String targetUrl = "https://www.taobao.com/help/getip.php"; 
    // 代理服务器
    final static String proxyHost = "域名";
    final static Integer proxyPort = "端口";

    // 代理隧道验证信息
    final static String proxyUser = "账号";
    final static String proxyPass = "密码";


    public static void main(String[] args) throws Exception {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
	        AuthScope.ANY,
                new UsernamePasswordCredentials(proxyUser, proxyPass));
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
        try {
            HttpHost proxy = new HttpHost(proxyHost, proxyPort);

            RequestConfig config = RequestConfig.custom()
                .setProxy(proxy)
                .build();
            HttpGet httpget = new HttpGet(targetUrl);
            httpget.setConfig(config);

            System.out.println("Executing request  to " + httpget + " via " + proxy);

            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
