package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

//this class will work with table Employee DAO = data access object
@Repository
public class EmployeeDao extends JdbcDaoSupport {




  /*  JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Autowired
    public EmployeeDao(DataSource dataSource) {
        setDataSource(dataSource);
    }


    public void executeSomeQuery() {

        getJdbcTemplate().execute("select 1 from dual");
    }

    public void createTable(){
        getJdbcTemplate().execute("CREATE TABLE Employee (\n" +
                "    employee_id INT PRIMARY KEY,\n" +
                "    name VARCHAR(255),\n" +
                "    department VARCHAR(255)\n" +
                ");");
    }

    public void insertEmployee(int id , String name , String department) {
        //not good way to write query
//        jdbcTemplate.execute(String.format("insert into Employee values ('%d', '%s', '%s')", id, name, department));
        int updatedRows = getJdbcTemplate().update("insert into Employee values (?, ?, ?)", id, name, department);
        System.out.println("Updated rows " + updatedRows);
    }

    public void updateEmployeeName(String newName, int id) {
        int updatedRows = getJdbcTemplate().update("update Employee set name = ? where employee_id = ?", newName, id);
        System.out.println("Updated rows " + updatedRows);
    }

    public String getEmployeeNameById(int id) {
        String name = getJdbcTemplate().queryForObject(String.format("select name from Employee where employee_id = %d ", id), String.class);
        System.out.println("the name is: " + name);
        return  name;
    }

    public List findAll() {
        List result = getJdbcTemplate().queryForList("select * from employee");
        System.out.println(result);
        return result;
    }





}
