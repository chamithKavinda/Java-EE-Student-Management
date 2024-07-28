package lk.ijse.gdse68.studentmanagement.dao;

import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse68.studentmanagement.Controller.Student;
import lk.ijse.gdse68.studentmanagement.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public final class StudentDAOIMPL implements StudentDAO {
    public static String SAVE_STUDENT = "INSERT INTO student (id,name,email,city,level) VALUES(?,?,?,?,?)";

    @Override
    public String saveStudent(StudentDTO student, Connection connection) throws Exception {
        try {
            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCity());
            ps.setString(5, student.getLevel());
            if(ps.executeUpdate() != 0){
                return "Student Save Successfully";
            }else {
                return "Failed to Save Student";
            }
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(String id, Connection connection) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(String id, StudentDTO student, Connection connection) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getStudent(String id, Connection connection) throws Exception {
        return null;
    }
}
