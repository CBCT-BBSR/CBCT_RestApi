package com.java.crud.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.java.crud.model.StudentRowMapper;
import com.java.crud.model.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @SuppressWarnings("unchecked")
	public List<Student> getStudent(){
        return  jdbcTemplate.query("select student_no,student_name,student_id,password,email,branch,department,school,academic_year,batch_id from student",new StudentRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Student findById(Integer studentid){

        String sql = "SELECT * FROM student WHERE STUDENT_ID = ?";
        try{
            return  (Student) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { studentid }, new StudentRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveStudent(Student student){
        String query="insert into student values(?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, student.getStudent_no());
                ps.setString(2,student.getStudent_name());
                ps.setInt(3,student.getStudent_id());
                ps.setString(4,student.getPassword());
                ps.setString(5,student.getEmail());
                ps.setString(6,student.getBranch());
                ps.setString(7,student.getDepartment());
                ps.setString(8,student.getSchool());
                ps.setString(9,student.getAcademic_year());
                ps.setString(10,student.getBatch_id());
                
             return ps.execute();

            }
        });
    }

    public Integer updateStudent(Student student){
        String query="update student set student_no = ?,student_name = ? , password = ? , email = ?, branch = ? , department = ? , school = ? , academic_year = ? , batch_id = ? where student_id = ?";
        Object[] params = {student.getStudent_no(),student.getStudent_name() ,student.getPassword(),student.getEmail(),student.getBranch(),student.getDepartment(),student.getSchool(),student.getAcademic_year(), student.getBatch_id(),student.getStudent_id()};
        int[] types = {Types.INTEGER,Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteStudentById(Integer student_id){
        return jdbcTemplate.update("delete from student where student_id = ?",student_id);
    }
}
