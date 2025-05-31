
package object;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SuperObject {
    //SIMILAR A LAS OTRAS CLASES EJEMPLO ENTITY
    
    public BufferedImage image,image2,image3;
    public String name ;
    public boolean collsion= false ;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,40,40);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaulY = 0;
    
    
    public void draw(Graphics2D g2,  GamePanel gp){
        
         int screenX = worldX - gp.player.wordlX + gp.player.screenX;
            int screenY = worldY - gp.player.wordlY + gp.player.screenY;
            // limitar el movimiento del mapa
            if (worldX + gp.titleSize > gp.player.wordlX - gp.player.screenX &&
                    worldX - gp.titleSize < gp.player.wordlX + gp.player.screenX &&
                    worldY + gp.titleSize > gp.player.wordlY - gp.player.screenY &&
                    worldY - gp.titleSize < gp.player.wordlY + gp.player.screenY) {
                g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
            }
        
    }
    
    
    
    
}