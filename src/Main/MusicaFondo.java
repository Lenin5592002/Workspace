package Main;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicaFondo {
    private Clip clip;

    public void reproducirMusica(String rutaArchivo) {
        try {
            File archivoSonido = new File(rutaArchivo);
            if (archivoSonido.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(archivoSonido);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY); // Repetir música en bucle
            } else {
                System.out.println("Archivo no encontrado: " + rutaArchivo);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void detenerMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        // aaa
    }
}
