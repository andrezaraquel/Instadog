package picoledelimao.github.io.instadog;

import android.content.Context;
import android.graphics.Bitmap;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A custom preference created in order to access elements of custom layout "fragment_preference_save"
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class SavePreference extends Preference {

    private Button mBtSave;
    private View.OnClickListener mClickListener;

    public SavePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutResource(R.layout.fragment_preference_save);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        mBtSave = (Button) view.findViewById(R.id.btSave);
        if (mClickListener != null) {
            mBtSave.setOnClickListener(mClickListener);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.mClickListener = listener;
    }

}
