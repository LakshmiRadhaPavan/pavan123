package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Models.WorkersModel;

public class WorkerService {
	private Connection conn;

	public WorkerService(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addworker(WorkersModel worker) { 
		boolean flag = false;
		try {
			String query = "insert into worker(name,field,phno,salary) values(?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(query);
			pmst.setString(1, worker.getName());
			pmst.setString(2, worker.getField());
			pmst.setLong(3, worker.getPhno());
			pmst.setInt(4, worker.getSalary());
			
			int i = pmst.executeUpdate();
			if(i==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<WorkersModel> getall(){ 
		List<WorkersModel> li = new ArrayList<WorkersModel>();
		WorkersModel worker = null;
		try {
			String query = "select * from worker";
			PreparedStatement pmst = conn.prepareStatement(query);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()){
				worker = new WorkersModel();
				worker.setId(rs.getInt(1));
				worker.setName(rs.getString(2));
				worker.setField(rs.getString(3));
				worker.setPhno(rs.getLong(4));
				worker.setSalary(rs.getInt(5));
				li.add(worker);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public WorkersModel getbyid(int id) { 
		WorkersModel worker = new WorkersModel();
		try {
			String query = "select * from worker where id = ?";
			PreparedStatement pmst = conn.prepareStatement(query);
			pmst.setInt(1, id);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				worker.setId(rs.getInt(1));
				worker.setName(rs.getString(2));
				worker.setField(rs.getString(3));
				worker.setPhno(rs.getLong(4));
				worker.setSalary(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return worker;
	}
	public boolean deletebyid(int id) { //delete by id
		boolean flag = false;
		try {
			String query = "delete from worker where id = ?";
			PreparedStatement pmst = conn.prepareStatement(query);
			pmst.setInt(1, id);
			int i = pmst.executeUpdate();
			if(i==1) {
				flag = true;
			}
			else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	public boolean update(WorkersModel worker) { //update data
		boolean flag = false;
		try {
			String query = "update worker set name=?,filed=?,phno=?,salary=? where id=?";
			PreparedStatement pmst = conn.prepareStatement(query);
			pmst.setString(1, worker.getName());
			pmst.setString(2, worker.getField());
			pmst.setLong(3, worker.getPhno() );
			pmst.setInt(4, worker.getSalary());
			int i = pmst.executeUpdate();
			if(i==1) {
				flag = true;
			}
			else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
