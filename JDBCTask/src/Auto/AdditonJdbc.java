package Auto;
import java.io.*;
import java.sql.*;
public class AdditonJdbc {
	public static void addtion()throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","");
		if(con==null) {
			System.out.println("not connectd");
		}
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from addition");
		int i=1;
		while(rs.next()) {
			int total=rs.getInt(2)+rs.getInt(3);
			//System.out.println(total+" "+rs.getInt(2)+" "+rs.getInt(3));
			PreparedStatement ps=con.prepareStatement("update addition set additon=? where id=?");
			ps.setInt(1, total);
			ps.setInt(2, i++);
			ps.executeUpdate();
			}
		System.out.println("Done Opeartion!!!!");
		con.close();
	}
	public static void main(String[] args)throws Exception {
		addtion();
	}

}
