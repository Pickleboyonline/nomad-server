/**
 * Created by pickl on 3/17/2017.
 */
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import java.util.Arrays;
import org.bson.Document;
import org.bson.types.ObjectId;


public class Database {
    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase database = mongoClient.getDatabase("nomad");
    private MongoCollection<Document> collection = database.getCollection("apps");
    private String metadata = "";
    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };

    public Database() {

    }
    public void setMetadata(String str) {
        metadata = str;
    }

    public String getMetadata(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        Block<Document> saveData = new Block<Document>() {
            @Override
            public void apply(final Document document){
                setMetadata(document.toJson());

                System.out.println(document.toJson());
            }
        };
        collection.find(query).forEach(saveData);

        return metadata;
    }

    public static void main(String args[]) throws InterruptedException{


    }



}
