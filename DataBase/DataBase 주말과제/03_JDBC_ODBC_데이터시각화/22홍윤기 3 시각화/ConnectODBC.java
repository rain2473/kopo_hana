package DatabaseExam;

import java.sql.*;
import oracle.jdbc.driver.*;

import java.util.*;
import java.util.function.IntPredicate;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class ConnectODBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String user = "scott";
		String password = "tiger";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement stmt = conn.createStatement();
		String sortby = "어린이집";
		String sql = "SELECT joined.지자체, joined.어린이집, joined.열린육아방, city_kiwoom.우리동네키움센터, joined.국공립비율, joined.무료육아방비율, city_kiwoom.무료키움센터비율\n"
				+ "FROM (SELECT city_day.지자체, city_day.어린이집, city_day.국공립비율, city_open.열린육아방, city_open.무료육아방비율\n"
				+ "FROM city_day\n"
				+ "LEFT OUTER JOIN\n"
				+ "city_open\n"
				+ "ON city_day.지자체 = city_open.지자체\n"
				+ ") joined\n"
				+ "LEFT OUTER JOIN\n"
				+ "city_kiwoom\n"
				+ "ON joined.지자체 = city_kiwoom.지자체\n"
				+ "order by " + sortby + " desc";
		ResultSet rs = stmt.executeQuery(sql);
		List <String> region = new ArrayList<String>();
		List <Integer> daycare = new ArrayList<Integer>();
		List <Integer> open = new ArrayList<Integer>();
		List <Integer> kiwoom = new ArrayList<Integer>();
		while (rs.next()) {
			// get values from each column in the current row
			region.add(rs.getString("지자체"));
			daycare.add(rs.getInt("어린이집"));
			open.add(rs.getInt("열린육아방"));
			kiwoom.add(rs.getInt("우리동네키움센터"));
		    
		    // process the data for the current row
		    System.out.println("지역 : " + region + "의 어린이집 수 : " + daycare + ",열린육아방 수 : " + open + ",우리동네키움센터 수 : " + kiwoom + "입니다.");
		}
		
		// Create the chart
	    CategoryChart chart =
	        new CategoryChartBuilder()
	            .title("지자체별 어린이집 수")
	            .xAxisTitle("지자체")
	            .yAxisTitle("어린이")
	            .build();

	    // Add the data to the chart
	    chart.addSeries("지자체별 어린이집 수", region, daycare);

	    // Customize the chart
	    chart.getStyler().setLegendVisible(false);

	    // Display the chart
	    new SwingWrapper<>(chart).displayChart();
	
	conn.close();}
}
