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
        Employee emp = new Employee();
        Manager mgr = new Manager();


        //Assign data for Employee emp
        emp.name="Employee1";
        emp.age="24";
        emp.phoneNumber="1234567891";
        emp.address="Employee_Address";
        emp.salary="100000";


        //Assign data for Manager mgr
        mgr.name="Manager1";
        mgr.age="30";
        mgr.phoneNumber="1234567892";
        mgr.address="Manager_Address";
        mgr.salary="150000";

        //Print assigned data for emp and mgr
        emp.getDetails(emp.department);
        mgr.getDetails(mgr.department);
    }
}