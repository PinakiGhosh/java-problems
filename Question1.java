//Member class
class Member
{
    public String name;
    public String age;
    public String phoneNumber;
    public String address;
    public String salary;

    void getDetails(String department) //Print member details
    {
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phoneNumber);
            System.out.println("Department: " + department);
            System.out.println("Salary: " + salary);
    }
}
//Employee class
class Employee extends Member
{
    public String specialization;
    public String department;
}

//Manager class
class Manager extends Member
{
    public String specialization;
    public String department;
}

public class Question1{
    public static void main(String[] args)
    {
        Employee emp_1 = new Employee();
        Manager mgr_1 = new Manager();


        //Assign data for Employee emp_1
        emp_1.name="Employee1";
        emp_1.age="24";
        emp_1.phoneNumber="1234567891";
        emp_1.address="Employee_Address";
        emp_1.salary="100000";


        //Assign data for Manager mgr_1
        mgr_1.name="Manager1";
        mgr_1.age="30";
        mgr_1.phoneNumber="1234567892";
        mgr_1.address="Manager_Address";
        mgr_1.salary="150000";

        //Print assigned data for emp_1 and mgr_1
        emp_1.getDetails(emp_1.department);
        mgr_1.getDetails(mgr_1.department);
    }
}