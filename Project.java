import java.io.*;
import java.util.*;

public class Project
{
  private String name, gender;
  private int age;
  static int n = 100, num, age2, ch, cnum, b_id[]=new int[n], cb_id[]=new int[cnum];
  static String name2, place1, place2, gender2;

  Project()
  {
    name = "noname";
    age = 1;
    gender = "Unknown";
  }
  
  Project(String name, int age, String gender)
  {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  static void Book()throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("\n\n\t\tEnter no. of tickets to book: ");
    num = Integer.parseInt(br.readLine());
    n = n - num;
    System.out.print("\n\t\tEnter the source place: ");
    place1 = br.readLine();
    System.out.print("\t\tEnter the destination place: ");
    place2 = br.readLine();
    System.out.println("\n\t\tList of trains available: ");
    System.out.println("\t\t1. Shatabdi Express");
    System.out.println("\t\t2. Rajdhani Express");
    System.out.println("\t\t3. Jammu Tavi Express");
    System.out.print("\t\tEnter your choice: ");
    ch = Integer.parseInt(br.readLine());
  }

  static void cancel()throws IOException
  {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    System.out.print("\n\t\tEnter the no. of tickets you want to cancel: ");
    cnum = Integer.parseInt(br.readLine());
    for(int i=0; i<cnum; i++)
    {
      System.out.print("\n\t\tEnter the booking id: ");
      int cid = Integer.parseInt(br.readLine());
      for(int j=0; j<cid; j++)
      {
        for(int k=0; k<num; k++)
        {
          if(cid == b_id[k])
          {
            System.out.print("\n\t\tTicket has been cancelled succesfully!!");
            return;
          }
        }
      }
    }
  }

  void show()
  {
    System.out.print("\t\tName: " + name + "\t\tAge: " + age + "\t\tGender: " + gender);
    if(age<=10)
    {
      System.out.print("\t\tCategory: Child");
    }
    else if (age > 10 && age < 40)
    {
      System.out.print("\t\tCategory: Adult");
    }
    else
    {
      System.out.print("\t\tCategory: Old");
    }
    System.out.println();
  }

  public static void main(String args[])throws IOException
  {
    Project[] students = new Project[100];
    int SavePass = 12345;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("\n\t\tUser Id: ");
    String id = br.readLine();
    System.out.print("\n\t\tPassword: ");
    int pass = Integer.parseInt(br.readLine());
    if(pass == SavePass)
    {
      while(true)
      {
        System.out.println("\n\n\t   -------WELCOME TO RAILWAY RESERVATION-------");
        System.out.print("\n\t\t1. Book\n\n\t\t2. Show\n\n\t\t3. Cancel\n\n\t\t4. Exit");
        System.out.print("\n\n\t\tEnter your choice: ");
        int choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
          case 1:
            Book();
            for(int i=0; i<num; i++)
            {
              System.out.print("\n\t\tEnter the deatails of passenger " + (i+1) + ": ");
              System.out.print("\n\t\tPassenger Name: ");
              name2=br.readLine();
              System.out.print("\t\tPassenger Gender: ");
              gender2=br.readLine();
              System.out.print("\t\tPassenger Age: ");
              age2=Integer.parseInt(br.readLine());
              students[i] = new Project(name2, age2, gender2);
            }
            for(int i=0; i<num; i++)
            {
              b_id[i] = 101 + i;
            }
            System.out.println("\n\t\t" + num + " ticket has been sucessfully booked.");
            break;
          case 2:
            System.out.print("\n\t\tPassenger details: ");
            if(ch==1)
            {
              System.out.print("\n\t\tTrain name: Shatabdi Express");
            }
            else if(ch==2)
            {
              System.out.print("\n\t\tTrain name: Rajdhani Express");
            }
            else
            {
              System.out.print("\n\t\tTrain name: Jamu Tavi Express");
            }
            System.out.print("\n\t\tFrom: " + place1 + "\t\t To: " + place2);
            System.out.println();
            for(int i=0; i<num; i++)
            {
              System.out.print("\n\t\tBookig Id: " + b_id[i]);
              students[i].show();
            }
            System.out.println("\n\n\t\tNo. of tickets available : " + n + "\n\n");
            break;
          case 3:
            cancel();
            break;
          case 4:
            return;
          default:
            System.out.println("Wrong choice;");
            break;
        }
      }
    }
    else
    {
      System.out.println("\n\t\t!! Wrong Password !!");
      main(args);
    }
  }
}