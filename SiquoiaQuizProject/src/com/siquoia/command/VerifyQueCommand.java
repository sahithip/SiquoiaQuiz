package com.siquoia.command;

import javax.servlet.http.HttpServletRequest;

import com.siquoia.exception.CommandException;
import com.siquoia.impl.QuestionImpl;

public class VerifyQueCommand extends TargetCommand {

	private QuestionImpl questionImpl;
	
	public VerifyQueCommand(String target) {
		super(target);
		questionImpl = new QuestionImpl();
		// TODO Auto-generated constructor stub
	}
	
	public String execute(HttpServletRequest request) throws CommandException {

		String flag = "false";
		String[] verifiedQueIdList = request.getParameterValues("check");
		flag = questionImpl.verifyQue(verifiedQueIdList);
		request.setAttribute("flag", flag);
		return super.execute(request);
	}

}
