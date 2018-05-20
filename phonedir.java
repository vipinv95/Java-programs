/* @author: Vipin Rajan Varatharajan
Purpose:
The purpose of the phonedir class is to create a program to keep a 
Phone Directory by storing the first name, last name and phone number into an 
object inside a LinkedList provided by the java library.
The output of the program should look like:
"A Program to keep a Phone Directory:
a     Show all records
d     Delete the current record
f     Change the first name in the current record
l     Change the last name in the current record
n     Add a new record
p     Change the phone number in the current record
q     Quit
s     Select a record from the record list to become the current record
Enter a command from the list above (q to quit):"
Solution: 
- A method AddRecord() to insert a phonedir object into the LinkedList based 
  on their last names. 
- A method ShowRecords() to display the records sorted by last name stored 
  inside the LinkedList.
- A method isNotQ() to check the validity of the user's command.
- A method sorter() uses bubble sort to sort the records in the LinkedList 
  by the last names when the last name of a record is changed by the user.
- A method DeleteRecord() to delete selected record from the LinkedList.
- A method ChangeFname() to change the first name from the selected record.
- A method ChangeLname() to change the last name from the selected record.
- A method ChangePnum() to change the phone number from the selected record.
- A method SelectRecord() to select a record from the LinkedList to be the 
  current record.
- A phonedir constructor to create the phonedir object with three fields 
  (First Name, Last Name, Phone Number).
- One getter and setter for each field in the phonedir object.
Data Structures used in the program:
- This programs only uses a LinkedList data structure to save the phonedir 
  object of the phone directory.
Description of how to use program and expected input/output:
- The program expects the user to enter an appropriate command from the menu 
  printed to the screen when the program begins. 
- The user enters q to quit the program.

*/
package phonedir;
import java.util.LinkedList;
import java.util.Scanner;
public class phonedir {
    public static char command;
    public static LinkedList<phonedir> list = new LinkedList<>();
    public  String fname;
    public  String lname;
    public  String pnum;
    public static String current_f;
    public static String current_l;
    public static String current_p;
    public static String pn;
    public static String fn;
    public static String ln;
    static Scanner userinput = new Scanner(System.in);
    public static void main(String[] args) {
               
        do {
        Scanner scan = new Scanner(System.in);        
        System.out.println("A Program to keep a Phone Directory:");
        System.out.println("a     Show all records");
        System.out.println("d     Delete the current record");
        System.out.println("f     Change the first name in the current "
                + "record");
        System.out.println("l     Change the last name in the current "
                + "record");
        System.out.println("n     Add a new record");
        System.out.println("p     Change the phone number in the current "
                + "record");
        System.out.println("q     Quit");
        System.out.println("s     Select a record from the record list to "
                + "become the current record");
        System.out.print("Enter a command from the list above (q to quit): ");        
        command = scan.next().charAt(0);
    }
        while(phonedir.isNotQ(command));
    }
    public phonedir(String f, String l, String p) {
        fname=f; lname=l; pnum=p;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getPnum() {
        return pnum;
    }
    public void setFname(String f) {
        this.fname=f;
    }
    public void setLname(String l) {
        this.lname=l;
    }
    public void setPnum(String p) {
        this.pnum=p;
    }
    /*
    Pre-condition: Takes the char value of command variable as input.
    Post-condition: Returns true if the command is not 'q'.
    */
    public static boolean isNotQ(char command) {
        boolean TorF;
        switch(command) {
           case 'a': TorF=true;
           phonedir.ShowRecords();
                break;
           case 'd': TorF=true;
           phonedir.DeleteRecord();
                break;
           case 'f': TorF=true;
           phonedir.ChangeFname();
                break;
           case 'l': TorF=true;
           phonedir.ChangeLname();
                break;
           case 'n': TorF=true;
           phonedir.AddRecord();
                break;
           case 'p': TorF=true;
           phonedir.ChangePnum();
                break;
           case 'q': TorF=false;
                break;
           case 's': TorF=true;
           phonedir.SelectRecord();
                break;
           default: TorF=true;
           System.out.println("Illegal Command!");
                break;
        }
            
        return TorF;
    }
    /*
    Pre-condition: Takes no input. 
    Post-condition: No return. Prints out the First Name, Last Name and 
    Phone Number to the screen.
    */
    public static void ShowRecords() {
        System.out.println("First Name \t\t Last Name \t\t Phone Number");
        System.out.println("---------- \t\t --------- \t\t ------------");
          for(int i=0;i<list.size();i++) {
            System.out.format("%10s %23s %26s%n", list.get(i).getFname(), 
                    list.get(i).getLname(), list.get(i).getPnum());
        }
    }
        /*
    Pre-condition: Takes no input.
    Post-condition: No return. Prompts the user to enter First Name, Last Name 
    and Phone Number. Regex expressions are used to validate and format the 
    Phone Number. This method inserts the phonedir object into its correct 
    position sorted by Last Names and prints the current record to the screen.
    */
    public static void AddRecord() {        
        System.out.print("Enter first name: ");
        String sfn = userinput.nextLine();
        fn = sfn;
        System.out.print("Enter last name: ");
        String sln = userinput.nextLine();
        ln = sln;
        boolean illegal=true;
        while(illegal) {
        System.out.print("Enter phone number (123-456-7890 or 1234567890): ");
        String pnum = userinput.nextLine();
        pn = pnum;
        pn = pn.replaceAll("\\s+", "");
        if(pn.matches("[0-9]{3}[0-9]{3}[0-9]{4}")) {
          pn = pn.substring(0, 3)+"-"+pn.substring(3, 6)+"-"
                  +pn.substring(6, 10);
        illegal=false;
        }
        else if(pn.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
        illegal=false;    
        }
        else {
            System.out.println("Invalid Phone Number!");
            System.out.print("Enter phone number (123-456-7890 or "
                    + "1234567890): ");
            pn = userinput.nextLine();
            pn = pn.replaceAll("\\s+", "");    
        }
            }
    
        if(!list.isEmpty()) {
        for(int i=0;i<list.size();i++) {
            if ((ln.compareToIgnoreCase(list.get(i).getLname()))<=0) {
                list.add(i,new phonedir(fn,ln,pn));
                break;
            }
            else if ((i==(list.size()-1))||list.isEmpty()) {
                list.add(new phonedir(fn,ln,pn));
                break;
            }
        }
        }
        else {
            list.add(new phonedir(fn,ln,pn));
        }
        current_f=fn;current_l=ln;current_p=pn;
        System.out.println("Current record is: "+fn+" "+ln+" "+pn);
       }
    /*
    Pre-condition: Takes no input.
    Post-condition: No Return. Changes the First Name of the selected current 
    record from the list.
    */
    public static void ChangeFname() {
        if(current_f!=null&&current_l!=null&&current_p!=null) {
        System.out.print("Enter new first name: ");
        String fne = userinput.next();
            for(int i=0;i<list.size();i++) {
                if ((list.get(i).getFname()).equals(current_f)) {
                    list.get(i).setFname(fne);
                    break;
                }
            }
            current_f=fne;
        System.out.println("Current record is: "+current_f+" "+current_l
                +" "+current_p);
        }
        else {
            System.out.println("No current record selected!");
        }
}
    /*
    Pre-condition: Takes no input.
    Post-condition: No Return. Changes the Last Name of the selected current 
    record from the list.
    */
    public static void ChangeLname() {
        if(current_f!=null&&current_l!=null&&current_p!=null) {
        System.out.print("Enter new last name: ");
        String lne = userinput.next();
            for(int i=0;i<list.size();i++) {
                if ((list.get(i).getLname()).equals(current_l)) {
                    list.get(i).setLname(lne);
                    break;
                }
            }
            current_l=lne;
        System.out.println("Current record is: "+current_f+" "+current_l
                +" "+current_p);
        phonedir.sorter(list);        
        }
        else {
            System.out.println("No current record selected!");
        }
    }
    /*
    Pre-condition: Takes no input.
    Post-condition: No Return. Validates and changes the Phone Number of the 
    selected current record from the list.
    */    
    public static void ChangePnum() {
        if(current_f!=null&&current_l!=null&&current_p!=null) {   
        boolean illegal=true;
        while(illegal) {
        System.out.print("Enter phone number (123-456-7890 or 1234567890): ");
        String pnum = userinput.nextLine();
        pn = pnum;
        pn = pn.replaceAll("\\s+", "");
        if(pn.matches("[0-9]{3}[0-9]{3}[0-9]{4}")) {
          pn = pn.substring(0, 3)+"-"+pn.substring(3, 6)+"-"+
                  pn.substring(6, 10);
        illegal=false;
        }
        else if(pn.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
        illegal=false;    
        }
        else {
            System.out.println("Invalid Phone Number!");   
        }
            }        
            for(int i=0;i<list.size();i++) {
                if ((list.get(i).getPnum()).equals(current_p)) {
                    list.get(i).setPnum(pn);
                    break;
                }
            }
            current_p=pn;
        System.out.println("Current record is: "+current_f+" "+current_l
                +" "+current_p);
        }
        else {
            System.out.println("No current record selected!");
        }
    }
    /*
    Pre-condition: Takes no input.
    Post-condition: No Return. Prompts the user to enter a First Name and a 
    Last Name. Selects a record from the LinkedList to be the current record. 
    Prints the current record if the record is found, and prints "No mathcing 
    record found." if the list does not contain a record with the same first 
    name and last name.
    */    
    public static void SelectRecord() {
        System.out.print("Enter first name: ");
        String fn = userinput.next();
        System.out.print("Enter last name: ");
        String ln = userinput.next();
            for(int i=0;i<list.size();i++) {
                if (((list.get(i).getFname()).equals(fn))&&
                        ((list.get(i).getLname()).equals(ln))) {
                    current_f=fn;current_l=ln;current_p=list.get(i).getPnum();
                    System.out.println("Current record is: "+current_f+" "
                            +current_l+" "+current_p);
                    break;
                }
                else if(i==((list.size())-1)) {
                    System.out.println("No matching record found.");
                }
                
            }        
    }
    /*
    Pre-condition: Takes no input.
    Post-condition: No Return. Deletes a phonedir object contained by the 
    current record and prints the deleted record to the screen.
    */    
    public static void DeleteRecord() {
        if(current_f!=null&&current_l!=null&&current_p!=null) {
            for(int i=0;i<list.size();i++) {
                if (((list.get(i).getFname()).equals(current_f))&&
                        ((list.get(i).getLname()).equals(current_l))&&
                        ((list.get(i).getPnum()).equals(current_p))) {
                    list.remove(i);
                    System.out.println("Deleted: "+current_f+" "+current_l
                            +" "+current_p);
                    current_f=null;current_l=null;current_p=null;                    
                    break;                
                }        
            }
        }
        else {
        System.out.println("No current record selected!");
        }
    }
    /*
    Pre-condition: Takes in a LinkedList of the type phonedir as input.
    Post-condition: No Return. Uses bubble sort to sort the records in the 
    list by the Last Names. It is only used when the Last Name in the list 
    is changed by the user.
    */
    public static void sorter(LinkedList<phonedir> l) {
        boolean swap = true;
        phonedir temp_l;
        while(swap) {
            swap = false;
            for(int i=0;i<l.size()-1;i++) {
                if((l.get(i).getLname()).compareToIgnoreCase(l.get(i+1).
                        getLname())>0) {
                    temp_l =(l.get(i));
                    l.set(i, (l.get(i+1)));
                    l.set(i+1,temp_l);
                    swap=true;
                }
            }
        }
            
    }
}
