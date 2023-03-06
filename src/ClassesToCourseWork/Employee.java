package ClassesToCourseWork;

import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int departmentNumber;
    private int employeeSalary;
    private static int tempId = 1;
    private int id;
    public Employee(String surname, String name, String patronymic, int departmentNumber, int employeeSalary){
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.departmentNumber = departmentNumber;
        this.employeeSalary = employeeSalary;
        this.id = tempId;
        tempId++;
    }
    public void setDepartmentNumber(int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
          throw new IllegalArgumentException("Некорректный номер отдела");
        }
        this.departmentNumber = departmentNumber;
    }
    public void setEmployeeSalary(int employeeSalary){
        if(employeeSalary <= 0){
            throw new IllegalArgumentException("Зарплата не может быть отрицательной или нулем");
        }
        this.employeeSalary = employeeSalary;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getName(){
        return this.name;
    }
    public String getPatronymic(){
        return this.patronymic;
    }
    public int getDepartmentNumber(){
        return this.departmentNumber;
    }
    public int getEmployeeSalary(){
        return this.employeeSalary;
    }
    public int getId() {
        return this.id;
    }
    @Override
    public String toString(){
        return "Сотрудник №: " + this.id +
                "\nФИО сотрудника: " + this.surname + " " + this.name + " " + this.patronymic +
                "\nОтдел сотрудника: " + this.departmentNumber +
                "\nЗаработная плата сотрудника: " + this.employeeSalary;
    }
}
