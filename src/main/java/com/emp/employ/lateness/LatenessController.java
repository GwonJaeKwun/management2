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
	 * 결.조 신청서 View
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
	    
	    @GetMapping("/createForm")
	    public ModelAndView createForm(HttpSession session) {
	        ModelAndView mav = new ModelAndView();
	        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
	        
	        mav.addObject("employeeDTO", employee);
	        mav.setViewName("lateness/createForm");
	        return mav;
	    }

	    @PostMapping("/eatCreate")
	    public String eatCreate(LatenessDTO latenessDTO, HttpSession session) {
	        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
	        
	        latenessDTO.setEmployee_id(employee.getEmployee_id());
	        latenessDTO.setStatus(0); 

	        
            latenessMapper.insertLateness(latenessDTO);
            return "redirect:/lateness/eatView"; 
	        
	           
	    }
	/*
	 * 권재균
	 * 결.조 신청 내역 조회
	 * 메서드 이름 : eatRead
	 */
	public ModelAndView eatRead() {
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
	public String delete(LatenessDTO latenessDTO) {
	    latenessMapper.deleteLateness(latenessDTO); 
	    return "redirect:/lateness/eatView"; 
	}
	/*
	 * 권재균
	 * 결.조 신청 내역 수정
	 * 메서드 이름 : eatUpdate
	 */
	public ModelAndView eatUpdate() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	/*
	 * 권재균
	 * 자신의 결.조 신청내역 수정 View
	 * 메서드 이름 : eatUpdateView
	 */
    @GetMapping("/updateForm")
    public ModelAndView updateForm(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
        
        mav.addObject("employeeDTO", employee);
        mav.setViewName("lateness/createForm");
        return mav;
    }
    @PostMapping("/eatUpdate")
    public String eatUpdate(LatenessDTO latenessDTO) {
        latenessMapper.updateLateness(latenessDTO);
        return "redirect:/lateness/eatView";
    }

    // 자신의 결.조 신청내역 수정 View (기존 데이터를 불러와 보여주는 페이지)
    @GetMapping("/eatUpdateView")
    public ModelAndView eatUpdateView(
        @RequestParam("employee_id") String employee_id,
        @RequestParam("ness_date") String ness_date,
        HttpSession session
    ) {
        ModelAndView mav = new ModelAndView();

        LatenessDTO latenessDTO = latenessMapper.selectLatenessByEmployee_idAndNess_date(employee_id, ness_date);

        mav.addObject("latenessDTO", latenessDTO);

        EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employee");
        mav.addObject("employeeDTO", employee);

        // 수정 페이지를 띄워주는 역할이므로 viewName은 updateForm으로 설정
        mav.setViewName("lateness/updateForm");

        return mav;
    }
	
}
