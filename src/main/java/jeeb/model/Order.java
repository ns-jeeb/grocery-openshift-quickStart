package jeeb.model;

import java.util.Date;

/**
 * Created by Jeeb on 11/3/2015.
 */
public class Order {
    private long mId;
    private String mCustomer;
    private String mProduct;
    private Date mOrderDate;
    private Date mShipDate;

    public long getId () {
        return mId;
    }

    public void setId (long id) {
        mId = id;
    }

    public String getCustomer () {
        return mCustomer;
    }

    public void setCustomer (String customer) {
        mCustomer = customer;
    }

    public String getProduct () {
        return mProduct;
    }

    public void setProduct (String product) {
        mProduct = product;
    }

    public Date getOrderDate () {
        return mOrderDate;
    }

    public void setOrderDate (Date orderDate) {
        mOrderDate = orderDate;
    }

    public Date getShipDate () {
        return mShipDate;
    }

    public void setShipDate (Date shipDate) {
        mShipDate = shipDate;
    }

    @Override
    public String toString() {
        return "Order [id=" + mId + ", customer=" + mCustomer + ", product="
                + mProduct + ", orderDate=" + mOrderDate + ", shipDate="
                + mShipDate + "]";
    }

}
