package aprice.org.restaurantfinder.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Base JustEatReqest class. This is a simple extension of the JsonObjectRequest that uses the custom required headers
 * to access the Just-Eat API
 *
 * Created by Adam Price on 09/11/2014.
 */
public class JustEatRequest extends JsonObjectRequest {

    /**
     * Custom constructor that uses the Just-Eat API base url
     *
     * @param query Query to send to API
     * @param listener Response listener
     * @param errorListener Error listener
     */
    public JustEatRequest(String query, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(Method.GET, JustEatConstants.JUST_EAT_BASE_API_URL + query, null, listener, errorListener);
    }

    /**
     * Override the super class implementation of getHeaders() in order to set the custom headers necessary to
     * interact with the Just-Eat API
     *
     * @return Headers
     * @throws AuthFailureError
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return JustEatConstants.JUST_EAT_HEADERS;
    }

}
