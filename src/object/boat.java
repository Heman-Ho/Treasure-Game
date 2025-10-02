package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class boat extends SuperObject{

    public boat(){
        name = "Boat";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boat.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    
}
} 