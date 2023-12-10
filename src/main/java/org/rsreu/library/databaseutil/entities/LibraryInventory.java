package org.rsreu.library.databaseutil.entities;

public class LibraryInventory {
    private int inventoryId;
    private Integer bookId;
    private String location;
    private String status;

    public LibraryInventory(int inventoryId, Integer bookId, String location, String status) {
        this.inventoryId = inventoryId;
        this.bookId = bookId;
        this.location = location;
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
