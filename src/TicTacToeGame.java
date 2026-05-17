public class TicTacToeGame {
    private char[][] board;
    private boolean xTurn;

    public TicTacToeGame() {
        board = new char[3][3];
        xTurn = true;
    }

    public char getCurrentPlayer() {
        return xTurn ? 'X' : 'O';
    }

    public boolean makeMove(int row, int col) {
        // TODO: Only allow placing if empty
        // Place the current player's symbol and toggle turn
    	if(col >= 0 && col<3 && row>= 0 && row < 3 && board[row][col]=='\0') {
    		board[row][col]= getCurrentPlayer();
    		xTurn = !xTurn;
    		return true;
    	}
    	
        return false; // return true if move was successful
    }

    public char checkWinner() {
        for (char player : new char[] { 'X', 'O' }) {
            for (int i = 0; i < 3; i++) {
                // Rows and columns
                if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                    return player;
                }
            }
            // Diagonals
            if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
                return player;
            }
        }
        return '\0';
    }


    public boolean isDraw() {
        // TODO: Check if the board is full and no winner
    	for(int row =0; row<3; row++) {
    		for(int col =0; col<3; col++) {
    			if(board[row][col]=='\0' ) {
    				return false;
    			}
    		}
    	}
        return checkWinner() == '\0';
    }

    public char getSymbolAt(int row, int col) {
        return board[row][col];
    }

    public void reset() {
        // TODO: Reset the board and turn
    	    for (int i = 0; i < 3; i++) {
    	        for (int j = 0; j < 3; j++) {
    	            board[i][j] = '\0';
    	        }
    	    }
    	    xTurn = true;
    	}

 
}