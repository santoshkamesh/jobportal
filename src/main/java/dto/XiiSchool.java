package dto;

public class XiiSchool {
	
	private int id;
	private String board;
	private String meadium;
	private String yop;
	private Double perc;
	
	
	
	
	public XiiSchool(int id, String board, String meadium, String yop, Double perc) {
		super();
		this.id = id;
		this.board = board;
		this.meadium = meadium;
		this.yop = yop;
		this.perc = perc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getMeadium() {
		return meadium;
	}
	public void setMeadium(String meadium) {
		this.meadium = meadium;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String yop) {
		this.yop = yop;
	}
	public Double getPerc() {
		return perc;
	}
	public void setPerc(Double perc) {
		this.perc = perc;
	}

}
