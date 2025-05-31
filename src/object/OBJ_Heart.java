
package object;

import Main.GamePanel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject {
    
    
    public OBJ_Heart() {

        name = "Heart";
        try{
            
            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/corafull.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/coramid.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/corano.png"));
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
        
        
    }
    
    
}
