import model.House;
import service.HouseService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    HouseService houseService = new HouseService();

        System.out.println("Evlerin toplam fiyatı: " + houseService.getTotalPriceOfHouse());
        System.out.println("Villaların toplam fiyatı: " + houseService.getTotalPriceOfVilla());
        System.out.println("Yazlıkların toplam fiyatı: " + houseService.getTotalPriceOfSummerHouse());
        System.out.println("Tüm tipteki evlerin toplam fiyatı: " + houseService.getTotalPriceOfAllProperties());

        System.out.println("Evlerin ortalama metrekaresi: " + houseService.getAverageAreaOfHouse());
        System.out.println("Villaların ortalama metrekaresi: " + houseService.getAverageAreaOfVilla());
        System.out.println("Yazlıkların ortalama metrekaresi: " + houseService.getAverageAreaOfSummerHouse());
        System.out.println("Tüm tipteki evlerin ortalama metrekaresi: " + houseService.getAverageAreaOfAllProperties());

    int filterRoomCount = 3;
    int filterLivingRoomCount = 1;
    List<House> filteredProperties = houseService.filterPropertiesByRoomAndLivingRoomCount(filterRoomCount, filterLivingRoomCount);
        System.out.println(filterRoomCount + " Oda sayısına ve " + filterLivingRoomCount + " salon sayısına göre tüm tipteki evler " + filteredProperties.size());

    }
}