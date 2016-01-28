package com.example.katyana.eartrainer;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoundActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
    }

    /**private Button mPlayButton;
    MediaPlayer middlec;
    MediaPlayer mp; //The Random Player

    //AudioManager mAudioManager;
   // private SoundPool middle_c;
    //private SoundPool randomsound;

    private int[] rawRef = {R.raw.d_re, R.raw.e_mi, R.raw.f_fa, R.raw.g_sol, R.raw.a_la, R.raw.b_ti, R.raw.do_upper};
    ArrayList<Integer> correct_answer = new ArrayList<>();
    ArrayList<Integer> submitted_answer = new ArrayList<>();

    /**final MediaPlayer start_do = MediaPlayer.create(this, R.raw.middle_c);
    final MediaPlayer re = MediaPlayer.create(this, R.raw.d_re);
    final MediaPlayer mi = MediaPlayer.create(this, R.raw.e_mi);
    final MediaPlayer fa = MediaPlayer.create(this, R.raw.f_fa);
    final MediaPlayer sol = MediaPlayer.create(this, R.raw.g_sol);
    final MediaPlayer la = MediaPlayer.create(this, R.raw.a_la);
    final MediaPlayer ti = MediaPlayer.create(this, R.raw.b_ti);**/
/**
    private Random mRandom = new Random();

   // List<Integer> msoundList = new ArrayList<Integer>();
   // private SoundPool[] sounds = new SoundPool[6];

    /** ONCREATE METHOD IS HERE **//**
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        mPlayButton = (Button) findViewById(R.id.play);
        correct_answer.add(R.raw.middle_c);

        //msoundList.add(MediaPlayer.create(this, R.raw.a_la));

        /** THIS INITIALIZES THE MIDDLE C SOUND FOR DIFFERENT VERSIONS**//**
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME).build();
            //Middle C
          /**  middle_c = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(aa).build();
            randomsound = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(aa).build();
            msoundList.add(randomsound.load(this, R.raw.d_re, 1));
            msoundList.add(randomsound.load(this, R.raw.e_mi, 1));
            msoundList.add(randomsound.load(this, R.raw.f_fa, 1));
            msoundList.add(randomsound.load(this, R.raw.g_sol, 1));
            msoundList.add(randomsound.load(this, R.raw.a_la, 1));
            msoundList.add(randomsound.load(this, R.raw.b_ti, 1));**/

/**
            //CsoundID = middle_c.load(this, R.raw.middle_c, 1);
        } else {
            /**middle_c = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            randomsound = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            msoundList.add(randomsound.load(this, R.raw.d_re, 1));
            msoundList.add(randomsound.load(this, R.raw.e_mi, 1));
            msoundList.add(randomsound.load(this, R.raw.f_fa, 1));
            msoundList.add(randomsound.load(this, R.raw.g_sol, 1));
            msoundList.add(randomsound.load(this, R.raw.a_la, 1));
            msoundList.add(randomsound.load(this, R.raw.b_ti, 1));;
            CsoundID = middle_c.load(this, R.raw.middle_c, 1);**//**
        }

    }
    /** END OF ONCREATE **/


    /** PLAY BUTTON **//**
    public void playbutton(View v) {
        int forArray = mRandom.nextInt(rawRef.length);
        correct_answer.add(forArray);
        mp = MediaPlayer.create(this, rawRef[forArray]);

        if(middlec == null) {
            middlec = MediaPlayer.create(this, R.raw.middle_c);
            middlec.start();
            countdown(middlec);
            middlec = null;
        }
        //starting on Do
       // middle_c.play(CsoundID, 1, 1, 1, 0, 1);
        //randomsound.play(msoundList.get(mRandom.nextInt(msoundList.size())), 1, 1, 0, 0, 1);
    }

    /**All my darling buttons**//**
    public void DoButton(View view) {
        submitted_answer.add(R.raw.middle_c);
    }

    public void MiButton(View view) {
        submitted_answer.add(R.raw.e_mi);
    }

    public void FaButton(View view) {
        submitted_answer.add(R.raw.f_fa);
    }

    public void SolButton(View view) {
        submitted_answer.add(R.raw.g_sol);
    }

    public void LaButton(View view) {
        submitted_answer.add(R.raw.a_la);
    }

    public void TiButton(View view) {
        submitted_answer.add(R.raw.b_ti);
    }

    public void OctaveButton(View view) {
        submitted_answer.add(R.raw.do_upper);
    }

    public void countdown(final MediaPlayer player){
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
    }**/


    /**@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }**/
}
