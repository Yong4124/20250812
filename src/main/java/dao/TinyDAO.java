package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TinyDTO;

public class TinyDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {  // DBMS 접속
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "scott", "tiger");
        return conn;
    }

    // 전체 목록 조회
    public List<TinyDTO> selectList() {
        List<TinyDTO> list = new ArrayList<TinyDTO>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tiny");
            while (rs.next()) {
                int num = rs.getInt("num");
                String content = rs.getString("content");
                list.add(new TinyDTO(num, content));
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
            }
        }

        return list;
    }

    // 한 건 입력
    public void insertOne(TinyDTO dto) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(String.format("INSERT INTO tiny(num, content) VALUES (tiny_seq.nextval, '%s')", dto.getContent()));

        } catch (SQLException e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
            }
        }
    }

    // 특정 번호 하나 조회
    public TinyDTO selectOne(int num) {
        TinyDTO dto = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tiny WHERE num = " + num);
            if (rs.next()) {
                String content = rs.getString("content");
                dto = new TinyDTO(num, content);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("selectOne 오류: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
            }
        }

        return dto;
    }

    // 특정 번호의 게시글 수정
    public void update(int num, String content) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = String.format("UPDATE tiny SET content = '%s' WHERE num = %d", content, num);
            stmt.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("update 오류: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
            }
        }
    }

    // 특정 번호의 게시글 삭제
    public void delete(int num) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM tiny WHERE num = " + num);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("delete 오류: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스를 닫는 도중 오류 발생: " + e.getMessage());
            }
        }
    }
}
