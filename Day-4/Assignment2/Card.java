class Card {
    private String title;
    private String author;
    private String subject;
    Card(final String title, final String author, final String subject) {
        this.title = title;
        this.author = author;
        this.subject = subject;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getSubject() {
        return this.subject;
    }
    public String toString() {
        return "{ Title = " + this.title + ", Author = " + this.author
        + ", Subject = " + this.subject + " }" ;
    }
    public void setTitle(final String toset) {
        this.title = toset;
    }
    public void setAuthor(final String toset) {
        this.author = toset;
    }
    public void setSubject(final String toset) {
        this.subject = toset;
    }
}
