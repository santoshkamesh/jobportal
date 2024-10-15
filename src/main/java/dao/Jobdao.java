package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import dto.Job;

public class Jobdao {
	
	public static void addjob(Job j) {
		try {
			Connection connection=Userdao.getconnection();
			PreparedStatement pstm=connection.prepareStatement("insert into job values(?,?,?,?,?,?,?,?)");
			pstm.setInt(1, j.getId());
			pstm.setInt(2, j.getOrgid());
			pstm.setString(3, j.getRole());
			pstm.setString(4, j.getDiscription());
			pstm.setString(5, j.getLoc());
			pstm.setDouble(6, j.getSal());
			pstm.setDouble(7, j.getMinexp());
			pstm.setDouble(8, j.getMaxexp());
			pstm.setString(9, j.getSkills());
			
			pstm.executeUpdate();
			
			connection.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Jobdao() {
		// TODO Auto-generated constructor stub
	}
	public static Job getjob(int id) {
Job job=null;
		
		try {
			Connection  connection =Userdao.getconnection();
			Statement s=connection.createStatement();
			PreparedStatement pstm=connection.prepareStatement("select * from job where id=?");
			pstm.setInt(1, id);
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				job=new Job(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6),rst.getDouble(7),rst.getDouble(8),rst.getString(9));
				
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return job;
		}
		
	}
	
	
	public static LinkedList<Job> getalljob(){
			LinkedList<Job> ls=new LinkedList<Job>();
		
		try {
			Connection  connection =Userdao.getconnection();
			Statement s=connection.createStatement();
			ResultSet rst=s.executeQuery("select * from job");
			while(rst.next()) {
				ls.add(new Job(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6),rst.getDouble(7),rst.getDouble(8),rst.getString(9)));
				
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return ls;
		}
		
	}
	

	public static Job getlastjob() {
		Job job=null;
		
		try {
			Connection  connection =Userdao.getconnection();
			Statement s=connection.createStatement();
			ResultSet rst=s.executeQuery("select * from job");
			while(rst.next()) {
				job=new Job(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6),rst.getDouble(7),rst.getDouble(8),rst.getString(9));
				
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return job;
		}
		
	}

}
