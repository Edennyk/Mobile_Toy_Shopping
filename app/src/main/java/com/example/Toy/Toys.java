package com.example.Toy;

public class Toys {

    //properies/instance variables
    int image;
    String name, company, description, price, category;

    public Toys(int image, String name, String company, String description, String price, String category)
    {
        this.image = image;
        this.name = name;
        this.company = company;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public int getImage()
    {
        return image;
    }

    public String getName()
    {
        return name;
    }

    public String getCompany()
    {
        return company;
    }

    public String getDescription()
    {
        return description;
    }

    public String getPrice()
    {
        return price;
    }
    public String getCategory()
    {
        return category;
    }
}
