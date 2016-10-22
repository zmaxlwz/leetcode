package addAndSearchWord;

import java.util.*;

public class WordDictionary {

	private TrieNode root;

	public WordDictionary(){
		root = new TrieNode();
	}

	public void addWord(String word){

		TrieNode p = root;
		int length = word.length();
		for(int i=0;i<length;i++){
			char c = word.charAt(i);
			if(!p.children.containsKey(c)){
				p.children.put(c, new TrieNode(c));
			}
			p = p.children.get(c);
		}
		p.isLeaf = true;
	}

	public boolean search(String word){
		//word may be literal word or regular expression with ‘.’ and letter a-z
		return dfs(root, word, 0);

	}

	private boolean dfs(TrieNode node, String word, int start){
		//start is the index to check in word
		if(start>=word.length()){
			if(node.isLeaf)
				return true;
			else
				return false;
		}
		
		char c = word.charAt(start);
		if(c != '.'){
			if(!node.children.containsKey(c)){
				return false;
			}
			else{
				TrieNode child = node.children.get(c);
				return dfs(child, word, start+1);
			}
		}
		else{
			//c == '.'
			for(char ch: node.children.keySet()){
				TrieNode child = node.children.get(ch);
				if(dfs(child, word, start+1)){
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WordDictionary dict = new WordDictionary();
		
		/*
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		System.out.println(dict.search("pad"));
		System.out.println(dict.search("bad"));
		System.out.println(dict.search(".ad"));
		System.out.println(dict.search("b.."));
		*/
		
		dict.addWord("at");
		dict.addWord("and");
		dict.addWord("an");
		dict.addWord("add");
		dict.search("a");
		dict.search(".at");
		
		dict.addWord("bat");
		dict.search(".at");
		dict.search("an.");
		dict.search("a.d.");
		dict.search("b.");
		dict.search("a.d");
		dict.search(".");
		
	}

}

class TrieNode{

	char ch;
	HashMap<Character, TrieNode> children;
	boolean isLeaf;

	public TrieNode(){
		children = new HashMap<Character, TrieNode>();
		isLeaf = false;
	}

	public TrieNode(char c){
		ch = c;
		children = new HashMap<Character, TrieNode>();
		isLeaf = false;
	}
}
