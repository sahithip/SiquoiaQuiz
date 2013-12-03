package com.siquoia.exception;

public class ExistsException extends Exception{

    private long id;

    public ExistsException(long id, String string) {
        super(string);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
