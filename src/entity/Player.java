
package entity;

import Main.GamePanel;
import Main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.reflect.Array.get;
import static java.nio.file.Paths.get;
import javax.imageio.ImageIO;
import static javax.swing.UIManager.get;

public class Player extends Entity{
    
    
    GamePanel gp ;
    KeyHandler keyH;
   public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 ; // ESTE Y EL DEBAJO LO UCAN EN LA MITAD DEL MAPA
        screenY = gp.screenHeight/2 ;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){

       wordlX = gp.titleSize * 23;
        wordlY= gp.titleSize *21 ;
        speed = 4 ;
        direction = "down" ;

    }
    
    public void uptade(){
        
        
        if(keyH.upPresses == true  || keyH.downPresses == true  || keyH.leftPresses == true  || keyH.rightPresses == true ){
            
             if (keyH.upPresses) {
        direction = "up" ;
        wordlY -= speed;
    }
    if (keyH.downPresses) {
        direction = "down" ;
        wordlY += speed;
    }
    if (keyH.leftPresses) {
        direction = "left" ;
        wordlX -= speed;
    }
    if (keyH.rightPresses) {
        direction = "right" ;
        wordlX += speed;
    }
        spriteCounter++ ;
        
        if(spriteCounter>10){
            if(spriteNum == 1){
                spriteNum = 2 ;
            }else if (spriteNum == 2){
                spriteNum = 1 ;
                
            }
            spriteCounter = 0 ;
        }
        }
        
        
        
        
   
        
        
    }
    
    public void draw(Graphics2D g2){
        //g2.setColor(Color.red);
        //g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        
        BufferedImage image = null;
        
        switch(direction){
            
            case "up":
                
                if(spriteNum == 1){  
                  image = up1;
                }
                if(spriteNum == 2){  
                  image = up2;
                }

                break ;
               
            case "down":
               if(spriteNum == 1){  
                  image = down1;
                }
                if(spriteNum == 2){  
                  image = down2;
                }
                
                break ;
            
            case "left":
                 if(spriteNum == 1){  
                  image = left1;
                }
                if(spriteNum == 2){  
                  image = left2;
                }
                
                break ;
            
            case "right":
                if(spriteNum == 1){  
                  image = right1;
                }
                if(spriteNum == 2){  
                  image = right2;
                } 
                break ;

        }
        g2.drawImage(image,screenX, screenY,gp.titleSize,gp.titleSize,null);
        
    }
    public void getPlayerImage(){
        try{
             up1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/arriba2.png"));
             up2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/arriba3.png"));
             down1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/abajo.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/abajo2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/derecha2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/derecha3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/izquierda2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/izquierda3.png"));
            
            
            
        }catch(IOException e){
            e.printStackTrace();
            
            
        }
        
        
        
    }
    
    
}
