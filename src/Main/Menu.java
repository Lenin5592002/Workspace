package Main;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

public class Menu {
    private JFrame frame;
    private MusicaFondo musica;
    private String rutaMusica = "src/Musica/Music.wav";
    private String sonidoHover = "src/Musica/choque.wav";
    private String sonidoClick = "src/Musica/inicio.wav";

    public Menu() {
        // Configuración del tema
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Reproducir música de fondo
        musica = new MusicaFondo();
        musica.reproducirMusica(rutaMusica);

        // Configuración del JFrame
        frame = new JFrame("Menú Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Cargar GIF de fondo
        String rutaGif = "src/Video/Fondo.gif";
        ImageIcon gif = new ImageIcon(rutaGif);

        if (gif.getIconWidth() <= 0 || gif.getIconHeight() <= 0) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el GIF. Verifica la ruta.");
            return;
        }

        JLabel fondo = new JLabel(gif);
        fondo.setLayout(new GridBagLayout());

        // Botones
        JButton botonIniciar = new JButton("Iniciar");
        botonIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SonidoEfecto.reproducirSonido(sonidoHover);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SonidoEfecto.reproducirSonido(sonidoClick);
            }
        });
        JButton botonSalir = new JButton("Salir");
        botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SonidoEfecto.reproducirSonido(sonidoHover);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SonidoEfecto.reproducirSonido(sonidoClick);
            }
        });

        botonSalir.addActionListener(e -> {
            musica.detenerMusica(); // Detener música antes de salir
            System.exit(0);
        });

        // Panel de botones y título
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setOpaque(false);

        // Título
        JLabel titulo = new JLabel("LLAVES DEL DESTINO");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Algerian", Font.BOLD, 32));
        titulo.setForeground(Color.BLACK);//cambia el color si tu fondo lo requiere

        panelBotones.add(Box.createVerticalStrut(40)); // Espacio arriba
        panelBotones.add(titulo);
        panelBotones.add(Box.createVerticalStrut(40)); // Espacio entre título y botón

        botonIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBotones.add(botonIniciar);
        panelBotones.add(Box.createVerticalStrut(20));
        panelBotones.add(botonSalir);

        fondo.add(panelBotones);

        frame.setContentPane(fondo);
        frame.pack(); // Ajustar al tamaño del GIF
        frame.setLocationRelativeTo(null);

        // Puedes agregar aquí el ActionListener para iniciar el juego
        botonIniciar.addActionListener(evt -> {
            musica.detenerMusica();
            frame.setVisible(false);

            // Abre la ventana del juego
            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("Pokemon");
            GamePanel gamepanle = new GamePanel();
            window.add(gamepanle);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
             gamepanle.requestFocusInWindow();
             gamepanle.setupGame();
            gamepanle.startGame();
        });
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}
