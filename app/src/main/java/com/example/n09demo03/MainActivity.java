package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * shortToast method
     * <p> Demonstrate firing of short duration toast
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void shortToast(View view) {
        str = "Short time demo Toast";
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * longToast method
     * <p> Demonstrate firing of long duration toast
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void longToast(View view) {
        str = "Long time demo Toast";
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    /**
     * customToast method
     * <p> Demonstrate firing of custom toast
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void customToast(View view) {
        View myToast = (LinearLayout) getLayoutInflater()
                .inflate(R.layout.custom_toast,null);
        ImageView iVToast = myToast.findViewById(R.id.iVToast);
        TextView tVToast = myToast.findViewById(R.id.tVToast);
        iVToast.setImageResource(R.drawable.custom_toast);
        str = "Custom Toast demo";
        tVToast.setText(str);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, -500);
        toast.setView(myToast);
        toast.show();
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
        int id = item.getItemId();
        if (id == R.id.audioMenu) {
            Intent intent = new Intent(this,AudioActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.notiMenu) {
            Intent intent = new Intent(this,NotiActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}