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
public final class LightTheme implements ITheme {
    @Override
    public Color getBackgroundColor() {
        return Color.LIGHT_GRAY;
    }
    
    @Override
    public Color getListBackgroundColor() {
        return Color.WHITE;
    }
    
    @Override
    public Color getComboBoxBackgroundColor() {
        return Color.WHITE;
    }
    
    @Override
    public Color getButtonBackgroundColor() {
        return Color.WHITE;
    }
    
    @Override
    public Color getTextFieldBackgroundColor() {
        return Color.WHITE;
    }
    
    @Override
    public Color getCheckBoxBackgroundColor() {
        return Color.WHITE;
    }
    
    @Override
    public Color getTextColor() {
        return Color.BLACK;
    }
}
