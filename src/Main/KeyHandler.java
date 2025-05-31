package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp ;
    public boolean upPresses, downPresses, leftPresses, rightPresses;
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

    if (code == KeyEvent.VK_P) {
        if (gp.gameSate == gp.playState) {
            gp.gameSate = gp.playPause;
        } else if (gp.gameSate == gp.playPause) {
            gp.gameSate = gp.playState;
        }
    }

    // Solo detectar movimiento si el juego está activo
    if (gp.gameSate == gp.playState) {
        switch (code) {
            case KeyEvent.VK_W -> upPresses = true;
            case KeyEvent.VK_S -> downPresses = true;
            case KeyEvent.VK_A -> leftPresses = true;
            case KeyEvent.VK_D -> rightPresses = true;
        }
    }
}

@Override
public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

    switch (code) {
        case KeyEvent.VK_W -> upPresses = false;
        case KeyEvent.VK_S -> downPresses = false;
        case KeyEvent.VK_A -> leftPresses = false;
        case KeyEvent.VK_D -> rightPresses = false;
    }
}

}
