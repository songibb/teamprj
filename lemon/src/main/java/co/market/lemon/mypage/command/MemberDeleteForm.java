package co.market.lemon.mypage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.market.lemon.common.Command;

public class MemberDeleteForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		return "member/memberDelete";
	}

}
