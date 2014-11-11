package aprice.org.restaurantfinder.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.makeramen.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

import aprice.org.restaurantfinder.R;
import aprice.org.restaurantfinder.model.CuisineType;
import aprice.org.restaurantfinder.model.Restaurant;
import butterknife.ButterKnife;

/**
 * Custom adapter to show restaurant data in an Android ListView
 *
 * Created by Adam Price on 10/11/2014.
 */
public class RestaurantListAdapter extends ArrayAdapter<Restaurant> {

    List<Restaurant> mRestaurants;
    Context mContext;
    Transformation mTransformation = new RoundedTransformationBuilder()
            .borderColor(Color.BLACK)
            .borderWidthDp(2)
            .cornerRadiusDp(30)
            .oval(false)
            .build();

    public RestaurantListAdapter(Context context, int resource, int textViewResourceId, List<Restaurant> objects) {
        super(context, resource, textViewResourceId, objects);
        mContext = context;
        mRestaurants = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = super.getView(position, convertView, parent);

        TextView title = ButterKnife.findById(row, R.id.restaurant_name);
        RatingBar rating = ButterKnife.findById(row, R.id.restaurant_rating);
        TextView foodTypes = ButterKnife.findById(row, R.id.restaurant_food_type);
        ImageView logoView = ButterKnife.findById(row, R.id.logo_image_view);

        Restaurant currentRestaurant = mRestaurants.get(position);

        Picasso.with(mContext)
                .load(currentRestaurant.getLogo().get(0).getStandardResolutionURL())
                .tag(mContext)
                .transform(mTransformation)
                .into(logoView);

        title.setText(currentRestaurant.getName());
//        rating.setText(currentRestaurant.getRatingStars().toString());
        rating.setRating((float)currentRestaurant.getRatingStars().doubleValue());

        StringBuilder builder = new StringBuilder();

        for (CuisineType type : currentRestaurant.getCuisineTypes()) {
            builder.append(type.getName()).append(", ");
        }

        // This removes the trailing comma
        builder.delete(builder.length() - 2, builder.length());
        foodTypes.setText(builder.toString());

        return row;
    }
}
