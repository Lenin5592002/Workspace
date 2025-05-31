
package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Chest extends SuperObject {
    
    
    public OBJ_Chest() {
        name = "Chest";
        try{
            
            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/prueba2.png"));
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
        
        
    }
    
    
}
