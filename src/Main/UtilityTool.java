package Main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UtilityTool {
    // Utilidades para el juego, como redimensionar imagenes, etc.
    public BufferedImage scaleImage(BufferedImage original, int width, int height) { // Redimensiona una imagen a un
                                                                                     // tamaño especificado
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType()); // Crea una nueva imagen con
                                                                                          // el tamaño especificado
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();// Libera los recursos del Graphics2D
        return scaledImage;//
    }

}
