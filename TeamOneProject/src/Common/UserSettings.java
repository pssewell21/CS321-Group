/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Themes.DarkTheme;
import Themes.ITheme;
import Themes.LightTheme;

/**
 *
 * @author Owner
 */
public final class UserSettings {

    /**
     *
     */
    public static ITheme theme;

    private UserSettings() {
    }

    /**
     *
     * @param theme
     */
    public static void setSelectedTheme(String theme) {
        if (theme.equals("Dark Theme")) {
            UserSettings.theme = new DarkTheme();
        }
        if (theme.equals("Light Theme")) {
            UserSettings.theme = new LightTheme();
        }
    }
}
