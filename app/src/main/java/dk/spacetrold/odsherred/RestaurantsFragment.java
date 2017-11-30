package dk.spacetrold.odsherred;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AndroidRuntimeException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set the layout of the fragment as the category_list.XML and store it as rootView
        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Find string array from resources
        String[] names      = getResources().getStringArray(R.array.restaurants_name_array);
        String[] flavours   = getResources().getStringArray(R.array.restaurent_flavour_array);
        String[] locations  = getResources().getStringArray(R.array.restaurants_location_array);
        String[] imageURLs  = getResources().getStringArray(R.array.restaurants_image_array);

        // Error if the arrays are not the same length
        if (!((names.length == flavours.length) && (names.length == locations.length) && (names.length == imageURLs.length))) {
            // Throw exception
            throw new AndroidRuntimeException("Restaurants resource arrays are not of equal length");
        }

        // Create the array list with Interest objects
        final ArrayList<Interest> interests = new ArrayList<>();
        // Add all the interests to the ArrayList from the resource file
        for (int i = 0; i < names.length; i++) {
            interests.add(new Interest(names[i], flavours[i], locations[i], imageURLs[i]));
        }

        // Setup the adapter
        InterestAdapter adapter = new InterestAdapter(getContext(), interests);

        final ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set on click listener to expand the list clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Create intent to open new activity ExpandActivity from the current class
                Intent intent = new Intent(getActivity(), ExpandActivity.class);


                // Pass in the values from the Interest object as extras to the intent
                intent.putExtra("Name", interests.get(position).getHeaderText());
                intent.putExtra("Flavour", interests.get(position).getFlavourText());
                intent.putExtra("GeoLocation", interests.get(position).getGeoLocation());
                intent.putExtra("ImageURL", interests.get(position).getImageURL());

                // Start the activity
                startActivity(intent);
            }
        });
        // Show the fragment
        return rootView;
    }
}
