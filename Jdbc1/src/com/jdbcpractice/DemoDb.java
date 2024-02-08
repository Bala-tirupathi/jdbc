package com.jdbcpractice;

import java.sql.*;

public class DemoDb {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/client";
		String uname = "root";
		String password = "Bala@2468";
		
		//String query = "select cname from customer where regno=2";                 // for fetching one value
		//String query = "select * from customer;";                                 // for fetching all 
		//String query = "insert into customer values (6,'Psycho')";               // inserting single data one way
		
//		int regno = 7;
//		String cname = "Chotu";                                                            // inserting single data 2nd way
//		String query = "insert into customer values (" + regno + ",'" + regno + "')";  
		
		/* here +," are used bc inside double quotes variable we can't write example regno, regno,
		 *  this is fine for 2 or 3 coloumns if we have more coloumns like phone number, gmail and other then this is not good
		 */
		
		int regno = 8;
		String cname = "Dhoni";
		String query = "insert into customer values (?,?)";
				
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conc = DriverManager.getConnection(url,uname,password);
		
		PreparedStatement st = conc.prepareStatement(query);
		st.setInt(1, regno);
		st.setString(2, cname);
		int count = st.executeUpdate();                             // here query is no need bc alrdy in prepared statement
		
		//Statement st = conc.createStatement();                    // ?,? need prepared statement and remaining all ways need this statement 
		//ResultSet rs = st.executeQuery(query);                    // executeQuery for fetching data (ddl)
		//int count = st.executeUpdate(query);                        // int bc it shows how many rows are effected
		
//		rs.next();
//		String data = rs.getString("cname");                      // for fetching one value
		
		
//		rs.next();
//		String data = rs.getInt(1) + " : " + rs.getString(2);     // Here also we will only regno and cname only, if we want another data need to add
//		                                                         //-like this 24,25,27 lines instead of this we will write "while" loop to fetch all
//		System.out.println(data);
		
//		while(rs.next()) {
//			String data = rs.getInt(1) + " : " + rs.getString(2);
//			System.out.println(data);
//		}
		
		System.out.println(count +" "+ "rows effected");
		
		st.close();
		conc.close();

	}

}
