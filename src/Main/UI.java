package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.SuperObject;


public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40,arial_80B;
    //BufferedImage keyImage;
    BufferedImage heart_full,heart_half,heart_blank;
    public boolean  messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
         
    
   
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40= new Font("Arial",Font.PLAIN,40);
         OBJ_Key key = new OBJ_Key();
        //keyImage = key.image;
        
        
        //CREAR OBJETO HUB CORAZONES
        SuperObject heart =new OBJ_Heart();
        heart_full =heart.image;
        heart_half =heart.image2;
        heart_blank =heart.image3;
        
        
    }
     public void showMessage(String text){
        
        
        message = text;
        messageOn = true;
        
        
        
        
    }
    public void draw(Graphics2D g2 ){
        
        this.g2 = g2 ;
        g2.setFont(arial_40);
        g2.setColor(Color.red);
        
        
        if(gp.gameSate== gp.playState){
            //AQUI HACE QUE SE PAUSE LE JUEGO 
            
            
        }if(gp.gameSate== gp.playPause){
            drawPauseScreen();
            
            
        }
        
            
    }
    
    
  
    
    
    public  void drawPauseScreen(){
        g2.getFont().deriveFont(Font.PLAIN,80F);
        String text = "PAUSADO";
        int x= getXforCenteredText(text) ;
        
        
       
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
        
        
    }
    //MERODO PARA CENTAR VEL TEXTO
    public int getXforCenteredText(String text){
        
       int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2 ;
        
        
        return x;
        
        
    }
    
    
   public void drawPlayerLife(Graphics2D g2) {
    
       
       int x = gp.titleSize/2;
    int y = gp.titleSize/2;
    int i = 0;
     //DIBUJAR EL CRAZON EN BLANCO

    while(i < gp.player.maxLife / 2) {
        g2.drawImage(heart_blank, x, y, null);
        i++;
        x += gp.titleSize;
    }
    
    //RESETEO LA VIDA
    x = gp.titleSize/2;
    y = gp.titleSize/2;
    i = 0;
    
    
    //DIBUJA LA VIDA ACTUAL
    
    while(i< gp.player.maxLife){
        
        
        g2.drawImage(heart_half,x,y,null);
        i++;
        //AQUI OBTIENE LA VIDA ACTUAL PARA QUE SE ACTUALIZE
        if(i< gp.player.life){
            
            g2.drawImage(heart_full, x,y, null);
            
            
        }
        i++;
        x+= gp.titleSize;
    }
    
    
    
    
    
}

    
    
}
