
package entity;

import java.awt.Rectangle; //rectangulo invisible
import java.awt.image.BufferedImage;

public class Entity {

    public int wordlX, wordlY; // jugador
    public int speed;
    public BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3, normal;
    public String direction;
    public int spriteCounter = 0; // para controlar cuando cambiar la imagen
    public int spriteNum = 1;
    public Rectangle solidArea; // rectangulo invisible
    public boolean collisionOn = false;

}
