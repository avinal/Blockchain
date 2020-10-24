import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(date);
        long hoursSince = (dateTime.getDayOfYear() - 1) * 24;
        hoursSince += dateTime.getHour();
        System.out.println(hoursSince);
        in.close();
    }
}