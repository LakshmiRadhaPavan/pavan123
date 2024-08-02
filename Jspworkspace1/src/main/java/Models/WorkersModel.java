package Models;

public class WorkersModel {
	private int id;
	private String name;
	private String field;
	private long phno;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public WorkersModel(int id, String name, String field, long phno, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.field = field;
		this.phno = phno;
		this.salary = salary;
	}
	public WorkersModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
