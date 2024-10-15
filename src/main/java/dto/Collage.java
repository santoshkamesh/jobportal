package dto;

public class Collage {
	private int id;
	private String degree;
	private String specialization;
	private String collagename;
	private double cgpa;
	private String yop;
	private String type;
	
	
	
	
	public String getType() {
		return type;
	}
	public Collage(int id, String degree, String specialization, String collagename, double cgpa, String yop,
			String type) {
		this.id = id;
		this.degree = degree;
		this.specialization = specialization;
		this.collagename = collagename;
		this.cgpa = cgpa;
		this.yop = yop;
		this.type = type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getCollagename() {
		return collagename;
	}
	public void setCollagename(String collagename) {
		this.collagename = collagename;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	
}
