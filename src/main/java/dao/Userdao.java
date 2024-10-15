package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Blob;

import dto.User;

public class Userdao {
	public static Connection getconnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql:///jobportal","root","tiger");		
	}
	
	public static void adduser(User u) throws Exception {
		Connection connection=getconnection();
		PreparedStatement pstm=connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
		pstm.setInt(1, u.getId());
		pstm.setString(2, u.getEmail());
		pstm.setString(3, u.getName());
		pstm.setString(4, u.getPassword());
		pstm.setString(5, u.getGender());
		pstm.setLong(6, u.getPhone());
		pstm.setString(7, u.getDob());
		pstm.setBlob(8, u.getPic());
		pstm.setString(9, u.getWorkstatus());
		pstm.executeUpdate();
		
		connection.close();
		pstm.close();
	}
	
	public static int lastid() {
		Connection connection;
		int lastid=0;
		try {
			connection=getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from user");
			
			while(resultSet.next()) {
				lastid=resultSet.getInt(1);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastid;
		
	}
	
	public static User getuser(String email) throws Exception{
		Connection connection;
		User user=null;
		try {
			connection = getconnection();
			PreparedStatement pstm=connection.prepareStatement("select * from user where email=?");
			pstm.setString(1, email);
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				user= new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getLong(6),rst.getString(7),(Blob) rst.getBlob(8),rst.getString(9));		
				}
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return user;
		}

		
		
	}
	public static User getuserid(int id) throws Exception{
		Connection connection;
		User user=null;
		try {
			connection = getconnection();
			PreparedStatement pstm=connection.prepareStatement("select * from user where id=?");
			pstm.setInt(1, id);
			ResultSet rst=pstm.executeQuery();
			while(rst.next()) {
				user= new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getLong(6),rst.getString(7),(Blob) rst.getBlob(8),rst.getString(9));		
				}
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return user;
		}

		
		
	}
	public static void updateusername(User u,String name) {
		System.out.println(name);
		Connection connection;
		try {
			connection = getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set name=? where id=?");
			pstm.setString(1, name);
			pstm.setInt(2, u.getId());
			
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateuseremail(User u,String mail) {
		Connection connection;
		try {
			connection =getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set email=? where id=?");
			pstm.setString(1, mail);
			pstm.setInt(2, u.getId());
			
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateusergender(User u,String gender) {
		Connection connection;
		try {
			connection =getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set gender=? where id=?");
			pstm.setString(1, gender);
			pstm.setInt(2, u.getId());
			
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateuserphone(User u,Long phone) {
		Connection connection;
		try {
			connection =getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set phone=? where id=?");
			pstm.setLong(1, phone);
			pstm.setInt(2, u.getId());
			
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void userdobupdate(User u,String dob) {
		Connection connection;
		try {
			connection=getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set dob=? where id=?");
			pstm.setString(1, dob);
			pstm.setInt(2, u.getId());
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateuserworkexp(User u,String exp) {
		Connection connection;
		try {
			connection =getconnection();
			PreparedStatement pstm=connection.prepareStatement("update user set workstatus=? where id=?");
			pstm.setString(1, exp);
			pstm.setInt(2, u.getId());
			
			pstm.executeUpdate();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
