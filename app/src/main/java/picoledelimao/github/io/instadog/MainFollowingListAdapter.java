package picoledelimao.github.io.instadog;

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

/**
 * This adapter is used to list the people that the current user is following
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.18.2016
 */
public class MainFollowingListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public MainFollowingListAdapter(Context context) {
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
        View rootView = mInflater.inflate(R.layout.list_following, null);
        ImageView ivUserPhoto = (ImageView) rootView.findViewById(R.id.listUserPhoto);
        TextView tvUserLogin = (TextView) rootView.findViewById(R.id.listUserLogin);
        Button btUnfollow = (Button) rootView.findViewById(R.id.btUnfollow);
        ivUserPhoto.setImageBitmap(getUserPhoto(i));
        tvUserLogin.setText(getUserLogin(i));
        btUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUnfollowClick(i, view);
            }
        });
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

    /**
     * Check if the current user is still following the given user
     * @param index Index of the user
     * @return If the current user is following the given user or not
     */
    private boolean isFollowing(int index) {
        // TODO Replace the content of this method with the correct implementation
        return true;
    }

    /**
     * This method is called when the unfollow button is pressed
     * @param index Index of followed user
     * @param view Button that triggered that event
     */
    private void onUnfollowClick(int index, View view) {
        if (isFollowing(index)) {
            unfollow(index, view);
        } else {
            follow(index, view);
        }
    }

    /**
     * Follow an user
     * @param index Index of the user
     * @param view Unfollow button
     */
    private void follow(int index, View view) {
        // TODO Replace the content of this method with the correct implementation
        ((Button)view).setText(mContext.getResources().getString(R.string.list_following_unfollow));
    }

    /**
     * Unfollow an user
     * @param index Index of the user
     * @param view Unfollow button
     */
    private void unfollow(int index, View view) {
        // TODO Replace the content of this method with the correct implementation
        ((Button)view).setText(mContext.getResources().getString(R.string.list_following_follow));
    }

}
