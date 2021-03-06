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
        SportEquipment bicycle1 = shop.findByTitle("RoadBicycle");
        SportEquipment bicycle2 = shop.findByTitle("RoadBicycle");
        SportEquipment bicycle3 = shop.findByTitle("Roadbicycle");
        SportEquipment bmx = shop.findByTitle("BMX");
        SportEquipment footballBalls = shop.findByTitle("FootballBalls");
        SportEquipment darts = shop.findByTitle("Darts");

        shop.rent(customer, bicycle1);
        shop.rent(customer, bicycle2);
        shop.rent(customer, bmx);
        shop.rent(customer, bicycle3);
        shop.rent(customer1, footballBalls);
        shop.rent(customer1, darts);
        shop.rent(customer1, footballBalls);

        shop.printAvailiableEquipment();
        shop.printRentedGoods();
    }
}
