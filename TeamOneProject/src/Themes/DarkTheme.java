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
    public Color getCheckBoxBackgroundColor() {
        return Color.DARK_GRAY;
    }
    
    @Override
    public Color getTextColor() {
        return Color.WHITE;
    }
}
