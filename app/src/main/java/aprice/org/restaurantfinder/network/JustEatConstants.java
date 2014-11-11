package aprice.org.restaurantfinder.network;

import java.util.HashMap;

/**
 * This class defines the constants that are used when accessing the Just-Eat API
 *
 * Created by Adam Price on 10/11/2014.
 */
public class JustEatConstants {

    // Connection constants
    public static final String JUST_EAT_BASE_API_URL = "http://api-interview.just-eat.com/";
    public static final String RESTAURANT_REQUEST = "restaurants?q=";
    public static final HashMap<String, String> JUST_EAT_HEADERS = initialiseHeaders();

    // JSON Keys
    public static final String JSON_RESTAURANTS_KEY = "Restaurants";

    private static HashMap<String, String> initialiseHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Accept-Tenant", "uk");
        headers.put("Accept-Language", "en-GB");
        headers.put("Authorization", "Basic VGVjaFRlc3RBUEk6dXNlcjI=");
        headers.put("Host", "api-interview.just-eat.com");
        return headers;
    }

}
