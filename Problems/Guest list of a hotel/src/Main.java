//put imports you need here

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String line = in.nextLine();
            list.addAll(Arrays.asList(line.split(" ")));
        }
        Collections.reverse(list);
        for (var name : list) {
            System.out.println(name);
        }
    }
}