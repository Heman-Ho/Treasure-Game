package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.key;

public class UI {
    GamePanel gp;
    Font arial_60;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_60 = new Font("Arial", Font.PLAIN, 60);
        
        key key= new key();
        keyImage = key.image;
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){ 

        if(gameFinished){

            g2.setFont(arial_60);
            g2.setFont(g2.getFont().deriveFont(80F));
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;  

            text ="You Win!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            gp.gameThread = null;


        }else{
            g2.setFont(arial_60);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.hasKey,148,120);
            if(messageOn){
                g2.setFont(g2.getFont().deriveFont(40F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
                messageCounter++;
    
                if(messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
