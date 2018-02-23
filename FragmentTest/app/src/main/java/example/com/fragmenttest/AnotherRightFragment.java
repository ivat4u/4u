package example.com.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hasee on 2017/10/11.
 */

public class AnotherRightFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstance){
        View view=inflater.inflate(R.layout.another_right_fragment,container,false);
        MainActivity activity=(MainActivity)getActivity();
        return view;
    }
}
