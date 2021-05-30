package com.india.suidhaga;

public class Category_Model {
    private String categoryIconLink;
    private String category_name;

    public Category_Model(String categoryIconLink , String category_name) {
        this.categoryIconLink = categoryIconLink;
        this.category_name = category_name;

    }


    public String getCategoryIconLink() {
        return categoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        this.categoryIconLink = categoryIconLink;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
