package programs.problems;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class TrentHTTPConnectionTest {

    static HostnameVerifier allHostsValid;
    static SSLContext sc;

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            allHostsValid = (hostname, session) -> true;

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public static void getWebData(String url) throws Exception {

        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication("yourid",
                        "yourpwd".toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);

        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("your.proxy.com", 8080));
        HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection(proxy);

        conn.setHostnameVerifier(allHostsValid);
        conn.setSSLSocketFactory(sc.getSocketFactory());

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        reader.lines().forEach(System.out::println);
    }

    public static void main(String[] args) {
        String url = "https://www.cs.dartmouth.edu/~cs10/notes21.html";
        try {
            getWebData(url);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

