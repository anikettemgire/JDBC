package task2;
import java.io.*;
import java.sql.*;

public class DashLogin {
	
	static void insert(String u,String p,String cp) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
		if(con==null) {
			System.out.println("not connected");
		}
		PreparedStatement ps=con.prepareStatement("insert into dash value(?,?,?)");
		ps.setString(1, u);
		ps.setString(2, p);
		ps.setString(3, cp);
		int r=ps.executeUpdate();
		System.out.println("Welocome "+u+ "  Sucess full ogine....!!!");
		con.close();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Enter the Username:");
			String u=br.readLine();
			System.out.println("Enter The Password");
			String p=br.readLine();
			System.out.println("Enter The Confirm Password");
			String cp=br.readLine();
			if(p.equals(cp)) {
				insert(u,p,cp);
			}
			else {
				System.out.println("password are not match try agian.....!!!!");
			}
		}
	

	}

}
