class Movie {
    private String movieName;
    private String level;
    private String[] hint;
    Movie (final String movieName1, final String leveltype, final String[] hints1) {
        this.movieName = movieName;
        this.level = leveltype;
        this.hint = hints1;
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
    public void setLevel(final String leveltype) {
        this.level = leveltype;
    }
    public String[] getHint() {
        return hint;
    }
    public void getHint(final String[] hints1) {
        this.hint = hints1;
    }
}