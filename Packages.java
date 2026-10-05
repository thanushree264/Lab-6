Mainbank.java
import accounts.*;
import customers.*;
import java.util.*;
import loans.*;
public class Mainbank
{
static Accounts accinit(Scanner sc)
{
System.out.println("Enter the Account no, type and balance");
String accno=sc.next();
String acctype=sc.next();
double balance=sc.nextDouble();
Accounts a=new Accounts(accno,acctype,balance);
a.display();
return a;
}
static Loans loaninit(Scanner sc)
{
System.out.println("Enter the Loan Account no, type and amount");
String loanno=sc.next();
String loantype=sc.next();
double loanamt=sc.nextDouble();
Loans l = new Loans(loanno,loantype,loanamt);
l.display();
return l;
}
static Customers custinit(Scanner sc){
System.out.println("Enter the Customer id, name and phone number");
String cusid=sc.next();
String cusname=sc.next();
int cusno=sc.nextInt();
Customers c = new Customers(cusid,cusname,cusno);
return c;
}
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int choice1=-1;
int choice2=-1;
Accounts a=null;
Loans l=null;
Customers c=null;
while (choice1!=0)
{
System.out.println("---------BANK MANAGEMENT SYSTEM----------");
System.out.println("1. ACCOUNTS");
System.out.println("2. LOANS");
System.out.println("3. CUSTOMER DETAILS");
System.out.println("------------------------------------------");
choice1=sc.nextInt();
switch(choice1)
{
case 1: System.out.println("1. CREATE ACCOUNT");
System.out.println("2. WITHDRAWAL ");
System.out.println("3. DEPOSIT");
System.out.println("4. CHECK BALANCE");
choice2=sc.nextInt();
switch(choice2)
{
case 1: a= accinit(sc);break;
case 2: a.withdraw(); break;
case 3: a.deposit(); break;
case 4: a.display();break;
default: System.out.println("Invalid option"); break;
}break;
case 2: System.out.println("1. CREATE LOAN ACCOUNT");
System.out.println("2. DISPLAY LOAN DETAILS");
choice2=sc.nextInt();
switch(choice2)
{
case 1: l=loaninit(sc); break;
case 2: l.display(); break;
default: System.out.println("Invalid option"); break;
} break;
case 3: System.out.println("1. CREATE CUSTOMER LOGIN");
System.out.println("2. DISPLAY CUSTOMER DETAILS");
choice2=sc.nextInt();
switch(choice2)
{
case 1: c=custinit(sc);
break;
case 2: c.display(); break;
default: System.out.println("Invalid option"); break;
} break;
default: System.out.println("Invalid option"); break;
}
} }} 
Accounts.java
package accounts;
import java.util.Scanner;
public class Accounts
{
String accno;
String acctype;
double balance;
public Accounts(String accno, String acctype, double balance)
{
this.accno=accno;
this.acctype=acctype;
this.balance=balance;
}
public void display()
{
System.out.println("Account Number= " + accno);
System.out.println("Account Type: " + acctype);
System.out.println("Account Balance: "+balance);
}
public void withdraw()
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the amount to withdraw: ");
int withdraw=sc.nextInt();
if(withdraw<balance)
{
balance=balance-withdraw;
System.out.println("Withdrawal successful!");
}
else if (withdraw<0)
{
System.out.println("Enter a valid amount!");
}
else
{
System.out.println("Insufficient Balance");
}
}
public void deposit()
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the amount you wish to deposit");
double deposit=sc.nextDouble();
if(deposit>0)
{
balance=balance+deposit;
System.out.println("Deposit successful");
}
else
{
System.out.println("Enter a valid amount");
}
}
}
Customers.java
package customers;
public class Customers
{
String cusid;
String cusname;
int cusno;
public Customers(String cusid, String cusname, int cusno)
{
this.cusid=cusid;
this.cusname=cusname;
this.cusno=cusno;
}
public void display()
{
System.out.println("Customer ID= " + cusid);
System.out.println("Customer Name: " + cusname);
System.out.println("Customer Phone Number: "+cusno);
}
}
Loans.java
package loans;
public class Loans {
String loanno;
String loantype;
double loanamt;
public Loans(String lobnanno, String loantype, double loanamt)
{
this.loanno=loanno;
this.loantype=loantype;
this.loanamt=loanamt;
}
public void display()
{
System.out.println("Loan Number= " + loanno);
System.out.println("Loan Type: " + loantype);
System.out.println("Loan Amount: "+loanamt);
} }
