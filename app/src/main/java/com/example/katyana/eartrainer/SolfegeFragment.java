package com.example.katyana.eartrainer;

import android.app.ActionBar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SolfegeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SolfegeFragment";

    private Button mPlayButton;
    private Button mButton_Do;
    private Button mButton_Re;
    private Button mButton_Mi;
    private Button mButton_Fa;
    private Button mButton_Sol;
    private Button mButton_La;
    private Button mButton_Ti;
    private Button mButton_Octave;
    private Button mSubmitButton;

    TextView score_view;

    private LinearLayout mLayout;
    private int score;

    MediaPlayer middlec;
    MediaPlayer mp; //The Random Player
    private int[] rawRef = {R.raw.d_re, R.raw.e_mi, R.raw.f_fa, R.raw.g_sol, R.raw.a_la, R.raw.b_ti, R.raw.do_upper};
    ArrayList<Integer> correct_answer = new ArrayList<>();
    ArrayList<Integer> submitted_answer = new ArrayList<>();

    /* this code will be added later, when we need to clear the answer views:
    if(((LinearLayout) linearLayout).getChildCount() > 0)
    ((LinearLayout) linearLayout).removeAllViews();
     */

    //AudioManager mAudioManager;
    // private SoundPool middle_c;
    //private SoundPool randomsound;

    /*final MediaPlayer start_do = MediaPlayer.create(this, R.raw.middle_c);
     final MediaPlayer re = MediaPlayer.create(this, R.raw.d_re);
     final MediaPlayer mi = MediaPlayer.create(this, R.raw.e_mi);
     final MediaPlayer fa = MediaPlayer.create(this, R.raw.f_fa);
     final MediaPlayer sol = MediaPlayer.create(this, R.raw.g_sol);
     final MediaPlayer la = MediaPlayer.create(this, R.raw.a_la);
     final MediaPlayer ti = MediaPlayer.create(this, R.raw.b_ti);*/

    private Random mRandom = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_sound, container, false);

        //The user's answer, to become a textview at the bottom of the screen
        mLayout = (LinearLayout) v.findViewById(R.id.array);

        //Initialize buttons, there is probably a better way to do this
        mPlayButton = (Button) v.findViewById(R.id.play);
        mPlayButton.setOnClickListener(this);
        mButton_Do = (Button) v.findViewById(R.id.button_Do);
        mButton_Do.setOnClickListener(this);
        mButton_Re = (Button) v.findViewById(R.id.button_re);
        mButton_Re.setOnClickListener(this);
        mButton_Mi = (Button) v.findViewById(R.id.button_mi);
        mButton_Mi.setOnClickListener(this);
        mButton_Fa = (Button) v.findViewById(R.id.button_fa);
        mButton_Fa.setOnClickListener(this);
        mButton_Sol = (Button) v.findViewById(R.id.button_sol);
        mButton_Sol.setOnClickListener(this);
        mButton_La = (Button) v.findViewById(R.id.button_la);
        mButton_La.setOnClickListener(this);
        mButton_Ti = (Button) v.findViewById(R.id.button_ti);
        mButton_Ti.setOnClickListener(this);
        mButton_Octave = (Button) v.findViewById(R.id.button_do_upper);
        mButton_Octave.setOnClickListener(this);
        mSubmitButton = (Button) v.findViewById(R.id.button_submit);
        mSubmitButton.setOnClickListener(this);

        return v;
    }

    /** BUTTON CLICK HANDLING **/
    @Override
    public void onClick(View view){
        Log.d(TAG, "onClick() called by " + view.getId());

        //This may or may not end up triggering accidentally later but it works for now
        if(correct_answer.isEmpty() && view.getId() != R.id.play){
            Toast.makeText(getActivity(), "You have not clicked Play yet!", Toast.LENGTH_SHORT).show();
            return;
        }

       switch(view.getId()) {
            case R.id.button_submit:
                Log.d(TAG, "onClick() > switch(view.getId()) > case R.id.button_submit called");
                test_correct();
                break;


            /*Cool stuff that would be cool:
            * Larger/varying amounts of random notes played after middle c
            * Before the submit button is clicked, clicking play will play the same notes again instead of creating more random ones and adding even more to the list
            * (as it stands, we don't want the user to click play again before submitting)
            * nicer looks, feel free to completely change color scheme*/
            case R.id.play:
               // Log.d(TAG, "onClick() > switch(view.getId()) > case R.id.play called");
                correct_answer.add(R.raw.middle_c);
                int forArray = mRandom.nextInt(rawRef.length); //random index
                int the_note = rawRef[forArray]; //random note
                Log.d(TAG, "Random Note: " + the_note);
                correct_answer.add(the_note); //adds random note to correct answer
                Toast.makeText(getActivity(), "Clicked! Size: " + correct_answer.size(), Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(super.getActivity(), rawRef[forArray]);
                if(middlec == null) {
                    middlec = MediaPlayer.create(super.getActivity(), R.raw.middle_c);
                    middlec.start();
                    countdown(middlec);
                    middlec = null; //to get rid of extra data for more efficiency
                }
                break;
           case R.id.button_Do:
               submitted_answer.add(R.raw.middle_c);
               mLayout.addView(createNewTextView(getString(R.string.button_do))); //testingthx
               break;
           case R.id.button_re:
               submitted_answer.add(R.raw.d_re);
               mLayout.addView(createNewTextView(getString(R.string.button_re)));
               break;
           case R.id.button_mi:
               submitted_answer.add(R.raw.e_mi);
               mLayout.addView(createNewTextView(getString(R.string.button_mi)));
               break;
           case R.id.button_fa:
               submitted_answer.add(R.raw.f_fa);
               mLayout.addView(createNewTextView(getString(R.string.button_fa)));
               break;
           case R.id.button_sol:
               submitted_answer.add(R.raw.g_sol);
               mLayout.addView(createNewTextView(getString(R.string.button_sol)));
               break;
           case R.id.button_la:
               submitted_answer.add(R.raw.a_la);
               mLayout.addView(createNewTextView(getString(R.string.button_la)));
               break;
           case R.id.button_ti:
               submitted_answer.add(R.raw.b_ti);
               mLayout.addView(createNewTextView(getString(R.string.button_ti)));
               break;
           case R.id.button_do_upper:
               submitted_answer.add(R.raw.do_upper);
               mLayout.addView(createNewTextView(getString(R.string.button_do_upper)));
               //arrayT.append(getText(R.string.button_do_upper));
               break;
           default:
               Toast.makeText(getActivity(), "shit fucked up", Toast.LENGTH_SHORT).show();
        }
    }

    private TextView createNewTextView(String text){
        final LinearLayout.LayoutParams lparams = new LinearLayout
                .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(10,20,10,20);
        final TextView textView = new TextView(getActivity());
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(20);
        textView.setPadding(20, 5, 20, 5);
        textView.setBackgroundColor(getResources().getColor(R.color.light_purple));
        return textView;
    }

    private void countdown(final MediaPlayer player){
        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Nothing to do
            }
            @Override
            public void onFinish() {
                if (player.isPlaying()) {
                    player.stop();
                    player.release();
                }
                else{
                    player.release();
                }
                mp.start();
            }
        };
        timer.start();
    }

    private void test_correct(){
        for(int i = 0; i<correct_answer.size(); i++){
            Log.d(TAG, "CA: " + correct_answer.get(i));
            Log.d(TAG, "SA: " + submitted_answer.get(i));
        }
        if(submitted_answer.equals(correct_answer) == true || (correct_answer.equals(submitted_answer) == true)){
            Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();

            //setup score for correct answers
            score += correct_answer.size();
            TextView score_view = (TextView) getActivity().findViewById(R.id.score_number);
            score_view.setText(score + "");

            correct_answer.removeAll(correct_answer);
            submitted_answer.removeAll(submitted_answer);

            if(correct_answer.isEmpty()){
                Log.d(TAG, "Correct Answer Emptied");
            }
            if(submitted_answer.isEmpty()){
                Log.d(TAG, "Submitted Answer Emptied");
            }
            mLayout.removeAllViews();
        } else {
            Toast.makeText(getActivity(), "Incorrect, try again", Toast.LENGTH_SHORT).show();
            submitted_answer.removeAll(submitted_answer);
            mLayout.removeAllViews();
        }
    }
}