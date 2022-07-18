package com.example.airbnb;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class Ville extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
     EditText datetext;

    


    int i=0;
    int j=0;

    Button button, sub, add;
    TextView quantity_text_view;
    Calendar calendar;
    int year,month,day;
    Button btn;
    // creating object of ViewPager
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.ville1, R.drawable.vile2, R.drawable.ville3, R.drawable.ville4,
            R.drawable.ville5};

    // Creating Object of ViewPagerAdapter
    ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ville);



        calendar = Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        //accessing EditText and Button
        datetext=(EditText)findViewById(R.id.datetext);
        quantity_text_view=(TextView)findViewById(R.id.quantity_text_view);
        button=(Button)findViewById(R.id.button);
        btn=(Button)findViewById(R.id.rulesbtn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (j == 0) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(Ville.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            //sets date in EditText
                            datetext.setText(dayOfMonth + "-" + (month + 1) + "-" + year);


                        }
                    }, year, month, day);
                    //shows DatePickerDialog
                    datePickerDialog.show();
                    // below line is to get data from all edit text fields.


                    // on below line we are calling a method to add new
                    // course to sqlite data and pass all our values to it.


                    button.setText("Reserve");

                    j++;
                } else if (j == 1) {
                    String value = quantity_text_view.getText().toString();
                    String newdate = datetext.getText().toString();
                        Intent intent = new Intent(Ville.this, Booking.class);
                    intent.putExtra("quantity",value);
                    intent.putExtra("date",newdate);
                    String sizevalue = quantity_text_view.getText().toString();
                    String datevalue = datetext.getText().toString();
                    Intent intent1=new Intent(Ville.this,Booking.class);
                    intent.putExtra("quantity",value);
                    intent.putExtra("date",newdate);
                    startActivity(intent);

                }

                }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ville.this, Rules.class);
                startActivity(intent);
            }

        });

        quantity_text_view=(TextView)findViewById(R.id.quantity_text_view) ;
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;

                quantity_text_view.setText(String.valueOf(i));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i-1;

                quantity_text_view.setText(String.valueOf(i));
            }
        });



        // Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(Ville.this, images);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
    }
}
