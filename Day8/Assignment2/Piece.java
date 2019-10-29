class Piece{
	Position position;
	Piece(){
		this.position = new Position();
	}
	 public boolean isValidMove(Position newPos){
	 	if(newPos.row >= 0 && newPos.column >= 0 && newPos.row < 8 && newPos.column < 8){
	 		return true;
	 	}
	 	return false;
	 }
	 public void move(Position newPos){
	 	this.position = newPos;
	 }
}