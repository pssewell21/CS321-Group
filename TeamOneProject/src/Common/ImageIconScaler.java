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
 * Got help from
 * http://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
 *
 * @author Patrick Sewell
 */
public final class ImageIconScaler {

    private ImageIconScaler() {
    }

    /**
     *
     * @param imageIcon
     * @param w
     * @param h
     * @return
     */
    public static ImageIcon getScaledImage(ImageIcon imageIcon, int w, int h) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        return imageIcon;
    }
}
