class Movie {
    /**
     * movieName which should be guessed by the player.
     */
    private String movieName;
    /**
     * level which is represened denpending on the type.
     */
    private String level;
    /**
     * hint1 represents the hint to guess.
     */
    private String hint1;
    /**
     * hint2 represents the hint to guess.
     */
    private String hint2;
    Movie(final String movieName1, final String level1,
            final String hints1, final String hints2) {
        this.movieName = movieName1;
        this.level = level1;
        this.hint1 = hints1;
        this.hint2 = hints2;
    }
    public String getMovieName() {
            return movieName;
    }
    public void setMovieName(final String movieName1) {
        this.movieName = movieName1;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(final String level1) {
        this.level = level1;
    }
    public String getHint1() {
        return hint1;
    }
    public void setHint1(final String hints1) {
        this.hint1 = hints1;
    }
    public String getHint2() {
        return hint2;
    }
    public void setHint2(final String hints2) {
        this.hint2 = hints2;
    }
}
