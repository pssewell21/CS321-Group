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
