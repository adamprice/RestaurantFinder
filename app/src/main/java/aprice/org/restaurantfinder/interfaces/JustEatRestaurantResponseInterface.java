package aprice.org.restaurantfinder.interfaces;

import org.json.JSONObject;

/**
 * Interface for handling Restaurant responses from the Just-Eat API
 *
 * Created by Adam Price on 10/11/2014.
 */
public interface JustEatRestaurantResponseInterface {

    public void onRestaurantDataReceived(JSONObject response);
    public void onErrorReceivingRestaurantData();
}
