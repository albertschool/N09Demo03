package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The Noti activity
 * <p>
 * This activity demonstrate two notifications options & reacting to one
 * </p>
 *
 * @author Levy Albert albert.school2015@gmail.com
 * @version 2.0
 * @since 21 /7/2023
 */
public class NotiActivity extends AppCompatActivity {
    private EditText eTNoti;
    private Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        initAll();
    }

    /**
     * initAll method
     * <p> Init all activity parameters
     * </p>
     */
    private void initAll() {
        eTNoti = (EditText) findViewById(R.id.eTNoti);
        gi = getIntent();
        boolean clicked = gi.getBooleanExtra("notification_clicked", false);
        if (clicked) {
            Toast.makeText(this, "Notification clicked!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * basic method
     * <p> Demonstrate basic notification firing
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void basic(View view) {
        String text = eTNoti.getText().toString();
        NotificationHelper.showNotification(this, text);
    }

    /**
     * plus method
     * <p> Demonstrate firing of notification with one button
     * </p>
     *
     * @param view the view that triggered the method
     */
    public void plus(View view) {
        String text = eTNoti.getText().toString();
        NotificationHelper.showNotificationBtn(this, text);
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
        if (id == R.id.audioMenu) {
            intent = new Intent(this,AudioActivity.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}