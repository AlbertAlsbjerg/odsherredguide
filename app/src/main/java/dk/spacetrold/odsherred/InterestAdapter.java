package dk.spacetrold.odsherred;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link InterestAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Interest} objects.
 */
public class InterestAdapter extends ArrayAdapter<Interest> {

    // Save the context
    Context mContext;

    // Constructor
    public InterestAdapter(Context context, ArrayList<Interest> interests) {
        super(context, 0, interests);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Interest currentInterest = getItem(position);


        // Get the TextViews and store them in variables
        TextView headerView  = listView.findViewById(R.id.header);
        TextView flavourView = listView.findViewById(R.id.flavourtextview);

        // Set the correct text to the views
        headerView.setText(currentInterest.getHeaderText());
        flavourView.setText(currentInterest.getFlavourText());


        // Get the ImageView and store them in variables
        ImageView imageView = listView.findViewById(R.id.imageview);

        // Set the image to the view
        new DownloadImageTask(imageView).execute(currentInterest.getImageURL());


        // Return the ListView
        return listView;
    }
}
