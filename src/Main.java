import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrieST trie = new TrieST<String>();
        Scanner scanner = new Scanner(System.in);
        int numOfInputs= scanner.nextInt();
        List<String> tList=new ArrayList<>();
        String word;
        for(int i=0;i<numOfInputs;i++){
            word=scanner.next();
            trie.put(word,i);
            tList.add(word);
            trie.wordList2.add(word);
            trie.wordList.add(word);
            Collections.sort(trie.wordList);
        }
        int opcode=0;
        while(opcode!=6) {
            System.out.println("Enter Operation Code: ");
           opcode= scanner.nextInt();
            switch (opcode){

                case 1:
                    String input=scanner.next();
                    trie.Search(input);
                    break;
                case 2:
                    trie.countPrefix();
                    break;
                case 3:
                    String input2=scanner.next();
                    trie.reverseFind(input2);
                    break;

                case 4:
                    trie.ShortestUniquePrefix(trie);
                    break;

                case 5:
                    trie.LongestCommonPrefix(numOfInputs);
                    break;

                case 6:
                    System.exit(0);
            }


        }
    }
}