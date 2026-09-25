package tj.rustam.englishtajik;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String[]> allWords = new ArrayList<>();
    WordAdapter adapter;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFromAssets();
        RecyclerView rv = findViewById(R.id.recyclerView);
        EditText search = findViewById(R.id.searchEdit);
        adapter = new WordAdapter(allWords);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher(){
            public void beforeTextChanged(CharSequence s,int a,int b,int c){}
            public void onTextChanged(CharSequence s,int a,int b,int c){
                String q=s.toString().toLowerCase().trim();
                List<String[]> f=new ArrayList<>();
                if(q.isEmpty()) f=allWords;
                else for(String[] w:allWords) if(w[0].toLowerCase().contains(q)||w[1].contains(q)) f.add(w);
                adapter.update(f);
            }
            public void afterTextChanged(Editable s){}
        });
    }
    private void loadFromAssets(){
        try{
            InputStream is = getAssets().open("dictionary.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer,"UTF-8");
            JSONArray arr = new JSONArray(json);
            for(int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                allWords.add(new String[]{o.getString("en"),o.getString("tj")});
            }
        }catch(Exception e){ e.printStackTrace(); }
    }
    class WordAdapter extends RecyclerView.Adapter<WordAdapter.VH>{
        List<String[]> items; WordAdapter(List<String[]> i){items=i;}
        void update(List<String[]> n){items=n; notifyDataSetChanged();}
        class VH extends RecyclerView.ViewHolder{TextView en,tj; VH(View v){super(v); en=v.findViewById(R.id.enText); tj=v.findViewById(R.id.tjText);}}
        public VH onCreateViewHolder(ViewGroup p,int t){View v=LayoutInflater.from(p.getContext()).inflate(R.layout.item_word,p,false); return new VH(v);}
        public void onBindViewHolder(VH h,int pos){h.en.setText(items.get(pos)[0]); h.tj.setText(items.get(pos)[1]);}
        public int getItemCount(){return items.size();}
    }
}
