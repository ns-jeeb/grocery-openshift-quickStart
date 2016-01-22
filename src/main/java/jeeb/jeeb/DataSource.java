package jeeb.jeeb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import jeeb.utilities.ParsingJsons;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jeeb.utilities.UtiliKey.*;

/**
 * Created by Jeeb on 10/27/2015.
 */
public class DataSource {

    public DataSource (){
    }

    public MongoCollection<Document> connectingMongo1 (String uriString, boolean isLocal, boolean createTabl) {
        MongoClientURI mUri = new MongoClientURI (uriString);
        MongoDatabase dbs;
        MongoCollection<Document> collection = null;
        MongoClient mongoClient = new MongoClient (mUri);
        if (isLocal){
            dbs = mongoClient.getDatabase (KEY_LOCAL_DB_NAME);
            collection = dbs.getCollection (KEY__LOCAL_COLLECTION_NAME);
        }else {
            if (createTabl){
                dbs = mongoClient.getDatabase (KEY_DB_NAME);
                collection = dbs.getCollection ("tempTable");
            }else {

                dbs = mongoClient.getDatabase (KEY_DB_NAME);
                collection = dbs.getCollection (KEY_COLLECTION_NAME);
        }
            }

        if (collection != null){
            return collection;
        }
        return null;
    }


    public String creatingTempTable(List<String> listData){
        //This method is only calls if application is connected to server
        MongoCollection <Document> docColl = connectingMongo1 (ParsingJsons.getParsingJsons ()
                .createClienURIMongoLab ("@ds045882", "45882/" + KEY_DB_NAME),false, true);
//        docColl.insertOne (new Document ("Meats",new Document ()
//                .append ("Beef", Arrays.asList ("Rib", "Chuck", "Brisket", "Plate", "Flank", "Short Loin", "Sirloin", "Tenderloin", "Top Sirloin", "Bottom Sirloin", "Ground"))
//                .append ("Lamb", Arrays.asList ("Head", "Sirloin(sytle B only", "Leg(Style A)", "Leg(B)", "Loin", "Flank", "Breast", "Rock", "Shoulder", "Nick", "Foreshonk", "Hindshank", "Feet(trotters)"))
//                .append ("Goat", Arrays.asList ("Silver Side", "Rump", "LegLeg cuts)", "Knuckle", "Rump Top Side", "Short Loin", "Loin", "Cap off", "Rack Frenched", "Rack", "Square Cut Shoulder", "Nick"))
//                .append ("Chicken", Arrays.asList ("Leg","Breast","whole Chicken"))));
        MongoNamespace namespace = docColl.getNamespace ();
        String collectionName = namespace.getCollectionName ();
        boolean isExist = collectionName.contains ("tempTable");

        List<String>beefs = null;
        List<String>lambs = new ArrayList<String> ();
        List<String>goats = new ArrayList<String> ();
        List<String>chickens = new ArrayList<String> ();
        List<String>porks = new ArrayList<String> ();
        List<String>veges = new ArrayList<String> ();
        List<String>fruits = new ArrayList<String> ();
        String key_beefs = "Beef";
        String key_lambs = "Lamb";
        String key_goats = "Goat";
        String key_chickens = "Chicken";
        String key_porks = "Pork";
        String key_vege = "Vegetable";
        String key_fruit = "Fruit";
        String key_parts = "Parts";

        String json = "";

        if (listData != null){
            beefs = new ArrayList<String> ();
            for (int i =0; i<listData.size ();i++){

                if (listData.get (i).contains (String.valueOf ("beef"))){
                    beefs.add (listData.get (i));

                }else if (listData.get (i).contains (String.valueOf ("lamb"))){
                    lambs.add (listData.get (i));
                }else if (listData.get (i).contains (String.valueOf ("goat"))){
                    goats.add (listData.get (i));
                }else if (listData.get (i).contains (String.valueOf ("pork"))){
                    porks.add (listData.get (i));
                }else if (listData.get (i).contains  (String.valueOf ("chicken"))){
                    chickens.add (listData.get (i));
                }else if (listData.get (i).contains  (String.valueOf ("vegetable"))){
                    veges.add (listData.get (i));
                }else if (listData.get (i).contains  (String.valueOf ("fruit"))){
                    fruits.add (listData.get (i));
                }
            }
        }
        //if collection exist it drops and create new one
        if (isExist){
            docColl.drop ();
            System.out.println ("temp table is dropped");

        }

        if (beefs != null && lambs!= null&& chickens!= null&& porks!=null && goats!= null){
            docColl.insertOne (new Document ("Grocery", new Document ()
                    .append (key_beefs, new Document (key_parts, Arrays.asList (beefs.toArray ())))
                    .append (key_lambs, new Document (key_parts, Arrays.asList (lambs.toArray ())))
                    .append (key_goats, new Document (key_parts, Arrays.asList (goats.toArray ())))
                    .append (key_porks, new Document (key_parts, Arrays.asList (porks.toArray ())))
                    .append (key_chickens, new Document (key_parts, Arrays.asList (chickens.toArray ())))
                    .append (key_vege, new Document (key_parts, Arrays.asList (veges.toArray ())))
                    .append (key_fruit, new Document (key_parts, Arrays.asList (fruits.toArray ())))

            ));
        }else {
            return json = "No Item chose";

        }
        if (docColl.hashCode () >= 1){
            json = "1 table is Created";
        }else {
           json = "0 table created";
        }
       return json;
    }
    public String buildKeyFromList(List<String> list, String key){
        String returnKey = null;
        for (String s: list){
            if (s.equalsIgnoreCase (key)){
                returnKey = s;
                break;
            }
        }
        return returnKey;
    }

    public String viewTempTable(boolean isLocal){

        String json = null;
        MongoCollection<Document> docCollection = null;
        if (isLocal) {

            docCollection = connectingMongo1(ParsingJsons.getParsingJsons ().createClienURILocal (),true, false);
        }else {

            docCollection = connectingMongo1(ParsingJsons.getParsingJsons ().createClienURIMongoLab ("@ds045882", "45882/" + KEY_DB_NAME),false,false);
        }
        try {
            MongoCursor<Document> iterator = docCollection.find ().iterator ();
            if (iterator != null){
                BasicDBList list = new BasicDBList ();
                while (iterator.hasNext ()) {
                    Document doc = iterator.next ();
                    list.add (doc);
                }
                json = JSON.serialize (list);
            }

        } catch (MongoException me) {
            System.out.println ("MongoException: " + me);
        }
        return json;
    }

    public boolean isAuthenticated (String userName, String password){
        boolean tf;
        String userNameInServer ="Najeeb";
        String pass = "gullegull";
        if (userNameInServer.contains (userName) && pass.contains (password)){
            tf = true;
            return tf;
        }else {
            tf = false;
            return tf;
        }
    }

}
