import ClassesToCourseWork.Employee;

import java.util.Arrays;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;
    public static int sum = 0;
    public static int indexSalary = 0;
    static Employee[] employee = new Employee[10];
    public static void main(String[] args) {

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
        showAllEmployees();
        //сумма затрат на зп
        salarySum();
        //минимальная зп
        minSalary();
        //максимальная зп
        maxSalary();
        // ФИО сотрудников
        getFio();
        //индексация зп
        indexSalary(100);
        // минимальная зп в отделе
        departmentMinSalary(1);
        //Максимальная зп в отделе
        departmentMaxSalary(3);
        //Сумма затрат на зп в отделе
        departmentSumSalary(1);
        // средняя зп в отделе
        averageDepartmentSalary(1);
        //индексация зп в отделе
        indexDepartmentSalary(5, 100);
        //данные сотрудников отдела
        printAllDepartmentPersons(1);
        // зп меньше числа
        lessSalaryThenNumber(100000);
        // зп больше числа
        moreOrEqualSalaryThenNumber(100000);
    }
    public static void showAllEmployees(){
        for(Employee e: employee){
            System.out.println(e);
        }
    }
    public static void salarySum(){
        for(Employee e: employee){
            sum += e.getEmployeeSalary();
        }
        System.out.println("\nСумма затрат на зарплаты в месяц: " + sum +
                "\nСумма затрат на зарплаты за год: " + sum * 12 +
                "\nСреднее значение заработных плат: " + sum / (employee.length));
    }
    public static void minSalary(){
        for(int i = 0; i < employee.length; i++){
            if(employee[i].getEmployeeSalary() == Arrays.stream(employee).mapToInt(el -> el.getEmployeeSalary()).min().getAsInt()){
                System.out.println("\nСотрудник(и) с наименьшей заработной платой: \n" + employee[i]);
            }
        }
    }
    public static void maxSalary(){
        for(int i = 0; i < employee.length; i++){
            if(employee[i].getEmployeeSalary() == Arrays.stream(employee).mapToInt(el -> el.getEmployeeSalary()).max().getAsInt()){
                System.out.println("\nСотрудник(и) с наибольшей заработной платой: \n" + employee[i]);
            }
        }
    }
    public static void getFio(){
        System.out.print("\nФИО сотрудников: ");
        for(Employee employee: employee){
            System.out.print("\n" + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        }
    }
    public static void indexSalary(int percent){
        if(percent <= 0) throw new IllegalArgumentException("Процент индексации должен быть больше нуля");
        System.out.println("\n\nСотрудники с проиндексированной заработной платой: ");
        for(Employee employee: employee){
            indexSalary = (employee.getEmployeeSalary() * (percent / 100)) + employee.getEmployeeSalary();
            employee.setEmployeeSalary(indexSalary);
            System.out.println(employee);
        }
    }
    public static void departmentMinSalary(int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(Employee employee: employee){
            if (employee.getDepartmentNumber() == departmentNumber){
                if(employee.getEmployeeSalary() < min){
                    min = employee.getEmployeeSalary();
                }
            }
        }
        System.out.println("\nСотрудник(и) с минимальной заработной платой в отделе № " + departmentNumber);
        for(Employee employee: employee){
            if(employee.getDepartmentNumber() == departmentNumber && employee.getEmployeeSalary() == min){
                System.out.println(employee);
            }
        }
    }
    public static void departmentMaxSalary(int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(Employee employee: employee){
            if (employee.getDepartmentNumber() == departmentNumber){
                if(employee.getEmployeeSalary() > max){
                    max = employee.getEmployeeSalary();
                }
            }
        }
        System.out.println("\nСотрудник(и) с максимальной заработной платой в отделе № " + departmentNumber);
        for(Employee employee: employee){
            if(employee.getDepartmentNumber() == departmentNumber && employee.getEmployeeSalary() == max){
                System.out.println(employee);
            }
        }
    }
    public static int departmentSumSalary(int departmentNumber){
        sum = 0;
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(Employee employee: employee){
            if(employee.getDepartmentNumber() == departmentNumber){
                sum += employee.getEmployeeSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты за месяц в отделе №" + departmentNumber + ": " + sum +
                            "\nСумма затрат на зарплаты за год в отделе №" + departmentNumber + ": " + sum * 12);
        return sum;
    }
    public static void averageDepartmentSalary( int departmentNumber){
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        Object[] array = Arrays.stream(employee).filter(i -> i.getDepartmentNumber() == departmentNumber).toArray();
        System.out.println("\nСредняя зп по отделу №" + departmentNumber + " за месяц: " + departmentSumSalary(departmentNumber)/array.length +
                "\nСредняя зп по отделу №" + departmentNumber + " за год: " +(departmentSumSalary(departmentNumber)/array.length) * 12);
    }
    public static void indexDepartmentSalary(int departmentNumber, int percent){
        if(percent <= 0)
        {
            throw new IllegalArgumentException("Процент индексации должен быть больше нуля");
        }
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        System.out.println("\n\nСотрудники с проиндексированной заработной платой из отдела № " + departmentNumber);
        for(Employee employee: employee){
            if (employee.getDepartmentNumber() == departmentNumber){
                indexSalary = (employee.getEmployeeSalary() * (percent / 100)) + employee.getEmployeeSalary();
                employee.setEmployeeSalary(indexSalary);
                System.out.println(employee);
            }
        }
    }
    public static void printAllDepartmentPersons(int departmentNumber){
        System.out.println("\n\nСотрудники отдела № " + departmentNumber);
        if(departmentNumber < 1 || departmentNumber > 5){
            throw new IllegalArgumentException("Некорректный номер отдела");
        }
        for(Employee employee: employee){
            if (employee.getDepartmentNumber() == departmentNumber){
                System.out.println("Сотрудник №: " + employee.getId() +
                        "\nФИО сотрудника: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() +
                        "\nЗаработная плата сотрудника: " + employee.getEmployeeSalary());
            }
        }
    }
    public static void lessSalaryThenNumber(int number){
        if(number <= 0)
        {
            throw new IllegalArgumentException("Зп не может быть отрицательной");
        }
        System.out.println("\n\nСотрудники с зп меньше чем " + number);
        for(Employee employee: employee){
            if (employee.getEmployeeSalary() < number){
                System.out.println("Сотрудник №: " + employee.getId() +
                        "\nФИО сотрудника: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() +
                        "\nЗаработная плата сотрудника: " + employee.getEmployeeSalary());
            }
        }
    }
    public static void moreOrEqualSalaryThenNumber(int number){
        if(number <= 0)
        {
            throw new IllegalArgumentException("Зп не может быть отрицательной");
        }
        System.out.println("\n\nСотрудники с зп больше чем " + number);
        for(Employee employee: employee){
            if (employee.getEmployeeSalary() >= number){
                System.out.println("Сотрудник №: " + employee.getId() +
                        "\nФИО сотрудника: " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() +
                        "\nЗаработная плата сотрудника: " + employee.getEmployeeSalary());
            }
        }
    }
}