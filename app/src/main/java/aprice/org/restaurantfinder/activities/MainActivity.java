package aprice.org.restaurantfinder.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aprice.org.restaurantfinder.adapters.RestaurantListAdapter;
import aprice.org.restaurantfinder.interfaces.JustEatRestaurantInterface;
import aprice.org.restaurantfinder.R;
import aprice.org.restaurantfinder.model.Restaurant;
import aprice.org.restaurantfinder.network.JustEatRequestManager;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity implements JustEatRestaurantInterface {

    @InjectView(R.id.postcode_edit_text) EditText mPostcodeInputEditText;
    @InjectView(R.id.restaurant_list) ListView mRestaurantList;

    private static final String TAG = MainActivity.class.getSimpleName();

    private RestaurantListAdapter mRestaurantListAdapter;
    private JustEatRequestManager mJustEatRequestManager;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<Restaurant> mRestaurants = new ArrayList<Restaurant>();
        mJustEatRequestManager = new JustEatRequestManager(this, this);
        mRestaurantListAdapter = new RestaurantListAdapter(this, R.layout.restaurant_row, R.id.restaurant_name, mRestaurants);
        mRestaurantList.setAdapter(mRestaurantListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.search_button)
    protected void searchButtonPressed() {

        Log.d(TAG, "Search button pressed");

        // Hide keyboard
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mPostcodeInputEditText.getWindowToken(), 0);

        Pattern p = Pattern.compile("^[a-z][a-z][1-9]{1,2}$", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        String outcode = mPostcodeInputEditText.getText().toString().trim();
        Matcher m = p.matcher(outcode);

        if (!m.find()) {
            showErrorDialog("Please enter a valid outcode");
        } else {
            showProgressDialog();
            mJustEatRequestManager.requestRestaurantsInOutcode(mPostcodeInputEditText.getText().toString());
        }

    }

    @Override
    public void onRestaurantsReceived(final Restaurant[] restaurants) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideProgressDialog();
                mRestaurantListAdapter.clear();
                mRestaurantListAdapter.addAll(restaurants);
            }
        });
    }

    @Override
    public void onErrorWithRequest(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showErrorDialog("An error has occurred. Please try again.");
            }
        });
    }

    private void showProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Requesting restaurants...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this).setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
                .show();
    }

}
