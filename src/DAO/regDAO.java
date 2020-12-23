package DAO;
import java.sql.*;
import java.util.ArrayList;
//import java.util.List;


import VO.regVO;

public class regDAO {
	
	public void insert(regVO v) 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/pro","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("insert into reg(firstname,lastname) values('"+v.getFn()+"','"+v.getLn()+"')");
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void delete(regVO y) 
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/pro","root","root");
		Statement s = c.createStatement();
		s.executeUpdate("delete from reg where id='"+y.getId()+"' ");
		System.out.println("Deleted");
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public ArrayList<Object> search(regVO s){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/pro","root","root");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("select * from reg where firstname='"+s.getFn()+"' or lastname='"+s.getLn()+"' ");
			ArrayList<Object> l = new ArrayList<Object>();
			while(rs.next()){
				Integer id = rs.getInt("id");
				String fnn = rs.getString("firstname");
				String lnn = rs.getString("lastname");
				
				regVO obj = new regVO();
				obj.setId(id);
				obj.setFn(fnn);
				obj.setLn(lnn);
//				PrintWriter out = response.getWriter();
				l.add(obj);
			}
			return l;
			}
			catch(Exception e){
				System.out.println(e);
				ArrayList<Object> l = new ArrayList<Object>();
				return l;
			}
		
	}
}
