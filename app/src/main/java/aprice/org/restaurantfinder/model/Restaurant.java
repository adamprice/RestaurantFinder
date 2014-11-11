package aprice.org.restaurantfinder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 09/11/2014.
 */
public class Restaurant {

    private Integer Id;
    private String Name;
    private String Address;
    private String Postcode;
    private String City;
    private List<CuisineType> CuisineTypes = new ArrayList<CuisineType>();
    private String Url;
    private Boolean IsOpenNow;
    private Boolean IsSponsored;
    private Boolean IsNew;
    private Boolean IsTemporarilyOffline;
    private String ReasonWhyTemporarilyOffline;
    private String UniqueName;
    private Boolean IsCloseBy;
    private Boolean IsHalal;
    private Integer DefaultDisplayRank;
    private Boolean IsOpenNowForDelivery;
    private Boolean IsOpenNowForCollection;
    private Double RatingStars;
    private List<Logo> Logo = new ArrayList<Logo>();
    private List<Deals> Deals = new ArrayList<Deals>();
    private Integer NumberOfRatings;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public List<CuisineType> getCuisineTypes() {
        return CuisineTypes;
    }

    public void setCuisineTypes(List<CuisineType> cuisineTypes) {
        CuisineTypes = cuisineTypes;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Boolean getIsOpenNow() {
        return IsOpenNow;
    }

    public void setIsOpenNow(Boolean isOpenNow) {
        IsOpenNow = isOpenNow;
    }

    public Boolean getIsSponsored() {
        return IsSponsored;
    }

    public void setIsSponsored(Boolean isSponsored) {
        IsSponsored = isSponsored;
    }

    public Boolean getIsNew() {
        return IsNew;
    }

    public void setIsNew(Boolean isNew) {
        IsNew = isNew;
    }

    public Boolean getIsTemporarilyOffline() {
        return IsTemporarilyOffline;
    }

    public void setIsTemporarilyOffline(Boolean isTemporarilyOffline) {
        IsTemporarilyOffline = isTemporarilyOffline;
    }

    public String getReasonWhyTemporarilyOffline() {
        return ReasonWhyTemporarilyOffline;
    }

    public void setReasonWhyTemporarilyOffline(String reasonWhyTemporarilyOffline) {
        ReasonWhyTemporarilyOffline = reasonWhyTemporarilyOffline;
    }

    public String getUniqueName() {
        return UniqueName;
    }

    public void setUniqueName(String uniqueName) {
        UniqueName = uniqueName;
    }

    public Boolean getIsCloseBy() {
        return IsCloseBy;
    }

    public void setIsCloseBy(Boolean isCloseBy) {
        IsCloseBy = isCloseBy;
    }

    public Boolean getIsHalal() {
        return IsHalal;
    }

    public void setIsHalal(Boolean isHalal) {
        IsHalal = isHalal;
    }

    public Integer getDefaultDisplayRank() {
        return DefaultDisplayRank;
    }

    public void setDefaultDisplayRank(Integer defaultDisplayRank) {
        DefaultDisplayRank = defaultDisplayRank;
    }

    public Boolean getIsOpenNowForDelivery() {
        return IsOpenNowForDelivery;
    }

    public void setIsOpenNowForDelivery(Boolean isOpenNowForDelivery) {
        IsOpenNowForDelivery = isOpenNowForDelivery;
    }

    public Boolean getIsOpenNowForCollection() {
        return IsOpenNowForCollection;
    }

    public void setIsOpenNowForCollection(Boolean isOpenNowForCollection) {
        IsOpenNowForCollection = isOpenNowForCollection;
    }

    public Double getRatingStars() {
        return RatingStars;
    }

    public void setRatingStars(Double ratingStars) {
        RatingStars = ratingStars;
    }

    public List<Logo> getLogo() {
        return Logo;
    }

    public void setLogo(List<Logo> logo) {
        Logo = logo;
    }

    public List<Deals> getDeals() {
        return Deals;
    }

    public void setDeals(List<Deals> deals) {
        Deals = deals;
    }

    public Integer getNumberOfRatings() {
        return NumberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        NumberOfRatings = numberOfRatings;
    }

}
