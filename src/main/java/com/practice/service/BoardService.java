package com.practice.service;

import java.util.List;

import com.practice.model.BoardVO;

public interface BoardService {
	//�Խ��� ���
	public void enroll(BoardVO board);
	
	//�Խ��� ���
	public List<BoardVO> getList();
	
	//�Խ��� ��ȸ
	public BoardVO getPage(int bno);
	
}
