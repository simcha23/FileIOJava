import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Please enter your comment: ");
        String comment = scanner.next();

        System.out.println("Please enter the name of a person that assisted you: ");
        String assistPerson = scanner.next();


        Visitor visitor = new Visitor(fullName, age, LocalDate.now(),LocalTime.now(),comment, assistPerson);
        visitor.save();


    }
}
