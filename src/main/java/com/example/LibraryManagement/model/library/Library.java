package com.example.LibraryManagement.model.library;


import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String name;
    private int count;
    private String imageURL;

    public Library(){

    }
    public Library(String name, int count, String imageURL) {
        this.name = name;
        this.count = count;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return name;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
