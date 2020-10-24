import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            int kb = in.nextInt();
            list.add(kb);
        }
        int N = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        Collections.sort(list);
    }
}