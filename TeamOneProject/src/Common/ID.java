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

import java.util.Random;

/**
 * Handles the creation of ID's .
 *
 * @author Patrick Sewell
 */
public final class ID {

    private ID() {
    }

    /**
     * Creates a new ID.
     *
     * @return A new ID
     */
    public static final Long newId() {
        Random random = new Random();

        do {
            Long id = random.nextLong();

            if (id > 0) {
                return id;
            }
        } while (true);
    }
}
