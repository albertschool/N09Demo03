package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * The main activity
 * <p>
 * A basic demo application to demonstrate:
 * 1. Toast options
 * 2. Two notifications demo
 * 3. TextToSpeech demo
 * <p>
 * This activity demonstrate Toast options
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 21 /7/2023
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if (id == R.id.audioMenu) {
            Intent intent = new Intent(this,AudioActivity.class);
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