/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Themes;

import java.awt.Color;

/**
 *
 * @author Patrick Sewell
 */
public interface ITheme {

    /**
     *
     * @return
     */
    public abstract Color getBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getListBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getComboBoxBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getButtonBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getTextFieldBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getCheckBoxBackgroundColor();

    /**
     *
     * @return
     */
    public abstract Color getTextColor();

    /**
     *
     * @return
     */
    public abstract Color getDisabledTextColor();
}
