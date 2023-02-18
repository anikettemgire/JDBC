import java.sql.*;



public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String s="com.mysql.jdbc.Driver";
	Class.forName(s);
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ani","root","root");
	if(con==null) {
		System.out.println("niot");
	}else {
	System.out.println("Connection done");
	}
	//PreparedStatement p=con.prepareStatement("select * from stduent");
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from student");  
	while(rs.next()) { 
	System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
	 
	}
	con.close(); 
	}

}
