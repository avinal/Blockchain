import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String date = in.next();
        int days = in.nextInt();
        int hours = in.nextInt();
        LocalDateTime dateTime = LocalDateTime.parse(date);
        dateTime = dateTime.plusDays(days);
        dateTime = dateTime.minusHours(hours);
        System.out.println(dateTime);
        in.close();
    }
}