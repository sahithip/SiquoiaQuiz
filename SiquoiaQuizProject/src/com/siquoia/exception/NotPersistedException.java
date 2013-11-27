/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siquoia.exception;

/**
 *
 * @author PC
 */
public class NotPersistedException extends Exception{
    
    private long id;

    public NotPersistedException(long id, String string) {
        super(string);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
