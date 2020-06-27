package fonseca.emmanuel.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] mTitle;
    String[] mDescription;
    int[] images = {
            R.drawable.christian_murguia,
            R.drawable.emmanuel_fonseca,
            R.drawable.julio_rivas,
            R.drawable.ruben_romo,
            R.drawable.araceli_garcia,
            R.drawable.alma_benitez,
            R.drawable.aryok_piera,
            R.drawable.jorge_ruiz,
            R.drawable.angel_medina,
            R.drawable.brayan_calderon,
            R.drawable.roberto_jimenez,
            R.drawable.luis_martinez,
            R.drawable.mario_ramirez,
            R.drawable.julio_mendizabal,
            R.drawable.felipe_fonseca,
            R.drawable.jesus_lopez,
            R.drawable.hector_archundia,
            R.drawable.manoella_valentino,
            R.drawable.diego_gaytan
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        mTitle = res.getStringArray(R.array.participantes);
        mDescription = res.getStringArray(R.array.emails);

        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] rTitle;
        String[] rDescription;
        int[] rImgs;

        MyAdapter (Context c, String title[], String description[], int imgs[]){
            super (c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
}
