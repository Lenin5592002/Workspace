
package object;

import Main.GamePanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

    GamePanel gp;

    public OBJ_Key(GamePanel gp) {

        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/prueba2.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
