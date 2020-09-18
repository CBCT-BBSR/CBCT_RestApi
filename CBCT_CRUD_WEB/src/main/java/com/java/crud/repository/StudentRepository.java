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
        return  jdbcTemplate.query("select studentno,studentid,studentname,password,academic_year,emailid,school,branch,department from student",new StudentRowMapper());
    }

    @SuppressWarnings("unchecked")
	public Student findById(Integer studentid){

        String sql = "SELECT * FROM student WHERE STUDENTID = ?";
        try{
            return  (Student) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { studentid }, new StudentRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean saveStudent(Student student){
        String query="insert into student values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(1, student.getStudentno());
                ps.setInt(2,student.getStudentid());
                ps.setString(3,student.getStudentname());
                ps.setString(4,student.getPassword());
                ps.setString(5,student.getAcademic_year());
                ps.setString(6,student.getEmailid());
                ps.setString(7,student.getSchool());
                ps.setString(8,student.getBranch());
                ps.setString(9,student.getDepartment());

                return ps.execute();

            }
        });
    }

    public Integer updateStudent(Student student){
        String query="update student set studentno = ?,studentname = ? , password = ? , academic_year = ? , emailid = ? , school = ? , branch = ? , department = ? where studentid = ?";
        Object[] params = {student.getStudentno(),student.getStudentname() ,student.getPassword(),student.getAcademic_year(),student.getEmailid(),student.getSchool(),student.getBranch(), student.getDepartment(),student.getStudentid()};
        int[] types = {Types.INTEGER,Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};

        return jdbcTemplate.update(query, params, types);
    }

    public Integer deleteStudentById(Integer studentid){
        return jdbcTemplate.update("delete from student where studentid = ?",studentid);
    }
}
