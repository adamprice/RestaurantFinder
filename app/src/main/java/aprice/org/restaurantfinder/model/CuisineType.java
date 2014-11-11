package aprice.org.restaurantfinder.model;

/**
 * Created by Adam on 09/11/2014.
 */
public class CuisineType {

    private int Id;
    private String Name;
    private String SeoName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSeoName() {
        return SeoName;
    }

    public void setSeoName(String seoName) {
        this.SeoName = seoName;
    }
}
