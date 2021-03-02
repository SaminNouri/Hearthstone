package graphics;
// Java program to play an Audio
// file using Clip Object
import resources.SoundPaths;
import sun.audio.AudioData;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{


    private  Long currentFrame;
    private static  Clip clip;
    private String status;
    private String name;
    private static int counter=0;
    private AudioData audioData;
    private  ContinuousAudioDataStream continuousAudioDataStream;


    public static Clip getClip() {
        return clip;
    }

    public static void setClip(Clip clip) {
        AudioPlayer.clip = clip;
    }

    private  AudioInputStream audioInputStream;
    private AudioInputStream mAudioInputStream;
    private  static String filePath;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        AudioPlayer.counter = counter;
    }


    public AudioPlayer()

    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playLoop(String name) throws IOException {

       this.name=name;
        String filepath=SoundPaths.getPathByName(name);
        this.filePath=filepath;
        audioData=new AudioStream(new FileInputStream(filepath)).getData();
        continuousAudioDataStream=new ContinuousAudioDataStream(audioData);
        sun.audio.AudioPlayer.player.start(continuousAudioDataStream);




    }

    public void stopLoop(String name) throws IOException {



      sun.audio.AudioPlayer.player.stop(continuousAudioDataStream);



    }

    public AudioPlayer(String name)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        this.name=name;
        String filepath=SoundPaths.getPathByName(name);
        this.filePath=filepath;
        mAudioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(mAudioInputStream);
         clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public  void playSound(String name) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

       filePath= SoundPaths.getPathByName(name);
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);
        try
        {


            this.play();
            Scanner sc = new Scanner(System.in);
            double f=0;
            double s=0;

            while (true)
            {

                 if(clip.getMicrosecondPosition()>100000 || clip.getMicrosecondLength()==clip.getMicrosecondPosition())
                     break;



            }
           // sc.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    public void play() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
      try {




            clip.start();
            status = "play";

        }catch (Exception e){}
    }

    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }


    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
       clip.close();


    }




}
