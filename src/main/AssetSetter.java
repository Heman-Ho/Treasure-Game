package main;

import object.boat;
import object.boots;
import object.chest;
import object.door;
import object.key;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){
        gp.obj[0] = new key();
        gp.obj[0].worldX = 32 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        gp.obj[1] = new key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        
        gp.obj[2] = new key();
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new door();
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 12 * gp.tileSize;

        gp.obj[4] = new door();
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        
        gp.obj[5] = new door();
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 23 * gp.tileSize;

        gp.obj[6] = new chest();
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 8 * gp.tileSize;

        gp.obj[7] = new boots();
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 43 * gp.tileSize;

        gp.obj[8] = new boat();
        gp.obj[8].worldX = 10*gp.tileSize;
        gp.obj[8].worldY = 14*gp.tileSize;


    }

}
