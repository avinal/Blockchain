import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private int filled = 0;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public void put(int key, T value) {
            if (hasKey(key) == -1) {
                table[filled] = new TableEntry(key, value);
                filled++;

            } else {
                table[hasKey(key)] = new TableEntry(key, value);
            }
        }

        public T get(int key) {
            return (T) table[hasKey(key)].getValue();
        }

        public void entrySet() {
            for (int i = 0; i < filled; i++) {
                System.out.println(table[i].getKey() + ": " + table[i].getValue());
            }
        }

        public int hasKey(int key) {
            for (int i = 0; i < size; i++) {
                if (table[i] != null && table[i].getKey() == key) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int query = in.nextInt();
        HashTable<String> table = new HashTable<>(query);
        in.nextLine();
        for (int i = 0; i < query; i++) {
            String name = in.nextLine();
            String[] spl = name.split(" ");
            if (table.hasKey(Integer.parseInt(spl[0])) == -1) {
                table.put(Integer.parseInt(spl[0]), spl[1]);
            } else {
                String now = table.get(Integer.parseInt(spl[0]));
                table.put(Integer.parseInt(spl[0]), now + " " + spl[1]);
            }
        }
        table.entrySet();
    }
}