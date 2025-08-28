package com.emp.employ.lateness;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LatenessMapper {

	 void insertLateness(LatenessDTO latenessDTO);

	List<LatenessDTO> selectLatenessListByEmployee_id(String employee_id);

	 void deleteEat(LatenessDTO latenessDTO);

	List<LatenessDTO> getLatenessList();

	void deleteLateness(LatenessDTO latenessDTO);
		

}
