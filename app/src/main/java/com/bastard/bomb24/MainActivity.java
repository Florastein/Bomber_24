package com.bastard.bomb24;

/*import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber;
    private EditText Editnumber;

    String Times;

    public MainActivity() {
        Times = Editnumber.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        Editnumber = findViewById(R.id.editTextNumber);

    }

    public void makePhoneCall(View view) {
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        if (!phoneNumber.isEmpty()) {
            // Ensure the phone number starts with "tel:"
            if (!phoneNumber.startsWith("tel:")) {
                phoneNumber = "tel:" + phoneNumber;
            }

            //Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
            //startActivity(dialIntent);
            int start = 1;
            int end = Integer.parseInt(Times);

            // Using a regular for loop
            for (int i = start; i <= end; i++) {
                Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
                startActivity(dialIntent);
            }

        }
    }
    /*public class ForLoopExample {
        public void main(String[] args) {
            int start = 1;
            int end = Integer.parseInt(Times);

            // Using a regular for loop
            for (int i = start; i <= end; i++) {
                System.out.println("Iteration " + i);
            }
        }
    }

}*/




/*import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber;
    private EditText editTextCallCount;
    public String phoneNumber = editTextPhoneNumber.getText().toString().trim();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextCallCount = findViewById(R.id.editTextCallCount);

    }

    public void makePhoneCalls(View view) {
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String callCountString = editTextCallCount.getText().toString().trim();

        if (!phoneNumber.isEmpty() && !callCountString.isEmpty()) {
            int callCount = Integer.parseInt(callCountString);

            for (int i = 0; i < callCount; i++) {
                initiatePhoneCall(phoneNumber);
            }
        } else {
            Toast.makeText(this, "Please enter a phone number and call count", Toast.LENGTH_SHORT).show();
        }
    }

    public class TimerExample {

        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        public void main(String[] args) {
            startTimer();
        }

        private void startTimer() {
            // Schedule the task to run every 5 seconds
            scheduler.scheduleAtFixedRate(() -> {
                initiatePhoneCall(phoneNumber); // Replace this with your desired function
            }, 0, 5, TimeUnit.SECONDS);
        }

        private void callFunction() {
            // Replace this method with the code you want to execute
            System.out.println("Function executed!");
        }
    }

    private void initiatePhoneCall(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }
}*/

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private boolean isTimerRunning = false;

    private EditText editTextPhoneNumber;

    private Button btnMakeCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        btnMakeCall = findViewById(R.id.btnMakeCall);

        handler = new Handler();
        startTimer();

        /*btnMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startTimer();

            }
        });*/


    }

    private void startTimer() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isTimerRunning) {
                    // Call your function here (e.g., initiatePhoneCall())
                    initiatePhoneCall();

                    // Show a toast or perform other actions
                    Toast.makeText(MainActivity.this, "Function executed!", Toast.LENGTH_SHORT).show();

                    // Restart the timer after 5 seconds
                    handler.postDelayed(this, 5000);
                }
            }
        }, 0);

        // Set isTimerRunning to true when you want to start the timer
        isTimerRunning = true;
    }

    private void initiatePhoneCall() {
        //String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        // Replace this method with the code to initiate a phone call
        //String phoneNumber = "tel:" + editTextPhoneNumber.toString().trim();
        String phoneNumber = "tel:" + "0242697943"; // Replace with the desired phone number
        Intent dialIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber));
        startActivity(dialIntent);
    }

    // Optionally, you can have a method to stop the timer
    private void stopTimer() {
        isTimerRunning = false;
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the timer when the activity is destroyed
        stopTimer();
    }
}
