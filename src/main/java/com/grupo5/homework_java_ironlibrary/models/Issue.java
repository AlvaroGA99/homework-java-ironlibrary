package com.grupo5.homework_java_ironlibrary.models;
import jakarta.persistence.*;

@Entity
@Table(name="issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "return_date")
    private String returnDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_usn",referencedColumnName = "usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "book_isbn",referencedColumnName = "isbn")
    private Book issueBook;

    public Issue(){}

    public Issue(String issueDate, Book issueBook, Student issueStudent, String returnDate) {
        this.issueDate = issueDate;
        this.issueBook = issueBook;
        this.issueStudent = issueStudent;
        this.returnDate = returnDate;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getIssueId() {
        return issueId;

    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    @Override
    public String toString() {
        return " Issue Details:\n" +
                "   Issue ID      : " + issueId + "\n" +
                "   Issue Date    : " + issueDate + "\n" +
                "   Return Date   : " + returnDate + "\n" +
                "   Student       : " + issueStudent + "\n" +
                "   Book          : " + issueBook + "\n";
    }
}
