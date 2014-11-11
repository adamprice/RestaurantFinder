package aprice.org.restaurantfinder.interfaces;

import aprice.org.restaurantfinder.model.Restaurant;

/**
 * Interface for classes that wish to receive parsed restaurant data
 *
 * Created by Adam Price on 10/11/2014.
 */
public interface JustEatRestaurantInterface {

    public void onRestaurantsReceived(Restaurant[] restaurants);
    public void onErrorWithRequest(String message);

}
