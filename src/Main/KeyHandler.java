package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPresses, downPresses, leftPresses, rightPresses;

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método no lo necesitas en este caso
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // obtiene el código de la tecla presionada

        if (code == KeyEvent.VK_W) {
            upPresses = true;
        }
        if (code == KeyEvent.VK_S) {
            downPresses = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPresses = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPresses = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPresses = false;
        }
        if (code == KeyEvent.VK_S) {
            downPresses = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPresses = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPresses = false;
        }
    }
}
