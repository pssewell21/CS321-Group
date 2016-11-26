/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Got help from http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
 * @author Owner
 */
public final class ImageIconScaler {

    private ImageIconScaler() {
    }

    public static ImageIcon getScaledImage(ImageIcon imageIcon, int w, int h) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        
        return imageIcon;
    }
}
