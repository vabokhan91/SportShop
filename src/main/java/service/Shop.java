package service;

import entity.Customer;
import entity.Category;
import entity.SportEquipment;

import java.io.*;
import java.util.*;

/**
 * Created by vbokh on 02.05.2017.
 */
public class Shop {
    /**
     * Character used for splitting strings, while reading from file in initStore method
     */
    private static final String COMMA_DELIMITER = ",";

    /**
     * Used for keeping available sport equipment. Map-value - number of available equipment
     */
    private Map<SportEquipment, Integer> goods;

    /**
     * Used for keeping rented sport equipment. Map-value - number of equipment rented
     */
    private Map<SportEquipment, Integer> rentedGoods;

    public Shop(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
    }

    public Shop(String filename) {
        rentedGoods = new HashMap<SportEquipment, Integer>();
        goods = new HashMap<SportEquipment, Integer>();
        goods.putAll(initStore(filename));
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
    }

    /**
     * Rents sport equipment to clients. If equipment is available and customer can rent more equipment, then decreases
     * number of equipment in map goods by 1, adds equipment to array of customers' rented goods and increases number of equipment by 1
     * in map of rented goods.
     *
     * @param customer  the object which is checked, if it is allowed to rent more equipment.
     * @param equipment the object, which is checked, if there is available equipment in the shop. The object then stored in the map
     *                  of rented goods,
     */
    public void rent(Customer customer, SportEquipment equipment) {
        if (isEquipmentAvailable(equipment)) {
            if (checkQuantity(customer)) {
                goods.put(equipment, goods.get(equipment) - 1);
                customer.getBorrowedGoods().addUnits(equipment);
                if (rentedGoods.containsKey(equipment)) {
                    rentedGoods.put(equipment, rentedGoods.get(equipment) + 1);
                } else {
                    rentedGoods.put(equipment, 1);
                }
            } else {
                System.out.println("Can not rent equipment. Customer " + customer.getId() + " " + customer.getName() + " has already borrowed > 3 units.");
            }
        } else {
            System.out.println("There is no equipment available");
        }
    }

    /**
     * Checks if requested equipment is available.
     */
    private boolean isEquipmentAvailable(SportEquipment equipment) {
        if (goods.get(equipment) > 0) {
            return true;
        } else return false;
    }

    /**
     * Checks the number of equipment, which customer has already rented.
     */
    private boolean checkQuantity(Customer customer) {
        if (customer.getBorrowedGoods().getUnits().length > 3) {
            return false;
        } else return true;
    }

    /**
     * Searches the requested equipment by title and uses overlap between the entered parameter (name) and the title field of sportequipment object.
     * Returns object of type SportEquipment, if found, or null.
     */
    public SportEquipment findByTitle(String name) {
        SportEquipment good = null;
        Set<SportEquipment> keyset = goods.keySet();
        Iterator<SportEquipment> iterator = keyset.iterator();

        while (iterator.hasNext()) {
            SportEquipment current = iterator.next();
            if (current.getTitle().contains(name)) {
                good = new SportEquipment(current.getCategory(), current.getTitle(), current.getPrice());
                break;
            }
        }
        return good;
    }

    /**
     * Prints available equipment in the shop.
     */
    public void printAvailiableEquipment() {
        Set<SportEquipment> available = goods.keySet();
        for (SportEquipment unit : available) {
            System.out.println(unit + " , available units : " + goods.get(unit));
        }
    }

    /**
     * Prints rented equipment.
     */
    public void printRentedGoods() {
        Set<SportEquipment> rented = rentedGoods.keySet();
        for (SportEquipment unit : rented) {
            System.out.println(unit + " , number of rented : " + rentedGoods.get(unit));
        }
    }

    /**
     * Initializes shop store from file.
     */
    private Map<SportEquipment, Integer> initStore(String filename) {
        Map<SportEquipment, Integer> shopEquipment = new HashMap<SportEquipment, Integer>();
        File initializationFile = new File(filename);
        SportEquipment sportEquipment;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(initializationFile));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                Category category = new Category(tokens[0]);

                String title = tokens[1];
                int price = Integer.parseInt(tokens[2]);
                Integer number = Integer.parseInt(tokens[3]);
                sportEquipment = new SportEquipment(category, title, price);
                shopEquipment.put(sportEquipment, number);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" No file named " + initializationFile.getName() + " was found.");
        } catch (IOException e) {
            System.out.println("Error while reading from file : " + filename);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return shopEquipment;
    }
}
