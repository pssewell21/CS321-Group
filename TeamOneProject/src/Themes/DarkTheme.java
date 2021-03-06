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
 * Gets theme colors for the Dark Theme
 *
 * @author Patrick Sewell
 */
public final class DarkTheme implements ITheme {

    @Override
    public Color getBackgroundColor() {
        return Color.BLACK;
    }

    @Override
    public Color getListBackgroundColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getComboBoxBackgroundColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getButtonBackgroundColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getTextFieldBackgroundColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getTextColor() {
        return Color.WHITE;
    }

    @Override
    public Color getDisabledTextColor() {
        return Color.BLACK;
    }
}
