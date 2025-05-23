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

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX; // coordenadas de la pantalla a mostrar
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp; // se le pasa el panel de juego
        this.keyH = keyH; // se le pasa el keyhandler
        screenX = gp.screenWidth / 2 - (gp.titleSize / 2); // pantalla y posicion del personaje en medio
        screenY = gp.screenHeight / 2 - (gp.titleSize / 2); // pantalla y posicion del personaje en medio
        setDefaultValues(); // se le asignan los valores por defecto
        getPlayerImage(); // se le asignan las imagenes
    }

    public void setDefaultValues() {

        wordlX = gp.titleSize * 23; // posicion inicial del jugador
        wordlY = gp.titleSize * 21;
        speed = 4;
        direction = "down";

    }

    public void uptade() {

        if (keyH.upPresses == true || keyH.downPresses == true || keyH.leftPresses == true
                || keyH.rightPresses == true) {

            if (keyH.upPresses) {
                direction = "up";
                wordlY -= speed; // personaje se mueve hacia arriba
            }
            if (keyH.downPresses) {
                direction = "down"; // personaje se mueve hacia abajo
                wordlY += speed;
            }
            if (keyH.leftPresses) {
                direction = "left"; // personaje se mueve hacia la izquierda
                wordlX -= speed;
            }
            if (keyH.rightPresses) {
                direction = "right";
                wordlX += speed;// personaje se mueve hacia la derecha
            }
            spriteCounter++;

            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        // Se dibuja la imagen dependiendo de la dirección
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
        // dibujar el personaje siempre en el centro de la pantalla
        g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/arriba2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/arriba3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/abajo.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/abajo2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/derecha2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/derecha3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/izquierda2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/imagenesPlayer/izquierda3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
