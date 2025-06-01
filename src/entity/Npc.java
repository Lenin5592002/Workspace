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
        speed = 1;
        getImage(); // se le asignan las imagenes
        setDialogues(); // se le asignan los dialogos
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

    // L: este metodo se encarga de asignar los dialogos al NPC
    public void setDialogues() {
        dialogues[0] = "Hola, valiente :D";
        dialogues[1] = "Así que has venido a esta \n isla para restaurar su color.";
        dialogues[2] = "Solía ser un lugar calido aqui.";
        dialogues[3] = "¡Encuentra las llaves!";
        dialogues[4] = "¡Buena suerte!";
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

    // L:
    public void speak() {
        super.speak(); // llama al metodo speak de la clase padre Entity
    }
}
