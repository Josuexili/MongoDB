package cat.institut.model;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {

    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        if (database == null) {

            String uri = "mongodb+srv://Josue:Josue_2026@cluster0.eo8z9i9.mongodb.net/?appName=Cluster0";

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(uri))
                    .serverApi(serverApi)
                    .build();

            MongoClient client = MongoClients.create(settings);
            database = client.getDatabase("Tasques");
        }
        return database;
    }
}
