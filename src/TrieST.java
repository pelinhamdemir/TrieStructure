import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrieST<Value> {
    private static final int R = 256;
    private Node root = new Node();
 static List<String> wordList= new ArrayList<>();
    static List<String> wordList2= new ArrayList<>();
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
        int count=0;

    }
    public void put(String key, Value val) {
        root = put(root, key, val, 0);  }
    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = val; return x;
        } char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x; }
    public boolean contains(String key) {
        boolean current = false;
        if(get(key) != null)
            current=true;
        return current;
    }
    public Value get(String key) {
    Node x = get(root, key, 0);
    if (x == null) return null;
    return (Value)x.value; }
    private Node get(Node x, String key, int d) {
    if (x == null) return null;
    if (d == key.length())
        return x;
    char c = key.charAt(d);
    return get(x.next[c], key, d+1); }

    private boolean hasChildren(Node x) {
        for (int i = 0; i < R; i++) {
            if (x.next[i] != null) {
                return true;
            }
        }
        return false;
    }
    public void Search(String arg) {
        if(contains(arg)){
            System.out.println("True");
        } else{
            System.out.println("False");
        }

    }
    int a=0;
    public void countPrefix() {
        List<String> words = countPrefix2(root, "", 0);
        for (int i = 0; i < words.size(); i++) {
            int a = 0; // Initialize count for each prefix
            for (int t = 0; t < words.size(); t++) {
                if (t != i && words.get(t).startsWith(words.get(i))) {
                    a++;
                }
            }
            if(contains(words.get(i))){
                if(a!=0)
                 a--;
        System.out.println(words.get(i) + ":" + a);}
        }
    }

    public List<String> countPrefix2(Node x, String key, int d) {
        List<String> list = new ArrayList<>();
        if (x == null) return list;
        if (d == key.length()) {
            list.add(key);
            for (char c = 0; c < R; c++) {
                list.addAll(countPrefix2(x.next[c], key + c, d + 1));
            }
        }
        return list;
    }
    public void reverseFind(String suffix) {
        List<String> list = new ArrayList<>();

        for (String a : wordList) {
            int length = a.length() - suffix.length();
            if (length >= 0 && a.substring(length).equals(suffix)) {
                list.add(a);
            }
        }
        Collections.sort(list);  // Sort the list lexicographically

        for (int t=0;t< list.size();t++) {
            System.out.println(list.get(t));
        }
        if(list.size()==0)
            System.out.println("not exists");
    }


    public void ShortestUniquePrefix(TrieST trie ) {
        boolean control=true;
        String tempString;
        List<String> temp=new ArrayList<>(wordList2);
        while(!temp.isEmpty()){
            List<String> profixList=new ArrayList<>();
            tempString=temp.remove(0);
            profixList=createPrefix(tempString);

        for(int i=0;i< profixList.size();i++){

            for(int j=0;j< wordList2.size();j++) {

                if(!wordList2.get(j).contains(profixList.get(i)))
                    control=true;
                if (wordList2.get(j).contains(profixList.get(i)) && !wordList2.get(j).equals(tempString)) {
                    control = false;
                    break;
                }

            }
            if(control){
                System.out.println(tempString+": "+profixList.get(i));
                break;
            }
        }

        if(!control)
            System.out.println(tempString+": "+"not exists");
        }

    }

    public List<String> createPrefix(String s){
        List<String> t=new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            t.add(s.substring(0, i));
        }
        return t;
    }
    public void LongestCommonPrefix (int NumOfInput){
        String tempString;
        String tempString2 ="not exists" ;
        int a=0;
        List<String> temp=new ArrayList<>(wordList);
        int count=0;
        while(!temp.isEmpty()){
            List<String> profixList=new ArrayList<>();

            tempString=temp.remove(0);
            profixList=createPrefix(tempString);

            for(int t=0;t< profixList.size();t++){
                for(int i=0;i< wordList.size();i++){
                    if(wordList.get(i).contains(profixList.get(t))) {
                            count++;
                        if (count == NumOfInput && profixList.get(t).length()>a){
                            tempString2=profixList.get(t);
                            a=tempString2.length();

                           }

                    }
                    else {
                        count=0;}

                }

                count=0;
            }
    }

System.out.println(tempString2);

}}