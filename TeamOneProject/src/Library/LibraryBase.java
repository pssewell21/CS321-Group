/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author Owner
 */
public abstract class LibraryBase {

    public Long Id;

    protected LibraryBase() {
        Id = ID.newId();
    }
}
