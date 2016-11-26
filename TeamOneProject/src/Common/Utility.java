/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.io.File;
import java.sql.Timestamp;

/**
 *
 * @author pssew
 */
public final class Utility {

    private Utility() {
    }

    /**
     *
     * @param string
     * @return
     */
    public static final boolean hasValue(String string) {
        if (string == null) {
            return false;
        }

        return !string.isEmpty();
    }

    /**
     *
     * @return
     */
    public static final Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * http://stackoverflow.com/questions/20281835/how-to-delete-a-folder-with-files-using-java
     *
     * @param element
     */
    public static void deleteFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        
        element.delete();
    }
}
