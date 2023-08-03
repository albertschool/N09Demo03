package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The Audio activity
 * <p>
 * This activity demonstrate TTS messaging
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 21 /7/2023
 */
public class AudioActivity extends AppCompatActivity {
    private EditText eTTTS;
    private TextToSpeechHelper ttsHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        initAll();
    }

    /**
     * initAll method
     * <p> Init all activity parameters
     * </p>
     */
    private void initAll() {
        eTTTS = findViewById(R.id.eTTTS);
        ttsHelper = new TextToSpeechHelper(this);
    }

    /**
     * speech method
     * <p> Trigger the TTS message with text in the EditText field
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void speech(View view) {
        String text = eTTTS.getText().toString();
        ttsHelper.speak(text);
    }

    /**
     * onBackPressed method
     * <p> Finish the activity when back button is clicked
     * </p>
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     * onDestroy method
     * <p> Kill all TTS operations when the activity closed
     * </p>
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsHelper!= null) {
            ttsHelper.destroy();
        }
    }

    /**
     * onCreateOptionsMenu method
     * <p> Creating the options menu
     * </p>
     *
     * @param menu the Menu object to pass to the inflater
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * onOptionsItemSelected method
     * <p> Reacting the options menu
     * </p>
     *
     * @param item the MenuItem object that triggered by the listener
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        int id = item.getItemId();
        if (id == R.id.mainMenu) {
            intent = new Intent(this,MainActivity.class);
        }
        else if (id == R.id.notiMenu) {
            intent = new Intent(this,NotiActivity.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}