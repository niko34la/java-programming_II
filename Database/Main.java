import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Entity en = new Entity();
		Scanner input = new Scanner(System.in);
		System.out.println("What kind of database would you like to create?");
		String name = input.next();
		System.out.println("How many columns would you like your database to contain?");
		int columns = input.nextInt();
		String[] colname = new String[columns];

		for (int i=0; i < colname.length; i++) {
		    System.out.print("Insert the name of the column\n");
			colname[i] = input.next();
		}
		Columns.setCols(colname);
		System.out.printf("%s\n", Columns.getCols());
		System.out.println("Declare a primary key");
		boolean accept = false;
		do {
			String primk = input.next();
			for(int i= 0; i < colname.length; i++) {
				if(primk.equals(colname[i])) {
					en.setPK(primk,i);
					accept = true;
					break;
				}
			}
		} while(!accept);
		Menu menu = new Menu();
		String[] elements = new String[columns];
		System.out.println("Insert the elements");
		for (int i = 0; i < columns ; i++) {
			elements[i] = input.next();
		}

		en.setter(elements);
		en.printEls(en.getter());
	}
}
