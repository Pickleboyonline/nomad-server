/**
 * Created by pickl on 3/16/2017.
 */
import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
