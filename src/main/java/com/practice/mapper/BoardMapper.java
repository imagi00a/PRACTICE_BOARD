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
	
	//게시판 수정
	// bno, title, content, writer에 대한 데이터가 필요로 하기 때문에 해당 변수들이 정의되어 있는 BoardVO를 파라미터로 추가
	//수정을 진행하는 메소드는 반환 타입이 필요없음.
	//하지만 int형으로 설정해 성공시1, 실패시0 반환.
	public int modify(BoardVO board);
	
	//게시판 삭제
	//반환 타입은 '수정'과 동일하게 int형으로 작성. 삭제 쿼리가 성공을 하면 '1'을 반환, 실패하면 '0'을 반환
	public int delete(int bno);
	
	
}
