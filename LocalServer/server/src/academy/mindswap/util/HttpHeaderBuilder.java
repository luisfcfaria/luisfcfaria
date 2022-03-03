package academy.mindswap.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpHeaderBuilder {

    public static String notAllowed(){
        return """
                HTTP/1.0 405 Method Not Allowed\r
                Allow: GET\r
                """;
    }


    public static String notFound(String fileName, long length) {
        return "HTTP/1.0 404 Not Found\r\n" +
                contentType(fileName) +
                "Content-Length: " + length + "\r\n\r\n";
    }

    public static String ok(String fileName, long length) {
        return "HTTP/1.0 200 Document Follows\r\n" +
                contentType(fileName) +
                "Content-Length: " + length + "\r\n\r\n";
    }

    public static String contentType(String fileName){
     String contentType = "" ;

        try {
            contentType = Files.probeContentType(Path.of("esr/www" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Content-Type: " + contentType + "; charset=UTF-8\r\n";
    }
}
