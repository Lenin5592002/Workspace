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
    public Rectangle solidArea = new Rectangle(10, 5, 30, 26); // rectangulo invisible
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int ActionLockCounter = 0; // contador para bloquear acciones
    String dialogues[] = new String[20]; // array de dialogos
    int dialogueIndex = 0; // indice del dialogo actual

    // ESTADO DE VIDA
    public int maxLife;
    public int life;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {
    }

    public void speak() {
        if (dialogues[dialogueIndex] == null) {
            dialogueIndex = 0; // reinicia el indice del dialogo
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex]; // asigna el dialogo actual
        dialogueIndex++;

        // cambia la direccion del NPC al hablar
        switch (gp.player.direction) {
            case "up":
                direction = "down"; // cambia la direccion del NPC al hablar
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    public void updateEntity() {
        setAction();
        collisionOn = false; // reiniciar colision
        gp.cChecker.checkTile(this); // verificar colision con el mapa
        gp.cChecker.checkPlayer(this); // verificar colision con el jugador
        gp.cChecker.checkObject(this, false); // verificar colision con objetos

        if (!collisionOn) {// Si no hay colisión, se mueve el personaje
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
        // ANIMACIÓN: SIEMPRE QUE INTENTE MOVERSE, CAMBIA EL SPRITE
        spriteCounter++;
        if (spriteCounter > 12) { // Ajusta el número para la velocidad de animación
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
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
}
