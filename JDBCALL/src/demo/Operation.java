package demo;
import java.io.*;
import java.sql.*;

public class Operation {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/College","root","");
		if(con==null) {
			System.out.println("Not Connected");
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Statement st=con.createStatement();
		 PreparedStatement p1,p2,p3=null;
		while(true) {
		System.out.println("Enter Your Choice:");
		
			System.out.println("1.Insert\n2.View\n3.Update\n4.Delete\n5.Exit");
			int ch=Integer.parseInt(br.readLine());
			switch(ch) {
			case 1: 
				System.out.println("how many record insert");
			      int no=Integer.parseInt(br.readLine());
			     
			      
			     for(int i=0;i<no;i++) {
			    	 
			    	 System.out.println("Enter The Id:");
			    	 int a=Integer.parseInt(br.readLine());
			    	 System.out.println("Enter The Name:");
			    	 String b=br.readLine();
			    	 System.out.println("Enter The mail");
			    	 String c=br.readLine();
			    	 System.out.println("Enter the location");
			    	 String d=br.readLine();
			    	 p1=con.prepareStatement("insert into student value(?,?,?,?)");
			    	 p1.setInt(1, a);
			    	 p1.setString(2,b);
			    	 p1.setString(3,c);
			    	 p1.setString(4,d);
			    	 p1.executeUpdate();
			    	 System.out.println("Record Succefull Insert!!!!!");
			      }
				
				  break;
			case 2:
				  System.out.println("id"+"\t"+"name"+"\t"+"email"+"\t"+"location");
				   ResultSet rs=st.executeQuery("select * from student");
				   while(rs.next()) {
					   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+
				       rs.getString(4));
				   }
				  break;
			case 3:
				   System.out.println("Enter The id You want to change:");
				   int id=Integer.parseInt(br.readLine());
				   System.out.println("Enter name\tEnter gamil\tEnter location new:");
				   String x=br.readLine();
				   String y=br.readLine();
				   String z=br.readLine();
				   p2=con.prepareStatement("update student set name=?,mail=?,location=? where id=?");
				   p2.setString(1, x);
				   p2.setString(2, y);
				   p2.setString(3, z);
				   p2.setInt(4, id);
					 p2.executeUpdate();
					 System.out.println("updtae record Sucessfulll");
				   
				  break;
			case 4:
				  System.out.println("Enter The Id you want to dlete");
				  int dd=Integer.parseInt(br.readLine());
				  p3=con.prepareStatement("delete from student where id=?");
				  p3.setInt(1, dd);
				  p3.executeUpdate();
				  System.out.println("Delete The Record Sucessful!!!");
				  break;
			case 5:
				  System.exit(0);
				  break;
			}
			con.close();
		}

	}

}
