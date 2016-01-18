package picoledelimao.github.io.instadog.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import picoledelimao.github.io.instadog.MainFollowersFragment;
import picoledelimao.github.io.instadog.MainFollowingFragment;
import picoledelimao.github.io.instadog.MainHomeFragment;
import picoledelimao.github.io.instadog.MainNotificationsFragment;
import picoledelimao.github.io.instadog.R;
import picoledelimao.github.io.instadog.RefreshableFragment;

/**
 * This pager adapter is used by the ProfileActivity tabbed menu to connect it to the fragments
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class ProfilePagerAdapter extends FragmentPagerAdapter {

    /**
     * Tab icons for when there aren't any new unread message on selected tab
     */
    public static int[] TAB_ICONS = {
        R.mipmap.ic_home_white_48dp,
        R.mipmap.ic_star_white_48dp,
        R.mipmap.ic_people_white_48dp
    };

    /**
     * Tab icons for when there are unread messages on selected tab
     */
    public static int[] TAB_ICONS_ACTIVE = {
        R.mipmap.ic_home_white_48dp,
        R.mipmap.ic_star_white_48dp,
        R.mipmap.ic_people_white_48dp
    };

    private Context mContext;

    public ProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MainHomeFragment.newInstance();
            case 1:
                return MainFollowingFragment.newInstance();
            case 2:
                return MainFollowersFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_ICONS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    /**
     * Refresh all fragments
     */
    public void refresh() {
        for (int i = 0; i < getCount(); i++) {
            ((RefreshableFragment)getItem(i)).refresh();
        }
    }

}