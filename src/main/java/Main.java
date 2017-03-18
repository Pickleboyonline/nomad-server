/**
 * Created by pickl on 3/16/2017.
 */
import static spark.Spark.*;
public class Main {

    public static void main(String[] args) {
        char mark = '\u0022';
        Database db = new Database();
        staticFiles.externalLocation("C:\\apps");
        get("/data", (request, response) -> {

            return db.getMetadata(request.queryParams("id"));
        });


        System.out.println("C:\\apps");

        get("/link", (request, response) -> {

            return "<a href=" + mark + "nomadapp://open?key=value&id=58cc05675e6d84d8c21f8bb5"+ mark + ">Link</a>";
        });
    }
}
