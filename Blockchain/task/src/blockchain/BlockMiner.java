package blockchain;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

public class BlockMiner {
    private final int hashZeros;

    public BlockMiner(int hashZeros) {
        this.hashZeros = hashZeros;
    }


    public Block mine(Block previousBlock) {
        long startMining = new Date().getTime();
        String hash;
        String prefixString = new String(new char[hashZeros]).replace('\0', '0');
        long magicNumber;
        do {
            magicNumber = new Random().nextInt(Integer.MAX_VALUE);
            String data = previousBlock.getId()
                    + previousBlock.getTimeStamp()
                    + previousBlock.getHash()
                    + magicNumber;
            hash = calculateHash(data);
        } while (!hash.substring(0, hashZeros).equals(prefixString));
        long finishMining = new Date().getTime();
        return new Block(magicNumber,
                previousBlock.getHash(),
                hash,
                finishMining,
                previousBlock.getId() + 1,
                (finishMining - startMining) / 1000);
    }

    private String calculateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

