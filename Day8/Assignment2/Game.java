class Game {
    Piece [][] board;
    // Constructor creates an empty board.
    Game() {
    board = new Piece[8][8];
    }
}

class Piece {
    Position position;
}
class Piece {
    boolean isValidMove(Position newPosition) {
    if(newPosition.row>0 && newPosition.column>0
    && newPosition.row<8 && newPosition.column<8) {
    return true;
    } else {
    return false;
    }
    }
}
Queen queen = new Queen();
Position testPosition = new Position(3,10);
if(queen.isValidMove(testPosition)) {
System.out.println("Yes, I can move there.");
} else {
System.out.println("Nope, can't do!");
}