package tile;

import Main.GamePanel;
import Main.UtilityTool;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp; //negro
import java.awt.color.ColorSpace;//negro
import java.io.BufferedReader; //negro
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[150]; // puedes agregar mas tiles
        mapTileNum = new int[gp.maxWordlCol][gp.maxWordlRow]; // matriz para el mapa
        getTileImage();
        loadMap("/maps/wordl01.txt");
    }

    public void getTileImage() {
        // Cargar imágenes de los tiles usando setup

        // pasto y hierva
        setup(10, "pasto1", false);
        setup(20, "pasto2", false);
        setup(30, "pasto3", false);
        setup(40, "hierva1", false);
        setup(50, "hierva2", false);

        // fuente
        setup(1, "fuente01", true);
        setup(2, "fuente02", true);
        setup(3, "fuente03", true);
        setup(4, "fuente04", true);
        setup(5, "fuente05", true);
        setup(6, "fuente06", true);
        setup(7, "fuente07", true);
        setup(8, "fuente08", true);
        setup(9, "fuente09", true);

        // arbol
        setup(11, "arbolPuntaIzquierda11", true);
        setup(12, "arbolPuntaDerecha12", true);
        setup(13, "arbolMedioIzquierda13", true);
        setup(14, "arbolMedioDerecha14", true);
        setup(15, "arbolIzquierdaAbajo15", true);
        setup(16, "arbolDerechaAbajo16", true);

        // arbol grupo
        setup(21, "arbolGrupoArribaIzquierda21", true);
        setup(22, "arbolGrupoArribaDerecha22", true);
        setup(23, "arbolGrupoAbajoIzquierda23", true);
        setup(24, "arbolGrupoAbajoDerecha24", true);

        // muro
        setup(31, "muro31", true);
        setup(32, "muroEsquinaIzquierda32", true);
        setup(33, "muroEsquinaDerecha33", true);
        setup(34, "muroEsquinaDerechaAbajo34", true);
        setup(35, "muro35", true);
        setup(36, "muroEsquinaIzquierdaAbajo36", true);

        // cosoRojo
        setup(41, "cosoRojo41", true);
        setup(42, "cosoRojo42", true);

        // arbol largo
        setup(43, "arbolLargo43", true);
        setup(44, "arbolLargo44", true);
        setup(45, "arbolLargo45", true);

        // arbusto
        setup(46, "arbusto46", true);

        // estatua
        setup(51, "estatua51", true);
        setup(52, "estatua52", true);
        setup(53, "estatua53", true);
        setup(54, "estatua54", true);
        setup(55, "estatua55", true);
        setup(56, "estatua56", true);
        setup(57, "estatua57", true);
        setup(58, "estatua58", true);

        // Piedra agua
        setup(59, "pidraAgua59", true);

        // flores
        setup(60, "flor1", false);
        setup(70, "flor2", false);
        setup(71, "flor3", false);

        // silla y tronco
        setup(72, "sillaVertical72", true);
        setup(73, "sillaVertical73", true);
        setup(74, "troncoHorizontal74", true);
        setup(75, "troncoHorizontal75", true);

        // faro y maceta
        setup(76, "faro76", true);
        setup(77, "faro77", true);
        setup(78, "faro78", true);
        setup(79, "maceta79", true);

        // casa principal
        setup(61, "casaPrincipal61", true);
        setup(62, "casaPrincipal62", true);
        setup(63, "casaPrincipal63", true);
        setup(64, "casaPrincipal64", true);
        setup(65, "casaPrincipal65", true);
        setup(66, "casaPrincipal66", true);
        setup(67, "casaPrincipal67", true);
        setup(68, "casaPrincipal68", true);
        setup(69, "casaPrincipal69", true);
        setup(93, "casaPrincipal93", true);
        setup(94, "casaPrincipal94", true);
        setup(95, "casaPrincipal95", true);
        setup(96, "casaPrincipal96", true);
        setup(97, "casaPrincipal97", true);
        setup(98, "casaPrincipal98", true);
        setup(99, "casaPrincipal99", true);
        setup(17, "casaPrincipal17", true);
        setup(18, "casaPrincipal18", true);
        setup(19, "casaPrincipal19", true);
        setup(25, "casaPrincipal25", true);
        setup(26, "casaPrincipal26", true);
        setup(27, "casaPrincipal27", true);
        setup(28, "casaPrincipal28", true);
        setup(29, "casaPrincipal29", true);
        setup(37, "casaPrincipal37", true);
        setup(38, "casaPrincipal38", true);
        setup(39, "casaPrincipal39", true);
        setup(47, "casaPrincipal47", true);
        setup(48, "casaPrincipal48", true);
        setup(49, "casaPrincipal49", true);
        setup(100, "casaPrincipal100", true);
        setup(101, "casaPrincipal101", true);
        setup(102, "casaPrincipal102", true);
        setup(103, "casaPrincipal103", true);
        setup(104, "casaPrincipal104", true);

        // agua
        setup(80, "aguaEsquinaIzquierda80", true);
        setup(81, "aguaArriba81", true);
        setup(82, "aguaEsquinaDerecha82", true);
        setup(83, "aguaIzquierda83", true);
        setup(84, "aguaCentral84", false);
        setup(85, "aguaDerecha85", true);
        setup(86, "aguaAbajoIzq86", true);
        setup(87, "aguaAbajo87", true);
        setup(88, "aguaAbajoDer88", true);
        setup(89, "aguaFilo89", true);
        setup(90, "aguaFilo90", true);
        setup(91, "aguaFilo91", true);
        setup(92, "aguaFilo92", true);

        // CASA DOS
        setup(105, "casaDos105", true);
        setup(106, "casaDos106", true);
        setup(107, "casaDos107", true);
        setup(108, "casaDos108", true);
        setup(109, "casaDos109", true);
        setup(110, "casaDos110", true);
        setup(111, "casaDos111", true);
        setup(112, "casaDos112", true);
        setup(113, "casaDos113", true);
        setup(114, "casaDos114", true);
        setup(115, "casaDos115", true);
        setup(116, "casaDos116", true);
        setup(117, "casaDos117", true);
        setup(118, "casaDos118", true);
        setup(119, "casaDos119", true);
        setup(120, "casaDos120", true);

        // sillaH
        setup(121, "sillaH121", true);
        setup(122, "sillaH122", true);
        setup(123, "sillaH123", true);
        setup(124, "sillaH124", true);

        // Casa azul
        setup(125, "casaAzul125", true);
        setup(126, "casaAzul126", true);
        setup(127, "casaAzul127", true);
        setup(128, "casaAzul128", true);
        setup(129, "casaAzul129", true);
        setup(130, "casaAzul130", true);
        setup(131, "casaAzul131", true);
        setup(132, "casaAzul132", true);
        setup(133, "casaAzul133", true);
        setup(134, "casaAzul134", true);
        setup(135, "casaAzul135", true);
        setup(136, "casaAzul136", true);
        setup(137, "casaAzul137", true);
        setup(138, "casaAzul138", true);
        setup(139, "casaAzul139", true);
        setup(140, "casaAzul140", true);
    }

    public void loadMap(String imagenName) {
        try {
            // abrir el archivo
            InputStream is = getClass().getResourceAsStream(imagenName); // importar
            BufferedReader br = new BufferedReader(new InputStreamReader(is));// leer
            int row = 0;
            // recorrer el archivo
            while (row < gp.maxWordlRow) {// OJO AQUI
                String line = br.readLine(); // leemos la fila
                String[] numbers = line.trim().split("\\s+");// la fila a numeros, separados por espacios
                // cada numero se convierte a entero y se guarda en el mapa
                for (int col = 0; col < gp.maxWordlCol; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;// siguiente fila
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // para configurar tiles
    public void setup(int index, String imagePath, boolean collision) {
        UtilityTool UTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/" + imagePath + ".png"));
            tile[index].image = UTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: /imagenesFondo/" + imagePath + ".png");
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // 1. Dibuja el mapa normalmente en un BufferedImage temporal
        BufferedImage temp = new BufferedImage(gp.getWidth(), gp.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gTemp = temp.createGraphics();

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWordlCol && worldRow < gp.maxWordlRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                if (tileNum >= tile.length || tileNum < 0) {
                    System.out.println("Tile fuera de rango: " + tileNum);
                } else if (tile[tileNum] == null) {
                    System.out.println(
                            "Tile no inicializado: " + tileNum + " en fila " + worldRow + " columna " + worldCol);
                } else {
                    gTemp.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }
            worldCol++;
            if (worldCol == gp.maxWordlCol) {
                worldCol = 0;
                worldRow++;
            }
        }
        gTemp.dispose();

        // para poner blanco y negro el mapa
        for (int y = 0; y < temp.getHeight(); y++) {
            for (int x = 0; x < temp.getWidth(); x++) {
                int rgb = temp.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                int gray = (r + g + b) / 3;
                int bw = (gray > 128) ? 0xFFFFFF : 0x000000;
                temp.setRGB(x, y, (0xFF << 24) | bw);
            }
        }

        g2.drawImage(temp, 0, 0, null);
    }

}
