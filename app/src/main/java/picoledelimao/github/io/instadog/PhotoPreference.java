package picoledelimao.github.io.instadog;

import android.content.Context;
import android.graphics.Bitmap;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A custom preference created in order to access elements of custom layout "fragment_preference_photo"
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class PhotoPreference extends Preference {

    private ImageView mIvPhoto;
    private Button mBtPhotoUpload;
    private Bitmap mPhoto;
    private View.OnClickListener mClickListener;

    public PhotoPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutResource(R.layout.fragment_preference_photo);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        mIvPhoto = (ImageView) view.findViewById(R.id.photo);
        mBtPhotoUpload = (Button) view.findViewById(R.id.btUploadPhoto);
        if (mPhoto != null) {
            mIvPhoto.setImageBitmap(mPhoto);
        }
        if (mClickListener != null) {
            mBtPhotoUpload.setOnClickListener(mClickListener);
        }
    }

    public void setPhoto(Bitmap photo) {
        this.mPhoto = photo;
        if (mIvPhoto != null) {
            mIvPhoto.setImageBitmap(photo);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.mClickListener = listener;
    }

}
