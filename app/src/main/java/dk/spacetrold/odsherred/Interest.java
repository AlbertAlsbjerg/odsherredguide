package dk.spacetrold.odsherred;

/**
 * {@link Interest} contains information about a point of interest in Odsherred
 * This includes:
 *      - Interest name     (String)
 *      - Flavour text      (String)
 *      - Geo location      (String)
 *      - Image resource    (String)
 */
public class Interest {

    // Text to be displayed in the header for the list item in the category view
    private String mHeaderText;

    // Text to be displayed in category view
    private String mFlavourText;

    // Geo location to later open in map
    private String mGeoLocation;

    // Image resource URL
    private String mImageURL;

    // Constructor
    public Interest(String headerText, String flavourText, String geoLocation, String imageURL){
        mHeaderText       = headerText;
        mFlavourText      = flavourText;
        mGeoLocation      = geoLocation;
        mImageURL         = imageURL;
    }

    // Getter method for the header text
    public String getHeaderText(){
        return mHeaderText;
    }

    // Getter method for the flavour text
    public String getFlavourText(){
        return mFlavourText;
    }

    // Getter method for the geo location
    public String getGeoLocation(){
        return mGeoLocation;
    }

    // Getter method for the image resource id
    public String getImageURL(){
        return mImageURL;
    }
}
