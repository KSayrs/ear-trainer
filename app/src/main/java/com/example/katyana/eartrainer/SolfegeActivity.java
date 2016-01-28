package com.example.katyana.eartrainer;

import android.support.v4.app.Fragment;

/**
 * Created by Katyana on 9/8/2015.
 * THIS CREATES THE FRAGMENT SO THAT IT DOES STUFF
 */
public class SolfegeActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment(){
        return new SolfegeFragment();
    }
}
