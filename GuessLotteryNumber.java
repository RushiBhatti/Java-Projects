import java.util.* ;
public class GuessLotteryNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\tLottery Game");

        int match_count , WOCount , win=0 ;

        // Lottery Number Generating
        int l_number = (int)(Math.random()*1000);
        
        if(l_number<100){
            if(l_number < 10) {
                l_number *= 100;
            }
            l_number *= 10;
        }
//        System.out.println(l_number);

        int[] lottery = new int[3];
        lottery[2] = l_number%10;
        lottery[1] = ((l_number/10)%10);
        lottery[0] = ((l_number/100)%10);

        do {
            System.out.print("Guess The Lottery Number(Any 3 Number) : ");
            int guess = sc.nextInt();

            int[] array = new int[3];
            array[2] = guess % 10;
            array[1] = ((guess / 10) % 10);
            array[0] = ((guess / 100) % 10);

            match_count = 0;
            for (int i = 0; i < 3; i++) {
                if (lottery[i] == array[i]) {
                    match_count++;
                }
            }
            WOCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (lottery[i] == array[j]) {
                        WOCount++;
                    }
                }
            }

            if (match_count == 3) {
                System.out.println("Exactly Correct ! You earned $10,000");
                win = 1;
            } else if (WOCount == 3) {
                System.out.println("Orderless Correct ! You earned $3,000");
                win = 1;
            } else if (match_count == 2) {
                System.out.println("Correct 2 digits! You earned $2,000");
                win = 1;
            } else if (WOCount == 2) {
                System.out.println("Orderless Correct 2 digits! You earned $1,000");
                win = 1;
            } else {
                System.out.println("\t\t****Correct Lottery Number: "+l_number + " to verify logic!");
                System.out.println("Oops! not a matched number.");
            }
        }while(win != 1);

    }
}