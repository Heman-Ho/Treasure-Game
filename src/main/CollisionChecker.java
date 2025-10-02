package main;

import entity.Entity;


public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity, int hasBoat, int hasBoots){
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction){
            case "up":
            if(hasBoots == 1){
                entityTopRow = (int) ((entityTopWorldY - entity.speed*1.5)/gp.tileSize);
            }
            if(hasBoots == 0){
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            }
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(hasBoat == 1){
                    gp.tileM.tile[42].collision = false;
                    gp.tileM.tile[43].collision = false;
                    gp.tileM.tile[44].collision = false;
                }
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true; 
                }
                

                
                break;

            case"down":
            if(hasBoots == 1){
                entityBottomRow = (int) ((entityBottomWorldY + entity.speed*1.5)/gp.tileSize);
            }
            if(hasBoots == 0){
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            }

                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(hasBoat == 1){
                    gp.tileM.tile[42].collision = false;
                    gp.tileM.tile[43].collision = false;
                    gp.tileM.tile[44].collision = false;
                }
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true; 
                }
                break;

            case"left":

            if(hasBoots == 1){
                entityLeftCol = (int) ((entityLeftWorldX - entity.speed*1.5)/gp.tileSize);
            }
            if(hasBoots == 0){
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
            }
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(hasBoat == 1){
                    gp.tileM.tile[42].collision = false;
                    gp.tileM.tile[43].collision = false;
                    gp.tileM.tile[44].collision = false;
                }
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true; 
                }
                break;

            case"right":

            if(hasBoots == 1){
                entityRightCol = (int) ((entityRightWorldX + entity.speed*1.5)/gp.tileSize);
            }
            if(hasBoots == 0){
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
            }

                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(hasBoat == 1){
                    gp.tileM.tile[42].collision = false;
                    gp.tileM.tile[43].collision = false;
                    gp.tileM.tile[44].collision = false;
                }
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true; 
                }
                break;
                case"boatUpRight":
                if(hasBoots == 1){
                    entityTopRow = (int) ((entityTopWorldY - entity.speed*1.5)/gp.tileSize);
                }
                if(hasBoots == 0){
                    entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                }
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    if(hasBoat == 1){
                        gp.tileM.tile[42].collision = false;
                        gp.tileM.tile[43].collision = false;
                        gp.tileM.tile[44].collision = false;
                    }
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        entity.collisionOn = true; 
                    }
                break;
                case"boatUpLeft":
                if(hasBoots == 1){
                    entityTopRow = (int) ((entityTopWorldY - entity.speed*1.5)/gp.tileSize);
                }
                if(hasBoots == 0){
                    entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                }
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                    if(hasBoat == 1){
                        gp.tileM.tile[42].collision = false;
                        gp.tileM.tile[43].collision = false;
                        gp.tileM.tile[44].collision = false;
                    }
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        entity.collisionOn = true; 
                    }
                break;
                case"boatDownRight":
                if(hasBoots == 1){
                    entityBottomRow = (int) ((entityBottomWorldY + entity.speed*1.5)/gp.tileSize);
                }
                if(hasBoots == 0){
                    entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                }
    
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if(hasBoat == 1){
                        gp.tileM.tile[42].collision = false;
                        gp.tileM.tile[43].collision = false;
                        gp.tileM.tile[44].collision = false;
                    }
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        entity.collisionOn = true; 
                    }

                break;
                case"boatDownLeft":
                if(hasBoots == 1){
                    entityBottomRow = (int) ((entityBottomWorldY + entity.speed*1.5)/gp.tileSize);
                }
                if(hasBoots == 0){
                    entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                }
    
                    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                    if(hasBoat == 1){
                        gp.tileM.tile[42].collision = false;
                        gp.tileM.tile[43].collision = false;
                        gp.tileM.tile[44].collision = false;
                    }
                    if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                        entity.collisionOn = true; 
                    }
                break;
        } 



    }
    public int checkObject(Entity entity, boolean player) {
        
        int index = 999;
        
        for(int i = 0; i < gp.obj.length; i++){
            if(gp.obj[i]!= null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                    case "up":
                    entity.solidArea.y -= entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                        if(gp.obj[i].collision == true) {
                            entity.collisionOn = true;

                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                    case "down":
                    entity.solidArea.y += entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                        if(gp.obj[i].collision == true) {
                            entity.collisionOn = true;

                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                    case "left":
                    entity.solidArea.x -= entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                        if(gp.obj[i].collision == true) {
                            entity.collisionOn = true;

                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                    case "right":
                    entity.solidArea.x += entity.speed; 
                    if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                        if(gp.obj[i].collision == true) {
                            entity.collisionOn = true;

                        }
                        if(player == true) {
                            index = i;
                        }
                    }
                    break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;

    }
}
