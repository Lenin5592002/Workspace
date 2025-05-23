package Main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar la ventana correctamente
        window.setResizable(false); // no redimensionar la pantalla
        window.setTitle("Pokemon");

        GamePanel gamePanel = new GamePanel(); // corregido el nombre de la variable
        window.add(gamePanel); // se añade el panel a la ventana
        window.pack();
        window.setLocationRelativeTo(null); // centrar
        window.setVisible(true);
        gamePanel.startGame();
    }

}
