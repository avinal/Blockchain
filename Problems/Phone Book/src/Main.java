import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

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

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int indx = findKey(key);

            if (indx == -1) {
                return false;
            }

            table[indx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }
            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            int inx = findKey(key);

            if (inx == -1) {
                return;
            }

            table[inx] = null;
        }

        private int findKey(int key) {
            int hash = key % size;
            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }
            return hash;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        String line;
        HashTable<String> table = new HashTable<>(size);

        for (int i = 0; i <= size; i++) {
            line = in.nextLine();
            String[] lineList = line.split(" ");
            switch (lineList[0]) {
                case "put":
                    table.put(Integer.parseInt(lineList[1]), lineList[2]);
                    break;
                case "get":
                    String result = table.get(Integer.parseInt(lineList[1]));
                    System.out.println(result != null ? result : -1);
                    break;
                case "remove":
                    table.remove(Integer.parseInt(lineList[1]));
                    break;
            }
            //System.out.println(i);
        }
    }
}