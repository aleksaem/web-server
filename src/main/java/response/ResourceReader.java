package response;

import java.io.*;

public class ResourceReader {

    private final String webAppPath;

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String read(String uri) throws IOException{
        File file = new File(webAppPath, uri);
        byte[] content = new byte[(int) file.length()];
        String readContent = "";

        try(InputStream inputStream = new FileInputStream(file)){
            inputStream.read(content);
            readContent = new String(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return readContent;
    }
}
