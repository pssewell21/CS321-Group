/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author pssew
 */
public final class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static void handleException(Exception e) {
        System.out.println(e.toString());
    }
}