package game;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Created by Data on 3/18/2020.
 */
public class LoggerCreator
{
    public static String password;
    public static String username;
    public  static  Logger logger;
    public LoggerCreator(String username,String password){
        this.password=password;
        this.username=username;
        logger = Logger.getLogger(LoggerCreator.class.getName());
        logger.setUseParentHandlers(false);
        try {
            MyFormatter formatter = new MyFormatter();
            //Handler handler = new FileHandler("C:\\Users\\Data\\Desktop\\hearthstone2\\loggerFiles\\"+this.username+this.password+".log",true);
            Handler handler = new FileHandler("loggerFiles/"+this.username+this.password+".log",true);
            handler.setFormatter(formatter);

            logger.addHandler(handler);
            logger.info("---------------------------------------------------------------------------------------------");


        }catch (Exception e){}

    }

  public static String historyToString( String name) throws IOException {
      logger.info("---------------------------------------------------------------------------------------------");
      BufferedReader bufferedReader = new BufferedReader(new FileReader("loggerFiles/"+username+password+".log"));
      //BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Data\\Desktop\\hearthstone2\\loggerFiles\\"+username+password+".log"));
      String ln;
      String str="";
      while((ln = bufferedReader.readLine()) != null) {
          if(ln.contains(name))
          {
              str+=ln;
          }
      }
      return str;
  }
    public static void main(String[] args) throws IOException {
        historyToString("tt");
    }


}
