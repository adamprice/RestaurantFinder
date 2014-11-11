package aprice.org.restaurantfinder.network;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import aprice.org.restaurantfinder.interfaces.JustEatRestaurantResponseInterface;

/**
 * Class that creates a request to the restaurant functionality of the Just-Eat API
 *
 * Created by Adam Price on 10/11/2014.
 */
public class JustEatRestaurantRequest extends JustEatRequest {

    public static final String TAG = JustEatRestaurantRequest.class.getSimpleName();

    /**
     * Constructor for a restaurants request, which uses the defined restaurant constant to access that
     * section of the Just-Eat API
     *
     * @param outcode       Outcode to search near for restaurants
     * @param delegate      Delegate class to receive callbacks
     */
    public JustEatRestaurantRequest(String outcode, final JustEatRestaurantResponseInterface delegate) {
        super(JustEatConstants.RESTAURANT_REQUEST + outcode, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "Response received");
                delegate.onRestaurantDataReceived(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error response");
                delegate.onErrorReceivingRestaurantData();
            }
        });
    }
}
