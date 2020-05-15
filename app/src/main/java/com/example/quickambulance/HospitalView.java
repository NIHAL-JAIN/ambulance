package com.example.quickambulance;

import android.app.AppComponentFactory;
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

public class HospitalView extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"TMHRC MORADABAD  800M","CREST HOSPITAL   16.3KM", "RSD HOSPITAL   16.1KM", "GALAXY SURGICAL CENTER    16KM",
            "BRAHMA NETRALAYA  12.6KM", "PANDIT DEEN DAYAL UPADHYAY MALE HOSPITAL  13KM","DISTRICT FEMAILE HOSPITAL 13.1KM",
            "RAMGANGA EYE HOSPITAL 15KM","SIDH MULTISPECIALLY HOSPITAL  16.5KM","APOLLO LASER HOSPITAL  12.4KM","SHRI MAHESH NETRALAYA  13.3KM",
            "CHC THAKURDWARA  13KM","COMOS HOSPITAL 13KM","CL GUPTA EYE INSTITUTE  16.9KM","SRI SAI HOSPITAL  12.4KM","LOKPRIYA HOSPITAL  14.5KM",
            "SADBHAVANA NURSING HOME  16.6KM","APEX HOSPITAL  10.9KM","ANAND HOSPITAL  13.8KM","SAHU RAMESHWAR SARA KOTHIWAL HEART & NEURO CENTER  17.1 KM",
            "JAIN EYE CARE CENTER  13.8KM","ASHIRWAD NURSING HOSPITAL 14.8KM","KUMAR NURSING HOME 12.8KM","CENTRE FOR SIGHT  18.4KM",
            "PREMIUM DENSITY HOSPITAL 12.5km","DR HANS RAJ MEMORIAL CLINC  18.4KM","NAVIN HOSPITAL 14KM","RAJANI HOSPITAL 12.4KM"};

    String mDescription[] = {"TMHRC BAGARPUR MORADABAD (UP)","PREM NAGAR KANTH ROAD MORADABAD (UP)","RAM GANGA VIHAR PHASE 2 MORADABAD (UP)", "B1/8 RAM GANGA VIHAR MORADABAD (UP)",
            "149 AVAS VIKAS, CIVIL LINES MORADABAD (UP)","CIVIL LINE MORADABAD (UP)","CIVIL LINES  MORADABAD (UP)"," NEAR NEURON HOSPITAL ASHIANA-1 MORADABAD (UP)"," OPP. JIYARAT HARTHALA KANTH ROAD MORADABAD (UP)",
            "AVAS VIKAS COLONHY  MORADABAD (UP)","SHRI MAHESH NETRALAYA B-25 GANDHI NAGAR  MORADABAD (UP)","TEHSIL BUS STAND  MORADABAD (UP)","PO KAZIPURA KANTH ROAD MORADABAD (UP)","RAM GANGA VIHAR PHASE-2 MORADABAD (UP)",
            "NEAR LOCOSHED BRIDGE DELHI ROAD MORADABAD (UP)","LOKPRIYA HOSPITAL  MORADABAD (UP)","ASHIYANA KANTH ROAD MORADABAD (UP)","APEX HOSPITAL, OPPOSITE HOTEL PARK SQUARE NEAR MAJHOLI CHAURHA MORADABAD (UP)",
            " NEAR MIGLANI CINEMA RAMPUR ROAD MORADABAD (UP)", "KANTH ROAD MORADABAD (UP)"," B-77 GANDHI NAGAR MORADABAD (UP)","A-109 LAJPAT NAGAR MORADABAD (UP)",
            "KUMAR NURSING HOME COMPANY BAGH CIVIL LINES MORADABAD (UP)","KANTH ROAD MOHRA KI MILAK MORADABAD (UP)","A35 LAJPAT NAGAR NEAR TELEPHONE EXCHANGE MORADABAD (UP)",
            "NEAR BALAJI MANDIR,COURT ROAD MORADABAD (UP)","A-93 GANDHI NAGAR PRINCE ROAD NEAR CHADDA CINEMA MORADABAD (UP)","PARKAR COLLEGE ROAD MORADABAD (UP)"};

    int images[] = {R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,
            R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,
            R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,
            R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,
            R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,R.drawable.hospital2,};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hospital_view);

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
                    Toast.makeText(HospitalView.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(HospitalView.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(HospitalView.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(HospitalView.this, "Hospital Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  0) {
                    Toast.makeText(HospitalView.this, "Hospital Description", Toast.LENGTH_SHORT).show();
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
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
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