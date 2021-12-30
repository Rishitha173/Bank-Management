import java.util.Scanner;
class Bank{
	private String Acc_no;
	private String Name;
	private long balance;
	
	Scanner BA=new Scanner(System.in);
	
	//method to open an account
	
	void openAccount() {
		System.out.print("Enter Account No:");
		Acc_no=BA.next(); 
		System.out.print("Enter Account holder Name:");
		Name=BA.next();
		System.out.print("Enter Balance:");
		balance=BA.nextLong();
		
	}
	
	//method to display account details
	
	void showAccount() {
		System.out.print(Acc_no+","+Name+","+balance);
		
	}
	
	//method to deposit money
	
	void deposit() {
		long amt;
		System.out.print("Enter Ammount You Want to Deposit:");
		amt=BA.nextLong();
		balance=balance+amt;
	}
	
	
	//method to withdraw money
	void withdrawal() {
		long amt;
		System.out.print("Enter Ammount You Want to Withdraw:");
		amt=BA.nextLong();
		if(balance>=amt) {
			balance=balance-amt;
			}
		else {
			System.out.print("Less Balance..Transaction Failed..");
		}
	}
	
	//method to search an account number
	boolean search(String acn) {
		if(Acc_no.equals(acn)) {
			showAccount();
			return(true);
		}
		return(false);
	}
}

public class ExBank {
	public static void main(String arg[]) {
        Scanner BA = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = BA.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.Exit ");
                System.out.println("Ur Choice :"); ch = BA.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = BA.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = BA.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = BA.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 5);
        }
    }
	


