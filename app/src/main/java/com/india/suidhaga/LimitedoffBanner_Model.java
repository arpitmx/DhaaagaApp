package com.india.suidhaga;

public class LimitedoffBanner_Model {
    private int productImage;
   private String productName;
   private String productPrice_Now;
   private String productPrice_Before;
    private String timeleft;
    private String oldprice;

    public int getProductImage() {
        return productImage;
    }
    public String getOldPrice() {
        return oldprice;
    }

    public void setPoductImage(int poductImage) {
        this.productImage = poductImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setOldPrice(String oldPrice) {
        this.oldprice = oldprice;
    }

    public String getProductPrice_Now() {
        return productPrice_Now;
    }

    public void setProductPrice_Now(String productPrice_Now) {
        this.productPrice_Now = productPrice_Now;
    }

    public String getProductPrice_Before() {
        return productPrice_Before;
    }

    public void setProductPrice_Before(String productPrice_Before) {
        this.productPrice_Before = productPrice_Before;
    }

    public String getTimeleft() {
        return timeleft;
    }

    public void setTimeleft(String timeleft) {
        this.timeleft = timeleft;
    }

    public LimitedoffBanner_Model(int poductImage, String productName, String productPrice_Now, String productPrice_Before, String timeleft,String oldprice) {
        this.productImage = poductImage;
        this.productName = productName;
        this.productPrice_Now = productPrice_Now;
        this.productPrice_Before = productPrice_Before;
        this.timeleft = timeleft;
        this.oldprice = oldprice;



    }
}
