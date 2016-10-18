package implementTrie;

import java.util.*;

public class Trie {

	private TrieNode root;

	public Trie(){
		root = new TrieNode();
	}

	public void insert(String word){
		TrieNode p = root;
		int length = word.length();
		for(int i=0;i<length;i++){
			char c = word.charAt(i);
			if(p.children.containsKey(c)){
				p = p.children.get(c);
			}
			else{
				TrieNode newNode = new TrieNode(c);
				p.children.put(c, newNode);
				p = p.children.get(c);
			}
		}
		p.isLeaf = true;
	}

	public boolean search(String word){

		TrieNode p = root;
		int length = word.length();
		for(int i = 0;i<length;i++){
			char c = word.charAt(i);
			if(!p.children.containsKey(c)){
				return false;
			}
			else{
				p = p.children.get(c);
			}
		}
		if(p.isLeaf){
			return true;
		}
		else{
			return false;
		}

	}

	public boolean startsWith(String prefix){

		TrieNode p = root;
		int length = prefix.length();
		for(int i=0;i<length;i++){
			char c = prefix.charAt(i);
			if(!p.children.containsKey(c)){
				return false;
			}
			else{
				p = p.children.get(c);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie();
		trie.insert("cloud");
		System.out.println(trie.search("clo"));
		System.out.println(trie.startsWith("clo"));
		System.out.println(trie.search("cloud"));

		trie.insert("clo");
		System.out.println(trie.search("clo"));
		System.out.println(trie.startsWith("clo"));
		System.out.println(trie.search("cloud"));

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


class TrieNode2{
	Character c;
	boolean isLeaf;
	HashMap<Character, TrieNode2> childMap;
	public TrieNode2(){
		c = null;
		isLeaf = false;
		childMap = new HashMap<Character, TrieNode2>();
	}
}

class Trie2{

	private TrieNode2 root;
	public Trie2(){
		root = new TrieNode2();
	}
	public void insert(String word){
		if(word == null || word.length()==0){
			return;
		}
		int length = word.length();
		TrieNode2 p = root;
		for(int i =0; i<length;i++){
			char ch = word.charAt(i);
			if(p.childMap.containsKey(ch)){
				p = p.childMap.get(ch);
			}
			else{
				p.childMap.put(ch, new TrieNode2());
				p = p.childMap.get(ch);
				p.c = ch;
			}
		}
		p.isLeaf = true;
		return;
	}
	public boolean search(String word){
		if(word==null || word.length()==0){
			return true;
		}
		int length = word.length();
		TrieNode2 p = root;
		for(int i =0;i<length;i++){
			char ch = word.charAt(i);
			if(!p.childMap.containsKey(ch)){
				return false;
			}
			p = p.childMap.get(ch);
		}
		if(!p.isLeaf){
			return false;
		}
		return true;
	}
	public boolean startsWith(String prefix){
		if(prefix==null || prefix.length()==0){
			return true;
		}
		int length = prefix.length();
		TrieNode2 p = root;
		for(int i =0;i<length;i++){
			char ch = prefix.charAt(i);
			if(!p.childMap.containsKey(ch)){
				return false;
			}
			p = p.childMap.get(ch);
		}
		return true;
	}
}

