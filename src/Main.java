public class Main {
    public static void main(String[] args) {
        HuffmanCoding huffmancoding = new HuffmanCoding();
        huffmancoding.countAlphabet("src/alphabets.txt");
        huffmancoding.makeTree();

        int[] array = new int[huffmancoding.frequency.size() - 1];
        huffmancoding.printFrequency();
        huffmancoding.printEachCharacterCode(huffmancoding.HuffmanTree, array, 0);
    }
}