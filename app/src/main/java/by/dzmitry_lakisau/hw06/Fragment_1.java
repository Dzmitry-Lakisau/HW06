package by.dzmitry_lakisau.hw06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static by.dzmitry_lakisau.hw06.Constants.FRAGMENT_1;

public class Fragment_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment thisFragment = fragmentManager.findFragmentByTag(FRAGMENT_1) ;
                fragmentTransaction.hide(thisFragment);
                fragmentTransaction.commit();

                getActivity().findViewById(R.id.button_1).setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }
}
