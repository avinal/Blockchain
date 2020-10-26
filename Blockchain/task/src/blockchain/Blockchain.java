package blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
    private final List<Block> blockChain;
    private final BlockMiner miner;


    public Blockchain(int hashZeros) {
        blockChain = new ArrayList<>();
        miner = new BlockMiner(hashZeros);
    }

    public void addBlock() {
        if (blockChain.size() == 0) {
            blockChain.add(miner.mine(new Block(0,
                    "0", "0",
                    new Date().getTime(),
                    0,
                    0)));
        } else {
            blockChain.add(miner.mine(blockChain.get(blockChain.size() - 1)));
        }
    }

    public void printBlockchain() {
        for (Block block : blockChain) {
            block.printBlock();
        }
    }

}
