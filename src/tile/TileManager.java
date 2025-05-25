
package tile;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
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
        tile = new Tile[100]; // puedes agregar mas tiles
        mapTileNum = new int[gp.maxWordlCol][gp.maxWordlRow]; // matriz para el mapa
        getTileImage();
        loadMap("/maps/wordl01.txt");
    }

    public void getTileImage() {
        try {
            // arbol
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolPuntaIzquierda11.png"));
            tile[11].collision = true; // colision con el arbol

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolPuntaDerecha12.png"));
            tile[12].collision = true; // colision con el arbol

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolMedioIzquierda13.png"));
            tile[13].collision = true; // colision con el arbol

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolMedioDerecha14.png"));
            tile[14].collision = true; // colision con el arbol

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolIzquierdaAbajo15.png"));
            tile[15].collision = true; // colision con el arbol

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolDerechaAbajo16.png"));
            tile[16].collision = true; // colision con el arbol

            // arbol grupo
            tile[21] = new Tile();
            tile[21].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoArribaIzquierda21.png"));
            tile[21].collision = true; // colision con el arbol

            tile[22] = new Tile();
            tile[22].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoArribaDerecha22.png"));
            tile[22].collision = true; // colision con el arbol

            tile[23] = new Tile();
            tile[23].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoAbajoIzquierda23.png"));
            tile[23].collision = true; // colision con el arbol

            tile[24] = new Tile();
            tile[24].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoAbajoDerecha24.png"));
            tile[24].collision = true; // colision con el arbol

            // muro
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muro31.png"));
            tile[31].collision = true; // colision con el muro

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaIzquierda32.png"));
            tile[32].collision = true; // colision con el muro

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaDerecha33.png"));
            tile[33].collision = true; // colision con el muro

            tile[34] = new Tile();
            tile[34].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaDerechaAbajo34.png"));
            tile[34].collision = true; // colision con el muro

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muro35.png"));
            tile[35].collision = true; // colision con el muro

            tile[36] = new Tile();
            tile[36].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaIzquierdaAbajo36.png"));
            tile[36].collision = true; // colision con el muro

            // camino
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/caminoGiroIzquierda41.png"));

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/caminoGiroDerecha42.png"));

            tile[43] = new Tile();
            tile[43].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/caminoGiroIzquierdaAbajo43.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/caminoArriba44.png"));

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/caminoCentral45.png"));

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/caminpAbajo46.png"));

            // flores
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flor1.png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flor2.png"));

            // pasto y hierva
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/pasto1.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/pasto2.png"));

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/pasto3.png"));

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/hierva1.png"));

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/hierva2.png"));

            // agua
            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaEsquinaIzquierda80.png"));
            tile[80].collision = true; // colision con el agua

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaArriba81.png"));
            tile[81].collision = true; // colision con el agua

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaEsquinaDerecha82.png"));
            tile[82].collision = true; // colision con el agua

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaIzquierda83.png"));
            tile[83].collision = true; // colision con el agua

            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaCentral84.png"));

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaDerecha85.png"));
            tile[85].collision = true; // colision con el agua

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajoIzq86.png"));
            tile[86].collision = true; // colision con el agua

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajo87.png"));
            tile[87].collision = true; // colision con el agua

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajoDer88.png"));
            tile[88].collision = true; // colision con el agua

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo89.png"));
            tile[89].collision = true; // colision con el agua

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo90.png"));
            tile[90].collision = true; // colision con el agua

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo91.png"));
            tile[91].collision = true; // colision con el agua

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            // abrir el archivo
            InputStream is = getClass().getResourceAsStream(filePath); // importar
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

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWordlCol && worldRow < gp.maxWordlRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            // coordenadas del tile en el mundo
            int worldX = worldCol * gp.titleSize;
            int worldY = worldRow * gp.titleSize;
            // la resta es la coordenada del personaje en el mundo
            // la suma es la simulacion de mover el mapa
            int screenX = worldX - gp.player.wordlX + gp.player.screenX;
            int screenY = worldY - gp.player.wordlY + gp.player.screenY;
            // limitar el movimiento del mapa
            if (worldX + gp.titleSize > gp.player.wordlX - gp.player.screenX &&
                    worldX - gp.titleSize < gp.player.wordlX + gp.player.screenX &&
                    worldY + gp.titleSize > gp.player.wordlY - gp.player.screenY &&
                    worldY - gp.titleSize < gp.player.wordlY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.titleSize, gp.titleSize, null);
            }
            worldCol++;

            if (worldCol == gp.maxWordlCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
