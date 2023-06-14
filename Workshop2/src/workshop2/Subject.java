
package workshop2;

public class Subject extends Document {
    String subjectCode;
    int numOfCredit;
    String title;
    String references;

    public Subject(String nameDocument, String author, String yearOfPublication, int coverPrice,String subjectCode, int numOfCredit, String title, String references) {
        super(nameDocument, author, yearOfPublication, coverPrice);
        this.subjectCode = subjectCode;
        this.numOfCredit = numOfCredit;
        this.title = title;
        this.references = references;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getNumOfCredit() {
        return numOfCredit;
    }

    public void setNumOfCredit(int numOfCredit) {
        this.numOfCredit = numOfCredit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectCode=" + subjectCode + ", numOfCredit=" + numOfCredit + ", title=" + title + ", references=" + references + '}';
    }
    
}
