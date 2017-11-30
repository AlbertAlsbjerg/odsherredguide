package dk.spacetrold.odsherred;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandActivity extends AppCompatActivity {

    // View variables
    ImageView imageView;
    TextView textHeader;
    TextView textFlavour;
    LinearLayout buttonLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);

        // Get the bundle from the intent which started this activity
        final Bundle bundle = getIntent().getExtras();

        // Find the views
        imageView       = findViewById(R.id.imageView);
        textHeader      = findViewById(R.id.textHeader);
        textFlavour     = findViewById(R.id.textFlavour);
        buttonLocation  = findViewById(R.id.locationButton);

        // Check if the current bundle isn't empty
        if (bundle != null) {
            // Set correct image view from the intent bundle
            new DownloadImageTask(imageView).execute(bundle.getString("ImageURL"));

            // Update the TextViews
            textHeader.setText(bundle.getString("Name"));
            textFlavour.setText(bundle.getString("Flavour"));

            // Set onClick listener to the LinearLayout used as a button
            buttonLocation.setOnClickListener(new LinearLayout.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Open location passed in the intent bundle with the custom showMap method
                    showMap(Uri.parse(bundle.getString("GeoLocation")));
                }
            });
        }
    }

    // Method for showing geo location
    private void showMap(Uri geoLocation) {
        // Create Intent for showing map location
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // Pass in the geolocation for the intent
        intent.setData(geoLocation);
        // Open map app if one is found on the device
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
