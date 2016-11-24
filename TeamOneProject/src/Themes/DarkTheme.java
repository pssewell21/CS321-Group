/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Themes;

import java.awt.Color;

/**
 *
 * @author Owner
 */
public final class DarkTheme implements ITheme{
    public static String themeName = "Dark Theme";
    
    public static Color backgroundColor = Color.GREEN;
    
    @Override
    public Color getBackgroundColor() {
        return Color.GREEN;
    }
    
    @Override
    public Color getListBackgroundColor() {
        return Color.ORANGE;
    }
    
    @Override
    public Color getComboBoxBackgroundColor() {
        return Color.GRAY;
    }
    
    @Override
    public Color getTextColor() {
        return Color.PINK;
    }
    
    @Override
    public Color getButtonColor() {
        return Color.BLUE;
    }
}
