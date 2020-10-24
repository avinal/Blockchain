package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
    private List<Block> blockChain;

    public Blockchain() {
        blockChain = new ArrayList<>();
    }

    public void addBlock() {
        String dataString = "I am Avinal";
        if (blockChain.size() == 0) {
            blockChain.add(new Block(dataString, "0", new Date().getTime(), 1));
        } else {
            dataString += blockChain.size();
            blockChain.add(new Block(dataString,
                    blockChain.get(blockChain.size() - 1).getHash(),
                    new Date().getTime(),
                    blockChain.size() + 1));
        }
    }

    public void printBlockchain() {
        for (Block block : blockChain) {
            block.printBlock();
        }
    }
}
