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
        tile = new Tile[150]; // puedes agregar mas tiles
        mapTileNum = new int[gp.maxWordlCol][gp.maxWordlRow]; // matriz para el mapa
        getTileImage();
        loadMap("/maps/wordl01.txt");
    }

    public void getTileImage() {
        try {
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

            // fuente
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente01.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente02.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente03.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente04.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente05.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente06.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente07.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente08.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/fuente09.png"));
            tile[9].collision = true;

            // arbol
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolPuntaIzquierda11.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolPuntaDerecha12.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolMedioIzquierda13.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolMedioDerecha14.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolIzquierdaAbajo15.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolDerechaAbajo16.png"));
            tile[16].collision = true;

            // arbol grupo
            tile[21] = new Tile();
            tile[21].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoArribaIzquierda21.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoArribaDerecha22.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoAbajoIzquierda23.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/arbolGrupoAbajoDerecha24.png"));
            tile[24].collision = true;

            // muro
            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muro31.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaIzquierda32.png"));
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaDerecha33.png"));
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaDerechaAbajo34.png"));
            tile[34].collision = true;

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/muro35.png"));
            tile[35].collision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO
                    .read(getClass().getResourceAsStream("/imagenesFondo/muroEsquinaIzquierdaAbajo36.png"));
            tile[36].collision = true;

            // cosoRojo
            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/cosoRojo41.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/cosoRojo42.png"));
            tile[42].collision = true;
            // arbol largo
            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolLargo43.png"));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolLargo44.png"));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbolLargo45.png"));
            tile[45].collision = true;

            // arbusto
            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/arbusto46.png"));
            tile[46].collision = true;

            // estatua
            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua51.png"));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua52.png"));
            tile[52].collision = true;

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua53.png"));
            tile[53].collision = true;

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua54.png"));
            tile[54].collision = true;

            tile[55] = new Tile();
            tile[55].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua55.png"));
            tile[55].collision = true;

            tile[56] = new Tile();
            tile[56].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua56.png"));
            tile[56].collision = true;

            tile[57] = new Tile();
            tile[57].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua57.png"));
            tile[57].collision = true;

            tile[58] = new Tile();
            tile[58].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/estatua58.png"));
            tile[58].collision = true;

            // Piedra agua
            tile[59] = new Tile();
            tile[59].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/pidraAgua59.png"));
            tile[59].collision = true;

            // flores
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flor1.png"));

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flor2.png"));

            tile[71] = new Tile();
            tile[71].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/flor3.png"));

            // silla y tronco
            tile[72] = new Tile();
            tile[72].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaVertical72.png"));
            tile[72].collision = true;

            tile[73] = new Tile();
            tile[73].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaVertical73.png"));
            tile[73].collision = true;

            tile[74] = new Tile();
            tile[74].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/troncoHorizontal74.png"));
            tile[74].collision = true;

            tile[75] = new Tile();
            tile[75].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/troncoHorizontal75.png"));
            tile[75].collision = true;

            // faro y maceta
            tile[76] = new Tile();
            tile[76].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/faro76.png"));
            tile[76].collision = true;

            tile[77] = new Tile();
            tile[77].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/faro77.png"));
            tile[77].collision = true;

            tile[78] = new Tile();
            tile[78].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/faro78.png"));
            tile[78].collision = true;

            tile[79] = new Tile();
            tile[79].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/maceta79.png"));
            tile[79].collision = true;

            // casa

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal61.png"));
            tile[61].collision = true;

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal62.png"));
            tile[62].collision = true;

            tile[63] = new Tile();
            tile[63].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal63.png"));
            tile[63].collision = true;

            tile[64] = new Tile();
            tile[64].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal64.png"));
            tile[64].collision = true;

            tile[65] = new Tile();
            tile[65].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal65.png"));
            tile[65].collision = true;

            tile[66] = new Tile();
            tile[66].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal66.png"));
            tile[66].collision = true;

            tile[67] = new Tile();
            tile[67].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal67.png"));
            tile[67].collision = true;

            tile[68] = new Tile();
            tile[68].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal68.png"));
            tile[68].collision = true;

            tile[69] = new Tile();
            tile[69].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal69.png"));
            tile[69].collision = true;

            tile[93] = new Tile();
            tile[93].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal93.png"));
            tile[93].collision = true;

            tile[94] = new Tile();
            tile[94].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal94.png"));
            tile[94].collision = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal95.png"));
            tile[95].collision = true;

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal96.png"));
            tile[96].collision = true;

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal97.png"));
            tile[97].collision = true;

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal98.png"));
            tile[98].collision = true;

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal99.png"));
            tile[99].collision = true;

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal17.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal18.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal19.png"));
            tile[19].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal25.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal26.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal27.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal28.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal29.png"));
            tile[29].collision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal37.png"));
            tile[37].collision = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal38.png"));
            tile[38].collision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal39.png"));
            tile[39].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal47.png"));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal48.png"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal49.png"));
            tile[49].collision = true;

            tile[100] = new Tile();
            tile[100].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal100.png"));
            tile[100].collision = true;

            tile[101] = new Tile();
            tile[101].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal101.png"));
            tile[101].collision = true;

            tile[102] = new Tile();
            tile[102].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal102.png"));
            tile[102].collision = true;

            tile[103] = new Tile();
            tile[103].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal103.png"));
            tile[103].collision = true;

            tile[104] = new Tile();
            tile[104].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaPrincipal104.png"));
            tile[104].collision = true;

            // agua
            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaEsquinaIzquierda80.png"));
            tile[80].collision = true;

            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaArriba81.png"));
            tile[81].collision = true;

            tile[82] = new Tile();
            tile[82].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaEsquinaDerecha82.png"));
            tile[82].collision = true;

            tile[83] = new Tile();
            tile[83].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaIzquierda83.png"));
            tile[83].collision = true;

            tile[84] = new Tile();
            tile[84] = new Tile();
            tile[84].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaCentral84.png"));

            tile[85] = new Tile();
            tile[85].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaDerecha85.png"));
            tile[85].collision = true;

            tile[86] = new Tile();
            tile[86].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajoIzq86.png"));
            tile[86].collision = true;

            tile[87] = new Tile();
            tile[87].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajo87.png"));
            tile[87].collision = true;

            tile[88] = new Tile();
            tile[88].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaAbajoDer88.png"));
            tile[88].collision = true;

            tile[89] = new Tile();
            tile[89].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo89.png"));
            tile[89].collision = true;

            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo90.png"));
            tile[90].collision = true;

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo91.png"));
            tile[91].collision = true;

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/aguaFilo92.png"));
            tile[92].collision = true;

            // CASA DOS
            tile[105] = new Tile();
            tile[105].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos105.png"));
            tile[105].collision = true;

            tile[106] = new Tile();
            tile[106].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos106.png"));
            tile[106].collision = true;

            tile[107] = new Tile();
            tile[107].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos107.png"));
            tile[107].collision = true;

            tile[108] = new Tile();
            tile[108].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos108.png"));
            tile[108].collision = true;

            tile[109] = new Tile();
            tile[109].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos109.png"));
            tile[109].collision = true;

            tile[110] = new Tile();
            tile[110].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos110.png"));
            tile[110].collision = true;

            tile[111] = new Tile();
            tile[111].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos111.png"));
            tile[111].collision = true;

            tile[112] = new Tile();
            tile[112].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos112.png"));
            tile[112].collision = true;

            tile[113] = new Tile();
            tile[113].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos113.png"));
            tile[113].collision = true;

            tile[114] = new Tile();
            tile[114].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos114.png"));
            tile[114].collision = true;

            tile[115] = new Tile();
            tile[115].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos115.png"));
            tile[115].collision = true;

            tile[116] = new Tile();
            tile[116].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos116.png"));
            tile[116].collision = true;

            tile[117] = new Tile();
            tile[117].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos117.png"));
            tile[117].collision = true;

            tile[118] = new Tile();
            tile[118].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos118.png"));
            tile[118].collision = true;

            tile[119] = new Tile();
            tile[119].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos119.png"));
            tile[119].collision = true;

            tile[120] = new Tile();
            tile[120].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaDos120.png"));
            tile[120].collision = true;

            // sillaH
            tile[121] = new Tile();
            tile[121].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaH121.png"));
            tile[121].collision = true;

            tile[122] = new Tile();
            tile[122].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaH122.png"));
            tile[122].collision = true;

            tile[123] = new Tile();
            tile[123].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaH123.png"));
            tile[123].collision = true;

            tile[124] = new Tile();
            tile[124].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/sillaH124.png"));
            tile[124].collision = true;

            // Casa azul
            tile[125] = new Tile();
            tile[125].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul125.png"));
            tile[125].collision = true;

            tile[126] = new Tile();
            tile[126].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul126.png"));
            tile[126].collision = true;

            tile[127] = new Tile();
            tile[127].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul127.png"));
            tile[127].collision = true;
            tile[128] = new Tile();
            tile[128].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul128.png"));
            tile[128].collision = true;
            tile[129] = new Tile();
            tile[129].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul129.png"));
            tile[129].collision = true;
            tile[130] = new Tile();
            tile[130].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul130.png"));
            tile[130].collision = true;
            tile[131] = new Tile();
            tile[131].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul131.png"));
            tile[131].collision = true;
            tile[132] = new Tile();
            tile[132].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul132.png"));
            tile[132].collision = true;
            tile[133] = new Tile();
            tile[133].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul133.png"));
            tile[133].collision = true;
            tile[134] = new Tile();
            tile[134].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul134.png"));
            tile[134].collision = true;
            tile[135] = new Tile();
            tile[135].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul135.png"));
            tile[135].collision = true;
            tile[136] = new Tile();
            tile[136].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul136.png"));
            tile[136].collision = true;
            tile[137] = new Tile();
            tile[137].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul137.png"));
            tile[137].collision = true;
            tile[138] = new Tile();
            tile[138].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul138.png"));
            tile[138].collision = true;
            tile[139] = new Tile();
            tile[139].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul139.png"));
            tile[139].collision = true;
            tile[140] = new Tile();
            tile[140].image = ImageIO.read(getClass().getResourceAsStream("/imagenesFondo/casaAzul140.png"));
            tile[140].collision = true;

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
                if (tileNum >= tile.length || tileNum < 0) {
                    System.out.println("Tile fuera de rango: " + tileNum);
                } else if (tile[tileNum] == null) {
                    System.out.println(
                            "Tile no inicializado: " + tileNum + " en fila " + worldRow + " columna " + worldCol);
                } else if (tile[tileNum].image == null) {
                    System.out.println("Tile sin imagen: " + tileNum);
                } else {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.titleSize, gp.titleSize, null);
                }
            }
            worldCol++;

            if (worldCol == gp.maxWordlCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

}
