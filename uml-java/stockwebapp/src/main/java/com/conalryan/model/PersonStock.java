package com.conalryan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Models a table the combines person with stocks.
 */
@Entity
@Table(name = "people_stocks", catalog = "stockappdb")
public class PersonStock {
    private int id;
    private Person person;
    private Stock stock;

    /**
     * Create a PersonStock that needs to be initialized
     */
    public PersonStock() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStock
     *
     * @param person the person to assign the hobby to
     * @param stock  the stock to associate the person with
     */
    public PersonStock(Person person, Stock stock) {
        setStock(stock);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a particular row in the people_stocks table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the people_stocks table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return get the Person associated with this Stock
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the Stock
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     *
     * @return get the Stock associated with this Person
     */
    @ManyToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "ID", nullable = false)
    public Stock getStock() {
        return stock;
    }

    /**
     * Specify the Stock associated with the Person.
     *
     * @param stock a person instance
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStock that = (PersonStock) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonHobby{" +
                "id=" + id +
                ", person=" + person +
                ", stock=" + stock +
                '}';
    }
}
