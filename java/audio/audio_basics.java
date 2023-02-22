import javax.sound.sampled.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class audio_basics
{
    public static void main (String [] args) throws UnsupportedAudioFileException, IOException,LineUnavailableException
    {
        Scanner scanner = new Scanner(System.in);

        File file = new File("BabyElephantWalk60.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
        clip.stop();
        clip.setMicrosecondPosition(111);

        clip.close();

        int choice = scanner.nextInt();
    }
}