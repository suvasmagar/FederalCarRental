
import java.util.Scanner;

public class Menu {

	public int i =0;
	String[] arr = new String[6];


	
	public void displayUserMenu() {
		// Control the menu navigation.  Includes display of menu, acceptance and processing of user input and
		// exiting the menu based on the user's selections.
		boolean blnContinue = true;
		Scanner scanInput = null;
		
		header();
		
		try {		//try-catch-finally to ensure compatibility with all java versions. 
			scanInput = new Scanner(System.in);
			while (blnContinue) {
				displayMenu();
			
				if (scanInput.hasNextInt()) {
					blnContinue = processMenuSelection(scanInput.nextInt());
				}
				else {
					scanInput.nextLine();
					System.out.println("Wrong kind of input");
					blnContinue = processMenuSelection(0);
				}
			}
		}
		catch (Exception e){
			// Generic error catch - this can be made more specific to the expected errors.
			System.out.println("An unexpected exception has occurred with input");
		}
		finally {
			// Close the scanner
			if (scanInput != null) {
				scanInput.close();
			}
		}
		
	}

	private void header() {
		// Display program header information
		System.out.println("Federation Car Rental Payment Tracking System");
		System.out.println("=============================================");
		System.out.println();
	}

	private void displayMenu() {
		// Display the menu for user to select which function to run
		System.out.println("Select an option from the menu below:");
		System.out.println("1. Standard Payment");
		System.out.println("2. Loyalty Payment");
		System.out.println("3. Employee Payment");
		System.out.println("4. Display List of Clients");
		System.out.println("5. Generate Report To View Payments Received");
		System.out.println("6. Exit");
		System.out.print("Enter your option: ");
 
	}


	double[] total = new double[3];
	double[] discount = new double[3];
	int uid = 1;
	int m=0;
	int k = 0;
	int l=0;
	int count1=0, count2=0, count3=0;

	// for displaying object of classes differently 
	String[] spay = new String[2];
	String[] lpay = new String[2];
	String[] epay = new String[2];


	private boolean processMenuSelection(int menuSelection) {
		// Use the input provided by the user to activate the appropriate code function

		boolean blnContinue = true;
		
		Scanner sc = new Scanner(System.in);
		
		switch (menuSelection){
		case 1:
			// call method to process standard payments here
			StandardPayment sp = new StandardPayment();
			System.out.print("Enter ID of an existing client or  0 to enter a new one: ");
			int sid = sc.nextInt();
			
			again:
			if(sid == 0)
			{
				
			
				System.out.println("--Processing Standard Payment--");
				sp.read();
				sp.calc(uid);
				count1++;
				arr[i] = sp.toString();

				// for displaying StandarPaymetn objects separately
				spay[m] = sp.toString();
				

				// for payment review
				 
				double tot = sp.getPay();
				
				total[0] += tot;

				double dis = sp.getDiscount();
				discount[0] += dis;

				// displaying the ojects of the Standard Payment class
				System.out.println("Client ID" + "\t" + "Name" + "\t" + "Total Amount"+ "\t" + "Discount Amount");
				for(int j=0; j < count1; j++)
				{
					System.out.println(spay[j]);
				}
				
				System.out.println("\nFinished processing payment.");
				uid++;
				m++;	
				i++;			
			}
		//	else if(sid == sp.getId() )
			else
			{
				System.out.println("Wrong kind of Input.");
				break again;
			}
			
			break;

		case 2:
			// call method to process loyalty rewards payments here
			LoyalityPayment lp = new LoyalityPayment();
			System.out.print("Enter ID of an existing client or  0 to enter a new one: ");
			int lid = sc.nextInt();

			again:
			if(lid == 0)
			{
				System.out.println("--Processing Loyalty Payment--");
				lp.read();
				lp.calc(uid);
				count2++;

			//	sp.read();
				arr[i] = lp.toString();

				// to display array of loyality payment only
				lpay[k] = lp.toString();
				

				// to review the payment received
				double tot = lp.getPay();
				total[1] =total[1] + tot;
				double dis = lp.getDiscount();
				discount[1] = discount[1] + dis;

				System.out.println("Client ID" + "\t" + "Name" + "\t" + "Total Amount"+ "\t" + "Discount Amount");
				for(int j=0; j < count2; j++)
				{
					System.out.println(lpay[j]);
				}
				System.out.println("\nFinished processing payment.");
				uid++;
				i++;
				k++;

			}
			else
			{
				System.out.println("Wrong kind of Input.");
				break again;
			}
			break;

		case 3:
			// call method to process employee payments here
			EmployeePayment ep= new EmployeePayment();
			System.out.print("Enter ID of an existing client or  0 to enter a new one: ");
			int eid = sc.nextInt();

			again:
			if(eid == 0)
			{
				System.out.println("--Processing Employee Payment--");
				ep.read();
				ep.calc(uid);
				count3++;

				arr[i] = ep.toString();

				// to display employee payments only
				epay[l] = ep.toString();

				// to review the payment and discount received
				double tot = ep.getPay();
				total[2] += tot;
				double dis = ep.getDiscount();
				discount[2] += dis;

				System.out.println("Client ID" + "\t" + "Name" + "\t" + "Total Amount"+ "\t" + "Discount Amount");
				for(int j=0; j < count3; j++)
				{
					System.out.println(epay[j]);
				}
				
				System.out.println("\nFinished processing payment.");
				uid++;
				i++;
				l++;

			}
			else
			{
				System.out.println("Wrong kind of Input.");
				break again;

			}
			
			break;

		case 4:
			// call method to  display list of clients here
			System.out.println("--List of Clients--");

			System.out.println("Client ID" + "\t" + "Name" + "\t" + "Total Amount"+ "\t" + "Discount Amount");

			System.out.println("Standard Payment");
			for(int x = 0; x < spay.length; x++)
			{
				System.out.println(spay[x]);
			}

			System.out.println("Loyality Payment");
			for(int x = 0; x < lpay.length; x++)
			{
				System.out.println(lpay[x]);
			}

			System.out.println("Employee Payment");
			for(int x = 0; x < spay.length; x++)
			{
				System.out.println(epay[x]);
			}
			break;

		case 5:
			// call method to generate report to display payments received here
			System.out.println("--Report to View Payments Received--");

			System.out.println("Type of Account" + "\t" +"Total amount Received" + "\t" + "Discount Given");
		
			System.out.println("Standard Payment" + "\t\t" + total[0] + "\t\t" + discount[0]);
			System.out.println("Loyality Payment" + "\t\t" + total[1] + "\t\t" + discount[1]);
			System.out.println("Employee Payment" + "\t\t" + total[2] + "\t\t" + discount[2]);

			double sum =0;
			double dis =0;

			for(int x =0; x<3; x++)
			{
				sum = sum + total[x];
				dis = dis + discount[x];
			}
			System.out.println("Total: " + "\t\t\t\t" + sum + "\t\t"+ dis );


			break;
		case 6:
			System.out.println("-- Exiting Federation Car Rental Payment Tracking System --\n ....\n  -- Goodbye! --\n");
			blnContinue = false;
			break;
		default:
			// no valid selection made
			System.out.println("Invalid selection! A number between 1 and 6 was expected.");
		}		
		return blnContinue;
	}

}//public class Menu
