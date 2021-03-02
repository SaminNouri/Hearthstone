package EndProgram;

import com.google.gson.Gson;
import game.LoggerCreator;
import initialCard.enumClasses.General;
import player.playerEnumClasses.GeneralPlayer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

/**
 * Created by Data on 3/15/2020.
 */
public class EndProgram {
    HashMap<GeneralPlayer,Object> map=new HashMap<GeneralPlayer, Object>();
    private LoggerCreator loggerCreator;

    public LoggerCreator getLoggerCreator() {
        return loggerCreator;
    }

    public void setLoggerCreator(LoggerCreator loggerCreator) {
        this.loggerCreator = loggerCreator;
    }

    public EndProgram(HashMap<GeneralPlayer,Object> map)
    {
        this.map=map;

        try{
           // System.out.println(map.get(GeneralPlayer.Password));

        }catch(Exception e){
            System.out.println("error");
        }


    }
    public static  void deleteEnd(HashMap<GeneralPlayer,Object> map) throws Exception{

        File file = new File("usersJsonFiles/"+map.get(GeneralPlayer.UserName)+map.get(GeneralPlayer.Password)+".json");
        //System.out.println("C:\\Users\\Data\\Desktop\\hearthstoneG2\\usersJsonFiles\\"+map.get(GeneralPlayer.UserName)+map.get(GeneralPlayer.Password)+".json");

        if(file.delete())
        {
            System.out.println("account deleted successfully");
        }
        else
        {
            System.out.println("the end!");
        }

        try{
            String filename="loggerFiles/" +map.get(GeneralPlayer.UserName)+map.get(GeneralPlayer.Password) + ".log";
            RandomAccessFile writer = new RandomAccessFile(filename, "rwd");
            writer.seek(0);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String st="deleted at : "+ dtf.format(now)+"\n";
            writer.writeBytes(st);
            writer.close();

        }catch(Exception e){
            LoggerCreator.logger.log(Level.WARNING,e.getMessage());
        }
        Gson gson=new Gson();
        //System.out.println(map);
        FileWriter fileWriter=new FileWriter("usersJsonFiles/deletedAccount"+map.get(GeneralPlayer.UserName)+map.get(GeneralPlayer.Password)+".json");
        gson.toJson(map,fileWriter);
        fileWriter.flush();
        fileWriter.close();





        System.exit(0);
    }
    public  void end() throws Exception{

        try{
            Gson gson=new Gson();
            //System.out.println(map);
            FileWriter fileWriter=new FileWriter("usersJsonFiles/"+map.get(GeneralPlayer.UserName)+map.get(GeneralPlayer.Password)+".json");
            gson.toJson(map,fileWriter);
            fileWriter.flush();
            fileWriter.close();

        }catch (Exception e){

        }

        LoggerCreator.logger.info("theEnd");
        System.exit(0);
    }


}
