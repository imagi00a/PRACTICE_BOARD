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
    
    // 게시판 조회
    @GetMapping("/get")
    public void boardGetPageGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    
    //게시판 수정
    //조회 페이지(get.jsp)에서 수정 페이지(modify.jsp)로 이동
    @GetMapping("/modify")
    public void boardModifyGET(int bno, Model model) {
        
        model.addAttribute("pageInfo", bservice.getPage(bno));
        
    }
    
    //페이지 수정
    //수정 페이지(modify.jsp)에서 내용을 변경 후  "수정 완료" 버튼을 눌렀을 때 실행되는 메소드
    @PostMapping("/modify")
    // 수정될 내용의 데이터를 가져오기 위해 BoardVO 클래스를 파라미터로 부여하였고,
    //수정 기능 실행 후 리다이렉트 방식으로 리스트 페이지 이동시 데이터를 같이 전송하기 위해서 RedirctAttributes 객체를 파라미터로 부여
    public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
        
        bservice.modify(board);
    //리스트 페이지(list.jsp) 페이지 이동 시 수정이 완료되었음을 알리는 경고창을 띄우기 위해 
    //"modify success" 스트링 데이터를 "result" 속성 값에 저장하는 addFlashAttribute() 메소드를 호출
        rttr.addFlashAttribute("result", "modify success");
    //리턴 타입은 String 타입으로 작성하였고, 리다이렉트(Redirect) 방식으로 리스트 페이지 이동을 하도록 작성    
        return "redirect:/board/list";
        
    }
    
    //페이지 삭제
    @PostMapping("/delete")
    public String boardDeletePOST(int bno, RedirectAttributes rttr) {
    	
    	bservice.delete(bno);
    	
    	rttr.addFlashAttribute("result", "delete success");
    	
    	return "redirect:/board/list";
    }
    
    
    
    
    
}
