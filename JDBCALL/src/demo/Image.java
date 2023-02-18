package demo;
import java.sql.*;
import java.io.*;
public class Image {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/img","root","");
		if(con!=null) {
			System.out.println("not connetc");
		}
		FileInputStream fl=new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Desktop\\humans - Shortcut.lnk");
		PreparedStatement ps=con.prepareStatement("insert into imges value(?,?)");
		ps.setInt(1, 60);
		ps.setBinaryStream(2, fl,fl.available());
		ps.executeUpdate();
		System.out.println("image insert sucessful.....");
	      Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from imges");
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
		}
		
      con.close();
	}

}
