
import sql.dao.AttributeDAO;
import sql.dao.impl.AttributeDAOimpl;
import sql.model.Attribute;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private List<Attribute> attribute;
public Product(){
    this.name = "xnj-nj";
    this.attribute = new ArrayList();
}
    public Product(String name, List<Attribute> attribute){
        this.name = name;
        this.attribute = new ArrayList();
        }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attribute = attribute;
    }

//    public ProductCategory getProductCategory() {
//        return productCategory;
//    }
}

class ProductCategory {
    private String name;
    private List<Product> productCategory;

    public ProductCategory(String name, List <Product> productCategory){
        this. name = name;
        this.productCategory = productCategory;
    }
    public void setName( String name ){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public List<Product> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(List<Product> productCategory) {
        this.productCategory = productCategory;
    }
}

//class Attribute {
//    private String nameAttribut;
//    public Attribute( String nameAttribut ) {
//        this.nameAttribut = nameAttribut;
//    }
//
//    public String getNameAttribut() {
//        return nameAttribut;
//    }
//
//    public void setNameAttribut(String nameAttribut) {
//        this.nameAttribut = nameAttribut;
//    }
//}

//class Size extends Attribute {
//    private String size;
//    public Size( String nameAttribut, String size){
//        super(nameAttribut);
//        this.size = size;
//    }
//    public String getSize() {
//        return size;
//    }
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//}
//
//class Color extends Attribute {
//    private String color;
//    public Color (String nameAttribut, String color ){
//        super(nameAttribut);
//        this.color = color;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//}

 class User {
    private String id;
    private String email;
    public User( String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Registered extends User {
    private String passvord;
    public Registered(String id, String email, String passvord ){
        super(id,email);
        this.passvord = passvord;
    }
    public String getPassvord() {
        return passvord;
    }
    public void setPassvord(String passvord) {
        this.passvord = passvord;
    }
}

class  Gues extends User {
    public Gues(String id, String email){
        super(id, email);
    }
}

class ProductCatalog{
    private Product product;
    private List<ProductCategory> productCategory;
    public ProductCatalog (List<ProductCategory> productCategoryg, Product product ){
        this.product = product;
        this.productCategory = new ArrayList();
    }

    public List<ProductCategory> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(List<ProductCategory> productCategory) {
        this.productCategory = productCategory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

class PriceBook{
    private BigDecimal price;
    private List<Product> product;
    public PriceBook(BigDecimal price,List<Product> product){
        this.price = price;
        this.product = new ArrayList();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}

class Basket{
    private Product product;
    private PriceBook price;
    private Integer number;
    private BigDecimal total;
    private List<Product> productList ;
    public Basket(Product product, PriceBook price, int number, List<Product> productList, BigDecimal total){
        this.product = product;
        this.number = number;
        this.price = price;
        this.total = total;
        this.productList = new ArrayList();
    }

    public Product getProduct() {
        return product;
    }

    public PriceBook getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}


class Order {
    private Basket basket;
    private OrderPromotion orderPromotion;
    private UserOrderInfo userOrderInfo;
    private Deliverycost deliverycost;
    private Campaign campaign;
    private Shipment shipment;
    private BigDecimal totalprice;
    public Order(Basket basket, OrderPromotion orderPromotion, UserOrderInfo userOrderInfo, Deliverycost deliverycost,
                 BigDecimal totalprice, Campaign campaign, Shipment shipment){
        this.basket = basket;
        this.orderPromotion = orderPromotion;
        this.userOrderInfo = userOrderInfo;
        this.deliverycost = deliverycost;
        this.totalprice = totalprice;
        this.campaign = campaign;
        this.shipment = shipment;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public OrderPromotion getOrderPromotion() {
        return orderPromotion;
    }

    public void setOrderPromotion(OrderPromotion orderPromotion) {
        this.orderPromotion = orderPromotion;
    }

    public UserOrderInfo getUserOrderInfo() {
        return userOrderInfo;
    }

    public void setUserOrderInfo(UserOrderInfo userOrderInfo) {
        this.userOrderInfo = userOrderInfo;
    }

    public Deliverycost getDeliverycost() {
        return deliverycost;
    }

    public void setDeliverycost(Deliverycost deliverycost) {
        this.deliverycost = deliverycost;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}

class UserOrderInfo {
    private User user;
    private String adress;
    private Boolean billingInfo;
    private Boolean orderReceipt;
    public UserOrderInfo(User user, String adress, Boolean billingInfo, Boolean orderReceipt){
        this.user = user;
        this.adress = adress;
        this.billingInfo = billingInfo;
        this.orderReceipt = orderReceipt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(Boolean billingInfo) {
        this.billingInfo = billingInfo;
    }

    public Boolean getOrderReceipt() {
        return orderReceipt;
    }

    public void setOrderReceipt(Boolean orderReceipt) {
        this.orderReceipt = orderReceipt;
    }
}

class Deliverycost {
    private BigDecimal tarif;
    private String location;
    private BigDecimal weight;
    public Deliverycost(BigDecimal tarif,BigDecimal weight,String location){
        this.tarif = tarif;
        this.weight = weight;
        this.location = location;
    }

    public BigDecimal getTarif() {
        return tarif;
    }

    public void setTarif(BigDecimal tarif) {
        this.tarif = tarif;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}

class Shipment {
    private String shipmentmetod;
    private BigDecimal costs;
    public Shipment(String shipmentmetod, BigDecimal costs){
        this.shipmentmetod = shipmentmetod;
        this.costs = costs;
    }

    public String getShipmentmetod() {
        return shipmentmetod;
    }

    public void setShipmentmetod(String shipmentmetod) {
        this.shipmentmetod = shipmentmetod;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }
}

class Couponcode{
    private String Couponcode;
    public Couponcode( String Couponcode){
        this.Couponcode = Couponcode;
    }

    public String getCouponcode() {
        return Couponcode;
    }

    public void setCouponcode(String couponcode) {
        Couponcode = couponcode;
    }
}

class Campaign {
    private Couponcode couponcode;
    private Promotions promotions;
    private List<Product> campaign;
    private Data start;
    private Data end;
    public Campaign(Couponcode couponcode, Promotions promotions, List<Product> campaign, Data start, Data end ){
        this.couponcode = couponcode;
        this.promotions = promotions;
        this.campaign = new ArrayList();
        this.start = start;
        this.end = end;
    }

    public Couponcode getCouponcode() {
        return couponcode;
    }

    public void setCouponcode(Couponcode couponcode) {
        this.couponcode = couponcode;
    }

    public List<Product> getCampaign() {
        return campaign;
    }

    public void setCampaign(List<Product> campaign) {
        this.campaign = campaign;
    }

    public Promotions getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotions promotions) {
        this.promotions = promotions;
    }

    public Data getStart() {
        return start;
    }

    public void setStart(Data start) {
        this.start = start;
    }

    public Data getEnd() {
        return end;
    }

    public void setEnd(Data end) {
        this.end = end;
    }
}

abstract class Promotions  {
    private String promotionsrule;
    public Promotions(String promotionsrule) {
        this.promotionsrule = promotionsrule;
    }

    public String getPromotions() {
        return promotionsrule;
    }

    public void setPromotions(String promotions) {
        this.promotionsrule = promotions;
    }
}

class OrderPromotion extends Promotions {
    private List<Order> promotion;
    public OrderPromotion(String promotionsrule,List<Order> promotion ) {
        super(promotionsrule);
        this.promotion = new ArrayList();
    }
    public List<Order> getPromotion() {
        return promotion;
    }

    public void setPromotion(List<Order> promotion) {
        this.promotion = promotion;
    }
}


public class Shop {
    public static void main ( String [] args ){
//        List<Product> ps = Arrays.asList(new Product());
//        ProductCategory shoes = new ProductCategory("shoes", ps);
//        System.out.println(shoes.getName());
       AttributeDAO attributeDAO = new AttributeDAOimpl();
        Attribute a = new Attribute("size");
        //attributeDAO.create(a);
        System.out.println(attributeDAO.getById(1).getNameAttribut());
    }
}
