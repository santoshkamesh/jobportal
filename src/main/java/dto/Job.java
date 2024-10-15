package dto;

public class Job {
	private int id;
	private  int orgid;
	private String role;
	private String discription;
	private String loc;
	private Double sal;
	private double minexp;
	private double maxexp;
	private String skills;
	
	
	
	
	
	
	public Job(int id, int orgid, String role, String discription, String loc, Double sal, double minexp, double maxexp,
			String skills) {
		super();
		this.id = id;
		this.orgid = orgid;
		this.role = role;
		this.discription = discription;
		this.loc = loc;
		this.sal = sal;
		this.minexp = minexp;
		this.maxexp = maxexp;
		this.skills = skills;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrgid() {
		return orgid;
	}
	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public double getMinexp() {
		return minexp;
	}
	public void setMinexp(double minexp) {
		this.minexp = minexp;
	}
	public double getMaxexp() {
		return maxexp;
	}
	public void setMaxexp(double maxexp) {
		this.maxexp = maxexp;
	}
	

}
