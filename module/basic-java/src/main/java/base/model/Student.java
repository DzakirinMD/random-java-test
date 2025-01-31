package base.model;

public class Student{
    int rollno;//instance variable
    String name;
    public static String college ="ITS"; //static variable

    //constructor
    public Student(int r, String n){
        rollno = r;
        name = n;
    }
    //method to display the values
    public void display (){System.out.println(rollno+" "+name+" "+college);}
}
