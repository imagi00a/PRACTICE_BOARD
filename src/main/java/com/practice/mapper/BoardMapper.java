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
	
	//�Խ��� ����
	// bno, title, content, writer�� ���� �����Ͱ� �ʿ�� �ϱ� ������ �ش� �������� ���ǵǾ� �ִ� BoardVO�� �Ķ���ͷ� �߰�
	//������ �����ϴ� �޼ҵ�� ��ȯ Ÿ���� �ʿ����.
	//������ int������ ������ ������1, ���н�0 ��ȯ.
	public int modify(BoardVO board);
	
	//�Խ��� ����
	//��ȯ Ÿ���� '����'�� �����ϰ� int������ �ۼ�. ���� ������ ������ �ϸ� '1'�� ��ȯ, �����ϸ� '0'�� ��ȯ
	public int delete(int bno);
	
	
}
