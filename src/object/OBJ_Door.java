
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{
    
   public OBJ_Door() {
        name = "Door";
        try{
            
            image = ImageIO.read(getClass().getResourceAsStream("/imagenesObjetos/prueba2.png"));
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
        
    
        
    }
   
    
    
}
