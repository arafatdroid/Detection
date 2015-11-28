package com.example.mazharulislam.detection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static RadioGroup radioGroup;
    public static RadioButton radioButton,radioButton1;
    public static SeekBar seekBar;
    public ToggleButton toggleButton;
    private OnCheckedChangeListener toggleListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_dropdown_item);
        radioGroup=(RadioGroup)findViewById(R.id.rg);
        radioButton=(RadioButton)findViewById(R.id.radioButton);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        Spinner spinner= (Spinner)(findViewById(R.id.spinner));
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        toggleButton= (ToggleButton)findViewById(R.id.toggleButton);

        toggleListener = new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this," Toggle Button Selected",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Toggle Button Not Selected",Toast.LENGTH_LONG).show();
                }
            }
        };
        toggleButton.setOnCheckedChangeListener(toggleListener);

        setSeekBar();

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Selected Radio Button Dhaka", Toast.LENGTH_LONG).show();
            }
        });
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Selected Radio Button Chittagong",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setSeekBar(){
        seekBar =(SeekBar)findViewById(R.id.seekBar);

         seekBar.setOnSeekBarChangeListener(
                 new SeekBar.OnSeekBarChangeListener() {
                     int progress_value;
                     @Override
                     public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                         progress_value=progress;
                         Toast.makeText(MainActivity.this,"Seekbar Covered "+progress+" / "+seekBar.getMax(),Toast.LENGTH_LONG).show();

                     }

                     @Override
                     public void onStartTrackingTouch(SeekBar seekBar) {
                       //  Toast.makeText(MainActivity.this,"Seekbar is start tracking ",Toast.LENGTH_LONG).show();

                     }

                     @Override
                     public void onStopTrackingTouch(SeekBar seekBar) {
                        // Toast.makeText(MainActivity.this,"Seekbar is stop tracking ",Toast.LENGTH_LONG).show();
                         Toast.makeText(MainActivity.this,"Seekbar Covered "+progress_value+" / "+seekBar.getMax(),Toast.LENGTH_LONG).show();

                     }
                 }
         );


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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mytext= (TextView) view;
        Toast.makeText(MainActivity.this,"Spinner Clicked "+mytext.getText(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
