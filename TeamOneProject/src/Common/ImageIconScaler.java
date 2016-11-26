/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Common;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Used to change the size of ImageIcons. Got from
 * http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon and
 * adapted for use in our application.
 *
 * @author Patrick Sewell
 */
public final class ImageIconScaler {

    private ImageIconScaler() {
    }

    /**
     * Used to change the size of an ImageIcon.
     *
     * @param imageIcon The ImageIcon to be scaled
     * @param w The desired image width
     * @param h The desired image height
     * @return The resized ImageIcon
     */
    public static ImageIcon getScaledImage(ImageIcon imageIcon, int w, int h) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        return imageIcon;
    }
}
