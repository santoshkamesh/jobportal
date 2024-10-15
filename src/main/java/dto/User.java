package dto;



import com.mysql.cj.jdbc.Blob;
public class User {
	private int id;
	private String email;
	private String name;
	private String password;
	private String gender;
	private long phone;
	private String dob;
	private Blob pic;
	private String workstatus;
	
	
	
	
	public String getWorkstatus() {
		return workstatus;
	}


	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}


	public User(int id, String email, String name, String password, String gender, long phone,String dob ,Blob pic,String workstatus) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.dob=dob;
		this.pic=pic;
		this.workstatus=workstatus;
	}
	
	
	public Blob getPic() {
		return pic;
	}


	public void setPic(Blob pic) {
		this.pic = pic;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
	
	

}
