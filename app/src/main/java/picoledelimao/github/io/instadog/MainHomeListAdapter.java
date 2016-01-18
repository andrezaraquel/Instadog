package picoledelimao.github.io.instadog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This adapter is used to list the posts in the main feed
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.18.2016
 */
public class MainHomeListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    public MainHomeListAdapter(Context context) {
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
        View rootView = mInflater.inflate(R.layout.list_home, null);
        ImageView ivUserPhoto = (ImageView) rootView.findViewById(R.id.listUserPhoto);
        TextView tvUserLogin = (TextView) rootView.findViewById(R.id.listUserLogin);
        ImageView ivPhoto = (ImageView) rootView.findViewById(R.id.listPhoto);
        TextView tvDescription = (TextView) rootView.findViewById(R.id.listDescription);
        ImageView ivFavorite = (ImageView) rootView.findViewById(R.id.listFavorite);
        TextView tvNumFavorites = (TextView) rootView.findViewById(R.id.listNumFavorites);
        ImageView ivComment = (ImageView) rootView.findViewById(R.id.listComment);
        TextView tvNumComments = (TextView) rootView.findViewById(R.id.listNumComments);
        ivUserPhoto.setImageBitmap(getUserPhoto(i));
        tvUserLogin.setText(getUserLogin(i));
        ivPhoto.setImageBitmap(getPhoto(i));
        tvDescription.setText(getDescription(i));
        if (isFavorite(i)) {
            ivFavorite.setImageResource(R.mipmap.ic_favorite_black_48dp);
        } else {
            ivFavorite.setImageResource(R.mipmap.ic_favorite_border_black_48dp);
        }
        tvNumFavorites.setText("(" + getNumFavorites(i) + ")");
        tvNumComments.setText("(" + getNumComments(i) + ")");
        ivFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFavoriteClick(i, view);
            }
        });
        return rootView;
    }

    /**
     * Get the post owner's profile picture
     * @param index Index of the post
     * @return The post owner's profile picture
     */
    private Bitmap getUserPhoto(int index) {
        // TODO Replace the content of this method with the correct implementation
        return ImageUtils.getCroppedBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.default_avatar));
    }

    /**
     * Get the post owner's login
     * @param index Index of the post
     * @return The post owner's login
     */
    private String getUserLogin(int index) {
        // TODO Replace the content of this method with the correct implementation
        return "joe";
    }

    /**
     * Get the post picture
     * @param index Index of the post
     * @return The post picture
     */
    private Bitmap getPhoto(int index) {
        // TODO Replace the content of this method with the correct implementation
        return BitmapFactory.decodeResource(mContext.getResources(), R.drawable.husky);
    }

    /**
     * Get the post description
     * @param index Index of the post
     * @return The post description
     */
    private String getDescription(int index) {
        // TODO Replace the content of this method with the correct implementation
        return "I love my husky <3 #husky #instadog #blueeyes";
    }

    /**
     * Check if the post was favorited by the current user
     * @param index Index of the post
     * @return If the post was favorited by the current user
     */
    private boolean isFavorite(int index) {
        // TODO Replace the content of this method with the correct implementation
        return false;
    }

    /**
     * Get the number of favorites for a given post
     * @param index Index of the post
     * @return The number of favorites for the given post
     */
    private int getNumFavorites(int index) {
        // TODO Replace the content of this method with the correct implementation
        return 0;
    }

    /**
     * Get the number of comments for a given post
     * @param index Index of the post
     * @return The number of comments for the given post
     */
    private int getNumComments(int index) {
        // TODO Replace the content of this method with the correct implementation
        return 0;
    }

    /**
     * This method is called when the favorite button is clicked
     * @param index Index of the post
     * @param view Button that triggered that event
     */
    private void onFavoriteClick(int index, View view) {
        if (isFavorite(index)) {
            unfavorite(index, view);
        } else {
            favorite(index, view);
        }
    }

    /**
     * Favorite a post
     * @param index Index of the post
     * @param view Button of favorite
     */
    private void favorite(int index, View view) {
        // TODO Replace the content of this method with the correct implementation
        view.setBackgroundResource(R.mipmap.ic_favorite_black_48dp);
    }

    /**
     * Unfavorite a post
     * @param index Index of the post
     * @param view Button of favorite
     */
    private void unfavorite(int index, View view) {
        // TODO Replace the content of this method with the correct implementation
        view.setBackgroundResource(R.mipmap.ic_favorite_border_black_48dp);
    }

}
