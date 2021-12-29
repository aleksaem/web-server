package request;

import domain.HttpMethod;
import domain.Request;
import response.ResponseWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static exceptions.Exceptions.*;

public class RequestParser {

    public static Request parse(BufferedReader reader) throws IOException {
        Request request = new Request();
        String line = reader.readLine();
        injectUriAndMethod(line, request);
        injectHeaders(reader, request);
        return request;
    }

    private static void injectUriAndMethod(String line, Request request) throws IOException {
        if (Objects.isNull(line)) {
            ResponseWriter.writeError(BAD_REQUEST);
        }
        String uri = line.substring(line.indexOf("/"), line.indexOf(" HTTP"));
        request.setUri(uri);
        String value = line.substring(0, line.indexOf(" "));
        HttpMethod httpMethod = HttpMethod.valueOf(value);

        if (httpMethod == HttpMethod.POST) {
            ResponseWriter.writeError(METHOD_NOT_ALLOWED);
        }
    }

    private static void injectHeaders(BufferedReader reader, Request request) throws IOException {
        Map<String, String> headers = new HashMap<>();

        while (reader.ready()) {
            String line = reader.readLine();
            if (Objects.isNull(line) || line.isBlank()) {
                continue;
            }

            String header = line.substring(0, line.indexOf(":"));
            String headerContent = line.substring(line.indexOf(":") + 1).trim();
            headers.put(header, headerContent);
        }
        request.setHeaders(headers);
    }
}
