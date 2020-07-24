package model;

public class SellBatchClass {
    String sellingPrice ;

    public SellBatchClass() {
        this.sellingPrice = "-";
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = String.valueOf(sellingPrice);
    }
}
