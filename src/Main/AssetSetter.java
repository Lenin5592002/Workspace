package Main;

import entity.Npc;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;

    }

    public void setObject() {

    }

    public void setNPC() {
        gp.npc[0] = new Npc(gp);
        gp.npc[0].worldX = gp.tileSize * 21; // columna 14
        gp.npc[0].worldY = gp.tileSize * 30; // fila 41

    }

}
