package com.olik.library.rental;

public class RentalRequest {

    private String bookId;
    private String renterName;

    public RentalRequest() {
    }

    public RentalRequest(String bookId, String renterName) {
        this.bookId = bookId;
        this.renterName = renterName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
}
