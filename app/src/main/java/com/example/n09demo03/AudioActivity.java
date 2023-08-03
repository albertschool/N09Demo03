package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AudioActivity extends AppCompatActivity {
    private EditText eTTTS;

    private TextToSpeechHelper ttsHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        initAll();
    }

    private void initAll() {
        eTTTS = findViewById(R.id.eTTTS);
        ttsHelper = new TextToSpeechHelper(this);
    }

    public void speech(View view) {
        String text = eTTTS.getText().toString();
        ttsHelper.speak(text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsHelper!= null) {
            ttsHelper.destroy();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainMenu) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.notiMenu) {
            Intent intent = new Intent(this,NotiActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

}