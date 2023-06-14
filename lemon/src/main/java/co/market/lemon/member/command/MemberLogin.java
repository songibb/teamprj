package co.market.lemon.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.market.lemon.common.Command;
import co.market.lemon.member.service.MemberService;
import co.market.lemon.member.service.MemberVO;
import co.market.lemon.member.serviceImpl.MemberServiceImpl;



public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
				MemberService ms = new MemberServiceImpl();
				MemberVO vo = new MemberVO();
				
				HttpSession session = request.getSession();   //request 객체가 갖고 있는 session을 가져와서 session객체를 하나 선언
				
				
				vo.setMemberId(request.getParameter("memberId"));
				vo.setMemberPw(request.getParameter("memberPw"));
				
				vo = ms.memberLogin(vo);
				if(vo != null) {    //로그인 성공했을 때
					session.setAttribute("id", vo.getMemberId());  //session변수인 "id"에 로그인한 memberId를 담음 -> 이 session변수는 jsp안에서는 전역에서 사용가능하기때문에 vo객체와 충돌하지 않게 만들어야함
					session.setAttribute("name", vo.getMemberName());
					session.setAttribute("grade", vo.getMemberGrade());
					return "main/main";
					
				} else {
					
					request.setAttribute("message", "아이디 또는 비밀번호가 틀렸습니다.");
					return "member/memberLoginMessage";
				}
				
	}

}
