package ch.supsi.tsp_algoritmi;

import java.util.List;
import java.util.Objects;

public class City {
    private int id;
    private double x;
    private double y;

    public City(int id, double x, double y) {
        this.id = id-1;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public static int getDistance(City city1, City city2){
        double x = Math.abs(city2.getX() - city1.getX());
        double y = Math.abs(city2.getY() - city1.getY());

        return ((int) (Math.hypot(x, y) + 0.5));
    }

    public static int getRouteDistance(List<City> route){
        int totalDistance = 0;
        int j;

        for(int i = 0; i<route.size(); i++){
            j = i+1;
            if(j == route.size()) {
                totalDistance += getDistance(route.get(0), route.get(route.size() - 1));
                break;
            }

            totalDistance += getDistance(route.get(i), route.get(j));
        }

        return totalDistance;
    }

    public static int[][] getDistanceMatrix(List<City> cityList){
        int[][] distanceMatrix = new int[cityList.size()][cityList.size()];

        City city1;
        City city2;

        for(int i=0; i<cityList.size(); i++){
            city1 = cityList.get(i);
            for(int j=0; j<cityList.size(); j++){
                city2 = cityList.get(j);
                distanceMatrix[i][j] = getDistance(city1, city2);
            }
        }

        return distanceMatrix;
    }

    public static void printDistanceMatrix(List<City> cityList, int[][] distanceMatrix) {
        System.out.println();

        System.out.printf("%s\t","");

        for (int j = 0; j < cityList.size(); j++) {
            System.out.printf("%s\t", cityList.get(j).getId());
        }

        System.out.println();

        for (int i = 0; i < cityList.size(); i++) {
            System.out.print("\n");
            System.out.print(cityList.get(i).getId() + "\t");
            for (int j = 0; j < cityList.size(); j++) {
                System.out.printf("%s\t", distanceMatrix[i][j]);
            }
        }

        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID = " + this.getId() + " / x = " + this.getX() + " / y = " + this.getY();
    }
}