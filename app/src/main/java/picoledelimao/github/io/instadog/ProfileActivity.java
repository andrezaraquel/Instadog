package picoledelimao.github.io.instadog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import picoledelimao.github.io.instadog.adapters.MainPagerAdapter;
import picoledelimao.github.io.instadog.adapters.ProfilePagerAdapter;
import picoledelimao.github.io.instadog.utils.ImageUtils;

/**
 * This is the activity called to display the profile of a certain user. It's very similar to
 * MainActivity with some minor differences
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.18.2016
 */
public class ProfileActivity extends AppCompatActivity {

    private ProfilePagerAdapter mProfilePagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getLogin());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProfilePagerAdapter = new ProfilePagerAdapter(getSupportFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mProfilePagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        // Refresh activity informations
        refresh();
    }

    /**
     * Go to settings activity
     */
    private void gotoSettings() {
       Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     * Go to new post activity
     */
    private void gotoNewPost() {
        Intent intent = new Intent(ProfileActivity.this, NewPostActivity.class);
        startActivity(intent);
    }

    /**
     * Refresh activity content
     */
    private void refresh() {
        // setting tab icons and text
        for (int i = 0; i < mProfilePagerAdapter.getCount(); i++) {
            int numUnread = 0;
            switch (i) {
                case 0:
                    numUnread = getNumHistories();
                    break;
                case 1:
                    numUnread = getNumFollowing();
                    break;
                case 2:
                    numUnread = getNumFollowers();
                    break;
            }
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.tab_layout);
            ((TextView)tab.getCustomView().findViewById(R.id.tab_title)).setText(" (" + numUnread + ")");
            if (numUnread > 0) {
                ((ImageView)tab.getCustomView().findViewById(R.id.tab_icon)).setImageResource(MainPagerAdapter.TAB_ICONS_ACTIVE[i]);
            } else {
                ((ImageView)tab.getCustomView().findViewById(R.id.tab_icon)).setImageResource(MainPagerAdapter.TAB_ICONS[i]);
            }
        }
        // order fragments to refresh as well
        mProfilePagerAdapter.refresh();
    }

    /**
     * Get number of unread histories on the news feed
     * @return The number of unread histories on the news feed
     */
    private int getNumHistories() {
        // TODO Replace the body of this method with the correct implementation
        return 0;
    }

    /**
     * Get number of people that the user is following
     * @return The number of people that the user is following
     */
    private int getNumFollowing() {
        // TODO Replace the body of this method with the correct implementation
        return 0;
    }

    /**
     * Get the number of people that follows the user
     * @return The number of people that follows the user
     */
    private int getNumFollowers() {
        // TODO Replace the body of this method with the correct implementation
        return 0;
    }

    /**
     * Get the user login
     * @return The user login
     */
    private String getLogin() {
        // TODO Replace the body of this method with the correct implementation
        return "joe";
    }

}
