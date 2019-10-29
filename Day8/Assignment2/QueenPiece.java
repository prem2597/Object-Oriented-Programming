class QueenPiece extends Piece{
	QueenPiece(){
		this.position = new Position(0,4);
	}
	public boolean isValid(Position location){
		if(isValidMove(location)){
			if (location.row == this.position.row || location.column == this.position.column
			        || Math.abs(location.row - this.position.row) == Math.abs(location.column - this.position.column)) {
				return true;
			}
		}
		return false;
	} 
	public void print(){
		System.out.println(this.position.row);
		System.out.println(this.position.column);
	}
}