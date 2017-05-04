package entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vbokh on 02.05.2017.
 */
public class RentUnit {
    private SportEquipment[] units;

    public RentUnit(SportEquipment[] units) {
        this.units = units;
    }

    public RentUnit() {
        units = new SportEquipment[1];
    }

    public SportEquipment[] getUnits() {
        return units;
    }

    public void setUnits(SportEquipment[] units) {
        this.units = units;
    }

    /**
    * Adds equipment to array of type SportEquipment.
     *
     * @param equipment the object, that is added to the array of SportEquipment units
    */
    public void addUnits(SportEquipment equipment){
        ArrayList<SportEquipment> arr = new ArrayList<SportEquipment>(Arrays.asList(units)) ;
        arr.add(equipment);
        units = arr.toArray(new SportEquipment[arr.size()]);
    }
}
