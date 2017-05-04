package entity;

import entity.RentUnit;
import entity.SportEquipment;

/**
 * Created by vbokh on 02.05.2017.
 */
public class Customer {
    private int id;
    private String name;
    private RentUnit borrowedGoods;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        borrowedGoods = new RentUnit();
    }

    public RentUnit getBorrowedGoods() {
        return borrowedGoods;
    }

    public void setBorrowedGoods(RentUnit borrowedGoods) {
        this.borrowedGoods = borrowedGoods;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
