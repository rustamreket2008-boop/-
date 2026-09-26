package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {

    EditText search;
    TextView result;

    HashMap<String, String> dictionary = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDictionary();

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 30, 25, 25);

        TextView title = new TextView(this);
        title.setText("📚 ENGLISH — ТОҶИКӢ\n300 КАЛИМА");
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 10, 0, 25);

        search = new EditText(this);
        search.setHint("English калимаро навис...");
        search.setTextSize(18);

        Button button = new Button(this);
        button.setText("ҶУСТУҶӮ");

        result = new TextView(this);
        result.setTextSize(21);
        result.setTextColor(Color.BLACK);
        result.setPadding(10, 25, 10, 10);

        layout.addView(title);
        layout.addView(search);
        layout.addView(button);
        layout.addView(result);

        setContentView(layout);

        button.setOnClickListener(v -> findWord());
    }

    void findWord() {
        String word = search.getText().toString()
                .trim()
                .toLowerCase(Locale.ROOT);

        String translation = dictionary.get(word);

        if (translation != null) {
            result.setText(
                    "English: " + word +
                    "\nТоҷикӣ: " + translation
            );
        } else {
            result.setText("❌ Калима ёфт нашуд.");
        }
    }

    void createDictionary() {

        dictionary.put("hello","салом");
        dictionary.put("goodbye","хайр");
        dictionary.put("yes","ҳа");
        dictionary.put("no","не");
        dictionary.put("please","лутфан");
        dictionary.put("thanks","ташаккур");
        dictionary.put("sorry","бахшиш");
        dictionary.put("welcome","хуш омадед");
        dictionary.put("friend","дӯст");
        dictionary.put("family","оила");

        dictionary.put("mother","модар");
        dictionary.put("father","падар");
        dictionary.put("brother","бародар");
        dictionary.put("sister","хоҳар");
        dictionary.put("son","писар");
        dictionary.put("daughter","духтар");
        dictionary.put("child","кӯдак");
        dictionary.put("baby","тифл");
        dictionary.put("man","мард");
        dictionary.put("woman","зан");

        dictionary.put("boy","писар");
        dictionary.put("girl","духтар");
        dictionary.put("parent","волид");
        dictionary.put("parents","волидон");
        dictionary.put("husband","шавҳар");
        dictionary.put("wife","ҳамсар");
        dictionary.put("uncle","амак");
        dictionary.put("aunt","хола");
        dictionary.put("grandfather","бобо");
        dictionary.put("grandmother","бибӣ");

        dictionary.put("school","мактаб");
        dictionary.put("teacher","муаллим");
        dictionary.put("student","хонанда");
        dictionary.put("class","синф");
        dictionary.put("book","китоб");
        dictionary.put("pen","қалам");
        dictionary.put("pencil","қалам");
        dictionary.put("paper","коғаз");
        dictionary.put("lesson","дарс");
        dictionary.put("homework","вазифаи хонагӣ");

        dictionary.put("question","савол");
        dictionary.put("answer","ҷавоб");
        dictionary.put("exam","имтиҳон");
        dictionary.put("test","санҷиш");
        dictionary.put("subject","фан");
        dictionary.put("science","илм");
        dictionary.put("history","таърих");
        dictionary.put("geography","ҷуғрофия");
        dictionary.put("mathematics","математика");
        dictionary.put("language","забон");

        dictionary.put("word","калима");
        dictionary.put("sentence","ҷумла");
        dictionary.put("letter","ҳарф");
        dictionary.put("number","рақам");
        dictionary.put("library","китобхона");
        dictionary.put("university","донишгоҳ");
        dictionary.put("college","коллеҷ");
        dictionary.put("desk","миз");
        dictionary.put("chair","курсӣ");
        dictionary.put("board","тахта");

        dictionary.put("house","хона");
        dictionary.put("home","манзил");
        dictionary.put("room","ҳуҷра");
        dictionary.put("door","дар");
        dictionary.put("window","тиреза");
        dictionary.put("wall","девор");
        dictionary.put("floor","фарш");
        dictionary.put("roof","бом");
        dictionary.put("bed","кат");
        dictionary.put("kitchen","ошхона");

        dictionary.put("bathroom","ҳаммом");
        dictionary.put("garden","боғ");
        dictionary.put("yard","ҳавлӣ");
        dictionary.put("key","калид");
        dictionary.put("light","чароғ");
        dictionary.put("lamp","чароғ");
        dictionary.put("clock","соат");
        dictionary.put("television","телевизор");
        dictionary.put("computer","компютер");
        dictionary.put("phone","телефон");

        dictionary.put("charger","пуркунандаи барқ");
        dictionary.put("bag","сумка");
        dictionary.put("box","қуттӣ");
        dictionary.put("cup","пиёла");
        dictionary.put("glass","истакон");
        dictionary.put("plate","табақ");
        dictionary.put("spoon","қошуқ");
        dictionary.put("knife","корд");
        dictionary.put("fork","чангак");
        dictionary.put("water","об");

        dictionary.put("food","хӯрок");
        dictionary.put("bread","нон");
        dictionary.put("milk","шир");
        dictionary.put("tea","чой");
        dictionary.put("coffee","қаҳва");
        dictionary.put("sugar","шакар");
        dictionary.put("salt","намак");
        dictionary.put("meat","гӯшт");
        dictionary.put("rice","биринҷ");
        dictionary.put("soup","шӯрбо");

        dictionary.put("egg","тухм");
        dictionary.put("cheese","панир");
        dictionary.put("apple","себ");
        dictionary.put("orange","афлесун");
        dictionary.put("banana","банан");
        dictionary.put("grape","ангур");
        dictionary.put("lemon","лимӯ");
        dictionary.put("potato","картошка");
        dictionary.put("tomato","помидор");
        dictionary.put("onion","пиёз");

        dictionary.put("carrot","сабзӣ");
        dictionary.put("cucumber","бодиринг");
        dictionary.put("fruit","мева");
        dictionary.put("vegetable","сабзавот");
        dictionary.put("sun","офтоб");
        dictionary.put("moon","моҳ");
        dictionary.put("star","ситора");
        dictionary.put("sky","осмон");
        dictionary.put("cloud","абр");
        dictionary.put("rain","борон");

        dictionary.put("snow","барф");
        dictionary.put("wind","шамол");
        dictionary.put("fire","оташ");
        dictionary.put("earth","замин");
        dictionary.put("air","ҳаво");
        dictionary.put("river","дарё");
        dictionary.put("lake","кӯл");
        dictionary.put("sea","баҳр");
        dictionary.put("mountain","кӯҳ");
        dictionary.put("forest","ҷангал");

        dictionary.put("tree","дарахт");
        dictionary.put("flower","гул");
        dictionary.put("grass","алаф");
        dictionary.put("stone","санг");
        dictionary.put("world","ҷаҳон");
        dictionary.put("weather","обу ҳаво");
        dictionary.put("summer","тобистон");
        dictionary.put("winter","зимистон");
        dictionary.put("spring","баҳор");
        dictionary.put("autumn","тирамоҳ");

        dictionary.put("car","мошин");
        dictionary.put("bus","автобус");
        dictionary.put("train","қатора");
        dictionary.put("airplane","ҳавопаймо");
        dictionary.put("road","роҳ");
        dictionary.put("street","кӯча");
        dictionary.put("bicycle","велосипед");
        dictionary.put("motorcycle","мотосикл");
        dictionary.put("taxi","таксӣ");
        dictionary.put("truck","мошини боркаш");

        dictionary.put("ship","киштӣ");
        dictionary.put("boat","қаиқ");
        dictionary.put("station","истгоҳ");
        dictionary.put("airport","фурудгоҳ");
        dictionary.put("ticket","чипта");
        dictionary.put("travel","сафар");
        dictionary.put("trip","саёҳат");
        dictionary.put("driver","ронанда");
        dictionary.put("passenger","мусофир");
        dictionary.put("city","шаҳр");

        dictionary.put("village","деҳа");
        dictionary.put("country","кишвар");
        dictionary.put("capital","пойтахт");
        dictionary.put("map","харита");
        dictionary.put("hotel","меҳмонхона");
        dictionary.put("shop","мағоза");
        dictionary.put("market","бозор");
        dictionary.put("bank","бонк");
        dictionary.put("hospital","беморхона");
        dictionary.put("park","боғ");

        dictionary.put("big","калон");
        dictionary.put("small","хурд");
        dictionary.put("good","хуб");
        dictionary.put("bad","бад");
        dictionary.put("new","нав");
        dictionary.put("old","кӯҳна");
        dictionary.put("hot","гарм");
        dictionary.put("cold","сард");
        dictionary.put("fast","тез");
        dictionary.put("slow","оҳиста");

        dictionary.put("beautiful","зебо");
        dictionary.put("happy","хушбахт");
        dictionary.put("sad","ғамгин");
        dictionary.put("easy","осон");
        dictionary.put("difficult","душвор");
        dictionary.put("strong","қавӣ");
        dictionary.put("weak","заиф");
        dictionary.put("young","ҷавон");
        dictionary.put("rich","бой");
        dictionary.put("poor","камбағал");

        dictionary.put("clean","тоза");
        dictionary.put("dirty","ифлос");
        dictionary.put("long","дароз");
        dictionary.put("short","кӯтоҳ");
        dictionary.put("high","баланд");
        dictionary.put("low","паст");
        dictionary.put("right","дуруст");
        dictionary.put("wrong","нодуруст");
        dictionary.put("easy","осон");
        dictionary.put("important","муҳим");

        dictionary.put("eat","хӯрдан");
        dictionary.put("drink","нӯшидан");
        dictionary.put("go","рафтан");
        dictionary.put("come","омадан");
        dictionary.put("see","дидан");
        dictionary.put("hear","шунидан");
        dictionary.put("speak","гап задан");
        dictionary.put("read","хондан");
        dictionary.put("write","навиштан");
        dictionary.put("learn","омӯхтан");

        dictionary.put("teach","омӯзондан");
        dictionary.put("work","кор кардан");
        dictionary.put("play","бозӣ кардан");
        dictionary.put("run","давидан");
        dictionary.put("walk","роҳ рафтан");
        dictionary.put("sit","нишастан");
        dictionary.put("stand","истодан");
        dictionary.put("sleep","хобидан");
        dictionary.put("wake","бедор шудан");
        dictionary.put("open","кушодан");

        dictionary.put("close","бастан");
        dictionary.put("buy","харидан");
        dictionary.put("sell","фурӯхтан");
        dictionary.put("give","додан");
        dictionary.put("take","гирифтан");
        dictionary.put("make","сохтан");
        dictionary.put("do","кардан");
        dictionary.put("know","донистан");
        dictionary.put("think","фикр кардан");
        dictionary.put("understand","фаҳмидан");

        dictionary.put("remember","дар хотир доштан");
        dictionary.put("forget","фаромӯш кардан");
        dictionary.put("find","ёфтан");
        dictionary.put("look","нигоҳ кардан");
        dictionary.put("listen","гӯш кардан");
        dictionary.put("ask","пурсидан");
        dictionary.put("tell","гуфтан");
        dictionary.put("help","ёрӣ додан");
        dictionary.put("start","оғоз кардан");
        dictionary.put("finish","тамом кардан");

        dictionary.put("live","зиндагӣ кардан");
        dictionary.put("love","дӯст доштан");
        dictionary.put("like","писанд кардан");
        dictionary.put("want","хостан");
        dictionary.put("need","лозим доштан");
        dictionary.put("use","истифода кардан");
        dictionary.put("call","занг задан");
        dictionary.put("wait","интизор шудан");
        dictionary.put("stop","истодан");
        dictionary.put("move","ҳаракат кардан");

        dictionary.put("bring","овардан");
        dictionary.put("send","фиристодан");
        dictionary.put("receive","гирифтан");
        dictionary.put("show","нишон додан");
        dictionary.put("change","иваз кардан");
        dictionary.put("try","кӯшиш кардан");
        dictionary.put("win","ғолиб шудан");
        dictionary.put("lose","бохтан");
        dictionary.put("pay","пардохт кардан");
        dictionary.put("save","захира кардан");

        dictionary.put("draw","расм кашидан");
        dictionary.put("sing","суруд хондан");
        dictionary.put("dance","рақс кардан");
        dictionary.put("smile","табассум кардан");
        dictionary.put("laugh","хандидан");
        dictionary.put("cry","гиря кардан");
        dictionary.put("cook","пухтан");
        dictionary.put("wash","шустан");
        dictionary.put("clean","тоза кардан");
        dictionary.put("cut","буридан");

        dictionary.put("one","як");
        dictionary.put("two","ду");
        dictionary.put("three","се");
        dictionary.put("four","чор");
        dictionary.put("five","панҷ");
        dictionary.put("six","шаш");
        dictionary.put("seven","ҳафт");
        dictionary.put("eight","ҳашт");
        dictionary.put("nine","нуҳ");
        dictionary.put("ten","даҳ");

        dictionary.put("morning","субҳ");
        dictionary.put("afternoon","нисфирӯзӣ");
        dictionary.put("evening","шом");
        dictionary.put("night","шаб");
        dictionary.put("today","имрӯз");
        dictionary.put("tomorrow","фардо");
        dictionary.put("yesterday","дирӯз");
        dictionary.put("day","рӯз");
        dictionary.put("week","ҳафта");
        dictionary.put("month","моҳ");

        dictionary.put("year","сол");
        dictionary.put("time","вақт");
        dictionary.put("hour","соат");
        dictionary.put("minute","дақиқа");
        dictionary.put("second","сония");
        dictionary.put("first","якум");
        dictionary.put("secondly","дуюм");
        dictionary.put("last","охирин");
        dictionary.put("many","бисёр");
        dictionary.put("few","кам");
    }
                       }
