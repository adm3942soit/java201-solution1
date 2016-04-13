package accenture.trainings.spring.security;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oxana on 08.11.2015.
 */

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = { Application.class})
@WebAppConfiguration
@IntegrationTest
public class AbstractSteps {
    protected ServerResponse serverResponse = null;
    protected RestTemplate restTemplate = null;
    protected String url;// = "http://localhost:8080/";
    protected MultiValueMap<String, String> params = new LinkedMultiValueMap<String,String>();
    @Value("${local.server.port}")
    protected int port;

    protected ServerResponse doHttpMethod(HttpMethod httpMethod, String url) throws IOException {
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }


        final Map<String, String> headers = new HashMap<String, String>();

        final RequestHeaderSettingCallback headerCallback = new RequestHeaderSettingCallback(headers);


        return restTemplate.execute(url, httpMethod, headerCallback,
                new ResponseExtractor<ServerResponse>() {
                    @Override
                    public ServerResponse extractData(ClientHttpResponse response) throws IOException {
                        return new ServerResponse(response);
                    }
                });

    }

    public String getFinalUrl() {
      UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).queryParams(params).build();
    return uriComponents.toString();
    }
    static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    static String urlEncodeUTF8(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }
    @Test
    public void testDummy() {}
}
