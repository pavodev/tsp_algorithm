package ch.supsi.tsp_algoritmi;

import java.util.Arrays;
import java.util.List;

class NearestNeighbor {
    private List<City> route;

    public NearestNeighbor(List<City> route) {
        this.route = route;
    }

    /*
        This method computes the nearest neighbor algorithm.

        Parameters:
            - A list of cities
            - The distanceMatrix of the list of cities

        Returns:
            - the totalDistance
         */
    public City[] compute(int[][] distanceMatrix) {

        int totalDistance = 0;

        City[] cities = this.route.toArray(new City[0]);

        City[] visitedCities = new City[cities.length];

        int index = 0;
        int newMinIndex = 0;
        int current = 0;
        int min = Integer.MAX_VALUE;

        //add the initial city to the visited cities list
        visitedCities[0] = cities[0];

        while (index < cities.length-1) {
            for (int i = 0; i < cities.length; i++) {
                if (i != current && distanceMatrix[current][i] < min && !Arrays.asList(visitedCities).contains(cities[i])) {
                    newMinIndex = i;
                    min = distanceMatrix[current][i];
                }
            }
            totalDistance += min; //update the total distance

            current = newMinIndex;
            min = Integer.MAX_VALUE; //reset minimum distance to a large number

            index++;

            visitedCities[index] = cities[current]; //add the nearest city to the visited list
        }

        return visitedCities;
    }

}
