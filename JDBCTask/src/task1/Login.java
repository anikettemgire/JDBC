package task1;
import java.io.*;
import java.sql.*;

public class Login {

	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
		if(con!=null) {
			//System.out.println("Establish Connection");
		}else {
			System.out.println("Not Esatbabish Connection");
		}
		Statement st=con.createStatement();
		String q="select * from login";
		
		ResultSet rs=st.executeQuery(q);
		rs.next();
			String user=rs.getString(1);
			String pass=rs.getString(2);
			
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The Usename:");
		String use=br.readLine();
		System.out.println("Enter The Password");
		String pas=br.readLine();
		if(use.equals(user)&& pas.equals(pass)) {
			System.out.println("Succesfull Logine......!!!!!");
			
			
		}else if(!use.equals(user)) {
			System.out.println("Enter Valid Username....");
		}else if(!pass.equals(pas)) {
			System.out.println("Enter Valid Password....");
		}else {
			System.out.println("Enter The valid password and Usename");
		}
	    con.close();

	}

}
