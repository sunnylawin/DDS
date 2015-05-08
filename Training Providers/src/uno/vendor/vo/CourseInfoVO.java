package uno.vendor.vo;

import javax.xml.bind.annotation.XmlType;

//@XmlType(name="CourseInfoVO" , namespace="CourseInfoVO")
public class CourseInfoVO {
	
	String courseID;
	String area;
	String courseTitle;
	String rank;
	String decp;
	String status;
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDecp() {
		return decp;
	}
	public void setDecp(String decp) {
		this.decp = decp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "CourseInfoVO [courseID=" + courseID + ", area=" + area
				+ ", courseTitle=" + courseTitle + ", rank=" + rank + ", decp="
				+ decp + ", status=" + status + "]";
	}
	
}
