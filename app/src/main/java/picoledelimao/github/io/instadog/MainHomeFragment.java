package picoledelimao.github.io.instadog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Fragment for home tab in MainActivity tabbed menu
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class MainHomeFragment extends Fragment implements RefreshableFragment {

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    public MainHomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void refresh() {
        //  TODO Insert code with correct implementation here
    }

}