package request;

import domain.Request;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {

    private final String webAppPath;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public RequestHandler(String webAppPath, BufferedReader reader, BufferedWriter writer) {
        this.webAppPath = webAppPath;
        this.reader = reader;
        this.writer = writer;
    }

    public void handle(){
        try{
            Request request = RequestParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
