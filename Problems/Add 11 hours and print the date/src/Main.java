import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inDate = in.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(inDate);
        System.out.println(dateTime.plusHours(11).toLocalDate());
        in.close();
    }
}