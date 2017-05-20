package service;

import java.util.List;

import entity.Students;

public interface StudentsDao {
	
	public List<Students> queryAllStudents();
	
	public Students queryStudentsById(String sid);
	
	public boolean addStudents(Students s);
	
	public boolean updateStudents(Students s);
	
	public boolean deleteStudents(String sid);
	
	public List<Students> selectStudentBySname(String sname);
}
