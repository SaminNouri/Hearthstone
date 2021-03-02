package resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Data on 4/29/2020.
 */
public class SoundPaths {
    private static final String NamesAndPaths="src/resources/jsonPathFiles/soundPaths.json";

    public static String getPathByName(String name){
        try{

            FileReader fileReader=new FileReader(NamesAndPaths);
            JSONParser parser=new JSONParser();
            JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
            String s=(jsonObject.get(name).getAsString());
            String temp=s;
            return temp;




        }catch(Exception e){}
        return null;

    }

    public static ArrayList<String> getPathListByNameList(ArrayList<String> names){
        ArrayList<String> paths=new ArrayList<String>();
        try{
            for(String name:names) {
                FileReader fileReader = new FileReader(NamesAndPaths);
                JSONParser parser = new JSONParser();
                JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
                String s = (jsonObject.get(name).getAsString());
                String temp = s;
                paths.add(temp);
            }
            return paths;



        }catch(Exception e){}
        return null;

    }
}
