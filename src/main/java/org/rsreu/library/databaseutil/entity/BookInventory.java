package org.rsreu.library.databaseutil.entity;

/**
 * The BookInventory class represents the inventory details of a book.
 */
public class BookInventory {

    private Long inventoryId; // Unique identifier for the inventory
    private Long bookId; // Identifier for the book associated with the inventory
    private String location; // Location where the book is stored
    private String status; // Status of the book in the inventory

    /**
     * Retrieves the inventory's unique identifier.
     *
     * @return The inventory's ID
     */
    public Long getInventoryId() {
        return inventoryId;
    }

    /**
     * Sets the inventory's unique identifier.
     *
     * @param inventoryId The inventory's ID to set
     */
    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * Retrieves the book's identifier associated with this inventory.
     *
     * @return The book's ID
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * Sets the book's identifier associated with this inventory.
     *
     * @param bookId The book's ID to set
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * Retrieves the location where the book is stored in the inventory.
     *
     * @return The location of the book
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where the book is stored in the inventory.
     *
     * @param location The location of the book to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Retrieves the status of the book in the inventory.
     *
     * @return The status of the book
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the book in the inventory.
     *
     * @param status The status of the book to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
