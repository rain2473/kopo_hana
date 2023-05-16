<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*, javax.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
    <h1>Employee List</h1>

    <%-- JDBC 연결 정보 --%>
    <%!
        private Connection getConnection() throws Exception {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:/comp/env/jdbc/dink22");
            Connection conn = ds.getConnection();
            return conn;
        }
    %>

    <%-- 데이터베이스 연결 및 쿼리 실행 --%>
    <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM emp");
    %>

    <%-- 쿼리 결과 표시 --%>
    <table border="1">
        <tr>
            <th>EMPNO</th>
            <th>ENAME</th>
            <th>JOB</th>
            <th>DEPTNO</th>
        </tr>
        <% while (rs.next()) { %>
            <tr>
                <td><%= rs.getInt("EMPNO") %></td>
                <td><%= rs.getString("ENAME") %></td>
                <td><%= rs.getString("JOB") %></td>
                <td><%= rs.getInt("DEPTNO") %></td>
            </tr>
        <% } %>
    </table>

    <%-- 예외 처리 --%>
    <%
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    %>

</body>
</html>