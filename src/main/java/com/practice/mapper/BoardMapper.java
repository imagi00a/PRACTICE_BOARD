package com.practice.mapper;

import java.util.List;

import com.practice.model.BoardVO;

public interface BoardMapper {

	//게시판 등록
	public void enroll(BoardVO board);
	
	//게시판 목록
	//List는 가변적인 데이터를 수용할 경우 유용한 자료형이다.
	public List<BoardVO> getList();
	
	//게시판 조회
	//게시판 번호로 조회할 것이기 때문에 게시판 번호 정보 데이터를 전달 받을
	//int bno를 파라미터로 추가한다.
	public BoardVO getPage(int bno);
	
}
