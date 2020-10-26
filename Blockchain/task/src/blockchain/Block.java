package blockchain;

public class Block {
    private final String hash;
    private final String previousHash;
    private final long data;
    private final long timeStamp;
    private final int Id;
    private final long generationTime;

    public Block(long data, String previousHash, String hash, long timeStamp, int Id, long generationTime) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = hash;
        this.timeStamp = timeStamp;
        this.Id = Id;
        this.generationTime = generationTime;
    }


    public String getHash() {
        return hash;
    }

    public long getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getId() {
        return Id;
    }

    public void printBlock() {
        System.out.println("Block:");
        System.out.println("Id: " + Id);
        System.out.println("Timestamp: " + timeStamp);
        System.out.println("Magic number: " + data);
        System.out.println("Hash of the previous block:");
        System.out.println(previousHash);
        System.out.println("Hash of the block:");
        System.out.println(hash);
        System.out.println("Block was generating for " + generationTime + " seconds");
        System.out.println();
    }
}
