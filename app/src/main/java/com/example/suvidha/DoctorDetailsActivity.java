package com.example.suvidha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {   {"Doctor Name : Nikhil Patil", "Hospital Address: Vasai" ,"Exp:  100yrs","Mobile No:9373565412", "6000"},
                    {"Doctor Name : Atharva Patil", "Hospital Address: byculla" ,"Exp: 1yrs","Mobile No:1234567890", "90"},
                    {"Doctor Name : Soham Pashte", "Hospital Address: Virar" ,"Exp:  2yrs","Mobile No:9373570412", "30"},
                    {"Doctor Name : Kamlesh Shelar", "Hospital Address: Borivali" ,"Exp:  3yrs","Mobile No:9373585412", "50"},
                    {"Doctor Name : Pratik Patil", "Hospital Address: Kandivali" ,"Exp:  4yrs","Mobile No:9373569412", "80"},
            };
    private String[][] doctor_details2=
            {   {"Doctor Name : Dr. Joyce Klamert", "Hospital Address: Vasai" ,"Exp:  100yrs","Mobile No:9373565412", "6000"},
                    {"Doctor Name : Dr. Dallas Minarik", "Hospital Address: byculla" ,"Exp: 1yrs","Mobile No:1234567890", "90"},
                    {"Doctor Name : Dr. Judah Ensey", "Hospital Address: Virar" ,"Exp:  2yrs","Mobile No:9373570412", "30"},
                    {"Doctor Name : Dr. Aubrey Trnong", "Hospital Address: Borivali" ,"Exp:  3yrs","Mobile No:9373585412", "50"},
                    {"Doctor Name : Dr. Jesse Umlauf", "Hospital Address: Kandivali" ,"Exp:  4yrs","Mobile No:9373569412", "80"},
            };
    private String[][] doctor_details3=
            {   {"Doctor Name : Dr. Julie Dangel", "Hospital Address: Vasai" ,"Exp:  100yrs","Mobile No:9373565412", "6000"},
                    {"Doctor Name : Dr. Malachi Patino", "Hospital Address: byculla" ,"Exp: 1yrs","Mobile No:1234567890", "90"},
                    {"Doctor Name : Dr. Sawyer Feathers", "Hospital Address: Virar" ,"Exp:  2yrs","Mobile No:9373570412", "30"},
                    {"Doctor Name : Dr. Herbert Kothenbeutel", "Hospital Address: Borivali" ,"Exp:  3yrs","Mobile No:9373585412", "50"},
                    {"Doctor Name : Dr. Jayden Tandon", "Hospital Address: Kandivali" ,"Exp:  4yrs","Mobile No:9373569412", "80"},
            };

    private String[][] doctor_details4=
            {   {"Doctor Name : Dr. Otis Eckstrom", "Hospital Address: Vasai" ,"Exp:  100yrs","Mobile No:9373565412", "6000"},
                    {"Doctor Name : Dr. Camille Schoen", "Hospital Address: byculla" ,"Exp: 1yrs","Mobile No:1234567890", "90"},
                    {"Doctor Name : Dr. Andre Matthews", "Hospital Address: Virar" ,"Exp:  2yrs","Mobile No:9373570412", "30"},
                    {"Doctor Name : Dr. Hector Kizziar", "Hospital Address: Borivali" ,"Exp:  3yrs","Mobile No:9373585412", "50"},
                    {"Doctor Name : Dr. Andrea Hrobsky", "Hospital Address: Kandivali" ,"Exp:  4yrs","Mobile No:9373569412", "80"},
            };

    private String[][] doctor_details5=
            {   {"Doctor Name : Dr. Braeden Wishum", "Hospital Address: Vasai" ,"Exp:  100yrs","Mobile No:9373565412", "6000"},
                    {"Doctor Name : Dr. Tyson Gessel", "Hospital Address: byculla" ,"Exp: 1yrs","Mobile No:1234567890", "90"},
                    {"Doctor Name : Dr. Kendrick Herzberg", "Hospital Address: Virar" ,"Exp:  2yrs","Mobile No:9373570412", "30"},
                    {"Doctor Name : Dr. Mark Matthies", "Hospital Address: Borivali" ,"Exp:  3yrs","Mobile No:9373585412", "50"},
                    {"Doctor Name : Dr. Cole Debus", "Hospital Address: Kandivali" ,"Exp:  4yrs","Mobile No:9373569412", "80"},
            };














    TextView tv;
    Button btn;
    String [][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv= findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.ButtonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


            if (title.compareTo("Family physician")==0)
                doctor_details=doctor_details1;
            else
            if (title.compareTo("Dietician")==0)
                doctor_details=doctor_details2;
            else
            if (title.compareTo("Dentist")==0)
                doctor_details=doctor_details3;
            else
            if (title.compareTo("Surgeon")==0)
                doctor_details=doctor_details4;
            else
                doctor_details=doctor_details5;
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });


                list= new ArrayList();
                for (int i=0;i<doctor_details.length;i++) {
                   item =new HashMap<String,String>();
                   item.put("line 1" ,doctor_details[i][0]);
                   item.put("line 2" ,doctor_details[i][1]);
                   item.put("line 3" ,doctor_details[i][2]);
                   item.put("line 4" ,doctor_details[i][3]);
                   item.put("line 5","Cons Fees :" +doctor_details[i][4]+"/-");
                   list.add(item);
                }
                sa= new SimpleAdapter(this,list ,
                        R.layout.multi_line,new String[] {"line1","line2","line3","line4","line5"} ,
                        new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );


        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
    }
}