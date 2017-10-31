package by.dzmitry_lakisau.hw06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static by.dzmitry_lakisau.hw06.Constants.*;

public class Fragment_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment thisFragment = fragmentManager.findFragmentByTag(FRAGMENT_2);
                fragmentTransaction.hide(thisFragment);
                fragmentTransaction.commit();

                getActivity().findViewById(R.id.button_2).setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }
}
