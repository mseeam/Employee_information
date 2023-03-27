/**
 * The program simply shows information of employee, such as Employee name, id, hiring date, shift, and pay rate.
 * @author Mohammad Seeam
 */

//To take user inpur
import java.util.Scanner;


/* Employee class contains all necessary methods to set and get employee name, id and hiring date */
class Employee{
    //To hold employee name
    private String employee_name;
    //To hold id
    private String employee_number_XXX_L;
    //To hold date
    private String hire_date;

    /* default constructor and we hardcoded some fixed value */
    Employee() {
        this.employee_name="John Smith";
        this.employee_number_XXX_L = "123-A";
        this.hire_date = "01/01/2022";
    }

    /* constructor that takes argument from user */
    Employee(String employee_name, String hiring_date, String employee_number) {
        this.employee_name=employee_name;
        this.employee_number_XXX_L = employee_number;
        this.hire_date = hiring_date;
    }

    /* getter method to get/return employee name */
    public String get_name() {
        return this.employee_name;
    }

    /* getter method to get/return employee number */
    public String get_number() {
        return this.employee_number_XXX_L;
    }

    /* getter method to get/return employee hiring date */
    public String get_date() {
        return this.hire_date;
    }

    /* setter method to set employee name */
    public void setEmployeeName(String name) {
        this.employee_name = name;
    }

    /* setter method to set employee number */
    public void setEmployeeNumber(String employee_number) {
        this.employee_number_XXX_L = employee_number;
    }

    /* setter method to set employee hiring date */
    public void setHireDate(String date) {
        this.hire_date = date;
    }
}

/* ProductionWorker class contains all necessary methods to set and get shift and pay rate.
*  ProductionWorker extends Employee */
class ProductionWorker extends Employee{
    //To store/hold shift value
    private int shift;
    //To store or hold pay rate value
    private double pay_rate;
    /* Default constructor which hardcoded shift and pay rate value */
    ProductionWorker(){
        this.shift = 1;
        this.pay_rate = 15.5;
    }

    /* Constructor that takes argument from user and set value */
    ProductionWorker(String employee_name, String employee_number, String date, int shift, double pay_rate) {
        //Passing employee_name, employee_number and date to Employee class.
        super(employee_name,employee_number,date);
        if(shift==1 || shift==2){
            this.shift = shift;
        }else{
            this.shift=1;
        }
        this.pay_rate = pay_rate;
    }

    /* setter method to set shift */
    public void setShift(int shift) {
        this.shift = shift;
    }

    /* setter method to set pay rate */
    public void setPayRate(double pay_rate) {
        this.pay_rate = pay_rate;
    }

    /* Getter method to get shift */
    public int getShift() {
        return this.shift;
    }

    /* Getter method to get pay rate */
    public double getPayRate() {
        return this.pay_rate;
    }
}


/* Test class contains all necessary methods to test and use Employee and ProductionWorker classes */

class Test_employee {

    /* main function below */
    public static void main(String[] args) {
        //shift_from_user to store shift value (0 or 1)
        Integer shift_from_user=0;
        System.out.println("Press 1, if you want to set all values by yourself ! ");
        System.out.println("Press 2, if you want to see default constructor hardcoded values ! ");
        Scanner in=new Scanner(System.in);
        //option to take option from user
        Integer option=in.nextInt();
        //Using switch because the program either print values taken from user or hardcoded values
        switch (option){
            //If user press 1, user can place/input values
            case 1:
                System.out.println("Please enter the Employee name: ");
                //employee_name_from_user to store employee name
                String employee_name_from_user=in.next();
                //employee_number_from_user to store employee number
                String employee_number_from_user="";
                //proceed will false when we need to stop the while loop
                Boolean proceed = true;
                //sec_proceed will false when we need to stop the while loop
                Boolean sec_proceed=true;
                while(proceed){
                    while(sec_proceed) {
                        System.out.println("Please enter the Employee number, Format (XXX–L): ");
                        //employee_number_from_user to store employee number/id
                        employee_number_from_user = in.next();
                        if (employee_number_from_user.length() != 5) {
                            System.out.println("Your Employee number is bigger or less than than actual format XXX–L");
                        }else{
                            break;
                        }
                    }

                    //The last index of employee_number_from_user to check if it is in range A-M
                    char last = employee_number_from_user.charAt(employee_number_from_user.length() - 1);
                    //The first index of employee_number_from_user to check if it is integer
                    char first = employee_number_from_user.charAt(0);
                    //The second index of employee_number_from_user to check if it is integer
                    char second = employee_number_from_user.charAt(1);
                    //The third index of employee_number_from_user to check if it is integer
                    char third = employee_number_from_user.charAt(2);
                    //The third index of employee_number_from_user to check if it (-) sign
                    char sign = employee_number_from_user.charAt(3);

                    //These below logic is to check if employee_number_from_user is valid or not
                    if(!Character.isDigit(first) || !Character.isDigit(second) || !Character.isDigit(third)){
                        System.out.println("Employee number has format XXX–L, where each X is a digit within the range 0–9. Place numeric value for each X for your Employee number !");
                    }else if(sign != '-'){
                        System.out.println("Employee number has format XXX–L, Place correct sign (-) after XXX numeric value !");
                    }else if ( last >= 'M') {
                        System.out.println("XXX–L, L is a letter within the range A–M (UPPER CASE). Try again !");
                    }else{
                        proceed=false;
                    }
                }
                System.out.println("Please enter the hiring date, Format: (01/01/2023): ");
                //To store date
                String date_from_user=in.next();
                //When shift_proceed is false, while loop will stop.
                Boolean shift_proceed = true;
                while(shift_proceed==true) {
                    System.out.println("Please enter the shift (Press 1 for day or 2 for night): ");
                    shift_from_user = in.nextInt();
                    if (shift_from_user == 1 || shift_from_user == 2) {
                        shift_proceed=false;
                    }else{
                        System.out.println("Your value is not 1 or 2. Please enter correct shift (Press 1 or 2):");
                    };
                }
                System.out.println("Please enter the payrate: ");
                //payrate_from_user to hold pay rate
                Double payrate_from_user=in.nextDouble();
                //We must make an object to use our values. Our object is called my_obj();
                //We have taken all necessary values from user, now pass out values to my_obj();
                ProductionWorker my_obj = new ProductionWorker(employee_name_from_user, employee_number_from_user, date_from_user, shift_from_user,payrate_from_user);
                //Printing our values by calling object and functions
                System.out.println("Employee Name : " + my_obj.get_name());
                System.out.println("Employee Number : " + my_obj.get_number());
                System.out.println("Hiring Date : " + my_obj.get_date());
                System.out.println("Shift : " + my_obj.getShift());
                System.out.println("Payrate : " + my_obj.getPayRate());
                System.exit(0);

            case 2:

                //If user choose option/case 2, they can see hardcoded values
                //We must make an object to use our values. Our object is called my_obj_default();
                //When we will call my_obj_default() and getter functions, our hardcoded values of constructors will get printed.
                ProductionWorker my_obj_default = new ProductionWorker();
                System.out.println("Employee Name : " + my_obj_default.get_name());
                System.out.println("Employee Number : " + my_obj_default.get_number());
                System.out.println("Hiring Date : " + my_obj_default.get_date());
                System.out.println("Shift : " + my_obj_default.getShift());
                System.out.println("Payrate : " + my_obj_default.getPayRate());
                System.exit(0);

        }
    }
}

//Output is given below:

/*
Press 1, if you want to set all values by yourself !
Press 2, if you want to see default constructor hardcoded values !
1
Please enter the Employee name:
Mohammad
Please enter the Employee number, Format (XXX–L):
1q2=z
Employee number has format XXX–L, where each X is a digit within the range 0–9. Place numeric value for each X for your Employee number !
Please enter the Employee number, Format (XXX–L):
123=Z
Employee number has format XXX–L, Place correct sign (-) after XXX numeric value !
Please enter the Employee number, Format (XXX–L):
555-Z
XXX–L, L is a letter within the range A–M (UPPER CASE). Try again !
Please enter the Employee number, Format (XXX–L):
369-A
Please enter the hiring date, Format: (01/01/2023):
03/01/2023
Please enter the shift (Press 1 for day or 2 for night):
7
Your value is not 1 or 2. Please enter correct shift (Press 1 or 2):
Please enter the shift (Press 1 for day or 2 for night):
1
Please enter the payrate:
15.5
Employee Name : Mohammad
Employee Number : 03/01/2023
Hiring Date : 369-A
Shift : 1
Payrate : 15.5
*/