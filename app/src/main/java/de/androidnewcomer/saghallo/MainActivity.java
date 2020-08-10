package de.androidnewcomer.saghallo;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

// Alt + Enter ==> für Import !
// Strg + Alt + O
// Strg

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // zeigt das activity_main.xml an...
        setContentView(R.layout.activity_main);
       tts = new TextToSpeech(this, this);
    }



    @Override
    public void onInit(int argO) {
        tts.setLanguage(Locale.GERMAN);
        Button button = findViewById(R.id.sag_es);
        button.setOnClickListener(this);
         /*
        tts.setLanguage(Locale.GERMAN);
        tts.speak("Hallo Isabel, dies ist ein Test. Ich wohne in Deutschland.", TextToSpeech.QUEUE_FLUSH, null);
        */
    }




    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editText1);
        tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
        // tts.setLanguage(Locale.GERMAN);
        // tts.speak("Hallo Isabel, dies ist ein Test. Ich wohne in Deutschland.", TextToSpeech.QUEUE_FLUSH, null);
    }

}