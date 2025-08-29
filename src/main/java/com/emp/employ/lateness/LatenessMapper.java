package com.emp.employ.lateness;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LatenessMapper {

	 void insertLateness(LatenessDTO latenessDTO);

	List<LatenessDTO> selectLatenessListByEmployee_id(String employee_id);

	 void deleteEat(LatenessDTO latenessDTO);

	List<LatenessDTO> getLatenessList();

	void deleteLateness(LatenessDTO latenessDTO);
	LatenessDTO selectLatenessByEmployee_idAndNess_date(
			@Param("employee_id") String employee_id,
			@Param("ness_date") String ness_date
		);

	public void updateLateness(LatenessDTO latenessDTO);
		

}
