package Main;

import entity.Player;
import object.SuperObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // CONFIGURACION DE LA PANTALLA

    final int orginalTileSize = 16; // Es el tamaño por defecto de todos los perosnajes,etc
    final int scale = 3; // reescala los pixels orginales: 16x3 = 48 pixels
    public final int titleSize = orginalTileSize * scale; // rescalar proceso
    public final int maxScreenCol = 16; // tamaño columna
    public final int maxScreenRow = 16; // tamaño fila
    public final int screenWidth = titleSize * maxScreenCol; // ancho final
    public final int screenHeight = titleSize * maxScreenRow; // altura final
    public UI ui = new UI(this); //PANEL DEL JUGADOR
    // DEFINE LOS 60 FPS
    int FPS = 60;

          
  //GAME STATE
    public int gameSate ;
    public final int playState =1 ;
    public final int playPause =2 ;

    // CONFIGUARCIONES DEL MUNDO
    public final int maxWordlCol = 50; // maximo de columnas del mundo
    public final int maxWordlRow = 50; // filas
    public final int worldWidth = titleSize * maxWordlCol;
    public final int worldHeight = titleSize * maxWordlRow;

    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread; // nucleo del juego
    public CollissionChecker cChecker = new CollissionChecker(this);
    public Player player = new Player(this, keyH);
    TileManager tileM = new TileManager(this);
    public SuperObject obj[]= new SuperObject[10]; //ESTO ME DICE QUE SOLO PUEDO TENER HASTA 10 OBJETOS A LA VEZ EN PANTALLA
    public AssetSetter aStter= new AssetSetter(this);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // para que no se vea el parpadeo
        this.addKeyListener(keyH);// para que reconozca las entradas por teclado
        this.setFocusable(true); // para que el panel pueda recibir el foco y escuchar las entradas del teclado
        this.requestFocusInWindow();

    }
      
public void setupGame() {
      aStter.setObject();
      gameSate = playState; 

    }

    public void startGame() {

        gameThread = new Thread(this);// inicia el juego(hilo)
        gameThread.start();
      

    }

    
    @Override
    public void run() {
        // dibuja y actualiza el juego
        // creamos update y paint antes
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                uptade();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void uptade() {
         if(gameSate == playState){
            
            player.uptade();
            
            
            
        }  if(gameSate == playPause){
            
            player.uptade();
            
            
            
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // transforma los gráficos a 2D
        tileM.draw(g2); // dibuja el mapa
        
        for (int i=0; i<obj.length;i++ ){
            
            if(obj[i]!= null){
                obj[i].draw(g2, this);
            }
            
        }
        ui.draw(g2);
        player.draw(g2); // dibuja el jugador
        g2.dispose(); // ahorra memoria
    }
    }

