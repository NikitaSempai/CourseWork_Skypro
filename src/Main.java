import ClassesToCourseWork.Employee;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int sum = 0;
    public static int indexSalary = 0;
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Афанасьев", "Никита", "Алексеевич",1,60000);
        employee[1] = new Employee("Горошенко", "Вадим", "Владимирович",1,90000);
        employee[2] = new Employee("Маслихов", "Антон", "Владимирович",1,200000);
        employee[3] = new Employee("Шевелев", "Даниил", "Александрович",2,50000);
        employee[4] = new Employee("Юсим", "Матвей", "Матвеевич",2,70000);
        employee[5] = new Employee("Филатов", "Андрей", "Вячеславович",3,10000);
        employee[6] = new Employee("Дихнич", "Степан", "Олегович",3,110000);
        employee[7] = new Employee("Андронников", "Павел", "Романович",4,20000);
        employee[8] = new Employee("Писарец", "Андрей", "Андреевич",4,90000);
        employee[9] = new Employee("Засимович", "Сергей", "Дмитриевич",5,200000);
        //список всех сотрудников
        showAllEmployees(employee);
        //сумма затрат на зп
        salarySum(employee);
        //минимальная зп
        minSalary(employee);
        //максимальная зп
        maxSalary(employee);
        // ФИО сотрудниковdf
        getFio(employee);
        //индексация зп
        indexSalary(employee,100);
        // минимальная зп в отделе
        departmentMinSalary(employee,1);
        //Максимальная зп в отделе
        departmentMaxSalary(employee,3);
        //Сумма затрат на зп в отделе
        departmentSumSalary(employee,1);
        // средняя зп в отделе
        averageDepartmentSalary(employee,1);
    }
    public static void showAllEmployees(Employee[] employee){
        for(Employee e: employee){
            System.out.println(e);
        }
    }
    public static void salarySum(Employee[] employee){
        for(Employee e: employee){
            sum += e.getEmployeeSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + sum +
                "\nСумма затрат на зарплаты за год: " + sum * 12 +
                "\nСреднее значение заработных плат: " + sum / (employee.length));
    }
    public static void minSalary(Employee[] employees){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getEmployeeSalary() == Arrays.stream(employees).mapToInt(el -> el.getEmployeeSalary()).min().getAsInt()){
                System.out.println("\nСотрудник(и) с наименьшей заработной платой: \n" + employees[i]);
            }
        }
    }
    public static void maxSalary(Employee[] employees){
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getEmployeeSalary() == Arrays.stream(employees).mapToInt(el -> el.getEmployeeSalary()).max().getAsInt()){
                System.out.println("\nСотрудник(и) с наибольшей заработной платой: \n" + employees[i]);
            }
        }
    }
    public static void getFio(Employee[] employees){
        System.out.print("\nФИО сотрудников: ");
        for(int i = 0; i < employees.length; i++){
            System.out.print("\n" + employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic());
        }
    }
    public static void indexSalary(Employee[] employees, int percent){
        if(percent <= 0) throw new IllegalArgumentException("Процент индексации должен быть больше нуля");
        System.out.println("\n\nСотрудники с проиндексированной заработной платой: ");
        for(int i = 0; i < employees.length; i++){
            indexSalary = (employees[i].getEmployeeSalary() * (percent / 100)) + employees[i].getEmployeeSalary();
            employees[i].setEmployeeSalary(indexSalary);
            System.out.println(employees[i]);
        }
    }
    public static void departmentMinSalary(Employee[] employees, int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(int i = 0; i < employees.length; i++){
            if (employees[i].getDepartmentNumber() == departmentNumber){
                if(employees[i].getEmployeeSalary() < min){
                    min = employees[i].getEmployeeSalary();
                }
            }
        }
        System.out.println("\nСотрудник(и) с минимальной заработной платой в отделе № " + departmentNumber);
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getDepartmentNumber() == departmentNumber && employees[i].getEmployeeSalary() == min){
                System.out.println(employees[i]);
            }
        }
    }
    public static void departmentMaxSalary(Employee[] employees, int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(int i = 0; i < employees.length; i++){
            if (employees[i].getDepartmentNumber() == departmentNumber){
                if(employees[i].getEmployeeSalary() > max){
                    max = employees[i].getEmployeeSalary();
                }
            }
        }
        System.out.println("\nСотрудник(и) с максимальной заработной платой в отделе № " + departmentNumber);
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getDepartmentNumber() == departmentNumber && employees[i].getEmployeeSalary() == max){
                System.out.println(employees[i]);
            }
        }
    }
    public static int departmentSumSalary(Employee[] employees, int departmentNumber){
        sum = 0;
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(int i = 0; i < employees.length; i++){
            if(employees[i].getDepartmentNumber() == departmentNumber){
                sum += employees[i].getEmployeeSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты за месяц в отделе №" + departmentNumber + ": " + sum +
                            "\nСумма затрат на зарплаты за год в отделе №" + departmentNumber + ": " + sum * 12);
        return sum;
    }
    public static void averageDepartmentSalary(Employee[] employees, int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        Object[] array = Arrays.stream(employees).filter(i -> i.getDepartmentNumber() == departmentNumber).toArray();
        System.out.println("\nСредняя зп по отделу №" + departmentNumber + " за месяц: " + departmentSumSalary(employees,departmentNumber)/array.length +
                "\nСредняя зп по отделу №" + departmentNumber + " за год: " +(departmentSumSalary(employees,departmentNumber)/array.length) * 12);
    }
}