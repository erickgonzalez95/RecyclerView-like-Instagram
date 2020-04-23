package com.androiddevs.recyclerview;

public class Person {
    private int imageResource;
    private String name;

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    private Boolean isSelected;
    private int age;

    public Person(String name, int age, int image,boolean isSelected) {
        this.name = name;
        this.age = age;
        this.imageResource = image;
        this.isSelected= isSelected;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getImageResource() { return imageResource; }

    public void setImageResource(int imageResource) { this.imageResource = imageResource; }
}
