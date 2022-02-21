package it.gb.esercitazione.windows;

class ItemSeparator{
    String name;
    Double price;
    Integer quantity;
    
    public ItemSeparator(String sub) {
        String[] items = sub.split("$$##");
        setName(items[0]);
        setPrice(Double.parseDouble(items[1]));
        setQuantity(Integer.valueOf(items[2]));
    }
    
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double newPrice) {
        this.price = newPrice;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer newQuantity) {
        this.quantity = newQuantity;
    }
    
}