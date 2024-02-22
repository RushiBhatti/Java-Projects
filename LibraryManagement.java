import java.util.*;

// In this program users are able to do opertions like 
// add, update, search, delete, etc on the books.

class Book {
	private String name, author;
	private String ISBN, price;

	void setName(String name) {
		this.name = name;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	void setPrice(String price) {
		this.price = price;
	}

	String getName() {
		return this.name;
	}

	String getAuthor() {
		return this.author;
	}

	String getISBN() {
		return this.ISBN;
	}

	String getPrice() {
		return this.price;
	}
}

public class LibraryManagement {
	
	static Book insert() {
		Book book = new Book();
		Scanner sc = new Scanner(System.in);
		System.out.println("============ Insert Book :--");
		System.out.print("\tEnter Book Name : ");
		book.setName(sc.nextLine());
		System.out.print("\tEnter Book price : ");
		book.setPrice(sc.nextLine());
		System.out.print("\tEnter Book Author Name : ");
		book.setAuthor(sc.nextLine());
		System.out.print("\tEnter ISBN number : ");
		book.setISBN(sc.nextLine());
		return book;
	}

	static void update(Book b) {
		String name, author;
		String ISBN, price;

		Scanner sc = new Scanner(System.in);
		System.out.println("============ Update Book :--");
		System.out.print("\tEnter Book Name : ");
		name = sc.nextLine();
		System.out.print("\tEnter Book price : ");
		price = sc.nextLine();
		System.out.print("\tEnter Book Author Name : ");
		author = sc.nextLine();
		System.out.print("\tEnter ISBN number : ");
		ISBN = sc.nextLine();
		if (!name.isEmpty())
			b.setName(name);
		if (!price.isEmpty())
			b.setPrice(price);
		if (!author.isEmpty())
			b.setAuthor(author);
		if (!ISBN.isEmpty())
			b.setISBN(ISBN);
	}

	static void printBook(Book b) {
		System.out.println("Book Name : " + b.getName());
		System.out.println("Author Name : " + b.getAuthor());
		System.out.println("Book ISBN number : " + b.getISBN());
		System.out.println("Book Price : " + b.getPrice());
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		
		int a = 0;
		Book[] bArray = new Book[10];
		A: do {
			System.out.println("\n1. Insert Book");
			System.out.println("2. Update Book");
			System.out.println("3. Search Book");
			System.out.println("4. Delete Book");
			System.out.println("5. Display all Books");
			System.out.println("** Exit. -> Write Exit **");
			System.out.print("\nEnter your choice : ");
			choice = sc.nextLine();
			System.out.println();
			switch (choice) {
				case "1":
					bArray[a] = insert();
					a++;
					break;
				case "2":
					// sc.next();
					System.out.print("Enter ISBN number : ");
					String ISBN = sc.nextLine();
					boolean flag = false;
					for (int i = 0; i < a; i++) {
						if (ISBN.equals(bArray[i].getISBN())) {
							update(bArray[i]);
							flag = true;
							break;
						}
					}
					if (flag == false)
						System.out.println("******* Book is not found!");
					break;
				case "3":
					System.out.print("Enter name of book : ");
					String name = sc.nextLine().toLowerCase();
					flag = false;
					for (int i = 0; i < a; i++) {
						String name1 = bArray[i].getName().toLowerCase();
						if (name1.contains(name)) {
							System.out.println("============ Searched Book :--");
							printBook(bArray[i]);
							flag = true;
						}
					}
					if (flag == false)
						System.out.println("******* Book is not found!");
					break;
				case "4":
					System.out.print("Enter ISBN number : ");
					String ISBN1 = sc.nextLine();
					flag = false;
					for (int i = 0; i < a; i++)
						if (ISBN1.equals(bArray[i].getISBN())) {
							for (int j = i; j < a; j++)
								bArray[j] = bArray[j + 1];
							a--;
							flag = true;
						}
					if (flag == false)
						System.out.println("******* Book is not found!");
					break;
				case "5":

					System.out.println("============ Displaying All Books :--");
					System.out.println("=========================================");
					for (int i = 0; i < a; i++)
						printBook(bArray[i]);
					break;
				default:
					break A;

			}
		} while (true);
		try {
			System.out.println();
		} finally {
			sc.close();
		}
	}
}