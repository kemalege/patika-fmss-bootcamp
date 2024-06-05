package repository;

import model.House;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {
    private List<House> houseList = new ArrayList<>();
    private List<House> villaList = new ArrayList<>();
    private List<House> summerHouseList = new ArrayList<>();

    public HouseRepository() {
        houseList.add(new House("House", 3, 1, 120, 300000));
        houseList.add(new House("House", 2, 1, 90, 200000));
        houseList.add(new House("House", 4, 1, 150, 400000));

        villaList.add(new House("Villa", 5, 2, 300, 1000000));
        villaList.add(new House("Villa", 4, 2, 250, 800000));
        villaList.add(new House("Villa", 6, 3, 350, 1200000));

        summerHouseList.add(new House("SummerHouse", 3, 1, 100, 400000));
        summerHouseList.add(new House("SummerHouse", 2, 1, 80, 300000));
        summerHouseList.add(new House("SummerHouse", 4, 2, 130, 500000));
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public List<House> getVillaList() {
        return villaList;
    }

    public List<House> getSummerHouseList() {
        return summerHouseList;
    }

    public List<House> getAllProperties() {
        List<House> allProperties = new ArrayList<>();
        allProperties.addAll(houseList);
        allProperties.addAll(villaList);
        allProperties.addAll(summerHouseList);
        return allProperties;
    }
}
