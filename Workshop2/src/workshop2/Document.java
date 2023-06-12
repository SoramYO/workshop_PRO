
package workshop2;


public class Document {
    String nameDocument;
    String author;
    String yearOfPublication;
    int coverPrice;

    public Document() {
    }

    public Document(String nameDocument, String author, String yearOfPublication, int coverPrice) {
        this.nameDocument = nameDocument;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.coverPrice = coverPrice;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getCoverPrice() {
        return coverPrice;
    }

    public void setCoverPrice(int coverPrice) {
        this.coverPrice = coverPrice;
    }

    
}
