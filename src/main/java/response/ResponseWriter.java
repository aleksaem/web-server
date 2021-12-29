package response;

import exceptions.Exceptions;

import java.io.BufferedWriter;
import java.io.IOException;

import static exceptions.Exceptions.*;

public class ResponseWriter {
    private static BufferedWriter writer;

    public ResponseWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public static void writeSuccessResponse(String content, BufferedWriter writer) throws IOException {
        writer.write("HTTP/1.1 200 OK");
        writer.newLine();
        writer.newLine();
        writer.write(content);
        writer.flush();
    }

    public static void writeError(Exceptions exception) throws IOException {
        switch (exception){
            case BAD_REQUEST -> writer.write("HTTP/1.1" + BAD_REQUEST.getCode() + BAD_REQUEST.getStatus());
            case NOT_FOUND -> writer.write("HTTP/1.1" + NOT_FOUND.getCode() + NOT_FOUND.getStatus());
            case METHOD_NOT_ALLOWED -> writer.write("HTTP/1.1" + METHOD_NOT_ALLOWED.getCode() + METHOD_NOT_ALLOWED.getStatus());
            case INTERNAL_SERVER_ERROR -> writer.write("HTTP/1.1" + INTERNAL_SERVER_ERROR.getCode() + INTERNAL_SERVER_ERROR.getStatus());
        }
    }
}
