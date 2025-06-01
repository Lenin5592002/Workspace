
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle; //rectangulo invisible
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.UtilityTool;

public class Entity {

    GamePanel gp; // referencia al GamePanel

    public int worldX, worldY; // jugador
    public int speed;
    public BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, right3, left1, left2, left3, normal;
    public String direction;
    public int spriteCounter = 0; // para controlar cuando cambiar la imagen
    public int spriteNum = 1;
    // colision
    // x brazos
    // y cabeza
    // 32 tamaño del personaje
    public Rectangle solidArea = new Rectangle(8, 5, 30, 26); // rectangulo invisible
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    // ESTADO DE VIDA
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {
        // Este método se puede sobrescribir en las subclases para definir acciones
        // específicas
    }

    public void updateEntity() {
        setAction();
        collisionOn = false; // reiniciar colision
        gp.cChecker.checkTile(this); // verificar colision con el mapa

        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (!collisionOn) {// Si no hay colisión, se mueve el jugador
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
    }

    public BufferedImage setup(String imagePath) {
        UtilityTool UTool = new UtilityTool();
        BufferedImage scaledImage = null;
        try {
            scaledImage = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            scaledImage = UTool.scaleImage(scaledImage, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scaledImage;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        // limitar el movimiento del mapa
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {
                case "up":
                    image = (spriteNum == 1) ? up1 : up2; //
                    break;

                case "down":
                    image = (spriteNum == 1) ? down1 : down2;
                    break;

                case "left":
                    image = (spriteNum == 1) ? left1 : left2;
                    break;

                case "right":
                    image = (spriteNum == 1) ? right1 : right2;
                    break;
            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

}
