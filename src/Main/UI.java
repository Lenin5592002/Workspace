package Main;

import java.awt.BasicStroke;
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
    Font arial_40, arial_80B;
    // BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    public String currentDialogue = ""; // L: para el dialogo actual

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_Key key = new OBJ_Key(gp);
        // keyImage = key.image;

        // CREAR OBJETO HUB CORAZONES
        SuperObject heart = new OBJ_Heart();
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.red);

        if (gp.gameState == gp.playState) {
            // AQUI HACE QUE SE PAUSE LE JUEGO

        }
        if (gp.gameState == gp.playPause) {
            drawPauseScreen();
        }
        // L:estado del dialogo
        if (gp.gameState == gp.dialogueState) {
            drawDialogueScreen(); // dibuja la pantalla de dialogo
        }

    }

    public void drawPauseScreen() {
        g2.getFont().deriveFont(Font.PLAIN, 80F);
        String text = "PAUSADO";
        int x = getXforCenteredText(text);

        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);

    }

    // L: dibuja la pantalla de dialogo
    public void drawDialogueScreen() {
        // L: rectangulo (mini ventana de dialogo)
        int x = gp.tileSize * 2;// x de la ventana
        int width = gp.screenWidth - (gp.tileSize * 4);// ancho de la ventana
        int height = gp.tileSize * 4; // alto de la ventana
        int y = (gp.screenHeight - height) / 4;// y de la ventana
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F)); // establece la fuente del dialogo
        x += gp.tileSize; // ajusta la x para que no se superponga con el borde
        y += gp.tileSize; // ajusta la y para que no se superponga con el borde
        for (String lineString : currentDialogue.split("\n")) {
            g2.drawString(lineString, x, y); // dibuja cada linea del dialogo
            y += 45; // espacio entre lineas
        }
    }

    // L: dibuja un rectangulo redondeado para la ventana de dialogo
    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 190);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35); // dibuja un rectangulo redondeado

        c = new Color(255, 255, 255, 200); // color blanco con transparencia
        g2.setStroke(new BasicStroke());// grosor de la linea
        g2.setColor(c);
        g2.drawRoundRect(x + 5, y + 5, width, height, 35, 35); // dibuja el borde del rectangulo redondeado
    }

    // MERODO PARA CENTAR VEL TEXTO
    public int getXforCenteredText(String text) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;

        return x;

    }

    public void drawPlayerLife(Graphics2D g2) {

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        // DIBUJAR EL CRAZON EN BLANCO

        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        // RESETEO LA VIDA
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // DIBUJA LA VIDA ACTUAL

        while (i < gp.player.maxLife) {

            g2.drawImage(heart_half, x, y, null);
            i++;
            // AQUI OBTIENE LA VIDA ACTUAL PARA QUE SE ACTUALIZE
            if (i < gp.player.life) {

                g2.drawImage(heart_full, x, y, null);

            }
            i++;
            x += gp.tileSize;
        }

    }

}
