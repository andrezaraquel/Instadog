package picoledelimao.github.io.instadog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import picoledelimao.github.io.instadog.adapters.MainHomeListAdapter;

/**
 * Fragment for home tab in MainActivity tabbed menu
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public class MainHomeFragment extends Fragment implements RefreshableFragment {

    private ListView mListView;
    private MainHomeListAdapter mAdapter;

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    public MainHomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mAdapter = new MainHomeListAdapter(getActivity());
        mListView = (ListView) rootView.findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void refresh() {
        if (mAdapter != null) mAdapter.notifyDataSetChanged();
    }

}