package resources;

import cardList.CardList;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import initialCard.card.Card;
import jdk.nashorn.api.scripting.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.print.DocFlavor;
import javax.print.attribute.standard.MediaSize;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Data on 3/12/2020.
 */
public class CardPaths
{
    private static final String allFilesPaths="src/resources/jsonPathFiles/allFiles.json";
    private static final String NamesAndPaths="src/resources/jsonPathFiles/namesAndPaths.json";
    private static final String cardFilesPaths="src/resources/jsonPathFiles/cardFiles.json";
    private static final String heroFilesPaths="src/resources/jsonPathFiles/heroFiles.json";
    private static final String heropowerFilesPaths="src/resources/jsonPathFiles/heropowerFiles.json";
   public static String getPathBySerialNumber(String serialNumber){

       try{
           FileReader fileReader=new FileReader(allFilesPaths);
           JSONParser parser=new JSONParser();
           JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
           String s=(jsonObject.get(serialNumber).getAsString());
           String temp=s;
           return temp;


       }catch(Exception e){}
       return null;

   }
    public static String getPathByName(String name){
        try{
            System.out.println("enters here");
            FileReader fileReader=new FileReader(NamesAndPaths);
            JSONParser parser=new JSONParser();
            JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
            String s=(jsonObject.get(name).getAsString());
            String temp=s;
            return temp;




        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public static ArrayList<String> getPathListByNameList(ArrayList<String> names){
        ArrayList<String> paths=new ArrayList<String>();
        try{

            FileReader fileReader=new FileReader(NamesAndPaths);
            JSONParser parser=new JSONParser();
            JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
            for(String name:names) {
                String s = (jsonObject.get(name).getAsString());
                String temp = s;
                paths.add(temp);
            }
            return paths;




        }catch(Exception e){}
        return null;

    }
    public static void main(String[] args){


    }



}
