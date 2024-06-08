package Services;

import java.sql.Connection;

import java.sql.PreparedStatement;

import Models.EmpModels;

public class EmpServices {

	private Connection conn;

	public EmpServices(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addEmployee(EmpModels E) {
		boolean f = false;
		try {
			String query = "insert into employee (Emp_id,Emp_name,Emp_salary,Emp_age,Emp_Phno,Emp_email) values(?,?,?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(query);
			pmst.setInt(1, E.getId());
			pmst.setString(2, E.getName());
			pmst.setInt(3, E.getSalary());
			pmst.setInt(4, E.getAge());
			pmst.setLong(5, (long) E.getPhno());
			pmst.setString(6, E.getEmail());
			int i = pmst.executeUpdate();
			if (i > 0) {
				f = true;
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
