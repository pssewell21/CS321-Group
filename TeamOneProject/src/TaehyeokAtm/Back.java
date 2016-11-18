/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaehyeokAtm;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;

       
    public class Back extends JFrame {
         Image img = null;
 
        Back(){
            
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
