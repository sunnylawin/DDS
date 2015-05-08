package uno.vendor.vo;

public class GradeSetVO {
	
	String personID;
	String sessionID;
	String grade;
	String courseID;
	String gradeStatus;
	
	
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getGradeStatus() {
		return gradeStatus;
	}
	public void setGradeStatus(String gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	
	
	@Override
	public String toString() {
		return "GradeSetVO [personID=" + personID + ", sessionID=" + sessionID
				+ ", grade=" + grade + ", courseID=" + courseID
				+ ", gradeStatus=" + gradeStatus + "]";
	}
	
	
	
}
