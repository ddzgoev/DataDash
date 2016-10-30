import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
    	port(50001);
    	staticFiles.location("/public");
        get("/hello", (req, res) -> "Hello World");
    }
}