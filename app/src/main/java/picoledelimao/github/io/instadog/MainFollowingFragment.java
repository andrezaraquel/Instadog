package picoledelimao.github.io.instadog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Fragment for following tab in MainActivity tabbed menu
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class MainFollowingFragment extends Fragment implements RefreshableFragment {

    private ListView mListView;
    private MainFollowingListAdapter mAdapter;

    public static MainFollowingFragment newInstance() {
        return new MainFollowingFragment();
    }

    public MainFollowingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_following, container, false);
        mAdapter = new MainFollowingListAdapter(getActivity());
        mListView = (ListView) rootView.findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void refresh() {
        //  TODO Insert code with correct implementation here
    }

}