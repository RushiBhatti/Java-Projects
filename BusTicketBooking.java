import java.util.Scanner;

public class BusTicketBooking {
    static int[] bus = new int[50];

    static void display() {
        System.out.println("The Seating Arrangement is : \n*************************\n");
        System.out.println("Door        Driver Seat");
        System.out.println("Conductor      ");
        for(int i=0; i<47 ;){
            int temp = i+2;
            int temp1 = i+5;
            for(int j=i ; j<temp && j<50 ; j++)
                if (bus[j] == 1) {
                    System.out.print(" R  ");
                    i++;
                } else {
                    System.out.print(j + 1 + "  ");
                    i++;
                }
            if(i<10){
                System.out.print("\t");
            }
            System.out.print("\t");
            for(int k=i; k<temp1 && k<50 ; k++)
                if (bus[k] == 1) {
                    System.out.print(" R  ");
                    i++;
                } else {
                    System.out.print(k + 1 + "  ");
                    i++;
                }
            System.out.println("\n");
        }
    }

    static void book(int seat,int[] arr){
        for (int i = 0; i < seat; i++) {
            // temp is used for storing value of choices that is given by user
            // here temp becomes exactly seat number-1
            int temp = arr[i] - 1;
            if(temp >= 50){
                System.out.println("*****Enter Seat Numbers From 1 to 50!******");
                return;
            }
            if (bus[temp] == 0) {
                bus[temp] = 1;
                System.out.println("\tSeat no. " + (temp+1) + " is Booked!");
            } else {
                System.out.println("\tSeat no. " + (temp+1) + " is Full!");
            }

        }
    }

    static void listBooked(){
        int count=1;
        System.out.println("The Booked Seats Are : ");
        for(int i=0;i<50;i++){
            if(bus[i]==1) {
                System.out.print((i+1) + " ");
            }
            else{ count++;}
            if(count==50){
                System.out.println("No any Seats are Booked For now!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bus Ticket Booking App !");
        int k;
        do {
            System.out.print("Enter 1 to View Seating : ");
            int ch = sc.nextInt();
            if(ch==1){
                display();
            }

            System.out.print("Enter 5 to view booked seats: ");
            int bookedSeat = sc.nextInt();
            if(bookedSeat==5){
                listBooked();
            }

            System.out.println("\nEnter no. of seats to book : ");
            int seat = sc.nextInt();

            // Array 'arr' contains choices given by user
            int[] arr = new int[seat];
            for (int i = 1; i <= seat; i++) {
                System.out.printf("Enter %d Seat : ", i);
                arr[i - 1] = sc.nextInt();
            }

            // Calling book method for Booking purpose!
            book(seat, arr);

            System.out.print("*********Enter 0 for exit :");
            k = sc.nextInt();
        }while (k!=0);
    }
}