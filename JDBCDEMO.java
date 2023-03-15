import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDEMO {
		public static void main(String[] args) {
			JDBCDEMO obj=new JDBCDEMO();
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(url);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		public void db_create()
		{
			try
			{
				String qur="create database ANP_demo ";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","root");
				PreparedStatement ps=con.prepareStatement(qur);
				ps.execute();
				System.out.println("Database is created.");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		public void table_create()
		{
			try 
			{
				String qur="create table stud (user_name varchar(20),user_pass varchar(20))";
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ANP_demo","root","root");
				PreparedStatement ps=con.prepareStatement(qur);
				ps.execute();
				System.out.println("Table is Created");
				con.close();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void insert()
		{
			String qur="insert into stud(user_name,user_pass)value(?,?)";
			String id,fn,mn,ln,add,city,state,pn,gm,dob;
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter  Student ID");
			id=sc.next();
			System.out.println("Enter Student first name");
			fn=sc.next();
			System.out.println("Enter  Student middle name");
			mn=sc.next();
			System.out.println("Enter Student last name");
			ln=sc.next();
			System.out.println("Enter  Student address");
			add=sc.next();
			System.out.println("Enter Student city");
			city=sc.next();
			System.out.println("Enter  Student State");
			state=sc.next();
			System.out.println("Enter Student phone number");
			pn=sc.next();
			System.out.println("Enter  Student gmail id");
			gm=sc.next();
			System.out.println("Enter Student dob");
			dob=sc.next();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ANP_demo","root","root");
				PreparedStatement ps=con.prepareStatement(qur);
				ps.setString(1, id);
				ps.setString(2, fn);
				ps.setString(3, mn);
				ps.setString(4, ln);
				ps.setString(5, add);
				ps.setString(6, city);
				ps.setString(7, state);
				ps.setString(8, pn);
				ps.setString(9, gm);
				ps.setString(10, dob);
				int count=ps.executeUpdate();
				if(count>0)
				{
					System.out.println("Data is inserted");
				}
				else
				{
					System.out.println("Error");
					
					}
				ps.close();
				con.close();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void delete_data()
		{
			String qur="delete from stud where user_name=?";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter userID");
			String un=sc.next();
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ANP_demo","root","root");
				PreparedStatement ps=con.prepareStatement(qur);
				ps.setString(1, un);
				int count=ps.executeUpdate();
				if(count>0)
				{
					System.out.println("Data is Deleted");
				}
				else
				{
					System.out.println("Error");
					
					}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void update()
		{
			String qur="update stud set user_pass=? where user_name=?";
			String id,fn,mn,ln,add,city,state,pn,gm,dob;
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter studentId");
			id=sc.next();
			System.out.println("Enter Student first_name");
			fn=sc.next();
			System.out.println("Enter student middle_name");
			mn=sc.next();
			System.out.println("Enter Student last_name");
			ln=sc.next();
			System.out.println("Enter student add");
			add=sc.next();
			System.out.println("Enter Student city");
			city=sc.next();
			System.out.println("Enter student state");
			state=sc.next();
			System.out.println("Enter Student phone no");
			pn=sc.next();
			System.out.println("Enter student gmail");
			gm=sc.next();
			System.out.println("Enter Student dob");
			dob=sc.next();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ANP_demo","root","root");
				PreparedStatement ps=con.prepareStatement(qur);
				ps.setString(1, id);
				ps.setString(2, fn);
				ps.setString(3, mn);
				ps.setString(4, ln);
				ps.setString(5, add);
				ps.setString(6, city);
				ps.setString(7, state);
				ps.setString(8, pn);
				ps.setString(9, gm);
				ps.setString(10, dob);
				int count=ps.executeUpdate();
				if(count>0)
				{
					System.out.println("Data is Updated");
				}
				else
				{
					System.out.println("Error");
					
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
	 


