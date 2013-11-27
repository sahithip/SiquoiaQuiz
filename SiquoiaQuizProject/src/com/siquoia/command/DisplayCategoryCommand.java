package com.siquoia.command;

import com.siquoia.impl.DisplayCategoryImpl;
import com.siquoia.impl.LoginImpl;

public class DisplayCategoryCommand extends TargetCommand{
	
	private DisplayCategoryImpl displayCategoryIMPL;
	
	public DisplayCategoryCommand(String target) {
        super(target);
        displayCategoryIMPL = new DisplayCategoryImpl();
    }


}
