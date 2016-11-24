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
    public final String themeName = "Light Theme";
    
    @Override
    public Color getBackgroundColor() {
        return new Color(0,0,0);
    }
    
    @Override
    public Color getListBackgroundColor() {
        return new Color(0,0,0);
    }
    
    @Override
    public Color getComboBoxBackgroundColor() {
        return new Color(0,0,0);
    }
    
    @Override
    public Color getTextColor() {
        return new Color(0,0,0);
    }
    
    @Override
    public Color getButtonColor() {
        return new Color(0,0,0);
    }
}
