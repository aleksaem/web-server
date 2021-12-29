import server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.setPort(3000);
        server.setWebAppPath("src/main/resources/");
        server.start();
    }
}
