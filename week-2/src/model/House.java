package model;

public class House {
    private String type;
    private int roomCount;
    private int livingRoomCount;
    private double area;
    private double price;

    public House(String type, int roomCount, int livingRoomCount, double area, double price) {
        this.type = type;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
        this.area = area;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }
}