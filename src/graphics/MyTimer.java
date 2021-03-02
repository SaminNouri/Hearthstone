package graphics;

import game.GameMapper;
import javafx.application.Platform;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MyTimer extends Thread {
    private static int counter=0;
    /*  public void run(){
          int counter=0;
          int o=0;
          while(true){
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              counter++;
              if(counter==5)
              {
                  o++;
                  System.out.println("5555555555555555555555");
                  GameMapper.setTimerMessage("message:"+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o+o);
                  try {
                      ScreenController.activate("Battlefield");
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  counter=0;


              }
          }

      }*/

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MyTimer.counter = counter;
    }

    @Override
    public void run() {


        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println("counter:" + counter);

            if (counter >= 40 ) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {


                        System.out.println("1111111111111111111");
                        GameMapper.setTimerMessage("turn is about to end!"+counter+" seconds left");
                        try {
                            GameMapper.getBattlefieldController().update();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        } catch (UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        }


                    }

                });
            }


            if (counter >= 60) {
                counter=0;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {


                        System.out.println("5555555555555555555555");
                        try {
                            GameMapper.getInstance().addRequest(GameMapper.RequestType.EndTurn);
                            GameMapper.setTimerMessage("");
                            ScreenController.activate("Battlefield");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                });
            }
        }


    }
}
