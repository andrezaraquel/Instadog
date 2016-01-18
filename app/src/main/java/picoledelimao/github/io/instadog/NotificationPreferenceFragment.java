package picoledelimao.github.io.instadog;


import android.annotation.TargetApi;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * This fragment shows notification preferences only. It is used when the
 * activity is showing a two-pane settings UI.
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class NotificationPreferenceFragment extends PreferenceFragment {

    public NotificationPreferenceFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_notification);
        setHasOptionsMenu(true);

        Preference prefEnableNotifications = findPreference("pref_enable_notifications");
        prefEnableNotifications.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(final Preference preference, Object o) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    boolean value = PreferenceManager.getDefaultSharedPreferences(preference
                            .getContext()).getBoolean(preference.getKey(), true);
                    setNotificationsEnabled(value);
                    }
                });
                }
            }).start();
            return true;
            }
        });
        Preference prefNotificationsRingtone = findPreference("pref_notifications_ringtone");
        Preference.OnPreferenceChangeListener listener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(final Preference preference, Object o) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    String ringtoneName = getRingtoneName(preference);
                    preference.setSummary(ringtoneName);
                    }
                });
                }
            }).start();
            return true;
            }
        };
        prefNotificationsRingtone.setOnPreferenceChangeListener(listener);
        listener.onPreferenceChange(prefNotificationsRingtone, null);
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
     * Get the current ringtone name
     * @param preference Ringtone preference
     * @return The current ringtone name
     */
    private String getRingtoneName(Preference preference) {
        String value = PreferenceManager.getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(), "");
        Ringtone ringtone = RingtoneManager.getRingtone(preference.getContext(), Uri.parse(value));
        if (ringtone == null) {
            // Clear the summary if there was a lookup error.
            return null;
        } else {
            // Set the summary to reflect the new ringtone display
            // name.
            String name = ringtone.getTitle(preference.getContext());
            return name;
        }
    }

    /**
     * Enable or disable notifications
     * @param isEnabled Check if notifications will be enabled
     */
    private void setNotificationsEnabled(boolean isEnabled) {
        // TODO Replace the body of this method with the correct implementation
    }

}
