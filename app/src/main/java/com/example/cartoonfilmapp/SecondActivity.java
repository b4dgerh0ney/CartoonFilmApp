package com.example.cartoonfilmapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private String[] cartoonNames = {
            "Rick and Morty", "SpongeBob", "Regular Show", "Tom and Jerry", "Batman"
    };

    private String[] videoUrls = {
            "https://www.youtube.com/embed/VNtHLmBVEr0",
            "https://www.youtube.com/embed/NL2j1Wi393Q",
            "https://www.youtube.com/embed/q7_9k08TATc",
            "https://www.youtube.com/embed/t0Q2otsqC4I",
            "https://www.youtube.com/embed/pWJMEHMi09U"
    };

    private int[] imageResIds = {
            R.drawable.ricky_and_morty, R.drawable.sponge_bob, R.drawable.regular_show,
            R.drawable.tom_and_jerry, R.drawable.batman
    };

    private String[] descriptions = {
            "Rick and Morty, Amerikan yapımı bir animasyon bilim kurgu sitcom'dur.\nRick ve torunu Morty ile olağan üstü maceraları konu alır.",
            "SpongeBob, denizin altında yaşayan neşeli bir süngerdir.\nDeniz altında arkadaşları ile eğlenceli geçen günlerini konu alır.",
            "Regular Show, Mordecai ve Rigby'nin maceralarını takip eder.\nHer bölümde olduğu gibi patronları Benson yine sinir ederler.",
            "Tom ve Jerry, klasik bir kedi ve fare çizgi filmidir.\nSürekli bir kovalamaca içerir.",
            "Batman, Gotham Şehri'nde suçla mücadele eden bir süper kahramandır.\nEn büyük düşmanı Jokerdir."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCartoon = cartoonNames[position];
            String videoUrl = videoUrls[position];
            String description = descriptions[position];

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("cartoonName", selectedCartoon);
            intent.putExtra("cartoonVideoUrl", videoUrl);
            intent.putExtra("cartoonDescription", description);
            startActivity(intent);
        });
    }


    private class CustomAdapter extends BaseAdapter {
        private Context context;

        public CustomAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return cartoonNames.length;
        }

        @Override
        public Object getItem(int position) {
            return cartoonNames[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.cartoon_item, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.cartoonImage);
            TextView textView = convertView.findViewById(R.id.cartoonNameTextView);

            imageView.setImageResource(imageResIds[position]);
            textView.setText(cartoonNames[position]);

            return convertView;
        }
    }
}
