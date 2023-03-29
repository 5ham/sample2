package edu.study.service;

import java.util.List;

import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;

public interface BoardService {
	public List<BoardVO> list(SearchVO svo);
	public BoardVO selectByBno(int bno);
	public int update(BoardVO vo);
	public int insert(BoardVO vo);
	public int delete(int bno);
}
