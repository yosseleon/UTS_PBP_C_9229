package com.uts_pbp_c_9229.listdata;

import com.uts_pbp_c_9229.dao.Category;

import java.util.ArrayList;

public class CategoryList {
    public ArrayList<Category> categories;

    public CategoryList(){
        categories = new ArrayList<>();
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        categories.add(c5);
    }

    public static final Category c1 = new Category(1, "Beach");
    public static final Category c2 = new Category(2, "City");
    public static final Category c3 = new Category(3, "Temple");
    public static final Category c4 = new Category(4, "River");
    public static final Category c5 = new Category(5, "Hotel");
}
