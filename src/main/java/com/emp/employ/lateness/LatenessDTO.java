package com.emp.employ.lateness;

public class LatenessDTO {

    private String employee_id;
    private String ness_date;
    private int type;
    private String content;
    private int status;
	/*
	지각/결석/조퇴사유서 DTO
	employee_id : 사번
	created_date: 사유서 작성 날짜
	ness_date   : 발생 날짜
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
   


    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public String getNess_date() {
		return ness_date;
	}

	public void setNess_date(String ness_date) {
		this.ness_date = ness_date;
	}

	public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for reason
    

    // Getter and Setter for status
    public int getStatus() {
        return status;
    }

    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setStatus(int status) {
        this.status = status;
    }
}
