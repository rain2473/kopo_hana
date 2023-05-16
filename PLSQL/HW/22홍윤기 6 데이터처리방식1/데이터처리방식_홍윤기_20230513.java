package DatabaseExam;

import java.sql.*;
import oracle.jdbc.driver.*;
import java.util.*;
import java.util.function.IntPredicate;

public class ConnectODBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 접속하는 DBMS의 IP 주소와 포트, SID 번호
		String url = "jdbc:oracle:thin:@//172.30.1.95:1521/dink22";
        // 유저 이름
		String user = "C##scott";
        // 비밀번호
		String password = "tiger";
        // 사용하는 JDBC 드라이버
		Class.forName("oracle.jdbc.driver.OracleDriver");
        // 위의 정보로 connection 객체 생성
		Connection conn = DriverManager.getConnection(url, user, password);
        // statement 생성
		Statement stmt = conn.createStatement();
        // autoCommit을 해재한다. => Transaction의 원자성을 위하여
		conn.setAutoCommit(false);
		
        // 저장할 Bonus 테이블의 요소들 변수 선언
		String ename;
		String job;
		int sal;
		int comm;
        // Group By를 사용하지 않고 570만여건을 실제로 하나하나 처리하므로, HashMap 방식을 채택하면 편하다.
		HashMap<Integer,Integer> customerNum = new HashMap<Integer,Integer>();
		
        // customer 테이블을 조회하는 쿼리
		String query1 = "select MGR_EMPNO from customer";
        // emp 테이블을 조회하는 쿼리
		String query2 = "select * from emp";
		// 이후에 Bonus 테이블을 변경할 때 쓸 dml 명령 미리 선언
        String dml;
		
        // 요청이 시작되는 순간의 시간
		long startTime = System.currentTimeMillis();
        // 쿼리1 요청 시작
		ResultSet rs = stmt.executeQuery(query1);
        // fetch를 1만으로 둠(실험 과정에서 바꿈)
		rs.setFetchSize(10000);
        // 데이터가 있는한 반복
		while (rs.next()) {
            // 받은 데이터의 MGR_EMPNO가 HashMap의 키로서 존재할 경우(HashMap에 담당자 이미 있는 경우)
			if (customerNum.containsKey(rs.getInt("MGR_EMPNO"))) {
                // 해당 담당자의 고객 + 1
				customerNum.put(rs.getInt("MGR_EMPNO"), customerNum.get(rs.getInt("MGR_EMPNO")) + 1);
			}
            // 받은 데이터의 MGR_EMPNO가 HashMap의 키로서 존재하지 않는 경우(HashMap에 담당자 없는 경우)
			else {
                // 해당 담장자의 고객을 0으로 해 HashMap에 추가
				customerNum.put(rs.getInt("MGR_EMPNO"), 0);
			}
		}
        //쿼리2 요청 시작
		rs = stmt.executeQuery(query2);
		while (rs.next()) {
			// emp 테이블에 대해, Bonus테이블의 변경에 필요한 요소만 변수로 저장
			ename = rs.getString("ename");
			job = rs.getString("job");
			sal = rs.getInt("sal");
            // 예외처리 필요하다
			try {
                // 해당사번의 직원에 대해 보너스 계산 함수를 적용한다.
				comm = rs.getInt("comm") + calculateComm(rs.getString("job"), customerNum.get(rs.getInt("EMPNO")));
			// president의 경우 담당 고객이 없으므로, null이 반환되어 오류가 발생
            } catch(NullPointerException e) {
                // 이 경우 담당 고객수를 0으로 하고 보너스를 계산, HashMap에도 이를 저장한다.
				comm = rs.getInt("comm") + calculateComm(rs.getString("job"), 0);
				customerNum.put(rs.getInt("EMPNO"), 0);
			}
            // 해당 사원의 보너스 관련 정보를 Bonus 테이블에 저장하는 SQL
			dml = "insert into bonus(ename, job, sal, comm) values ('" + ename + "', '" + job + "', " + sal + ", "
					+ comm + ")";
            // 위의 dml 실행
			PreparedStatement pstmt = conn.prepareStatement(dml);
			pstmt.executeUpdate();
            // print도 해줌
			System.out.println(ename + ", " + job + ", " + sal + ", " + comm + ", " + customerNum.get(rs.getInt("EMPNO")));
		}
        // Transaction이 무사히 끝나면 커밋 -> 어차피 문제 있으면 이 앞에서 오류 던지므로 예외처리는 생략
		conn.commit();

        // 요청이 종료된 시점의 시간
		long endTime = System.currentTimeMillis();
        // 둘을 빼서 소요시간 계산
		long executionTime = endTime - startTime;
        // 소요시간 출력
		System.out.println("소요시간 : " + executionTime + "ms");
        // 꺼줄거 꺼줌
		rs.close();
		stmt.close();
		conn.close();
	}

    // 보너스를 계산하는 함수 - 직급과 담당 고객수를 바탕으로 판단하므로 이를 인자로 넣어준다.
	public static int calculateComm(String job, int customerNum) {
        // PRESIDENT와 ANALYST는 보너스 지급 안함
		if (job.equals("PRESIDENT") || job.equals("ANALYST")) {
			return 0;
        // 담당 고객이 10만명 미만이면 보너스 1000
		} else if (customerNum < 100000) {
			return 1000;
        // 담당 고객이 10만명 이상이면 보너스 2000
		} else {
			return 2000;
		}
	}
}
