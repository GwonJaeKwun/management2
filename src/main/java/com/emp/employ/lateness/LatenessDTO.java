package com.emp.employ.lateness;

import java.time.LocalDateTime;

public class LatenessDTO {

    private String employee_id;
    private LocalDateTime ness_date;
    // private String time;
    private String type;
    private String content;
    private int status;
	/*
	지각/결석/조퇴사유서 DTO
	employee_id : 사번
	ness_date   : 사유서 작성 날짜
	type        : 신청 타입 (조퇴, 결근. ...)
	content     : 사유서 내용
	status      : 승인/미승인 상태 플래그
	            : 0 = 미승인 , 1 = 승인
	 */
    // Getter and Setter for employee_id
    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    // Getter and Setter for ness_date
    public LocalDateTime getNess_date() {
        return ness_date;
    }

    public void setNess_date(LocalDateTime ness_date) {
        this.ness_date = ness_date;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for reason
    public String getType() {
        return type;
    }

    public void setType(String reason) {
        this.type = reason;
    }

    // Getter and Setter for status
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
