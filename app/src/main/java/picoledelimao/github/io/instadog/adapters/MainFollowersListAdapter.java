package picoledelimao.github.io.instadog.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import picoledelimao.github.io.instadog.R;
import picoledelimao.github.io.instadog.utils.ImageUtils;

/**
 * This adapter is used to list the people who are following the current user
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.18.2016
 */
public class MainFollowersListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public MainFollowersListAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Replace the content of this method with the correct implementation
        return 10;
    }

    @Override
    public Object getItem(int i) {
        // TODO Replace the content of this method with the correct implementation
        return null;
    }

    @Override
    public long getItemId(int i) {
        // TODO Replace the content of this method with the correct implementation
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View rootView = mInflater.inflate(R.layout.list_followers, null);
        ImageView ivUserPhoto = (ImageView) rootView.findViewById(R.id.listUserPhoto);
        TextView tvUserLogin = (TextView) rootView.findViewById(R.id.listUserLogin);
        ivUserPhoto.setImageBitmap(getUserPhoto(i));
        tvUserLogin.setText(getUserLogin(i));
        return rootView;
    }

    /**
     * Get the profile picture for a given followed user
     * @param index Index of the user being followed
     * @return The profile picture of the followed user
     */
    private Bitmap getUserPhoto(int index) {
        // TODO Replace the content of this method with the correct implementation
        return ImageUtils.getCroppedBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.default_avatar));
    }

    /**
     * Get the login for a given followed user
     * @param index Index of the user being followed
     * @return The login of the followed user
     */
    private String getUserLogin(int index) {
        // TODO Replace the content of this method with the correct implementation
        return "joe";
    }

}
