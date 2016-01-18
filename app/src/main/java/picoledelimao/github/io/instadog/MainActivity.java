package picoledelimao.github.io.instadog;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This is the main activity, where things like timeline, followers and following are displayed
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class MainActivity extends AppCompatActivity {

    private MainPagerAdapter mMainPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mMainPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_new_photo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNewPost();
            }
        });

        // Refresh activity informations
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                gotoSettings();
                break;
            case R.id.action_logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Go to settings activity
     */
    private void gotoSettings() {
       Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     * Go to new post activity
     */
    private void gotoNewPost() {
        Intent intent = new Intent(MainActivity.this, NewPostActivity.class);
        startActivity(intent);
    }

    /**
     * Refresh activity content
     */
    private void refresh() {
        // setting tab icons and text
        for (int i = 0; i < mMainPagerAdapter.getCount(); i++) {
            int numUnread = 0;
            switch (i) {
                case 0:
                    numUnread = getNumHistories();
                    break;
                case 1:
                    numUnread = getNumNotifications();
                    break;
                case 2:
                    numUnread = getNumFollowing();
                    break;
                case 3:
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
        mMainPagerAdapter.refresh();
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
     * Get number of unread notifications
     * @return The number of unread notifications
     */
    private int getNumNotifications() {
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
     * Get the number of people that folows the user
     * @return The number of people that follows the user
     */
    private int getNumFollowers() {
        // TODO Replace the body of this method with the correct implementation
        return 0;
    }

    /**
     * This method is called when logout action on menu options is selected
     */
    private void logout() {
        // TODO Replace the body of this method with the correct implementation
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
