package blockchain;

import java.security.MessageDigest;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int Id;

    public Block(String data, String previousHash, long timeStamp, int Id) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.Id = Id;
        calculateHash();
    }

    private void calculateHash() {
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
            this.hash = hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void printBlock() {
        System.out.println("Block:");
        System.out.println("Id: " + Id);
        System.out.println("Timestamp: " + timeStamp);
        System.out.println("Hash of the previous block:");
        System.out.println(previousHash);
        System.out.println("Hash of the block:");
        System.out.println(hash);
        System.out.println();
    }
}
