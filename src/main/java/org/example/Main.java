package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/academy";
        final String USER = "postgres";
        final String PASSWORD = "postgres";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement st = conn.createStatement();
            String sql = "select count(*) from student where full_name like('%a%')";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Количество студентов , в именах которых содержится буква а" +
                    " ("+rs.getInt(1)+')');

            sql = "select max(age) from student";
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Максимальный возраст ("+rs.getInt(1)+')');

            sql = "select AVG(evaluation) from student";
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Средняя оценка  студентов ("+rs.getInt(1)+')');

            sql = "select count(*) from student";
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Количество студентов ("+rs.getInt(1)+')');

            sql = "select min(age) from student";
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Самому младшему студенту ("+rs.getInt(1)+')');

            sql = "select sum(scholarship) from student";
            rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Сумма всех стипендий ("+rs.getInt(1)+')');

    }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}