package Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SoundClass {

    public SoundClass() {
        SourceDataLine soundLine = null;
        int BUFFER_SIZE = 64 * 1024;  // 64 KB

        // Set up an audio input stream piped from the sound file.
        try {
            Path path = Paths.get("src\\Sound\\music_dave_miles_get_the_groove.wav");
            String location = String.valueOf(path.toAbsolutePath()); //holds the image path
            File soundFile = new File(location);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat audioFormat = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            soundLine = (SourceDataLine) AudioSystem.getLine(info);
            soundLine.open(audioFormat);
            soundLine.start();
            int nBytesRead = 0;
            byte[] sampledData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
                if (nBytesRead >= 0) {
                    // Writes audio data to the mixer via this source data line.
                    soundLine.write(sampledData, 0, nBytesRead);
                }
            }
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } finally {
            soundLine.drain();
            soundLine.close();

        }
    }

}