package aprice.org.restaurantfinder.model;

/**
 * Created by ap138752 on 10/11/2014.
 */
public class Deals {

    private String Description;
    private String DiscountPercent;
    private String QualifyingPrice;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDiscountPercent() {
        return DiscountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        DiscountPercent = discountPercent;
    }

    public String getQualifyingPrice() {
        return QualifyingPrice;
    }

    public void setQualifyingPrice(String qualifyingPrice) {
        QualifyingPrice = qualifyingPrice;
    }
}
