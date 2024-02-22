import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInputException extends Exception{
    @Override
    public String getMessage() {
        return "Supported Operations are : \"+ - * /\" ONLY";
    }
}

class CanNotDivideByZeroException extends Exception{
    @Override
    public String getMessage() {
        return "Can't divide by Zero!";
    }
}

class MaxInputException extends Exception{
    @Override
    public String getMessage() {
        return "MAX INPUT is 1,00,000 Selected for NOW!";
    }
}
class MaxMultiplierException extends Exception{
    @Override
    public String getMessage() {
        return "MAX MULTIPLIER is 7,000 Selected for NOW!";
    }
}


public class CalcWithCustomExceptions {

    public static double getA() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Operand-1 : ");
        String temp1 = sc.nextLine().trim();
        String temp = temp1.replace(" ","");
//        for (int i=65; i<=90 ; i++){
//            String t = Integer.toString(i);
//            if(temp.contains(t) || temp.contains(t.toLowerCase())){
//                throw new InputMismatchException();
//            }
//        }
        double a = Double.parseDouble(temp);
        if(a > 100000){
            throw new MaxInputException();
        }
        return a;
    }

    public static double getB() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Operand-2 : ");
        String temp1 = sc.nextLine().trim();
        String temp = temp1.replace(" ","");
        for (int i=65; i<=90 ; i++){
            String t = Integer.toString(i);
            if(temp.contains(t) || temp.contains(t.toLowerCase())){
                throw new InputMismatchException();
            }
        }
        double b = Double.parseDouble(temp);
        if(b > 100000){
            throw new MaxInputException();
        }
        return b;
    }
    
    public static double doOperation(char op , double a , double b) throws Exception{
        if((op != '+' && (op != '-') && (op != '*') && (op != '/'))){
            throw new InvalidInputException();
        }
        switch (op) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                if (b > 7000) {
                    throw new MaxMultiplierException();
                }
                return a * b;
            }
            case '/' -> {
                if (b == 0) {
                    throw new CanNotDivideByZeroException();
                }
                return a / b;
            }
            default -> System.out.println("Invalid Operation");
        }
        return 0;
    }

    public static void main(String[] args){

        try (Scanner sc = new Scanner(System.in)) {
            double a = getA();
            double b = getB();

            System.out.print("Enter Operation( + - * / ) : ");
            String operation = sc.next().trim();

            double result = doOperation(operation.charAt(0), a, b);
            System.out.println("RESULT : " + result);
        }
        catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Enter Valid Input!");
        }
        catch (Exception e) {
//            System.out.println(e);
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("THANK YOU! for Using This.");
        }
    }
}