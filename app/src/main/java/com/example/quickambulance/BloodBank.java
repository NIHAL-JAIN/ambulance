package com.example.quickambulance;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class BloodBank extends AppCompatActivity {



    ListView listView;
    String mTitle[] = {"TMU Blood Bank  650M","PATH CARE PATHOLOGY LAB 3.3KM","SRI SAI SUPER SPECIALITY HOSPITAL  8.8KM","DR LAL PATH LABS MDA 9.7KM",
            "COSMOS BLOOD BANK 10.0KM","GOVT. BLOOD BANK  10.2KM", "IMA BLOOD BANK 10.6KM","JANTA PATHOLOGY LAB 10.6KM","MRI DIAGNOSTIC 10.6KM",
            "DR. CHATURVEDI CENTRAL BLOOD BANK 10.9KM","DONOR BANK 8.0KM","NEW CITY HOSPITAL 10.6KM"};

    String mDescription[] = {"TMU MEDICAL COLLEGE BAGADPUR MORADABAD (UP)","KDR PUBLIC SCHOOL DINGARPUR ROAD,OPPOSITE,KUNDARKI (UP)",
            "DELHI RD,MANSAROVER COLONY LINE PAR MORADABAD(UP)","SAI MADIR ROAD NR ALLAHABAD BANK DEEN DAYAL NAGAR MORADABAD(UP)",
            "KANTA ROAD PREM NAGAR MOHRA KI MOHLI MORADABAD(UP)","DISTRICT HOSPITAL CAMPUS CIVIL LINES MORADABAD(UP)","CIVIL LINES MORADABAD (UP)",
            "27 SHRI RAM VIHAR COLONY CIVIL LINES MORADABAD (UP)","MORADABAD GANDHI NAGAR MORADABAD(UP)","SMALL STREET NUMBER 6 GANDHI NAGAR MORADABAD(UP)",
            "NEAR  DEPUTY GANJ ROAD DARZIN MORADABAD(UP)","CHAMBER NO. 352 COLLECRET COURT COMPOUND MORADABAD(UP)","B-24 RD NUMBER 1,NEAR JANTA BLOOD BANK GANDHI NAGAR MORADABAD(UP)" };

    int images[] = {R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,
            R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank,
            R.drawable.bloodbank,R.drawable.bloodbank,R.drawable.bloodbank};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(BloodBank.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(BloodBank.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(BloodBank.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(BloodBank.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(BloodBank.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.bloodbrow, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.bloodbrow, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}
