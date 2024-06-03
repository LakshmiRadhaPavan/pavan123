package jdbc_pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Demo1 {
	public static final String url="jdbc:mysql://localhost:3306/";
	 public static final String name="root";
	 public static final String password="21551A05C6";
	 public static final Scanner sc=new Scanner(System.in);
	 public static Connection con;
	 public static PreparedStatement stmt;
	 public static void main(String[] args) {
		 int key;
			do {
				System.out.println("1.Create database \n2.show databases \n3.Drop database ");
				System.out.println("4.Create table \n5.Display tables \n6.deletion of table ");
				System.out.println("7.Insertion of Data \n8.fetching all data \n9.get all record by id ");
				System.out.println("10.deletion of data \n11.Update table\n12.Terminate process");
				key=sc.nextInt();
				switch (key) {
				case 1: {
					CreateDatabase();
					break;
				}
				case 2 :
				{
					Show_databases();
					break;
				}
				case 3: {
					DropDatabase();
					break;
				}
				case 4:{
					CreateTable();
					break;
				}
				case 5:{
					Diplaytables();
					break;
				}
				case 6:{
					deletetable();
					break;
				}
				case 7:{
					InsertionData();
					break;
				}
				case 8:{
					DisplayData();
					break;
				}
				case 9:{
					getbyId();
					break;
				}
				case 10:{
					deletedata();
					break;
				}
				case 11:{
					Update();
					break;
				}
				case 12:{
					System.exit(0);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + key);
				}

			
			} while (key>0);
		 
	 }	 
		 
		 
		 
		 private static void CreateDatabase() {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,name,password);
					System.out.println("Enter the database name:");
					String query="CREATE DATABASE "+sc.next();
					Statement stmt=con.createStatement();
					int i=stmt.executeUpdate(query);	
					if(i!=0) {
						System.out.println("Database is created Succesfully");
					}
					else {
						System.out.println("data base is already exists");
					}
					stmt.close();
					con.close();	
				}
				 catch (Exception e) {
					e.printStackTrace();
				}
			
	}
		 
		 public static void Show_databases() {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,name,password);
				String query1 = "Show databases";
				Statement stmt1 = con.createStatement();
				ResultSet rs = stmt1.executeQuery(query1); 
				System.out.println("\nDatabases are:");
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\n");
			 }
			 catch (Exception e) {
				e.printStackTrace();
			}
			 }
		 
		 
		 
		 private static void DropDatabase() {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,name,password);
					System.out.println("Enter the database name:");
					String query="Drop DATABASE "+sc.next();
					Statement stmt=con.createStatement();
					int i=stmt.executeUpdate(query);	
					if(i==0) {
						System.out.println("\nDatabase is droped Succesfully\n");
					}
					else {
						System.out.println("\ndata base is already exists\n");
					}
					stmt.close();
					con.close();	
				}
				 catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
	}
		 private static void CreateTable() {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Enter the database");
					String url1=url+sc.next();
					con=DriverManager.getConnection(url1,name,password);
					System.out.println("Enter the table name:");
					String query="CREATE TABLE "+sc.next()+" (Stu_num int,Stu_name varchar(20),Stu_marks int)";
					Statement stmt=con.createStatement();
					int i=stmt.executeUpdate(query);	
					if(i==0) {
						System.out.println("\nTable is created Succesfully\n");
					}
					else {
						System.out.println("\nTable is already exists\n");
					}
					stmt.close();
					con.close();	
				}
				 catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		 }
		 
		 
		 public static void Diplaytables() {
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Enter the database name:");
				String url1 = url+sc.next();
				con = DriverManager.getConnection(url1,name,password);
				String query1 = "Show tables";
				Statement stmt1 = con.createStatement();
				ResultSet rs = stmt1.executeQuery(query1); 
				System.out.println("\nTables are:");
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				System.out.println("\n");
			 }
			 catch (Exception e) {
				e.printStackTrace();
			}
			 }
			 private static void InsertionData() {
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						System.out.println("Enter the database");
						String url1=url+sc.next();
						con=DriverManager.getConnection(url1,name,password);
						System.out.println("Enter the table name:");
						String query="Insert into "+sc.next()+" values(?,?,?)";
						stmt=con.prepareStatement(query);
						System.out.println("Enter student number");
						stmt.setInt(1,sc.nextInt());
						System.out.println("Enter student name");
						stmt.setString(2,sc.next());
						System.out.println("Enter student Marks");
						stmt.setInt(3,sc.nextInt());
						int i=stmt.executeUpdate();	
						if(i!=0) {
							System.out.println("\nData is inserted Succesfully\n");
						}
						else {
							System.out.println("\nData is not inserted\n");
						}
						stmt.close();
						con.close();	
					}
					 catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}

			 }
			 public static void DisplayData() {
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 System.out.println("Enter the database name");
					 String url1=url+sc.next();
					 con=DriverManager.getConnection(url1,name,password);
					 Statement stmt=con.createStatement();
					 System.out.println("Enter the table name");
					 String query="SELECT * FROM "+sc.next();
					 ResultSet rs=stmt.executeQuery(query);
					 while (rs.next()) {
						 System.out.println("");
						 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					 }
					 System.out.println("\n\n\n");
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
			 }
			 public static void getbyId() {
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Enter the database");
					String url1 = url+sc.next();
					con = DriverManager.getConnection(url1,name,password);
					System.out.println("Enter the Table");
					String table1 = sc.next();
					System.out.println("Enter the Student number");
					String query = "select * from "+table1+" where Stu_num = "+sc.next();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()) {
						System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\n\n\n");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 public static void deletetable() {
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 System.out.println("Enter the database:");
					 String url1 = url+sc.next();
					 con=DriverManager.getConnection(url1,name,password);
					 System.out.println("Enter the table name:");
					 String query = "Drop table "+sc.next();
					 stmt = con.prepareStatement(query);
					 int i = stmt.executeUpdate();
					 if (i == 0) {
						System.out.println("table is deleted");
					} else {
						System.out.println("table is not deleted");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 
			 public static void Update() {
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Enter the database name:");
					String url1 = url+sc.next();
					con = DriverManager.getConnection(url1,name,password);
					String query1 = "SET SQL_SAFE_UPDATES = 0";
					Statement st = con.createStatement();
					st.execute(query1);
					System.out.println("Enter the table name:");
					String table1=sc.next();
					System.out.println("Enter the marks");
					int mark = sc.nextInt();
					System.out.println("Enter the Student number");
					String query = "update "+table1+" set stu_marks ="+mark+" where stu_num="+sc.nextInt();
					stmt = con.prepareStatement(query);
					int i = stmt.executeUpdate(query);
					if (i==1) {
						System.out.println("\nUpdated successfully\n");
					} else {
						System.out.println("\nNot Updated\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
			 
			 
			 public static void deletedata() {
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Enter the database name:");
					String url1 = url+sc.next();
					con = DriverManager.getConnection(url1,name,password);
					System.out.println("Enter the table name:");
					String table1=sc.next();
					System.out.println("Enter the Student number");
					String query = "delete from "+table1+" where stu_num="+sc.nextInt();
					stmt = con.prepareStatement(query);
					int i = stmt.executeUpdate(query);
					if (i==1) {
						System.out.println("\ndeleted successfully\n");
					} else {
						System.out.println("\nNot deleted\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }
	}
