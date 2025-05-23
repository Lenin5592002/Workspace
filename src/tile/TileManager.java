
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
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10]; // puedes agregar mas tiles
        mapTileNum = new int[gp.maxWordlCol][gp.maxWordlRow]; // matriz para el mapa
        getTileImage();
        loadMap("/maps/wordl01.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbol.png"));
            tile[0].colision = true; // colision con el arbol

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flores.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/cesped.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arena.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/agua.png"));
            tile[5].colision = true; // colision con el agua

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaborde.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arenainicio.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/bordecespes.png"));

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
