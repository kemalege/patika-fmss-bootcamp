package service;

import model.House;
import repository.HouseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class HouseService {
    private HouseRepository houseRepository;

    public HouseService() {
        this.houseRepository = new HouseRepository();
    }

    public double getTotalPriceOfHouse() {
        return houseRepository.getHouseList().stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceOfVilla() {
        return houseRepository.getVillaList().stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceOfSummerHouse() {
        return houseRepository.getSummerHouseList().stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalPriceOfAllProperties() {
        return houseRepository.getAllProperties().stream().mapToDouble(House::getPrice).sum();
    }

    public double getAverageAreaOfHouse() {
        return houseRepository.getHouseList().stream().mapToDouble(House::getArea).average().orElse(0);
    }

    public double getAverageAreaOfVilla() {
        return houseRepository.getVillaList().stream().mapToDouble(House::getArea).average().orElse(0);
    }

    public double getAverageAreaOfSummerHouse() {
        return houseRepository.getSummerHouseList().stream().mapToDouble(House::getArea).average().orElse(0);
    }

    public double getAverageAreaOfAllProperties() {
        return houseRepository.getAllProperties().stream().mapToDouble(House::getArea).average().orElse(0);
    }

    public List<House> filterPropertiesByRoomAndLivingRoomCount(int roomCount, int livingRoomCount) {
        return houseRepository.getAllProperties().stream()
                .filter(house -> house.getRoomCount() == roomCount && house.getLivingRoomCount() == livingRoomCount)
                .collect(Collectors.toList());
    }
}
