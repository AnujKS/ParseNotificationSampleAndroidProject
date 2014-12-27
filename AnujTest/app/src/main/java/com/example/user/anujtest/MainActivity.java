package com.example.user.anujtest;

import android.app.Activity;



import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;


public class MainActivity extends Activity {

    Button sendButton;
    EditText message;
    EditText userNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "QTNYhdcyuLGg4EySrA8JEQsbSKaj2AqSwT0LE4Q2", "o6YGHENpyQS2gTtUQOBEdOgxbULUwIGUlofJ3y1T");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       sendButton=(Button)findViewById(R.id._sendbutton);
        message=(EditText)findViewById(R.id._message);
        userNumber =(EditText)findViewById(R.id._username);



        ParseInstallation currentInstall=ParseInstallation.getCurrentInstallation();
        currentInstall.put("phone","9742510298");
       /* ParseUser user=new ParseUser();
        user.setEmail("Anuj301091@gmail.com");
        user.setUsername("Anuj");
        user.setPassword("anuj");
        user.saveInBackground();*/
      //  currentInstall.put(((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getLine1Number(),ParseUser.getCurrentUser());
      //  currentInstall.put("9742510299",user);
       // currentInstall.saveInBackground();


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ParseQuery pQuery=new ParseInstallation().getQuery();
                pQuery.whereEqualTo("phone",userNumber.getText().toString());
                ParsePush pushMessage=new ParsePush();
                pushMessage.setQuery(pQuery);
                pushMessage.setMessage(message.getText().toString());
                pushMessage.sendInBackground();
            }
        });
      //  PushService.setDefaultPushCallback(this, MainActivity.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }
}
