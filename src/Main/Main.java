
package Main;

import javax.swing.JFrame;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar la ventana correctamente
        
        window.setResizable(false);//redimenzionar a la pantalla
        window.setTitle("Pokemon");
        //pepepepepepeppepepepe
        
         GamePanel gamepanle = new GamePanel();
        window.add(gamepanle);// se añade al panel a la ventana
        window.pack();
        window.setLocationRelativeTo(null);//centrar
        window.setVisible(true);
        gamepanle.startGame() ;
        
       
        
        
        
        
    }
    
}
