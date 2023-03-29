package edu.study.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.BoardService;
import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;
import edu.study.vo.UserVO;

// DispatchServlet �� �����θ� ���� �� controller ���� �ݵ�� @Controller��
// ����ؾ߸� �Ѵ�!
@RequestMapping(value="/board")
@Controller 
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list.do") // /board/list.do
	public String list(Model model,SearchVO svo) {
		
		List<BoardVO> list = boardService.list(svo);
		
		model.addAttribute("blist", list); //request.setAttribute("list",list)
		
		return "board/list";
	}
	
	@RequestMapping(value="/write.do",method = RequestMethod.GET)
	public String write() {
		
		return "board/write";
	}
	
	@RequestMapping(value="/write.do",method = RequestMethod.POST)
	public String write(BoardVO vo,String btest, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		UserVO loginUserVO = (UserVO)session.getAttribute("login");
		
		vo.setUno(loginUserVO.getUno()); // ���۷� ������ ��ü�� �α��� ������ ���� ��ȣ�� ��´�.
		
		int result = boardService.insert(vo);
		
		System.out.println("��ϵ� �Խñ��� bno ::"+vo.getBno());
		
		return "redirect:/board/view.do?bno="+vo.getBno();
	}
	
	@RequestMapping(value="/view.do")
	public String view(int bno, Model model) {
		BoardVO vo = boardService.selectByBno(bno); //ȭ�鿡 �ʿ��� �� �Խñ� ��ȸ
		model.addAttribute("vo", vo);
		return "board/view";
	}
	
	@RequestMapping(value="/modify.do",method=RequestMethod.GET)
	public String modify(int bno, Model model) {
		
		BoardVO vo = boardService.selectByBno(bno); //ȭ�鿡 �ʿ��� �� �Խñ� ��ȸ
		model.addAttribute("vo", vo);
		
		return "board/modify";
	}
	
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modify(BoardVO vo) {
		
		//ȭ�鿡�� �Ѿ�� �����͸� ����ó�� (�����Ͻ� ����)
		int result = boardService.update(vo);
		
		if(result >0) {
			return "redirect:/board/view.do?bno="+vo.getBno();
		}else {
			return "redirect:/board/view.do?bno="+vo.getBno()+"&updateYN=N";
		}
		
	}
	
	@RequestMapping(value="/delete.do",method=RequestMethod.POST)
	public String delete(int bno) {
		
		int result = boardService.delete(bno);
		
		return "redirect:/board/list.do";
	}
	
	
}
