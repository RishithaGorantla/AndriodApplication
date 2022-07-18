package com.example.airbnb;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Booking extends AppCompatActivity {

    Button addguest, reqtobook, changedate;
    EditText quantityedit,dateedit;
    Calendar calendar;
    int year,month,day;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking);

        calendar = Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);


dateedit=(EditText)findViewById(R.id.dateedit);
        quantityedit=(EditText) findViewById(R.id.quantityedit);
        Intent intent = getIntent();
        String value = intent.getStringExtra("quantity");
        quantityedit.setText(""+value);

        String newdate = intent.getStringExtra("date");
        dateedit.setText(""+newdate);

        addguest=(Button)findViewById(R.id.addguest);
        addguest.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Booking.this, GuestDetails.class);
                startActivity(intent);
            }

        });

        changedate=(Button) findViewById(R.id.changedate);
        changedate.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              DatePickerDialog datePickerDialog = new DatePickerDialog(Booking.this, new DatePickerDialog.OnDateSetListener() {
                                                  @Override
                                                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                                      //sets date in EditText
                                                      dateedit.setText(dayOfMonth + "-" + (month + 1) + "-" + year);


                                                  }
                                              }, year, month, day);
                                              //shows DatePickerDialog
                                              datePickerDialog.show();
                                          }
                                      });
                // below line is to get data from all edit text fields.


                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.







                    reqtobook=(Button) findViewById(R.id.reqtobook);
        reqtobook.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                    Message.message(getApplicationContext(), "Booking Details sent to the given Email");

            }

        });
    }
}
