package entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class Npc extends Entity {
    public Npc(GamePanel gp) {
        super(gp); // se llama al constructor de la clase padre Entity
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
}
