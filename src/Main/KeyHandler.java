package Main;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gp) {

        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método no lo necesitas en este caso
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_P) {
                if (gp.gameState == gp.playState) {
                    gp.gameState = gp.playPause;
                } else if (gp.gameState == gp.playPause) {
                    gp.gameState = gp.playState;
                }
            }

            // Solo detectar movimiento si el juego está activo
            if (gp.gameState == gp.playState) {
                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                }
                if (code == KeyEvent.VK_S) {
                    downPressed = true;
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = true;
                }
                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playPause; // Pausa el juego
                }
                if (code == KeyEvent.VK_ENTER) {
                    enterPressed = true; // Para detectar si se presiona Enter
                }
            }
        }

        // L: para pausar el juego
        if (gp.gameState == gp.playPause) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState; // Reanuda el juego
            }
        }
        // L: para el estado de dialogo
        if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState; // Sale del estado de dialogo
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W -> upPressed = false;
            case KeyEvent.VK_S -> downPressed = false;
            case KeyEvent.VK_A -> leftPressed = false;
            case KeyEvent.VK_D -> rightPressed = false;
        }
    }

}
