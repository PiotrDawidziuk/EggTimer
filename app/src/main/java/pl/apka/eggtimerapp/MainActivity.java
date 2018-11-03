package pl.apka.eggtimerapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    SeekBar seekBar;

    public void buttonClicked (View view) {

        Log.i("info", "button pressed");

        new CountDownTimer(seekBar.getProgress()*1000, 1000){

            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);
            }

            @Override
            public void onFinish() {
                Log.i("info", "Finish");
            }
        }.start();

    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft/60;
        int seconds = secondsLeft - (minutes*60);

        String secondString = Integer.toString(seconds);

        if (secondString.length() == 1) {
            secondString = "0"+secondString;
        }


        textView.setText(Integer.toString(minutes)+":"+secondString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar2);

        textView = findViewById(R.id.textView);

        seekBar.setMax(600);

        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
