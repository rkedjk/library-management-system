package org.rsreu.library.databaseutil.entity;

public class BookInventory {

    private Long inventoryId;
    private Long bookId;
    private String location;
    private String status;

    // Getters and Setters for INVENTORY_ID
    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    // Getters and Setters for BOOK_ID
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getters and Setters for LOCATION
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getters and Setters for STATUS
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
