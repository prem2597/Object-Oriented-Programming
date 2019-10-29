class Runner{
	public static void main(String[] args) {
		QueenPiece queen = new QueenPiece();
		Position newPosition = new Position(2,4);
		System.out.println((queen.isValid(newPosition)));
		if(queen.isValid(newPosition)){
			queen.move(newPosition);
		}
		queen.print();
	}
}