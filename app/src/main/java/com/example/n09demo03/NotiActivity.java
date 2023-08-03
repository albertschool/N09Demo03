package com.example.n09demo03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotiActivity extends AppCompatActivity {
    private EditText eTNoti;
    private Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        initAll();
    }

    private void initAll() {
        eTNoti = (EditText) findViewById(R.id.eTNoti);
        gi = getIntent();
        boolean clicked = gi.getBooleanExtra("notification_clicked", false);
        if (clicked) {
            Toast.makeText(this, "Notification clicked!", Toast.LENGTH_LONG).show();
        }
    }

    public void basic(View view) {
        String text = eTNoti.getText().toString();
        NotificationHelper.showNotification(this, text);
    }

    public void plus(View view) {
        String text = eTNoti.getText().toString();
        NotificationHelper.showNotificationBtn(this, text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
        if (id == R.id.audioMenu) {
            Intent intent = new Intent(this,AudioActivity.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

}