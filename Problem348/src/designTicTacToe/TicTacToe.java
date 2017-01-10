package designTicTacToe;

public class TicTacToe {
	
	int size;
	int[] rows;
	int[] cols;
	int diagonal;
	int anti_diagonal;
	
	
	/** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.anti_diagonal = 0;
        this.size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
    	if(player == 1){
    		//this is player 1, add 1
    		this.rows[row]++;
    		if(this.rows[row] == this.size){
    			return 1;
    		}
    		
    		this.cols[col]++;
    		if(this.cols[col] == this.size){
    			return 1;
    		}
    		
    		if(row == col){
    			this.diagonal++;
    			if(this.diagonal == this.size){
    				return 1;
    			}
    		}
    		
    		if(row+col == this.size-1){
    			this.anti_diagonal++;
    			if(this.anti_diagonal == this.size){
    				return 1;
    			}
    		}
    		
    	}
    	else{
    		//this is player 2, minus 1
    		this.rows[row]--;
    		if(this.rows[row] == -this.size){
    			return 2;
    		}
    		
    		this.cols[col]--;
    		if(this.cols[col] == -this.size){
    			return 2;
    		}
    		
    		if(row == col){
    			this.diagonal--;
    			if(this.diagonal == -this.size){
    				return 2;
    			}
    		}
    		
    		if(row+col == this.size-1){
    			this.anti_diagonal--;
    			if(this.anti_diagonal == -this.size){
    				return 2;
    			}
    		}
    	}
    	
    	return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
