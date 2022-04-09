package util;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    private String host = "https://xjtu.yuketang.cn/";
    private int agentIndex = 0;

    /**
            *"accept-encoding":"gzip, deflate, br",
            *"accept-language":"zh-CN,zh;q=0.9",
            *"platform-id":"3",
            *"x-csrftoken":"JdaCLYhE5BFkwMgNLCX5rYyamkWETmvS",
            *"xtbz":"cloud",
            *"cookie":"university_id=2628; platform_id=3; login_type=WX; django_language=zh-cn; csrftoken=JdaCLYhE5BFkwMgNLCX5rYyamkWETmvS; sessionid=uqfbn87atqy552ws3o5ufon1zm2k7nms; user_role=3; JG_d651262356d93f6497b466bc1_PV=1647421520952|1647421574452",
            *"referer":"https://xjtu.yuketang.cn/pro/lms/xjtu-82PF3807732790N/11561618/studycontent",
            *"university-id":"2628"
     * @param connection
     */

    private Map<String, String> headers;

    public Request() {
        headers = new HashMap<>();
        headers.put("accept", "application/json, text/plain, */*");
        headers.put("accept-encoding", "gzip, deflate, br");
        headers.put("platform-id", "3");
        headers.put("x-csrftoken", "JdaCLYhE5BFkwMgNLCX5rYyamkWETmvS");
        headers.put("xtbz", "cloud");
        headers.put("cookie", "university_id=2628; platform_id=3; login_type=WX; django_language=zh-cn; csrftoken=JdaCLYhE5BFkwMgNLCX5rYyamkWETmvS; sessionid=uqfbn87atqy552ws3o5ufon1zm2k7nms; user_role=3; JG_d651262356d93f6497b466bc1_PV=1647421520952|1647421574452");
        headers.put("university-id", "2628");
        headers.put("user-agent", agents[0]);
    }

    public <R> R get(String path, Map<String, String> parameters, Class<R> type) {
        HttpURLConnection connection = null;
        R result = null;
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append(host);
            buffer.append(path);
            if (parameters != null) {
                boolean first = true;
                for (String key: parameters.keySet()) {
                    if (!first) {
                        buffer.append("&");
                    }
                    buffer.append(key);
                    buffer.append("=");
                    buffer.append(parameters.get(key));
                    first = false;
                }
            }
            URL url = new URL(buffer.toString());
            connection = (HttpURLConnection) url.openConnection();

            for (String key : headers.keySet()) {
                connection.setRequestProperty(key, headers.get(key));
            }

            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder inputStringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                inputStringBuilder.append(line);
            }
            Gson gson = new Gson();
            result = gson.fromJson(inputStringBuilder.toString(), type);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <K, V> V post(String path, K data, Class<V> type) {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(host + path);

        for (String key : headers.keySet()) {
            httpPost.setHeader(key, headers.get(key));
        }
        httpPost.setHeader("content-type", "application/json");

        Gson gson = new Gson();
        V result = null;

        try {
            if (data != null) {
                httpPost.setEntity(new StringEntity(gson.toJson(data)));
            }
            HttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (response.getStatusLine().getStatusCode() / 100 != 2) {
                return null;
            }
            result = gson.fromJson(EntityUtils.toString(entity), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String[] agents = new String[]{
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0) Gecko/20100101 Firefox/6.0",
            "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; InfoPath.3)"
    };

    public void resetAgent() {
        agentIndex = (agentIndex + 1) % agents.length;
        headers.put("user-agent", agents[agentIndex]);
    }
}
