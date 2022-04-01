import java.util.ArrayList;
//Member class
class Member
{
    public ArrayList<String> Data_members;
    public String Name;
    public String Age;
    public String Phone_number;
    public String Address;
    public String Salary;

    void getDetails() //Print member details
    {
            System.out.println("Name: " + Data_members.get(0));
            System.out.println("Phone: " + Data_members.get(2));
            System.out.println("Department: " + Data_members.get(6));
            System.out.println("Salary: " + Data_members.get(4));
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

        emp_1.Data_members = new ArrayList<String>();

        //Assign data for Employee emp_1 and store in data_members
        emp_1.Data_members.add(emp_1.Name="Employee1");
        emp_1.Data_members.add(emp_1.Age="24");
        emp_1.Data_members.add(emp_1.Phone_number="1234567891");
        emp_1.Data_members.add(emp_1.Address="Employee_Address");
        emp_1.Data_members.add(emp_1.Salary="100000");
        emp_1.Data_members.add(emp_1.specialization);
        emp_1.Data_members.add(emp_1.department);

        mgr_1.Data_members = new ArrayList<String>();
        //Assign data for Manager mgr_1 and store in data_members
        mgr_1.Data_members.add(mgr_1.Name="Manager1");
        mgr_1.Data_members.add(mgr_1.Age="30");
        mgr_1.Data_members.add(mgr_1.Phone_number="1234567892");
        mgr_1.Data_members.add(mgr_1.Address="Manager_Address");
        mgr_1.Data_members.add(mgr_1.Salary="150000");
        mgr_1.Data_members.add(mgr_1.specialization);
        mgr_1.Data_members.add(mgr_1.department);

        //Print assigned data for emp_1 and mgr_1
        emp_1.getDetails();
        mgr_1.getDetails();
    }
}