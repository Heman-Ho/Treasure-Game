package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;


public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public int hasBoots = 0;
    public int hasBoat = 0;

    public Player(GamePanel gp, main.KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
 
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2  - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 22;
        solidArea.y = 45;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 44;
        solidArea.height = 44;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        worldX = gp.tileSize*23; 
        worldY = gp.tileSize*21;
        speed = 5;
        direction = "front";
    }
    public void getPlayerImage(){

        up1 = setup("player-7");
        up2 = setup("player-8");
        left1 = setup("player-5");
        left2 = setup("player-6");
        right1 = setup("player-3");
        right2 = setup("player-4");
        down1 = setup("player-1");
        down2 = setup("player-2");
        front = setup("player-9");
        boatLeft = setup("boatLeft");
        boatRight = setup("boatRight");
//        boatUpLeft = setup("boatLeft");
//        boatUpRight = setup("boatRight");
//        boatDownLeft = setup("boatLeft");
//        boatDownRight = setup("boatRight");
    }
    public BufferedImage setup(String imageName){

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/main/res/player/"+imageName+".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
    boolean boatL;
    public void update(Entity entity){

        int pX = entity.worldX; 
        int pY = entity.worldY;

        //System.out.println("pY: "+ pY);
        //System.out.println("pX: "+ pX );

        
        if(keyH.upPressed ==true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if((2068 > pX && pX > 1008 && pY > 1391 && pY <= 1450)||(pX >2568 && pX < 3000 && pY > 817 && pY < 872)){
                if(keyH.leftPressed == true){    
                direction = "boatLeft";
                boatL = true;
                }
                else if(keyH.rightPressed == true){
                    direction = "boatRight";
                    boatL = false;
                }else  if(keyH.upPressed == true){
                    if(boatL){
                        direction = "boatUpLeft";
                    }else{
                        direction = "boatUpRight";
                    }
                }else if(keyH.downPressed == true){
                    if(boatL){
                        direction = "boatDownLeft";
                    }else{
                        direction = "boatDownRight";
                    }
                }
            }else{
        
            if(keyH.upPressed == true) {
                direction = "up";
                
            }
            else if(keyH.downPressed == true){
                direction = "down";
                
            }
            else if(keyH.leftPressed == true){
                direction = "left";
              
            }
            else if(keyH.rightPressed == true){
                direction = "right";
          
            }
            }
            collisionOn =false;
            gp.cChecker.checkTile(this, hasBoat, hasBoots);
            
            //Check obj collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);


            if(collisionOn == false){
                if(hasBoots == 1 ){
                    if(keyH.shiftPressed == true){
                        switch(direction){
                        case"up":
                        worldY -= speed*1.5;
                        break;
                        case "down": 
                        worldY += speed*1.5;
                        break;
                        case "left":
                        worldX -= speed*1.5;
                        break;
                        case"right":
                        worldX += speed*1.5;
                        break;
                        case"boatLeft":
                        worldX -= speed*1.5;
                        break;
                        case"boatRight":
                        worldX += speed*1.5;
                        break;
                        case"boatUpRight":
                        worldY -= speed *1.5; 
                        break;
                        case"boatDownRight":
                        worldY += speed *1.5; 
                        break;
                        case"boatUpLeft":
                        worldY -= speed *1.5; 
                        break;
                        case"boatDownLeft":
                        worldY += speed *1.5; 
                        break;
                    }
                }
                    else if(keyH.shiftPressed == false){
                        switch(direction){
                            case"up":
                            worldY -= speed;
                            break;
                            case "down": 
                            worldY += speed;
                            break;
                            case "left":
                            worldX -= speed;
                            break;
                            case"right":
                            worldX += speed;
                            break;
                            case"boatLeft":
                            worldX -= speed;
                            break;
                            case"boatRight":
                            worldX += speed;
                            break;
                            case"boatUpRight":
                            worldY -= speed ; 
                            break;
                            case"boatDownRight":
                            worldY += speed ; 
                            break;
                            case"boatUpLeft":
                            worldY -= speed; 
                            break;
                            case"boatDownLeft":
                            worldY += speed ; 
                            break;
                    }
                    
                    }
                    

                
            }
                if(hasBoots == 0){
                    switch(direction){
                        case"up":
                        worldY -= speed;
                        break;
                        case "down": 
                        worldY += speed;
                        break;
                        case "left":
                        worldX -= speed;
                        break;
                        case"right":
                        worldX += speed;
                        break;
                        case"boatLeft":
                        worldX -= speed;
                        break;
                        case"boatRight":
                        worldX += speed;
                        break;
                        case"boatUpRight":
                        worldY -= speed; 
                        break;
                        case"boatDownRight":
                        worldY += speed ; 
                        break;
                        case"boatUpLeft":
                        worldY -= speed ; 
                        break;
                        case"boatDownLeft":
                        worldY += speed ; 
                        break;
                }
                
                }
            }

            spriteCounter++;
            if(spriteCounter>12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else if(!((2068 > pX && pX > 1008 && pY > 1391 && pY <= 1450)||(pX >2568 && pX < 3000 && pY > 817 && pY < 872))){
            direction ="front";
        }
    }

    public void pickUpObject(int i){
        if(i != 999){
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "key":
                hasKey ++;
                gp.obj[i] = null;
                break;
                case "Door":
                if(hasKey > 0){
                    gp.obj[i] = null;
                    hasKey--;
                    gp.ui.showMessage("You opened the door!");
                }
                else{gp.ui.showMessage("You need a key!");}
                break;
                case "Chest":
                gp.ui.gameFinished = true;
                gp.ui.showMessage("");
                break;
                case "Boots":
                gp.ui.showMessage("You can now hold shift to sprint!");
                gp.obj[i] = null;
                hasBoots++;
                break;
                case "Boat":
                gp.ui.showMessage("You got a boat!");
                gp.obj[i] = null; 
                hasBoat++;
            }
        }

    } 

    public void draw(Graphics2D g2){
        BufferedImage image =null;
        switch(direction) {
        case "up":
            if(spriteNum == 1){
                image = up1; 
            }
            if(spriteNum == 2){
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1){
                image = down1;
            }
            if(spriteNum == 2){
                image = down2;
            }
            break;
        case "left":
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }
            break;
        case "right":
            if(spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }
            break;
        case "front":
            image = front;
            break;
            case "boatLeft":
            image = boatLeft;
            break;
            case "boatRight":
            image = boatRight;
            break;
            case"boatUpRight":
            image = boatRight;
            break;
            case"boatDownRight":
            image = boatRight;
            break;
            case"boatUpLeft":
            image = boatLeft;
            break;
            case"boatDownLeft":
            image = boatLeft;
            break;

        }

        g2.drawImage(image, screenX, screenY, null);
    }
}
