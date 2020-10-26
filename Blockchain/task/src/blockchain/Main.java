package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with: ");
        int hashZeros = in.nextInt();
        Blockchain blockChain = new Blockchain(hashZeros);

        for (int i = 0; i < 5; i++) {
            blockChain.addBlock();
        }

        blockChain.printBlockchain();
    }
}

