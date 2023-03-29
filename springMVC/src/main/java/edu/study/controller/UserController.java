package edu.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.UserService;
import edu.study.vo.UserVO;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public void login(UserVO vo,HttpServletRequest req,HttpServletResponse rsp) throws IOException {
		
		//1.입력한 아이디,패스워드 일치하는 user 정보 조회
		UserVO loginVO = userService.selectLogin(vo);
		
		rsp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = rsp.getWriter();
		
		if(loginVO != null) {
			//2.정보가 존재하는 경우 session에 login user 정보 담기
			HttpSession session = req.getSession();
			session.setAttribute("login", loginVO);
			//3.로그인 처리 후 메인페이지 이동
			pw.append("<script>alert('로그인성공!');location.href='"+req.getContextPath()+"'</script>");
			//return "redirect:/";
		}else {
			//4.user 정보가 없는 경우 다시 login 페이지로 이동
			pw.append("<script>alert('로그인실패!');location.href='login.do'</script>");
			//return "redirect:/user/login.do";
		}
		pw.flush();
		
		
		
		
	}
	
	
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.POST)
	public void join(UserVO vo, HttpServletRequest req,HttpServletResponse rsp) throws IOException {
		
		
		System.out.println("uid::"+vo.getUid());
		System.out.println("upw::"+vo.getUpw());
		System.out.println("uname::"+vo.getUname());
		System.out.println("ugender::"+vo.getUgender());
		
		//회원가입기능을 구현해보세요
		int result = userService.insert(vo);
		
		
		rsp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = rsp.getWriter();
		
		if(result>0) {
			//회원가입 성공 <script>alert('회원가입 성공!');location.href='/springMVC';<script>
			pw.append("<script>alert('회원가입 성공!');location.href='"+req.getContextPath()+"';</script>");
		}else {
			//회원가입 실패
			pw.append("<script>alert('회원가입 실패!');location.href='"+req.getContextPath()+"';</script>");
		}
		pw.flush();
		
		
		
	}
	
	
}
