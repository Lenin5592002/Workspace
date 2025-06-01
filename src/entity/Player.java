package entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.reflect.Array.get;
import static java.nio.file.Paths.get;
import javax.imageio.ImageIO;
import static javax.swing.UIManager.get;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX; // coordenadas de la pantalla a mostrar
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp); // se llama al constructor de la clase padre Entity
        this.keyH = keyH; // se le pasa el keyhandler

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2); // pantalla y posicion del personaje en medio
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2); // pantalla y posicion del personaje en medio

        setDefaultValues(); // se le asignan los valores por defecto
        getPlayerImage(); // se le asignan las imagenes
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23; // posicion inicial del jugador
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

        // ESTADO DE VIDA JUGADOR 2 VIDAS EQUIVALEN A UN CORAZON
        maxLife = 6;
        life = maxLife;

    }

    public void uptade() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed)
                direction = "up";
            else if (keyH.downPressed)
                direction = "down";
            else if (keyH.leftPressed)
                direction = "left";
            else if (keyH.rightPressed)
                direction = "right";

            // Colisión
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

        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }

        // Imprime la posición del jugador en consola (columna y fila)
        int col = worldX / gp.tileSize;
        int row = worldY / gp.tileSize;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (!(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
            // Si no hay teclas presionadas, muestra la imagen 1 de la última dirección
            switch (direction) {
                case "up":
                    image = up1;
                    break;
                case "down":
                    image = down1;
                    break;
                case "left":
                    image = left1;
                    break;
                case "right":
                    image = right1;
                    break;
            }
        } else {
            // Si se está moviendo, alterna entre los sprites para animar
            switch (direction) {
                case "up":
                    image = (spriteNum == 1) ? up1 : up2;
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
        }
        g2.drawImage(image, screenX, screenY, null);
    }

    public void getPlayerImage() {

        up1 = setup("/imagenesPlayer/arriba2");
        up2 = setup("/imagenesPlayer/arriba3");
        down1 = setup("/imagenesPlayer/abajo");
        down2 = setup("/imagenesPlayer/abajo2");
        right1 = setup("/imagenesPlayer/derecha2");
        right2 = setup("/imagenesPlayer/derecha3");
        left1 = setup("/imagenesPlayer/izquierda2");
        left2 = setup("/imagenesPlayer/izquierda3");
        normal = setup("/imagenesPlayer/normal");
    }

}
