
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import Main.GamePanel;

public class OBJ_Chest extends SuperObject {

    GamePanel gp;

    public OBJ_Chest(GamePanel gp) {
        name = "Chest";
        try {

            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/prueba2.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
