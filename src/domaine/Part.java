/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author Hourglass
 */
public class Part {
    
    private int id;
    private String desc;
    private String serialNo;
    private double price;
    private int stock;
    private String cat;

    public Part(int id, String desc, String serialNo, double price, int stock, String cat) {
        this.id = id;
        this.desc = desc;
        this.serialNo = serialNo;
        this.price = price;
        this.stock = stock;
        this.cat = cat;
    }

    public int getId() {
        return id;
    }
    
    public String getDesc() {
        return desc;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCat() {
        return cat;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
