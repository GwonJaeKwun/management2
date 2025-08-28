package com.emp.employ.lateness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emp.employ.employee.EmployeeDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/lateness")
public class LatenessController {
	@Autowired
	private LatenessMapper latenessMapper;
	/*
	 * 권재균
	 * 지.결.조 신청서 View
	 * 메서드 이름 : eatView
	 */
	   @GetMapping("/eatView")
	    public ModelAndView eatView(HttpSession session) {
	        ModelAndView mav = new ModelAndView();
	        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
	        
	        List<LatenessDTO> latenessList = latenessMapper.selectLatenessListByEmployee_id(employee.getEmployee_id());
	        
	        mav.addObject("employeeDTO", employee);
	        mav.addObject("LatenessDTOList", latenessList);
	        mav.setViewName("lateness/eatView");
	        return mav;
	    }
	    
	    // 신청서 작성 폼을 보여주는 페이지
	    @GetMapping("/createForm")
	    public ModelAndView createForm(HttpSession session) {
	        ModelAndView mav = new ModelAndView();
	        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
	        
	        mav.addObject("employeeDTO", employee);
	        mav.setViewName("lateness/createForm");
	        return mav;
	    }

	    // 신청서 제출(POST)을 처리하고 목록 페이지로 리다이렉션
	    @PostMapping("/eatCreate")
	    public String eatCreate(LatenessDTO latenessDTO, HttpSession session) {
	        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
	        
	        latenessDTO.setEmployee_id(employee.getEmployee_id());
	        latenessDTO.setStatus(0); 

	        try {
	            latenessMapper.insertLateness(latenessDTO);
	            return "redirect:/eatView"; 
	        } catch (Exception e) {
	            System.err.println("데이터 삽입 중 오류 발생: " + e.getMessage());
	            return "redirect:/createForm"; 
	        }	
	    }
	/*
	 * 권재균
	 * 지.결.조 신청 내역 조회
	 * 메서드 이름 : eatRead
	 */
	public ModelAndView eatRead() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	
	/*
	 * 권재균
	 * 지.결.조 신청 내역 수정
	 * 메서드 이름 : eatUpdate
	 */
	public ModelAndView eatUpdate() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	
	/*
	 * 권재균
	 * 지.결.조 신청 내역 삭제
	 * 메서드 이름 : eatDelete
	 */
	public ModelAndView eatDelete() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
    @RequestMapping("/delete")
    public ModelAndView delete(LatenessDTO latenessDTO) {
        latenessMapper.deleteLateness(latenessDTO);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/lateness/eatView");
        return mav;
    }
	/*
	 * 권재균
	 * 자신의 지.결.조 신청내역 수정 View
	 * 메서드 이름 : eatUpdateView
	 */
	@GetMapping("/eatUpdateView")
	public ModelAndView eatUpdateView() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}
