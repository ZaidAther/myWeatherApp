import java.util.*;
import java.io.*;

interface Profile{  
    public void Name();  
    public void ID();
    public void Age();
}  

class Person implements Profile {
    public String name;
    public int id;
    public int age;
    
    
    public Person(String name,int id,int age){
      this.name=name;
      this.id=id;
      this.age=age;
    }
       
       public void ID() {
        System.out.println(id); 
    }

        public void Name() {
        System.out.println(name);
    }
    
        public void Age() {
        System.out.println(age);
    }
      
    public String toString(){
      return "the name is:"+this.name +"the id is :"+this.id+"the age is :"+this.age;
    }
}

class Address extends Person{
    
    public int house_no;
    public int street;
    public String block;
    public String town;
    public Address(String name,int id,int age,int house_no,int street,String block,String town){
        super(name,id,age);
        this.house_no=house_no;
        this.street=street;
        this.block=block;
        this.town=town;
    }
    
    public String toString(){
            return "Name: "+this.name+ "\n" +"ID: "+this.id+"\n" + "GetAge: "+this.age + "\n" + "House number is " +  this.house_no
            + "\n" + "Street number " + this.street + "\n" + "Block: " +this.block+ "\n" + "Town "+ this.town;
    }
}

class Staff extends Person{
    public String Position;
    public int Pay;
    public int Final_Pay=0;
    public int Working_hours;
    public Staff(String name,int id,int age,String Position, int Working_hours){
        super(name,id,age);
        this.Position=Position;
        this.Working_hours=Working_hours;
        this.Final_Pay=0;
}


    public String GetPosition(){
        return Position;
}
    public void FinalPay(int Pay){
        Final_Pay+=Pay;
        SchoolAccountsOffice.updateTotalMoneySpent(Pay);
    
}
    public void GetHours(){
    System.out.println(Working_hours+"Hours");
}
    public int GetPay(){
        return Pay;
    }
    
    public String toString(){
        return "Staff Name "+name+" of "+age+" Years old "+" working as "+Position+" Having Income "+Final_Pay;
    }

}


class Student extends Person{
    
    public char grade;
    public int Paid_Fees;
    public int TotalDues;

    public Student(String name,int id,int age,char grade){
        super(name,id,age);
        this.Paid_Fees=0;
        this.TotalDues=40000;
        this.grade=grade;
    }
    public void setGrade(char grade){
        this.grade=grade;
    }
    public void payDues(int fees){
        Paid_Fees+=fees;
        SchoolAccountsOffice.updateTotalMoneyEarned(Paid_Fees);
    }
    
    public void Scholorship(int s_ship){
        TotalDues-=s_ship;
    }

    public char setGrade() {
        return grade;
    }
    public int GetpaidDues() {
        return Paid_Fees;
    }
    public int GetDues() {
        return TotalDues;
    }
    public int GetremainingPayable(){
        return TotalDues-Paid_Fees;
    }
    public String toString() {
        return "Fees Paid so far $" +Paid_Fees+" by Student: " + name+"\n";
    }
}

class Teacher extends Person {

    public int salary;
    public int salaryEarned;
    public int bonus;

    public Teacher(String name,int id,int age, int salary){
        super(name,id,age);
        this.salary=salary;
        this.salaryEarned=0;
    }
    
    
    public void BonusPay(int bonus){
        salaryEarned+=bonus;
        SchoolAccountsOffice.updateTotalMoneySpent(bonus);
    }
    
    public int getbonus(){
        return bonus;
    }
    
    public int GetPay(){
        return  salary;
    }

    public void SetPay(int salary){ 
        this.salary=salary;
    }

    public void ReceivedPay(int salary){
        salaryEarned+=salary;
        SchoolAccountsOffice.updateTotalMoneySpent(salary);
    }

    public String toString() {
        return "Salary earned so far $" + salaryEarned +" by Teacher: " + name+"\n";
                
    }
    
}

class SchoolAccountsOffice{

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Staff> staffs;
    private static int  TotalCashRecived;
    private static int Totalcashspent;

    public SchoolAccountsOffice(ArrayList<Teacher> teachers, ArrayList<Student> students,ArrayList<Staff> staffs) {
        this.teachers = teachers;
        this.students = students;
        this.staffs=staffs;
        TotalCashRecived=0;
        Totalcashspent=0;
    }

    public int GetTotalCashRecived() {
        return TotalCashRecived;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        TotalCashRecived += MoneyEarned;
    }

    public int GetTotalcashspent() {
        return Totalcashspent;
    }

    public static void updateTotalMoneySpent(int moneySpent) {
        TotalCashRecived-=moneySpent;
     }
}

class Institute{
    
    String Schoolname;
 
    public void setname(){
    Scanner sc10= new Scanner(System.in);
    System.out.println("Kindly Enter the School Name: ");
    String bn=sc10.nextLine();
    Schoolname=bn;
    }
    
       public String getname(){
            return Schoolname;
         
    }
}


class Main {
    
    public static void main(String[] args) {
           
     Scanner sc= new Scanner(System.in);
      sn.setname();
        
    int a=0;
    
    while (a!=5){
            
        System.out.print("Select option\n Main Menu\n"); 
        System.out.println("1 Student's Information ");
        System.out.println("2 Add & Display Student info");
        System.out.println("3 Add & Display Teacher info");
        System.out.println("4 Add & Display Staff info");
        System.out.println("5 Exit the system:");
        
        a= sc.nextInt();
        
        if (a==1){
            StudentInfo();
        }
    
       else if (a==2){
            AddStudent();
        }
        
       else if (a==3){
            AddTeacher();
       }
        
       else if (a==4){
            AddStaff();
        }
        else if (a==5){
            break;
        }
          
    }
        }
        
    static ArrayList<Teacher> teacherList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    static ArrayList<Address> Addresslist = new ArrayList<>();
    
         
             
    static SchoolAccountsOffice sc1 = new SchoolAccountsOffice(teacherList,studentList,staffList);
    static Institute sn=new Institute();
  
   public static void StudentInfo(){
        
    try{
        
      FileWriter num1 =new FileWriter("Address.txt",true);
        int so=0;
        Scanner sc11= new Scanner(System.in);
      
       while (so!=4){
              
        System.out.println("Kindly Enter the Person who's Address is being Entered ");
        System.out.println("1 Students Address ");
        System.out.println("2 Teacher Address");
        System.out.println("3 Staff Address");
        System.out.println("4 To Submit & Enter to the Main menu");
            

         so= sc11.nextInt();
        if (so==1){
               num1.write("------------");
        System.out.println("Enter Student  Name : ");
        String aa=sc11.next();
        System.out.println("Enter Student  ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Student  Age: ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        
        System.out.println("Enter Student  House Number: ");
        int a3=sc11.nextInt();
        System.out.println("Enter Student Street Number : ");
        int a4=sc11.nextInt();
        System.out.println("Enter Student Block  : ");
        String a5=sc11.next();
        System.out.println("Enter Student Town  : \n");
        String a6=sc11.next();
        Address ad1=new Address(p1.name,p1.id,p1.age,a3,a4,a5,a6);
        Addresslist.add(ad1);
        
        
        }
    
       else if (so==2){
              num1.write("------------");
        System.out.println("\nAddress Of Teacher\nEnter Teacher Name : ");
        String aa=sc11.next();
        System.out.println("Enter Teacher ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Teacher Age: ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        
        System.out.println("Enter Teacher  House Number : ");
        int a3=sc11.nextInt();
        System.out.println("Enter Teacher  Street Number : ");
        int a4=sc11.nextInt();
        System.out.println("Enter Teacher Block : ");
        String a5=sc11.next();
        System.out.println("\nEnter Teacher  Town : \n");
        String a6=sc11.next();
        Address ad1=new Address(p1.name,p1.id,p1.age,a3,a4,a5,a6);
        Addresslist.add(ad1);
        
        
        }
        
       else if (so==3){
        num1.write("------------");
        System.out.println("/nAddress Of Staff/nEnter Staff  Name : ");
        String aa=sc11.next();
        System.out.println("Enter Staff ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Staff Age: ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        
        System.out.println("Enter Staff  House Number : ");
        int a3=sc11.nextInt();
        System.out.println("Enter Staff  Street Number : ");
        int a4=sc11.nextInt();
        System.out.println("Enter Staff  Block  : ");
        String a5=sc11.next();
        System.out.println("Enter Staff  Town  : \n");
        String a6=sc11.next();
        Address ad1=new Address(p1.name,p1.id,p1.age,a3,a4,a5,a6);
        Addresslist.add(ad1);
        
       }
        else if (so==4){
            break;
        }
          }
            for (int j = 0; j < Addresslist.size(); j++) {
                System.out.println(Addresslist.get(j) + " ");
                            num1.write(Addresslist.get(j) + " ");
        }
                num1.close();
    }
         catch(Exception x){
        System.out.print("Error Occured: file not found");
      }
    }        
    
    public static void AddStudent(){
        
        try{
            FileWriter numbers =new FileWriter("Student.txt",true);

        for(int i=1; i<3; i++){
            
        Scanner sc11= new Scanner(System.in);
        
        System.out.println("Enter Student " + i +" Name : ");
        String aa=sc11.nextLine();
        System.out.println("Enter Student "+ i +" ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Student "+ i + " age: ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        System.out.println("Enter Student"+ i +" Grade: ");
        char a3=sc11.next().charAt(0);
        Student student1 = new Student(p1.name,p1.id,p1.age,a3);
    
        studentList.add(student1);
        System.out.println("Enter the Fees to be paid by "+aa);
        int fee=sc11.nextInt();
        student1.payDues(fee);
        
        numbers.write(sc1.GetTotalCashRecived()+" is the total Money Earned by "+ sn.getname() +"\n");

        System.out.println(sc1.GetTotalCashRecived()+" is the total Money Earned by "+sn.getname());
            }
            
            for (int j = 0; j < studentList.size(); j++) {
        numbers.write(studentList.get(j)+" ");
               System.out.println(studentList.get(j) + " ");
        }numbers.close();}
             catch(Exception x){
        System.out.print("Error Occured: file not found");
      }
    }
    public static void AddTeacher(){
        
        try{
              FileWriter numbers1 =new FileWriter("Teacher.txt",true);
            
        for(int i=1; i<3; i++){       
        Scanner sc11= new Scanner(System.in);
        
        System.out.println("Enter Teacher " + i +" Name : ");
        String aa=sc11.nextLine();
        System.out.println("Enter Teacher " + i +" ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Teacher "+ i + " age: ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        System.out.println("Enter Teacher "+ i + " Salary: ");
        int a3=sc11.nextInt();
            
        Teacher teacher1 = new Teacher(p1.name,p1.id,p1.age,a3);
    
        teacherList.add(teacher1);
        
        teacher1.ReceivedPay(teacher1.GetPay());
        
        numbers1.write("$"+sc1.GetTotalCashRecived() + " is the remaning cash in "+
        sn.getname()+" Acounts After Spending Salary to Teacher "+aa+"\n");
                
        System.out.println("$"+sc1.GetTotalCashRecived() + " is the remaning cash in "+
        sn.getname()+" Acounts After Spending Salary to Teacher"+aa);
                
        System.out.println("Enter the Bonus Salary Amount");
        int a5=sc11.nextInt();
        teacher1.BonusPay(a5);
        
        numbers1.write(sn.getname()+" has spent Bonus salary of $ "+a5+" to Teacher "+ aa
                +" and now has $" + sc1.GetTotalCashRecived()+"\n");
                
        System.out.println(sn.getname()+" has spent Bonus salary of $ "+a5+" to Teacher "+ aa
                +" and now has $" + sc1.GetTotalCashRecived());
            }
            for (int j = 0; j < teacherList.size(); j++) {
                numbers1.write(teacherList.get(j) + " ");
                System.out.println(teacherList.get(j) + " ");}
                numbers1.close();}

             catch(Exception x){
        System.out.print("Error Occured: file not found");
      }

}
    public static void AddStaff(){
       
       try{
           FileWriter numbers2=new FileWriter("Staff.txt",true);
      
        for(int i=1; i<3; i++){       
        Scanner sc11= new Scanner(System.in);
        
        System.out.println("Enter Staff " + i +" Name : ");
        String aa=sc11.nextLine();
        System.out.println("Enter Staff " + i +" ID : ");
        int a1=sc11.nextInt();
        System.out.println("Enter Staff " + i +" age : ");
        int a2=sc11.nextInt();
        Person p1=new Person(aa,a1,a2);
        System.out.println("Enter Staff " + i +" Position : ");
        String a9=sc11.next();
        System.out.println("Enter Staff " + i +" Working Hours : ");
        int a4=sc11.nextInt();
            
        Staff staff1 = new Staff(p1.name,p1.id,p1.age,a9,a4);
        staffList.add(staff1);
        
        System.out.println("Enter the Pay Earned by "+aa);
        int pay=sc11.nextInt();
        staff1.FinalPay(pay);
        
        
        staff1.FinalPay(staff1.GetPay());
        
        numbers2.write("\n"+sn.getname()+" has spent for salary to "+ aa
                +" and now has $" + sc1.GetTotalCashRecived()+"\n");
        
        System.out.println(sn.getname()+" has spent for salary to "+ aa
                +" and now has $" + sc1.GetTotalCashRecived());
    
        }

        
        for (int j = 0; j < staffList.size(); j++) {
            numbers2.write(staffList.get(j) + " ");
                System.out.println(staffList.get(j) + " "+"\n"); }
                numbers2.close();}
                
             catch(Exception x){
        System.out.print("Error Occured: file not found");
      }
}
    
        
  

}