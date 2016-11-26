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
