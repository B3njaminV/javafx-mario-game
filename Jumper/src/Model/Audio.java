package Model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

    private Clip clip;

    /**
     * Audio permet de lire un fichier wav
     * @param son URL du fichier
     */
    public Audio(String son){

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(son));
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {}
    }

    /**
     * Lancer le son
     */
    public void play(){clip.start();}

    public void stop(){clip.stop();}

    /**
     * Charger un fichier audio
     * @param son URL du fichier
     */
    public static void playSound(String son){
        Audio s = new Audio(son);
        s.play();
    }
}
