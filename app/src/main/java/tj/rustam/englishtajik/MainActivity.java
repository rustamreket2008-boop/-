package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.*;

public class MainActivity extends Activity {

    EditText search;
    TextView result;
    LinearLayout list;

    HashMap<String,String> dictionary = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDictionary();
        createUI();
        showAll();
    }

    void createUI() {

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(20,20,20,20);
        main.setBackgroundColor(Color.rgb(8,35,70));

        TextView title = new TextView(this);
        title.setText("📚 English — Тоҷикӣ");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0,10,0,20);

        main.addView(title);

        search = new EditText(this);
        search.setHint("Калимаи англисӣ навис...");
        search.setTextSize(17);
        search.setSingleLine(true);
        search.setPadding(15,10,15,10);

        main.addView(search);

        result = new TextView(this);
        result.setTextColor(Color.WHITE);
        result.setTextSize(21);
        result.setPadding(15,25,15,25);

        main.addView(result);

        ScrollView scroll = new ScrollView(this);

        list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);

        scroll.addView(list);
        main.addView(scroll,
                new LinearLayout.LayoutParams(
                        -1,0,1));

        setContentView(main);

        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s,int start,int count,int after){}

            @Override
            public void onTextChanged(
                    CharSequence s,int start,int before,int count){

                searchWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s){}
        });
    }

    void searchWord(String text){

        text=text.toLowerCase().trim();

        list.removeAllViews();

        if(text.isEmpty()){
            result.setText(
                    "👋 Хуш омадед!\n\n" +
                    "Калимаи англисиро нависед."
            );
            showAll();
            return;
        }

        if(dictionary.containsKey(text)){

            result.setText(
                    "🇬🇧 "+text+
                    "\n\n🇹🇯 "+dictionary.get(text)
            );

            return;
        }

        int count=0;

        for(String word:dictionary.keySet()){

            if(word.contains(text) ||
               dictionary.get(word)
               .toLowerCase()
               .contains(text)){

                addWord(word);
                count++;
            }
        }

        result.setText(
                "🔎 Натиҷа: "+count+" калима"
        );
    }

    void showAll(){

        list.removeAllViews();

        for(String word:dictionary.keySet()){
            addWord(word);
        }

        result.setText(
                "📖 Луғат\n\n"+
                "Ҳамагӣ: "+
                dictionary.size()+
                " калима"
        );
    }

    void addWord(final String word){

        TextView item=new TextView(this);

        item.setText(
                "🇬🇧 "+word+
                "     →     🇹🇯 "+
                dictionary.get(word)
        );

        item.setTextColor(Color.WHITE);
        item.setTextSize(18);
        item.setPadding(15,20,15,20);

        item.setBackgroundColor(
                Color.rgb(20,65,105)
        );

        item.setOnClickListener(v -> {

            search.setText(word);
            search.setSelection(
                    search.length()
            );

            result.setText(
                    "🇬🇧 "+word+
                    "\n\n🇹🇯 "+
                    dictionary.get(word)
            );

            list.removeAllViews();
        });

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1, -2);

        params.setMargins(0,0,0,8);

        list.addView(item,params);
    }

    void add(String en,String tj){
        dictionary.put(en.toLowerCase(),tj);
    }

    void createDictionary(){

        add("hello","салом");
        add("hi","салом");
        add("goodbye","хайр");
        add("thanks","раҳмат");
        add("please","лутфан");
        add("yes","ҳа");
        add("no","не");

        add("father","падар");
        add("mother","модар");
        add("brother","бародар");
        add("sister","хоҳар");
        add("family","оила");
        add("friend","дӯст");
        add("boy","писар");
        add("girl","духтар");
        add("child","кӯдак");
        add("man","мард");
        add("woman","зан");

        add("school","мактаб");
        add("teacher","муаллим");
        add("student","хонанда");
        add("book","китоб");
        add("pen","қалам");
        add("lesson","дарс");
        add("class","синф");
        add("exam","имтиҳон");
        add("question","савол");
        add("answer","ҷавоб");

        add("house","хона");
        add("room","ҳуҷра");
        add("door","дар");
        add("window","тиреза");
        add("table","миз");
        add("chair","курсӣ");
        add("bed","кат");
        add("car","мошин");
        add("road","роҳ");
        add("city","шаҳр");

        add("water","об");
        add("bread","нон");
        add("milk","шир");
        add("tea","чой");
        add("coffee","қаҳва");
        add("rice","биринҷ");
        add("meat","гӯшт");
        add("egg","тухм");
        add("apple","себ");
        add("banana","банан");

        add("eat","хӯрдан");
        add("drink","нӯшидан");
        add("go","рафтан");
        add("come","омадан");
        add("see","дидан");
        add("hear","шунидан");
        add("speak","сухан гуфтан");
        add("read","хондан");
        add("write","навиштан");
        add("learn","омӯхтан");
        add("work","кор кардан");
        add("play","бозӣ кардан");
        add("run","давидан");
        add("walk","роҳ рафтан");
        add("sleep","хобидан");
        add("help","ёрӣ додан");

        add("good","хуб");
        add("bad","бад");
        add("big","калон");
        add("small","хурд");
        add("new","нав");
        add("old","кӯҳна");
        add("beautiful","зебо");
        add("happy","хушбахт");
        add("sad","ғамгин");
        add("fast","тез");
        add("slow","оҳиста");
        add("hot","гарм");
        add("cold","сард");
        add("easy","осон");
        add("difficult","душвор");

        add("red","сурх");
        add("blue","кабуд");
        add("green","сабз");
        add("yellow","зард");
        add("black","сиёҳ");
        add("white","сафед");
        add("orange","норанҷӣ");
        add("purple","бунафш");
        add("brown","қаҳваранг");
        add("pink","гулобӣ");

        add("one","як");
        add("two","ду");
        add("three","се");
        add("four","чор");
        add("five","панҷ");
        add("six","шаш");
        add("seven","ҳафт");
        add("eight","ҳашт");
        add("nine","нӯҳ");
        add("ten","даҳ");
        add("twenty","бист");
        add("hundred","сад");
        add("thousand","ҳазор");

        add("day","рӯз");
        add("night","шаб");
        add("morning","субҳ");
        add("evening","шом");
        add("today","имрӯз");
        add("tomorrow","фардо");
        add("yesterday","дирӯз");
        add("week","ҳафта");
        add("month","моҳ");
        add("year","сол");

        add("computer","компютер");
        add("phone","телефон");
        add("internet","интернет");
        add("website","сомона");
        add("program","барнома");
        add("code","код");
        add("file","файл");
        add("screen","экран");
        add("camera","камера");
        add("photo","акс");
        add("video","видео");
        add("music","мусиқӣ");
        add("game","бозӣ");

        add("money","пул");
        add("bank","бонк");
        add("market","бозор");
        add("shop","мағоза");
        add("price","нарх");
        add("buy","харидан");
        add("sell","фурӯхтан");
        add("pay","пардохт кардан");

        add("love","дӯст доштан");
        add("like","писандидан");
        add("want","хостан");
        add("need","лозим доштан");
        add("know","донистан");
        add("think","фикр кардан");
        add("understand","фаҳмидан");
        add("remember","ба ёд овардан");
        add("forget","фаромӯш кардан");

        add("world","ҷаҳон");
        add("country","кишвар");
        add("language","забон");
        add("English","англисӣ");
        add("Tajik","тоҷикӣ");
        add("Russian","русӣ");
        add("people","мардум");
        add("place","ҷой");
        add("life","ҳаёт");
        add("time","вақт");

        // Калимаҳои иловагӣ
        add("about","дар бораи");
        add("above","боло");
        add("after","баъд");
        add("again","дубора");
        add("always","ҳамеша");
        add("animal","ҳайвон");
        add("area","минтақа");
        add("around","дар атроф");
        add("away","дур");
        add("back","қафо");
        add("before","пеш аз");
        add("behind","дар паси");
        add("believe","бовар кардан");
        add("between","байни");
        add("bird","парранда");
        add("body","бадан");
        add("box","қуттӣ");
        add("bring","овардан");
        add("build","сохтан");
        add("call","занидан");
        add("care","ғамхорӣ");
        add("change","тағйир додан");
        add("clean","тоза");
        add("close","бастан");
        add("continue","идома додан");
        add("cook","пухтан");
        add("create","эҷод кардан");
        add("cry","гиря кардан");
        add("cut","буридан");
        add("dark","торик");
        add("daughter","духтар");
        add("decide","қарор кардан");
        add("different","гуногун");
        add("dog","саг");
        add("draw","кашидан");
        add("dream","хоб");
        add("drive","рондан");
        add("early","барвақт");
        add("enjoy","лаззат бурдан");
        add("example","мисол");
        add("eye","чашм");
        add("face","рӯй");
        add("fact","далел");
        add("far","дур");
        add("feel","ҳис кардан");
        add("find","ёфтан");
        add("fire","оташ");
        add("fish","моҳӣ");
        add("flower","гул");
        add("food","хӯрок");
        add("foot","пой");
        add("free","озод");
        add("full","пур");
        add("garden","боғ");
        add("give","додан");
        add("great","олӣ");
        add("grow","калон шудан");
        add("hand","даст");
        add("head","сар");
        add("heart","дил");
        add("high","баланд");
        add("home","хона");
        add("hope","умед");
        add("hour","соат");
        add("important","муҳим");
        add("interest","шавқ");
        add("job","кор");
        add("key","калид");
        add("kind","меҳрубон");
        add("large","калон");
        add("last","охирин");
        add("late","дер");
        add("left","чап");
        add("letter","ҳарф");
        add("light","рӯшноӣ");
        add("line","хат");
        add("little","хурд");
        add("long","дароз");
        add("look","нигоҳ кардан");
        add("lose","гум кардан");
        add("low","паст");
        add("make","сохтан");
        add("many","бисёр");
        add("meet","вохӯрдан");
        add("more","бештар");
        add("move","ҳаракат кардан");
        add("name","ном");
        add("near","наздик");
        add("never","ҳеҷ гоҳ");
        add("next","оянда");
        add("open","кушодан");
        add("order","фармоиш");
        add("other","дигар");
        add("page","саҳифа");
        add("paper","коғаз");
        add("part","қисм");
        add("plan","нақша");
        add("point","нуқта");
        add("problem","мушкилӣ");
        add("quick","тез");
        add("rain","борон");
        add("ready","тайёр");
        add("reason","сабаб");
        add("right","рост");
        add("river","дарё");
        add("same","ҳамон");
        add("sea","баҳр");
        add("show","нишон додан");
        add("side","тараф");
        add("snow","барф");
        add("soon","ба зудӣ");
        add("start","оғоз кардан");
        add("stay","мондан");
        add("stop","истодан");
        add("strong","қавӣ");
        add("summer","тобистон");
        add("sun","офтоб");
        add("sure","мутмаин");
        add("take","гирифтан");
        add("talk","суҳбат кардан");
        add("teach","омӯзондан");
        add("team","даста");
        add("tell","гуфтан");
        add("thing","чиз");
        add("three","се");
        add("tree","дарахт");
        add("try","кӯшиш кардан");
        add("use","истифода бурдан");
        add("very","хеле");
        add("voice","овоз");
        add("wait","интизор шудан");
        add("watch","тамошо кардан");
        add("way","роҳ");
        add("week","ҳафта");
        add("well","хуб");
        add("what","чӣ");
        add("when","кай");
        add("where","куҷо");
        add("which","кадом");
        add("who","кӣ");
        add("why","чаро");
        add("winter","зимистон");
        add("woman","зан");
        add("word","калима");
        add("write","навиштан");
        add("young","ҷавон");
    }
            }
