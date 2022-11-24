/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

/**
 *
 * @author RPAGUIO
 */
import com.raven.swing.table.EventActionYourCart;
import com.raven.swing.table.ModelActionYourCart;
import java.io.File;
import java.io.InputStream;

public class Order {

    private int orderId;
    private int sellerId;
    private int userId;
    private String userName;
    private InputStream orderImage;
    private File file;
    private byte[] cropImageData;
    private String productName;
    private double quantity;
    private double unitPrice;
    private String transacDate;
    private boolean paid;
    private String dateShipped;
    private String dateArrived;
    private String dateReceived;
    private int rating;
    private String status;
    private String sellerName;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Order() {
    }

    public Order(String supplierName, String farmerName, String cropName, double quantity, double price) {
        userName = supplierName;
        sellerName = farmerName;
        productName = cropName;
        this.quantity = quantity;
        unitPrice = price;
    }

    public Order(int orderId, int sellerId, String productName, double quantity, double unitPrice) {
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Order(int sellerId, String productName, String sellerName, double unitPrice, double quantity) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Object[] toRowTable(EventActionYourCart event) {
        return new Object[]{sellerId, productName, sellerName, unitPrice, quantity, new ModelActionYourCart(this, event)};
    }

    public Order(int sellerId, int userId, String userName, InputStream orderImage, File file, byte[] cropImageData, String productName, double quantity, double unitPrice, String transacDate, boolean paid, String dateShipped, String dateArrived, String dateReceived, int rating, String status) {
        this.sellerId = sellerId;
        this.userId = userId;
        this.userName = userName;
        this.orderImage = orderImage;
        this.file = file;
        this.cropImageData = cropImageData;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.transacDate = transacDate;
        this.paid = paid;
        this.dateShipped = dateShipped;
        this.dateArrived = dateArrived;
        this.dateReceived = dateReceived;
        this.rating = rating;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public InputStream getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(InputStream orderImage) {
        this.orderImage = orderImage;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public byte[] getCropImageData() {
        return cropImageData;
    }

    public void setCropImageData(byte[] cropImageData) {
        this.cropImageData = cropImageData;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTransacDate() {
        return transacDate;
    }

    public void setTransacDate(String transacDate) {
        this.transacDate = transacDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped) {
        this.dateShipped = dateShipped;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
