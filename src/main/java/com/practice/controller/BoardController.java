package com.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.model.BoardVO;
import com.practice.service.BoardService;

@Controller
@RequestMapping("/board/*")

public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	
	//�Խ��� ��� ������ ����
	@GetMapping("/list")
    // => @RequestMapping(value="list", method=RequestMethod.GET)
    public void boardListGET() {
        
        log.info("�Խ��� ��� ������ ����");
        
    }
	
    //�Խ��� ��� ������ ����
    @GetMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
    public void boardEnrollGET() {
        
        log.info("�Խ��� ��� ������ ����");
        
    }
    
    //�Խ��� ���
    @PostMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.POST)
    public String boardEnrollPOST(BoardVO board) {
    	
    	log.info("BoardVO : " + board);
    	
    	bservice.enroll(board);
    	
    	return "redirect:/board/list";
    	
    }
}
