package aprice.org.restaurantfinder.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aprice.org.restaurantfinder.interfaces.JustEatRestaurantInterface;
import aprice.org.restaurantfinder.interfaces.JustEatRestaurantResponseInterface;
import aprice.org.restaurantfinder.model.Restaurant;

/**
 * This class manages requests to the Just-Eat API. It currently has one method to request restaurants in a given outcode, and conforms to the
 * RestaurantResponseInterface. Could be easily extended to send additional API calls and conform to additional response interfaces.
 *
 * Created by Adam Price on 10/11/2014.
 */
public class JustEatRequestManager implements JustEatRestaurantResponseInterface {

    public static final String TAG = JustEatRequestManager.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private JustEatRestaurantInterface mDelegate;
    private Gson mGson;

    public JustEatRequestManager(Context context, JustEatRestaurantInterface delegate) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        mDelegate = delegate;
        mGson = new Gson();
    }

    public void requestRestaurantsInOutcode(String outcode) {
        JustEatRestaurantRequest request = new JustEatRestaurantRequest(outcode, this);
        mRequestQueue.add(request);
    }

    @Override
    public void onRestaurantDataReceived(final JSONObject response) {

        // Parse the data in a background thread so as not to block the UI thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONArray array = response.getJSONArray(JustEatConstants.JSON_RESTAURANTS_KEY);
                    if (array != null) {
                        Restaurant[] restaurants = mGson.fromJson(array.toString(), Restaurant[].class);
                        mDelegate.onRestaurantsReceived(restaurants);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    mDelegate.onErrorWithRequest("Error parsing received data");
                }
            }
        }).start();

    }

    @Override
    public void onErrorReceivingRestaurantData() {
        mDelegate.onErrorWithRequest("Error receiving data.");
    }
}
