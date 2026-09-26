package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {

    EditText searchBox;
    TextView resultText;
    ArrayList<String[]> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // English - Tajik words
        add("hello", "салом");
        add("goodbye", "хайр");
        add("yes", "ҳа");
        add("no", "не");
        add("please", "лутфан");
        add("thanks", "раҳмат");
        add("sorry", "бахшиш");
        add("friend", "дӯст");
        add("family", "оила");
        add("mother", "модар");
        add("father", "падар");
        add("brother", "бародар");
        add("sister", "хоҳар");
        add("child", "кӯдак");
        add("boy", "писар");
        add("girl", "духтар");
        add("man", "мард");
        add("woman", "зан");
        add("name", "ном");
        add("home", "хона");
        add("school", "мактаб");
        add("teacher", "муаллим");
        add("student", "хонанда");
        add("book", "китоб");
        add("pen", "қалам");
        add("table", "миз");
        add("chair", "курсӣ");
        add("door", "дар");
        add("window", "тиреза");
        add("room", "ҳуҷра");
        add("water", "об");
        add("food", "хӯрок");
        add("bread", "нон");
        add("milk", "шир");
        add("tea", "чой");
        add("apple", "себ");
        add("orange", "афлесун");
        add("banana", "банан");
        add("grape", "ангур");
        add("car", "мошин");
        add("bus", "автобус");
        add("train", "қатора");
        add("road", "роҳ");
        add("city", "шаҳр");
        add("village", "деҳа");
        add("country", "кишвар");
        add("world", "ҷаҳон");
        add("sun", "офтоб");
        add("moon", "моҳ");
        add("star", "ситора");
        add("sky", "осмон");
        add("earth", "замин");
        add("tree", "дарахт");
        add("flower", "гул");
        add("river", "дарё");
        add("mountain", "кӯҳ");
        add("sea", "баҳр");
        add("day", "рӯз");
        add("night", "шаб");
        add("morning", "субҳ");
        add("evening", "шом");
        add("today", "имрӯз");
        add("tomorrow", "фардо");
        add("yesterday", "дирӯз");
        add("time", "вақт");
        add("year", "сол");
        add("month", "моҳ");
        add("week", "ҳафта");
        add("work", "кор");
        add("money", "пул");
        add("shop", "мағоза");
        add("market", "бозор");
        add("phone", "телефон");
        add("computer", "компютер");
        add("internet", "интернет");
        add("game", "бозӣ");
        add("music", "мусиқӣ");
        add("song", "суруд");
        add("picture", "расм");
        add("video", "видео");
        add("language", "забон");
        add("word", "калима");
        add("question", "савол");
        add("answer", "ҷавоб");
        add("good", "хуб");
        add("bad", "бад");
        add("big", "калон");
        add("small", "хурд");
        add("new", "нав");
        add("old", "кӯҳна");
        add("hot", "гарм");
        add("cold", "сард");
        add("fast", "тез");
        add("slow", "суст");
        add("beautiful", "зебо");
        add("easy", "осон");
        add("difficult", "душвор");
        add("happy", "хушҳол");
        add("sad", "ғамгин");
        add("strong", "қавӣ");
        add("weak", "заиф");
        add("clean", "тоза");
        add("dirty", "ифлос");
        add("open", "кушода");
        add("close", "пӯшидан");
        add("come", "омадан");
        add("go", "рафтан");
        add("see", "дидан");
        add("look", "нигоҳ кардан");
        add("read", "хондан");
        add("write", "навиштан");
        add("speak", "гап задан");
        add("listen", "гӯш кардан");
        add("eat", "хӯрдан");
        add("drink", "нӯшидан");
        add("sleep", "хобидан");
        add("wake", "бедор шудан");
        add("run", "давидан");
        add("walk", "роҳ рафтан");
        add("sit", "нишастан");
        add("stand", "истодан");
        add("play", "бозӣ кардан");
        add("learn", "омӯхтан");
        add("teach", "омӯзондан");
        add("know", "донистан");
        add("understand", "фаҳмидан");
        add("think", "фикр кардан");
        add("want", "хостан");
        add("need", "лозим будан");
        add("love", "дӯст доштан");
        add("like", "писанд омадан");
        add("help", "кӯмак кардан");
        add("make", "сохтан");
        add("do", "кардан");
        add("give", "додан");
        add("take", "гирифтан");
        add("find", "ёфтан");
        add("use", "истифода кардан");
        add("buy", "харидан");
        add("sell", "фурӯхтан");
        add("pay", "пардохт кардан");
        add("call", "занг задан");
        add("ask", "пурсидан");
        add("tell", "гуфтан");
        add("start", "оғоз кардан");
        add("finish", "тамом кардан");
        add("stop", "қатъ кардан");
        add("wait", "интизор шудан");
        add("live", "зиндагӣ кардан");
        add("die", "мурдан");
        add("win", "бурд кардан");
        add("lose", "бой додан");
        add("try", "кӯшиш кардан");
        add("remember", "ба ёд овардан");
        add("forget", "фаромӯш кардан");
        add("work", "кор кардан");
        add("study", "таҳсил кардан");
        add("travel", "сафар кардан");
        add("country", "кишвар");
        add("people", "мардум");
        add("person", "шахс");
        add("world", "ҷаҳон");
        add("life", "ҳаёт");
        add("school", "мактаб");
        add("class", "синф");
        add("lesson", "дарс");
        add("teacher", "муаллим");
        add("student", "хонанда");
        add("book", "китоб");
        add("page", "саҳифа");
        add("letter", "ҳарф");
        add("number", "рақам");
        add("one", "як");
        add("two", "ду");
        add("three", "се");
        add("four", "чор");
        add("five", "панҷ");
        add("six", "шаш");
        add("seven", "ҳафт");
        add("eight", "ҳашт");
        add("nine", "нуҳ");
        add("ten", "даҳ");
        add("hundred", "сад");
        add("thousand", "ҳазор");
        add("first", "якум");
        add("second", "дуюм");
        add("third", "сеюм");
        add("air", "ҳаво");
        add("animal", "ҳайвон");
        add("bird", "парранда");
add("cat", "гурба");
add("dog", "саг");
add("horse", "асп");
add("cow", "гов");
add("sheep", "гӯсфанд");
add("fish", "моҳӣ");
add("chicken", "мурғ");
add("egg", "тухм");
add("meat", "гӯшт");
add("rice", "биринҷ");
add("sugar", "шакар");
add("salt", "намак");
add("fruit", "мева");
add("vegetable", "сабзавот");
add("potato", "картошка");
add("tomato", "помидор");
add("onion", "пиёз");
add("carrot", "сабзӣ");
add("head", "сар");
add("face", "рӯй");
add("eye", "чашм");
add("ear", "гӯш");
add("nose", "бинӣ");
add("mouth", "даҳон");
add("hand", "даст");
add("finger", "ангушт");
add("leg", "пой");
add("foot", "панҷа");
add("heart", "дил");
add("body", "бадан");
add("red", "сурх");
add("blue", "кабуд");
add("green", "сабз");
add("white", "сафед");
add("black", "сиёҳ");
add("yellow", "зард");
add("brown", "қаҳваранг");
add("color", "ранг");
add("Monday", "душанбе");
add("Tuesday", "сешанбе");
add("Wednesday", "чоршанбе");
add("Thursday", "панҷшанбе");
add("Friday", "ҷумъа");
add("Saturday", "шанбе");
add("Sunday", "якшанбе");
add("January", "январ");
add("February", "феврал");
add("March", "март");
add("April", "апрел");
add("May", "май");
add("June", "июн");
add("July", "июл");
add("August", "август");
add("September", "сентябр");
add("October", "октябр");
add("November", "ноябр");
add("December", "декабр");
add("house", "хона");
add("kitchen", "ошхона");
add("bedroom", "ҳуҷраи хоб");
add("bathroom", "ҳаммом");
add("bed", "кат");
add("wall", "девор");
add("floor", "фарш");
add("roof", "бом");
add("key", "калид");
add("bag", "сумка");
add("clothes", "либос");
add("shirt", "курта");
add("shoes", "пойафзол");
add("hat", "кулоҳ");
add("doctor", "духтур");
add("hospital", "беморхона");
add("medicine", "дору");
add("health", "саломатӣ");
add("police", "полис");
add("bank", "бонк");
add("hotel", "меҳмонхона");
add("restaurant", "тарабхона");
add("airport", "фурудгоҳ");
add("station", "истгоҳ");
add("beautiful", "зебо");
add("ugly", "зишт");
add("young", "ҷавон");
add("strong", "қавӣ");
add("weak", "заиф");
add("rich", "сарватманд");
add("poor", "камбағал");
add("important", "муҳим");
add("different", "гуногун");
add("same", "якхела");
add("right", "дуруст");
add("wrong", "нодуруст");
add("true", "ҳақиқӣ");
add("false", "дурӯғ");
add("easy", "осон");
add("hard", "душвор");
add("always", "ҳамеша");
add("never", "ҳеҷ гоҳ");
add("often", "аксар вақт");
add("sometimes", "баъзан");
add("here", "ин ҷо");
add("there", "он ҷо");
add("now", "ҳозир");
add("later", "баъд");
add("before", "пеш");
add("after", "баъд аз");
add("very", "хеле");
add("more", "бештар");
add("less", "камтар");
add("again", "дубора");
     
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 30, 25, 25);

        TextView title = new TextView(this);
        title.setText("Луғати English - Тоҷикӣ");
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);

        searchBox = new EditText(this);
        searchBox.setHint("Калимаи англисиро нависед...");
        searchBox.setTextSize(18);

        Button searchButton = new Button(this);
        searchButton.setText("Ҷустуҷӯ");

        resultText = new TextView(this);
        resultText.setTextSize(21);
        resultText.setPadding(10, 30, 10, 10);

        layout.addView(title);
        layout.addView(searchBox);
        layout.addView(searchButton);
        layout.addView(resultText);

        setContentView(layout);

        searchButton.setOnClickListener(v -> searchWord());

        searchBox.setOnEditorActionListener((v, actionId, event) -> {
            searchWord();
            return true;
        });
    }

    void add(String english, String tajik) {
        words.add(new String[]{english.toLowerCase(), tajik});
    }

    void searchWord() {
        String query = searchBox.getText().toString().trim().toLowerCase();

        if (query.isEmpty()) {
            resultText.setText("Калима нависед.");
            return;
        }

        for (String[] word : words) {
            if (word[0].equals(query)) {
                resultText.setText(
                        "English: " + word[0] +
                        "\n\nТоҷикӣ: " + word[1]
                );
                return;
            }
        }

        resultText.setText("Ин калима дар луғат ёфт нашуд.");
    }
            }
