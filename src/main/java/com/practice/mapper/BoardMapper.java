package com.practice.mapper;

import java.util.List;

import com.practice.model.BoardVO;

public interface BoardMapper {

	//�Խ��� ���
	public void enroll(BoardVO board);
	
	//�Խ��� ���
	//List�� �������� �����͸� ������ ��� ������ �ڷ����̴�.
	public List<BoardVO> getList();
	
	//�Խ��� ��ȸ
	//�Խ��� ��ȣ�� ��ȸ�� ���̱� ������ �Խ��� ��ȣ ���� �����͸� ���� ����
	//int bno�� �Ķ���ͷ� �߰��Ѵ�.
	public BoardVO getPage(int bno);
	
}
