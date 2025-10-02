package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class key extends SuperObject{
    public key(){
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/main/res/objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
