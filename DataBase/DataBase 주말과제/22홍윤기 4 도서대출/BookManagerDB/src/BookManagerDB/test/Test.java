package BookManagerDB.test;

import java.sql.*;

import BookManagerDB.system.LibrarySystem;
import BookManagerDB.utillities.DataHandler;

public class Test {
	private static LibrarySystem librarySystem = LibrarySystem.getInstance();
	private static DataHandler datahandler = DataHandler.getInstance();

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("시작");
		datahandler.connect();
		
		librarySystem.showRentalList();
		datahandler.disconnect();
	}
}
