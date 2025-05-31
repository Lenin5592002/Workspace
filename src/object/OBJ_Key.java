
package object;

import Main.GamePanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Key extends SuperObject {
        
    public OBJ_Key() {

        name = "Key";
        try{
            
            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/prueba2.png"));
            
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
        
        
    }
    
}
