package example.com.fragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hasee on 2017/10/7.
 */

public class RightFragment extends Fragment {
    
    public static final String TAG="RightFragment";
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }
    @Override
    public void onCreate(Bundle saveInsatanceState){
        super.onCreate(saveInsatanceState);
        Log.d(TAG, "onCreate: ");
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.right_fragment,container,false);
        Log.d(TAG, "onCreateView: ");
        return view;
    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }
    public void onDetach(){
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}