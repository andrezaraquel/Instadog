package picoledelimao.github.io.instadog;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;

import picoledelimao.github.io.instadog.utils.ImagePicker;
import picoledelimao.github.io.instadog.utils.ImageUtils;

/**
 * This fragment shows general preferences only. It is used when the
 * activity is showing a two-pane settings UI.
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class ProfilePreferenceFragment extends PreferenceFragment {

    private Bitmap mPhoto;

    public ProfilePreferenceFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_profile);
        setHasOptionsMenu(true);

        final PhotoPreference prefPhoto = (PhotoPreference) findPreference("pref_photo");
        prefPhoto.setPhoto(getPhoto());
        prefPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseImageIntent = ImagePicker.getPickImageIntent(getActivity());
                getActivity().startActivityForResult(chooseImageIntent, SettingsActivity.PICK_IMAGE_ID);
                ((SettingsActivity) getActivity()).setOnImagePickListener(new ImagePicker.OnImagePickListener() {
                    @Override
                    public void onPickImage(Bitmap image) {
                        mPhoto = image;
                        prefPhoto.setPhoto(mPhoto);
                    }
                });
            }
        });
        final Preference prefEmail = findPreference("pref_email");
        prefEmail.setSummary(getEmail());
        final Preference prefNewPassword = findPreference("pref_password");
        final Preference prefRepeatNewPassword = findPreference("pref_repeat_password");
        SavePreference prefSave = (SavePreference) findPreference("pref_save");
        prefSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = PreferenceManager.getDefaultSharedPreferences(prefEmail.getContext())
                        .getString(prefEmail.getKey(), "");
                String newPassword = PreferenceManager.getDefaultSharedPreferences(prefNewPassword
                        .getContext()).getString(prefNewPassword.getKey(), "");
                String repeatNewPassword = PreferenceManager.getDefaultSharedPreferences(
                        prefRepeatNewPassword.getContext()).getString(prefRepeatNewPassword.getKey(), "");
                save(mPhoto, email, newPassword, repeatNewPassword);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Get the current photo of the user
     * @return The current photo of the user
     */
    public Bitmap getPhoto() {
        // TODO Replace the body of this method with the correct implementation
        return ImageUtils.getCroppedBitmap(BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.default_avatar));
    }

    /**
     * Get the current name of the user
     * @return The current name of the user
     */
    public String getName() {
        // TODO Replace the body of this method with the correct implementation
        return "Joe";
    }

    /**
     * Get the current e-mail of the user
     * @return The current e-mail of the user
     */
    public String getEmail() {
        // TODO Replace the body of this method with the correct implementation
        return "joe@joe.com";
    }

    /**
     * Save new user profile informations
     * @param photo The new user photo (null if none was provided)
     * @param email The new user e-mail
     * @param newPassword The new user password (empty if none was provided)
     * @param repeatNewPassword The new user password repeat (empty if none was provided)
     */
    public void save(Bitmap photo, String email, String newPassword, String repeatNewPassword) {
        // TODO Insert code with correct implementation here
    }

}