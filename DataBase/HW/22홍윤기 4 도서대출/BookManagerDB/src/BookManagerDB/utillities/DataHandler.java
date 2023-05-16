package BookManagerDB.utillities;

import java.sql.*;
import java.util.*;

public class DataHandler {
	private static DataHandler instance;
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String user = "scott";
	private String password = "tiger";
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private DateHandler dateHandler = DateHandler.getInstance();

	private DataHandler() {
	}

	public static DataHandler getInstance() {
		if (instance == null) {
			synchronized (DataHandler.class) {
				if (instance == null) {
					instance = new DataHandler();
				}
			}
		}
		return instance;
	}

	public void connect() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.conn = DriverManager.getConnection(instance.url, instance.user, instance.password);
		conn.setAutoCommit(false);
		this.stmt = this.conn.createStatement();
	}

	public void disconnect() throws SQLException {
		this.commit();
		this.conn.close();
	}

	public void printQuery(String sql) throws SQLException {
	    List<List<String>> result = selectQuery(sql);
	    int columnCount = result.get(0).size();
	    int rowCount = result.size();
	    
	    // 각 칼럼의 최대 길이를 계산하여 출력 간격을 조절한다
	    int[] columnWidths = new int[columnCount];
	    for (int i = 0; i < columnCount; i++) {
	        int maxColumnWidth = 0;
	        for (int j = 0; j < rowCount; j++) {
	            int columnWidth = result.get(j).get(i).length();
	            if (columnWidth > maxColumnWidth) {
	                maxColumnWidth = columnWidth;
	            }
	        }
	        columnWidths[i] = maxColumnWidth + 2; // 좌우 여백을 위해 2를 더해준다
	    }
	    
	    // 각 칼럼의 출력 간격을 설정한다
	    String[] formatStrings = new String[columnCount];
	    for (int i = 0; i < columnCount; i++) {
	        formatStrings[i] = "%-" + columnWidths[i] + "s\t";
	    }
	    
	    // 칼럼명 출력
	    for (int i = 0; i < columnCount; i++) {
	        System.out.printf(formatStrings[i], result.get(0).get(i));
	    }
	    System.out.println();
	    
	    // 구분선 출력
	    for (int i = 0; i < columnCount; i++) {
	        for (int j = 0; j < columnWidths[i]; j++) {
	            System.out.print("-");
	        }
	        System.out.print("\t");
	    }
	    System.out.println();
	    
	    // 데이터 출력
	    for (int i = 1; i < rowCount; i++) {
	        for (int j = 0; j < columnCount; j++) {
	            System.out.printf(formatStrings[j], result.get(i).get(j));
	        }
	        System.out.println();
	    }
	}

	public List<List<String>> selectQuery(String sql) throws SQLException {
		ResultSet rs = this.stmt.executeQuery(sql);
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> data = new ArrayList<String>();
		for (int i = 1; i <= columnCount; i++) {
			data.add(metaData.getColumnName(i));
		}
		result.add(data);
		while (rs.next()) {
			data = new ArrayList<String>();
			for (int i = 1; i <= columnCount; i++) {
				String columnValue = rs.getString(i);
				if (rs.getMetaData().getColumnTypeName(i).equalsIgnoreCase("DATE")) {
					columnValue = rs.getString(i) != null ? dateHandler.getFormat().format(rs.getDate(i)) : "";
				}
				data.add(columnValue);
			}
			result.add(data);
		}
		return result;
	}

	public void dmlQuery(String sql) throws SQLException {
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.executeUpdate();
		this.conn.commit();
	}

	public void dmlQuery(List<String> sqlList) throws SQLException {
		try {
			for (String sql : sqlList) {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.executeUpdate();
			}
			this.conn.commit(); // 트랜잭션 커밋
		} catch (SQLException e) {
			this.conn.rollback(); // 트랜잭션 롤백
			throw e;
		}
	}

	public void commit() throws SQLException {
		pstmt = conn.prepareStatement("commit");
		pstmt.executeUpdate();
		pstmt.close();
	}

	public void rollback() throws SQLException {
		pstmt = conn.prepareStatement("rollback");
		pstmt.executeUpdate();
		pstmt.close();
	}
}