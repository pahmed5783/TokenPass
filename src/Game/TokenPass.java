
package Game;


public class TokenPass {

    private int[] board;
    private int currentPlayer;
    private int playerCount;

    
    public TokenPass(int playerCount) {
        this.playerCount = playerCount;
        board = new int[playerCount];
        fillBoard(board);
        choosePlayer();
    }

    
    public void fillBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = (int)((Math.random() * 10) + 1);
        }
    }

    
    public void choosePlayer() {


        this.currentPlayer = (int)(Math.random() * board.length);
    }

    
    public void distributeCurrentPlayerTokens() {
        int tokensDist = board[currentPlayer];
        board[currentPlayer] = 0;
        for (int i = currentPlayer + 1; tokensDist > 0; i++) {
            if (i > board.length - 1) {
                i = 0;
            }
            tokensDist--;
            board[i] = board[i] + 1;
        }
    }

    
    public void nextPlayer() {

        if (currentPlayer == board.length - 1) {
            currentPlayer = 0;
        } else {
            currentPlayer++;
        }
    }

    
    public void printBoard() {
        String str = "";
        for (int i = 0; i < board.length; i++) {
            str += " Player " + i + ": " + board[i];
        }
        System.out.println(str);
    }

    
    public int gameOver() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
