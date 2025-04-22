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

    @OneToOne
    @JoinColumn(name = "student_usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "book_isbn")
    private Student issueBook;

    public Issue(Student issueBook, String returnDate, Student issueStudent, String issueDate) {
        this.issueBook = issueBook;
        this.returnDate = returnDate;
        this.issueStudent = issueStudent;
        this.issueDate = issueDate;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Student getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Student issueBook) {
        this.issueBook = issueBook;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
