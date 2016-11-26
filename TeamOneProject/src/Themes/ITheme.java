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
 * Contract to define what methods must be defined in a Theme class
 *
 * @author Patrick Sewell
 */
public interface ITheme {

    /**
     * Gets the background color
     *
     * @return The background Color
     */
    public abstract Color getBackgroundColor();

    /**
     * Gets the list background color
     *
     * @return The list background Color
     */
    public abstract Color getListBackgroundColor();

    /**
     * Gets the combo box background color
     *
     * @return The combo box background Color
     */
    public abstract Color getComboBoxBackgroundColor();

    /**
     * Gets the button background color
     *
     * @return The button background Color
     */
    public abstract Color getButtonBackgroundColor();

    /**
     * Gets the text field background color
     *
     * @return The text field background Color
     */
    public abstract Color getTextFieldBackgroundColor();

    /**
     * Gets the text color
     *
     * @return The text Color
     */
    public abstract Color getTextColor();

    /**
     * Gets the disabled text color
     *
     * @return The disabled text Color
     */
    public abstract Color getDisabledTextColor();
}
