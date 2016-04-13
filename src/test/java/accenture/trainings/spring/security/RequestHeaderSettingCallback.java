package accenture.trainings.spring.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;

import java.io.IOException;
import java.util.Map;

public class RequestHeaderSettingCallback implements RequestCallback {

	final Map<String, String> requestHeaders;

	public RequestHeaderSettingCallback(final Map<String, String> headers) {
		this.requestHeaders = headers;
	}

	@Override
	public void doWithRequest(ClientHttpRequest request) throws IOException {
		final HttpHeaders clientHeaders = request.getHeaders();
		for (final Map.Entry<String, String> entry : requestHeaders.entrySet()) {
			clientHeaders.add(entry.getKey(), entry.getValue());
		}
	}

}
