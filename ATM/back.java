import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

       
    public class back extends JFrame {
         Image img = null;
 
        back(){
            
        try{
        File image = new File("/Users/taehyeoklee/Pictures/coms309.jpg");
       
        //배경 Panel 생성후 컨텐츠페인으로 지정      
         img = ImageIO.read(image);
        }
        catch(IOException e)
        {
        System.out.println("no");
        }


        }
    }


