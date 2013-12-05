package com.siquoia.exception;

import com.siquoia.mapper.Mapper;

public class RollBackException extends Exception{

	    private Mapper origin; //the mapper that failed to roll back the connection

	    public RollBackException(Mapper mapper) {
	        origin = mapper;
	    }
	    
	    @Override
	    public String getMessage() {
	    	return "Failed to roll back in: " + origin.toString();
	    }

}
