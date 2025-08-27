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
		EmployeeDTO employee= (EmployeeDTO) session.getAttribute("employee");
		
		// TODO LatenessMapper를 통해 내 사번정보(employee_id)로 조회된 신청정보 목록을 조회
		List<LatenessDTO> latenessList = latenessMapper.selectLatenessListByEmployee_id(employee.getEmployee_id());	
		
		 mav.addObject("employeeDTO", employee);
		
// 		 mav.addObject("LatenessDTOList", Arrays.asList(new LatenessDTO()));
		 mav.addObject("LatenessDTOList", latenessList);
		
		mav.setViewName("lateness/eatView");
		return mav;
	}
	
	/*
	 * 권재균
	 * 지.결.조 신청 로직
	 * 메서드 이름 : eatCreate
	 */
	public ModelAndView eatCreate() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	@GetMapping("/createForm")
	public ModelAndView create(HttpSession session) {
		EmployeeDTO employee= (EmployeeDTO) session.getAttribute("employee");
		
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("employeeDTO", employee);
		mav.setViewName("lateness/create");
		return mav;
	}
	@PostMapping("/eatCreate")
	public ModelAndView eatcreate(
			                      LatenessDTO latenessDTO,
			                      HttpSession session) {
		EmployeeDTO employee= (EmployeeDTO) session.getAttribute("employee");
		
		LocalDateTime now = LocalDateTime.now();
		latenessDTO.setEmployee_id(employee.getEmployee_id());
		
		// TODO LatenessMapper에 인자로 받아온 latenessDTO를 insert하는 기능이 필요
		latenessMapper.insertLateness(latenessDTO);
		
		
		// TODO LatenessMapper를 통해 내 사번정보(employee_id)로 조회된 신청정보 목록을 조회
		List<LatenessDTO> latenessList = latenessMapper.selectLatenessListByEmployee_id(employee.getEmployee_id());
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("employeeDTO", employee);
		// mav.addObject("latenessDTO", latenessDTO);
		mav.addObject("latenessDTOList", latenessList);
		mav.setViewName("lateness/eatView");	
		return mav;
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
