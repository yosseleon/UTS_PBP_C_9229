package com.uts_pbp_c_9229.listdata;

import com.uts_pbp_c_9229.dao.City;

import java.util.ArrayList;

public class CityList {
    public ArrayList<City> cities;

    public CityList(){
        cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
    }

    public static final City city1 = new City(1, "Bali", "https://i.ibb.co/JdCrW2D/bali-city.png");
    public static final City city2 = new City(2, "Jakarta", "https://i.ibb.co/S6Ywp0X/jakarta-city.png");
    public static final City city3 = new City(3, "Semarang", "https://i.ibb.co/0tGdVhP/semarang-city.png");
    public static final City city4 = new City(4, "Yogyakarta", "https://i.ibb.co/C23r170/yogyakarta-city.png");
}
