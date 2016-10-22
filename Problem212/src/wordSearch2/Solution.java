package wordSearch2;

import java.util.*;

public class Solution {

	private TrieNode root;

	public Solution(){
		root = new TrieNode();
	}

	public List<String> findWords(char[][] board, String[] words){
		List<String> result = new ArrayList<String>();
		if(words == null || words.length==0){
			return result;
		}
		if(board == null || board.length==0){
			return result;
		}

		int numWords = words.length;
		for(int i=0;i<numWords;i++){
			insert(words[i]);
		}
		List<Character> temp = new ArrayList<Character>();
		int numRow = board.length;
		int numCol = board[0].length;
		HashSet<String> set = new HashSet<String>();
		boolean[][] visited = new boolean[numRow][numCol];

		for(int i=0;i<numRow;i++){
			for(int j=0;j<numCol;j++){
				dfs(board, i, j, visited, root, temp, result, set);
			}
		}

		return result;
	}

	private void dfs(char[][] board, int rowIndex, int colIndex, boolean[][] visited, TrieNode node, List<Character> temp, List<String> result, HashSet<String> set){
		if(!node.children.containsKey(board[rowIndex][colIndex])){
			return;
		}
		if(visited[rowIndex][colIndex]){
			return;
		}
		visited[rowIndex][colIndex] = true;
		temp.add(board[rowIndex][colIndex]);
		TrieNode child = node.children.get(board[rowIndex][colIndex]);
		if(child.isLeaf){
			StringBuilder builder = new StringBuilder(temp.size());
			for(char c: temp){
				builder.append(c);
			}
			String s = builder.toString();
			if(!set.contains(s)){
				result.add(s);
				set.add(s);
			}

		}

		if(rowIndex-1>=0){
			dfs(board, rowIndex-1, colIndex, visited, child, temp, result, set);
		}
		if(rowIndex+1<board.length){
			dfs(board, rowIndex+1, colIndex, visited, child, temp, result, set);
		}
		if(colIndex-1>=0){
			dfs(board, rowIndex, colIndex-1, visited, child, temp, result, set);
		}
		if(colIndex+1<board[0].length){
			dfs(board, rowIndex, colIndex+1, visited, child, temp, result, set);
		}


		visited[rowIndex][colIndex] = false;
		temp.remove(temp.size()-1);
		return;
	}

	private void insert(String word){
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"oath", "pea", "eat", "rain"};
		char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

		Solution sol = new Solution();
		System.out.println(sol.findWords(board, words));

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
