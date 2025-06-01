package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Npc extends Entity {
    public Npc(GamePanel gp) {
        super(gp); // se llama al constructor de la clase padre Entity
        solidArea = new Rectangle(10, 10, 30, 26);// x brazos, y cabeza
        direction = "down";
        speed = 2;
        getImage(); // se le asignan las imagenes
    }

    public void getImage() {

        up1 = setup("/imagenesNPC/Rarriba2");
        up2 = setup("/imagenesNPC/Rarriba3");
        down1 = setup("/imagenesNPC/Rabajo");
        down2 = setup("/imagenesNPC/Rabajo2");
        right1 = setup("/imagenesNPC/Rderecha2");
        right2 = setup("/imagenesNPC/Rderecha3");
        left1 = setup("/imagenesNPC/Rizquierda2");
        left2 = setup("/imagenesNPC/Rizquierda3");
    }

    public void setAction() {
        ActionLockCounter++;
        if (ActionLockCounter == 120) { // cada 120 frames cambia de direccion
            Random random = new Random();
            int i = random.nextInt(100) + 1; // genera un numero aleatorio entre 0 y 3
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            ActionLockCounter = 0; // reinicia el contador
        }
    }
}
