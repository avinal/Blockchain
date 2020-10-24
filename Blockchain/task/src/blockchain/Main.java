package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain myChain = new Blockchain();

        for (int i = 0; i < 5; i++) {
            myChain.addBlock();
        }

        myChain.printBlockchain();
    }
}

