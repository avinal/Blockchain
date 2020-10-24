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
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);
            if (idx == -1) {
                return false;
            }
            table[idx] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        private int findKey(int key) {
            int hash = key % size;
            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    rehash();
                    hash = key % size;
                }
            }
            return hash;
        }

        private void rehash() {
            HashTable bigTable = new HashTable(size * 2);
            for (int i = 0; i < size; i++) {
                if (table[i] != null) {
                    bigTable.put(table[i].key, table[i].value);
                }
            }
            this.table = bigTable.table;
            this.size *= 2;
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                            + ", value=" + table[i].getValue());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        HashTable<String> intable = new HashTable<>(5);
        Scanner in = new Scanner(System.in);
        int elements = in.nextInt();
        in.nextLine();
        for (int i = 0; i < elements; i++) {
            String line = in.nextLine();
            String[] keyValue = line.split(" ");
            intable.put(Integer.parseInt(keyValue[0]), keyValue[1]);
        }
        System.out.println(intable.toString());
        in.close();
    }
}