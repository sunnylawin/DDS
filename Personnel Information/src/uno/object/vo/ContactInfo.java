package uno.object.vo;


public class ContactInfo {
	
	private String person_Id = "";
	private String name ="";
	private String contact = "";
	private String address = "";
	private String gender="";
	private String age = "";
	
	public String getPerson_Id() {
		return person_Id;
	}
	public void setPerson_Id(String person_Id) {
		this.person_Id = person_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "ContactInfo [person_Id=" + person_Id + ", name=" + name
				+ ", contact=" + contact + ", address=" + address + ", gender="
				+ gender + ", age=" + age + "]";
	}
	
	
	
	
}
