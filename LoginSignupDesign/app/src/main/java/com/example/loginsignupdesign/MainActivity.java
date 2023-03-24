
package com.example.loginsignupdesign;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button requestButton;
    TextView alreadySignin;
    private AwesomeValidation awesomeValidation;
    TextView dataName; // a text field to display the request response
    TextView dataEmail; // a text field where the data to be sent is entered
    TextView dataMobile; // a text field where the data to be sent is entered
    TextView dataPassword; // a text field where the data to be sent is entered
    RequestQueue requestQueue;
    ProgressDialog progressDialog;
    String NameHolder, EmailHolder, MobileHolder, PasswordHolder ;

    // Storing server url into String variable.
    String HttpUrl = "http://192.168.0.103/myloginphp/signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        requestButton = (Button) findViewById(R.id.buttonSubmit);
        alreadySignin = (TextView) findViewById(R.id.already_signin);
        requestButton.setOnClickListener(mMyListener);
        alreadySignin.setOnClickListener(mMyListener);

        dataName = (TextView) findViewById(R.id.editTextName);
        dataEmail = (TextView) findViewById(R.id.editTextEmail);
        dataMobile = (TextView) findViewById(R.id.editTextMobile);
        dataPassword = (TextView) findViewById(R.id.editPassword);


        String regexPassword = "^" + "(?=\\S+$)" + ".{5,20}" +"$";
        //String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.editTextName, "^"+ "(?=.*[a-zA-Z])"+ ".{3,10}" +"$" , R.string.nameerror); //alternative "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$"
        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextMobile, "[0-9]{8,11}", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.editPassword, regexPassword, R.string.passworderror);

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        progressDialog = new ProgressDialog(MainActivity.this);

    }

    private View.OnClickListener mMyListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonSubmit:
                    if (awesomeValidation.validate()) {
                        regUser();
                    }
                    break;
                case R.id.already_signin:
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);
                    break;
                default:
                    break;
            }
        }
    };
    public void regUser(){
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        progressDialog.show();

        NameHolder = dataName.getText().toString().trim();
        EmailHolder = dataEmail.getText().toString().trim();
        MobileHolder = dataMobile.getText().toString().trim();
        PasswordHolder = dataPassword.getText().toString().trim();

        String myurl = "http://192.168.0.103/myloginphp/signup.php?name=" + NameHolder +
                "&email=" + EmailHolder + "&mobile="+MobileHolder + "&password=" + PasswordHolder;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, myurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing response message coming from server.
                        Toast.makeText(MainActivity.this, ServerResponse, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();
                        // Showing error message if something goes wrong.
                        Toast.makeText(MainActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        queue.add(stringRequest);
    }
}