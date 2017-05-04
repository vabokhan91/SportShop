package test;

import entity.Customer;
import service.Shop;
import entity.SportEquipment;

/**
 * Created by vbokh on 03.05.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Shop shop = new Shop("src/main/resources/equipmentStorage.csv");
        shop.printAvailiableEquipment();

        Customer customer = new Customer(1, "James");
        Customer customer1 = new Customer(2, " John");
        SportEquipment bicycle = shop.findByTitle("Road");
        SportEquipment bmx = shop.findByTitle("BMX");
        SportEquipment footballBalls = shop.findByTitle("Football");
        SportEquipment darts = shop.findByTitle("Darts");

        shop.rent(customer, bicycle);
        shop.rent(customer, bicycle);
        shop.rent(customer, bmx);
        shop.rent(customer, bicycle);
        shop.rent(customer1, footballBalls);
        shop.rent(customer1, darts);
        shop.rent(customer1, footballBalls);

        shop.printAvailiableEquipment();
        shop.printRentedGoods();
    }
}
