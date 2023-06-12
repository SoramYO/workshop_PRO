/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

/**
 *
 * @author Son
 */
public class Subject extends Document {
    String subjectCode;
    int numOfCredit;
    String title;
    String references;

    public Subject(String subjectCode, int numOfCredit, String title, String references, String nameDocument, String author, String yearOfPublication, int coverPrice) {
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
}
