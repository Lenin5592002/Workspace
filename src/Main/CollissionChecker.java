package Main;

import entity.Entity;

public class CollissionChecker {
    GamePanel gp;

    public CollissionChecker(GamePanel gp) {
        this.gp = gp;
    }

    // coliciones con todo.
    public void checkTile(Entity entity) {
        // obtener la posicion de la entidad en el mundo
        int entityLeftWorldX = entity.wordlX + entity.solidArea.x;
        int entityRightWorldX = entity.wordlX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.wordlY + entity.solidArea.y;
        int entityBottomWorldY = entity.wordlY + entity.solidArea.y + entity.solidArea.height;
        // enocntrar nunmeros de la fila y columna
        int entityLeftCol = entityLeftWorldX / gp.titleSize;
        int entityRightCol = entityRightWorldX / gp.titleSize;
        int entityTopRow = entityTopWorldY / gp.titleSize;
        int entityBottomRow = entityBottomWorldY / gp.titleSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];// lado izquierdo
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];// lado derecho
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }

    }

  public int checkObjetc(Entity entity, boolean player) {

    int index = 999;

    for (int i = 0; i < gp.obj.length; i++) {

        if (gp.obj[i] != null) {

            // Obtener la posición del área sólida
            entity.solidArea.x = entity.wordlX + entity.solidArea.x;
            entity.solidArea.y = entity.wordlY + entity.solidArea.y;

            gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
            gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

            switch (entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                       //ESTE IF PARA QUE SI UN NPC TPCA EL OBJETO NO HAGA NADA ES DECIR PASRA QUE SOLO EL JUGADOR PUEDA INTERACTUAR CON EL OBEJTO
                        if(gp.obj[i].collsion ==true){
                           entity.collisionOn = true;
                        }
                        if(player ==true){
                            index = i;
                            
                            
                            
                        }
                    }
                    break;
                case "down":
                    entity.solidArea.y += entity.speed; // <- Corregido: antes también era -=
                    if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collsion ==true){
                           entity.collisionOn = true;
                        }
                        if(player ==true){
                            index = i;
                            
                            
                            
                        }
                    }
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collsion ==true){
                           entity.collisionOn = true;
                        }
                        if(player ==true){
                            index = i;
                            
                            
                            
                        }
                    }
                    break;
                case "right":
                    entity.solidArea.x += entity.speed; // <- Corregido: antes también era -=
                    if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                        if(gp.obj[i].collsion ==true){
                           entity.collisionOn = true;
                        }
                        if(player ==true){
                            index = i;
                            
                            
                            
                        }
                    }
                    break;
            }

            // Restablecer posiciones
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;

            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaulY;
        }
    }

    return index;
}








}
