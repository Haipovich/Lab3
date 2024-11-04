package ru.Khismatov.data;

public class House {
    private int num_floors;

    public House(int numFloors) {
        if (numFloors < 1) {
            throw new IllegalArgumentException("Number of floors must be greater than 0");
        }
        this.num_floors = numFloors;
    }

    @Override
    public String toString() {
        return "дом с " + num_floors + " " + get_floor_ending(num_floors);
    }

    private String get_floor_ending(int number) {
        if (number % 100 >= 11 && number % 100 <= 19) {return "этажами";}
        switch (number % 10) {
            case 1:
                return "этажом";
            case 2:
            case 3:
            case 4:
                return "этажами";
            default:
                return "этажами";
        }
    }
}