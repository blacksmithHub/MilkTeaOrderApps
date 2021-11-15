package com.example.chanel.milkteaorderapps;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.attr.angle;

public class MainActivity extends AppCompatActivity {

//sss
    ImageButton btnMilktea,btnAddons;
    SeekBar skbarSugarlevel,skbarSize;
    TextView txtMsg,txtFlavor,txtSugarlevel,txtSize,txtPrice,txtAddOns,txtAddonPrice,txtExPrice,txtNoOrder,txtTotalPrice;
    public String test[];
    public Integer teaimage[] = {R.drawable.milktea1,R.drawable.milktea2,R.drawable.milktea3,R.drawable.milktea4,R.drawable.milktea5};
   public Integer addonsimage[]={R.drawable.noaddons,R.drawable.boba,R.drawable.coffeejelly,R.drawable.greenapplejelly,R.drawable.greenreadbean,
           R.drawable.greenteaboba,R.drawable.mangojelly};           ;
    public String sugarlevel[]={"No Sugar","25% Sugar","50% Sugar","75% Sugar","Full Sugar"};
    public String teasize[]={"Small","Medium","Large"};
    public String teaflavor[]={"Original","Emperor","Dragon","Pearl Black","Okinawa"};
    public String teaaddons[]={"No Add Ons","Boba Jelly","Coffee Jelly","Green Apple Jelly","Green/Red Beans"
    ,"Green TeaBoba","Mango Jelly"};
    public Double addonsprice[]={0.00,10.00,11.00,13.00,12.00,14.00,15.00};
   public Double teaprice  [][]={{70.00,80.00,90.00},{75.00,85.00,95.00},{70.00,80.00,90.00},{72.00,82.00,92.00},{80.00,90.00,100.00}};


    public int size=0;
    public int qty=0;
    public int imageteacntr=0;
    public int imageaddonscntr=0;
    public int flavor,progresssugar,progresssize;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMilktea=(ImageButton)findViewById(R.id.imageButtonTea);
        btnAddons=(ImageButton) findViewById(R.id.imageButtonAddons);
        txtSugarlevel=(TextView) findViewById(R.id.textSugarlevel);
        txtFlavor=(TextView)findViewById(R.id.textFlavor);
        txtSize=(TextView) findViewById(R.id.textSize);
        skbarSize=(SeekBar) findViewById(R.id.seekBarSize);
        skbarSugarlevel=(SeekBar) findViewById(R.id.seekBarSugarLevel);
        txtMsg=(TextView) findViewById(R.id.textViewMsg);
        txtPrice=(TextView) findViewById(R.id.textPrice);
        txtAddOns=(TextView) findViewById(R.id.textAddons) ;
        txtAddonPrice=(TextView) findViewById(R.id.textAddonPrice);
        txtExPrice=(TextView) findViewById(R.id.textExPrice);
        txtNoOrder=(EditText) findViewById(R.id.textNoOrder);
        txtTotalPrice=(TextView) findViewById(R.id.textTotalPrice);
//        txtMsg.setText("Tap Images for more Flavor/Add-ons");
        skbarSugarlevel.setProgress(1);
        imageteacntr=(int)(Math.random()*4);
        refreshdisplay(imageteacntr,1,0,0);
//

        skbarSugarlevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progresssugar=progress;
                refreshdisplay(imageteacntr,progresssugar,progresssize,imageaddonscntr);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skbarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progresssize=progress;
                refreshdisplay(imageteacntr,progresssugar,progresssize,imageaddonscntr);;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnMilktea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (imageteacntr<4)
                    imageteacntr=imageteacntr+1;
                   else
                 imageteacntr=0;

                refreshdisplay(imageteacntr,progresssugar,progresssize,imageaddonscntr);

            }
        });

        btnAddons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageaddonscntr<6)
                    imageaddonscntr=imageaddonscntr+1;
                else
                    imageaddonscntr=0;

                refreshdisplay(imageteacntr,progresssugar,progresssize,imageaddonscntr);
            }
        });

        txtNoOrder.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                refreshdisplay(imageteacntr,progresssugar,progresssize,imageaddonscntr);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void refreshdisplay(int mimageteacnt,int msugar,int msize,int mimagecntraddons)

    {



        btnMilktea.setImageResource(teaimage[mimageteacnt]);
        btnAddons.setImageResource(addonsimage[mimagecntraddons]);
        txtSugarlevel.setText(sugarlevel[msugar]);
        txtSize.setText(teasize[msize]);
        txtFlavor.setText("**"+teaflavor[mimageteacnt]+"**"+teasize[msize]+"***"+sugarlevel[msugar]+"**");
        txtPrice.setText(""+String.format("%.2f",teaprice[mimageteacnt][msize]));
        txtAddonPrice.setText(""+String.format("%.2f",addonsprice[mimagecntraddons]));
        txtAddOns.setText("Add "+teaaddons[mimagecntraddons]);
        double extPrice=Double.parseDouble(txtPrice.getText().toString())+Double.parseDouble(txtAddonPrice.getText().toString());
        txtExPrice.setText(""+String.format("%.2f",extPrice));
        try {
            double totalPrice=Double.parseDouble(txtExPrice.getText().toString())*Double.parseDouble((txtNoOrder.getText().toString()));
            txtTotalPrice.setText(""+String.format("%,.2f",totalPrice));
        } catch (NumberFormatException e) {
            txtTotalPrice.setText(""+String.format("%,.2f",0.00));
        }


    }
}

