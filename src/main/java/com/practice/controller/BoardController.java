package com.practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.model.BoardVO;
import com.practice.service.BoardService;

@Controller
@RequestMapping("/board/*")

public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bservice;
	
	//게시판 목록 페이지 접속
	@GetMapping("/list")
    // => @RequestMapping(value="list", method=RequestMethod.GET)
    public void boardListGET(Model model) {
        
        log.info("게시판 목록 페이지 진입");
        
        model.addAttribute("list", bservice.getList());
        
    }
	
    //게시판 등록 페이지 접속
    @GetMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.GET)
    public void boardEnrollGET() {
        
        log.info("게시판 등록 페이지 진입");
        
    }
    
    //게시판 등록
    @PostMapping("/enroll")
    // => @RequestMapping(value="enroll", method=RequestMethod.POST)
    public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
    	
    	log.info("BoardVO : " + board);
    	
    	rttr.addFlashAttribute("result", "enroll success");
    	
    	bservice.enroll(board);
    	
    	return "redirect:/board/list";
    	
    }
    
    /* 게시판 조회 */
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    
}
