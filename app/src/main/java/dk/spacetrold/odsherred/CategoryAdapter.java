package dk.spacetrold.odsherred;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new ArtFragment();
            case 2:
                return new GeoParkFragment();
            case 3:
                return new CampingSitesFragment();
            default:
                return null;
        }
    }

    /**
     * return the correct title string for the given fragment to be shown in the tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.restaurants);
            case 1:
                return mContext.getString(R.string.art);
            case 2:
                return mContext.getString(R.string.geo_park);
            case 3:
                return mContext.getString(R.string.camping_sites);
            default:
                return null;
        }
    }
}
