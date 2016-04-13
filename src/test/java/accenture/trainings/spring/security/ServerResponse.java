package accenture.trainings.spring.security;




import org.springframework.http.client.ClientHttpResponse;
import org.apache.commons.io.*;
import java.io.IOException;
import java.io.InputStream;

import java.io.StringWriter;

public class ServerResponse {
    private final ClientHttpResponse clientHttpResponse;
    private final String body;

    public ServerResponse(final ClientHttpResponse response) throws IOException {
        this.clientHttpResponse = response;
        final InputStream bodyInputStream = response.getBody();
        if (null == bodyInputStream)
        {
            this.body = "{}";
        }
        else
        {
            final StringWriter stringWriter = new StringWriter();

            IOUtils.copy(bodyInputStream, stringWriter);
            this.body = stringWriter.toString();
        }
    }

    public ClientHttpResponse getOriginalResponse() {
        return clientHttpResponse;
    }

    protected String getBody() {
        return body;
    }
}
