/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.Random;

/**
 *
 * @author Owner
 */
public final class ID {

    private ID() {
    }

    /**
     *
     * @return
     */
    public static Long newId() {
        Random random = new Random();

        do {
            Long id = random.nextLong();

            if (id > 0) {
                return id;
            }
        } while (true);
    }
}
