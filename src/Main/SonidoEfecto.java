package Main;

import java.io.File;
import javax.sound.sampled.*;

public class SonidoEfecto {
    public static void reproducirSonido(String rutaArchivo) {
        new Thread(() -> {
            try {
                File archivo = new File(rutaArchivo);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(archivo);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
