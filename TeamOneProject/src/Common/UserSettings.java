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

import Themes.DarkTheme;
import Themes.ITheme;
import Themes.LightTheme;

/**
 * Stores user settings for easy access.
 *
 * @author Patrick Sewell
 */
public final class UserSettings {

    /**
     * The selected Theme.
     */
    public static ITheme selectedTheme;

    private UserSettings() {
    }

    /**
     * Sets the selected theme.
     *
     * @param theme The name of the theme to be selected
     */
    public static void setSelectedTheme(String theme) {
        if (theme == null) {
            return;
        }
        if (theme.equals("Dark Theme")) {
            UserSettings.selectedTheme = new DarkTheme();
        }
        if (theme.equals("Light Theme")) {
            UserSettings.selectedTheme = new LightTheme();
        }
    }
}
