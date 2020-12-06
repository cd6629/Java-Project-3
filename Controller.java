package app;

import java.util.Random;
import payment.CreditCard;
import client.Person;
import goods.Item;


public class Controller {
	public static void main(String[] args) throws InterruptedException{

		Person john = new Person("John", "Doe", "1100 Brickell Ave", "Apt 102", "Miami", "Florida");

		CreditCard masterCard = new CreditCard(john, "MasterCard", 2500.00);
				
		CreditCard ax = new CreditCard(john, "American Express", 5000.00);
		
		john.getCreditCards().add(masterCard);
		john.getCreditCards().add(ax);
		
		Item cafeMocha = new Item("Food", "Cafe Mocha", 4.77);

		Item gucciSlipper = new Item("Clothing", "Gucci Princetown", 2650.00);

		Item coke = new Item("Food", "Coke", 1.99);

		Item airlinesTicket = new Item("Travel", "MIA-SFO", 823.26);
		
		// john is buying cafeMocha using his MasterCard credit card
		((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
		
		// john is buying gucciSlipper using his MasterCard credit card		
		((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);
		
		// john is buying gucciSlipper using his American Express
		((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);
		
		// john is running a transaction Report on his MasterCard
		((CreditCard)john.getCreditCards().get(0)).transactionsReport();
		
		// john is running a transaction Report on his American Express
		((CreditCard)john.getCreditCards().get(1)).transactionsReport();
		
		Random generator = new Random();
				
		for(int i=1; i<=7; i++){
			Thread.sleep(generator.nextInt(1001));
			if(i%3 == 0) {
				((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
			} else {
				((CreditCard)john.getCreditCards().get(1)).makeCharge(cafeMocha);
			}
		}//end for
		
		for(int i=1; i<=5; i++){
			Thread.sleep(generator.nextInt(1001));
			if(i%2 == 0) {
				((CreditCard)john.getCreditCards().get(0)).makeCharge(airlinesTicket);
			} else {
				((CreditCard)john.getCreditCards().get(1)).makeCharge(airlinesTicket);
			}
		}//end for
		
		for(int i=1; i<=10; i++){
			Thread.sleep(generator.nextInt(1001));
			int randomSelectCard = generator.nextInt(2);
			if(randomSelectCard == 0) {
				System.out.println("randomSelectCard: MasterCard");
				((CreditCard)john.getCreditCards().get(0)).makeCharge(coke);
			} else {
				System.out.println("randomSelectCard: American Express");
				((CreditCard)john.getCreditCards().get(1)).makeCharge(coke);
			}
			
			
		}//end for
		
		// john is running a transaction Report on his masterCard
		((CreditCard)john.getCreditCards().get(0)).transactionsReport();
		// john is running a transaction Report on his American Express
		((CreditCard)john.getCreditCards().get(1)).transactionsReport();
		// john is running displayInfo method
		john.displayInfo();
		
	}
}
