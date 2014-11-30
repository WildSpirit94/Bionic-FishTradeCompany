package ftcApp.model;

import ftcApp.model.enums.ParcelStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Parcel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private ParcelStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date purchased;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrived;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parcel")
    private List<Item> items = new ArrayList<>();

    private Double deliveryCost;

    public Parcel(ParcelStatus status, Date purchased, List<Item> items, Double deliveryCost) {
        this.status = status;
        this.purchased = purchased;
        this.items = items;
        this.deliveryCost = deliveryCost;
    }

    public Parcel() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parcel parcel = (Parcel) o;

        if (arrived != null ? !arrived.equals(parcel.arrived) : parcel.arrived != null) return false;
        if (deliveryCost != null ? !deliveryCost.equals(parcel.deliveryCost) : parcel.deliveryCost != null)
            return false;
        if (items != null ? !items.equals(parcel.items) : parcel.items != null) return false;
        if (purchased != null ? !purchased.equals(parcel.purchased) : parcel.purchased != null) return false;
        if (status != parcel.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (purchased != null ? purchased.hashCode() : 0);
        result = 31 * result + (arrived != null ? arrived.hashCode() : 0);
        result = 31 * result + (deliveryCost != null ? deliveryCost.hashCode() : 0);
        return result;
    }

    public Date getArrived() {
        return arrived;
    }

    public void setArrived(Date arrived) {
        this.arrived = arrived;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    public Date getPurchased() {
        return purchased;
    }

    public void setPurchased(Date registered) {
        this.purchased = registered;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryPrice) {
        this.deliveryCost = deliveryPrice;
    }
}
