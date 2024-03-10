package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeDao employeeDao = applicationContext.getBean(EmployeeDao.class);
//        employeeDao.executeSomeQuery();
//        employeeDao.createTable();
//        employeeDao.insertEmployee(4, "Sansa", "Cleaning");
//        employeeDao.updateEmployeeName("Robert", 4);
//        employeeDao.getEmployeeNameById(2);
        employeeDao.findAll();
    }
}