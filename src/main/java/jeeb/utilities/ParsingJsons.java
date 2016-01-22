package jeeb.utilities;


import jeeb.jeeb.DataSource;
import jeeb.model.Item;
import jeeb.model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jeeb.utilities.UtiliKey.*;

/**
 * Created by Jeeb on 11/10/2015.
 */
public class ParsingJsons {
    public static ParsingJsons sParsingJsons = null;
    public static ParsingJsons getParsingJsons(){
        if (sParsingJsons == null){
            sParsingJsons = new ParsingJsons ();
        }
        return sParsingJsons;
    }
    DataSource mDataSource;
    public ParsingJsons (){
        mDataSource = new DataSource ();
    }

    public List<List<String>> parssingGrocery () throws IOException {
//        String url = createClienURIMongoLab ("@ds045882","45882");
//        String url = "mongodb://najeeb:gullegull@ds045882.mongolab.com:45882/grocery";
        String jsonString = mDataSource.viewTempTable (false);
        List<List<String>> meats = new ArrayList<List<String>> ();
        Item item = new Item ();

        JSONArray jsArray = null;
        try {
            JSONObject jsonObj;
            JSONObject jsonMeat = null;
            JSONObject jsBeef;
            JSONObject jsLamb;
            JSONObject jsGoat;
            JSONObject jsPork;
            JSONObject jsChik;
            JSONObject jsVege;
            JSONObject jsFruit;
            String keyPart = "Parts";
            String keyBf = "Beef";
            String keyPr = "Pork";
            String keyGt = "Goat";
            String keyChk = "Chicken";
            String keyLmb = "Lamb";
            String keyFruit = "Fruit";
            String keyVege = "Vegetable";

            jsArray = new JSONArray (jsonString);
            for (int i=0; i<jsArray.length (); i++) {
               jsonObj = jsArray.getJSONObject (i);
               jsonMeat = jsonObj.getJSONObject ("Grocery");
            }
            if (jsonMeat != null){
                jsBeef = jsonMeat.optJSONObject (keyBf);
                jsLamb = jsonMeat.optJSONObject (keyLmb);
                jsGoat = jsonMeat.optJSONObject (keyGt);
                jsPork = jsonMeat.optJSONObject (keyPr);
                jsChik = jsonMeat.optJSONObject (keyChk);
                jsVege = jsonMeat.optJSONObject (keyVege);
                jsFruit = jsonMeat.optJSONObject (keyFruit);

                JSONArray jsBeefParts = jsBeef.getJSONArray (keyPart);
                JSONArray jsLambParts = jsLamb.getJSONArray (keyPart);
                JSONArray jsGoatParts = jsGoat.getJSONArray (keyPart);
                JSONArray jsPorkParts = jsPork.getJSONArray (keyPart);
                JSONArray jsChikParts = jsChik.getJSONArray (keyPart);
                JSONArray jsVegeParts = jsVege.getJSONArray (keyPart);
                JSONArray jsFruitParts = jsFruit.getJSONArray (keyPart);



                List<String> beefItems = getJsonItem (jsBeefParts);
                beefItems.add (0,keyBf);
                List<String> lambItems = getJsonItem (jsLambParts);
                lambItems.add (0, keyLmb);
                List<String> goatItems = getJsonItem (jsGoatParts);
                goatItems.add (0, keyGt);
                List<String> porkItems = getJsonItem (jsPorkParts);
                porkItems.add (0,keyPr);
                List<String> chicItems = getJsonItem (jsChikParts);
                chicItems.add (0,keyChk);
                List<String> vegeItems = getJsonItem (jsVegeParts);
                vegeItems.add (0,keyVege);
                List<String> fruitItems = getJsonItem (jsFruitParts);
                fruitItems.add (0,keyFruit);

                meats.add (beefItems);
                meats.add (lambItems);
                meats.add (porkItems);
                meats.add (chicItems);
                meats.add (goatItems);
                meats.add (vegeItems);
                meats.add (fruitItems);

            }
        } catch (JSONException e) {
            e.printStackTrace ();
        }

        return meats;
    }

    public List<String> getJsonItem(JSONArray jsonArray){
        List<String> jsonItems = new ArrayList<String> ();
        if (jsonArray != null){
            for (int j = 0; j < jsonArray.length (); j++) {
                String itemArray = jsonArray.getString (j);
                jsonItems.add (itemArray);


            }
            return jsonItems;
        }
        return null;
    }

    public List<User> users(){

//        String string = mDataSource.connectingMongo ("usersData","users",url);
//        mDataSource.creatingTempTable ();
        String json = mDataSource.viewTempTable (true);
        System.out.println (json);
        List<User> users = new ArrayList<User> ();

        JSONArray jsonObject = new JSONArray (json);
        for (int i =0; i<jsonObject.length (); i++){
            JSONObject jb = jsonObject.getJSONObject (i);
            String name =   jb.getString("name");
            String email =  jb.getString ("email");
//            String bPhone = jb.getString ("Business_phone");
//            String bEamil = jb.getString ("Business_email");
//            String bDesc  = jb.getString ("Business_desc");
//            String bImageSget = jb.getString ("Business_image_src");

            User user = new User ();
            user.setName (name);
            user.setEmail (email);
//            user.setPassword (bPhone);
            users.add (user);
        }

        return users;
    }

    public String createClienURIMongoLab (String ds, String portNumber){
        String createdUri = KEY_URI+ KEY_URI_DB_USER_NAME + KEY_URI_DB_PASSWORD + ds + KEY_DB_HOST + portNumber;
        return createdUri;

    }
    public String createClienURILocal (){
        String url = "mongodb://localhost:27017";
        return url;

    }
}




