package com.example.dictionary;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private EditText searchBox;
    private TextView resultText;
    private LinearLayout wordList;

    private final LinkedHashMap<String, String> dictionary =
            new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDictionary();
        createInterface();
    }

    private void createInterface() {

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(20, 20, 20, 20);

        TextView title = new TextView(this);
        title.setText("📚 English — Тоҷикӣ");
        title.setTextSize(27);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 10, 0, 20);

        main.addView(title);

        searchBox = new EditText(this);
        searchBox.setHint("Калимаи англисиро нависед...");
        searchBox.setTextSize(18);
        searchBox.setSingleLine(true);

        main.addView(searchBox);

        Button searchButton = new Button(this);
        searchButton.setText("🔍 Ҷустуҷӯ");
        main.addView(searchButton);

        resultText = new TextView(this);
        resultText.setText("Калимаеро ҷустуҷӯ кунед");
        resultText.setTextSize(21);
        resultText.setPadding(10, 25, 10, 25);

        main.addView(resultText);

        TextView allTitle = new TextView(this);
        allTitle.setText("Ҳамаи калимаҳо:");
        allTitle.setTextSize(20);
        allTitle.setTypeface(null, Typeface.BOLD);
        allTitle.setPadding(5, 10, 5, 10);

        main.addView(allTitle);

        ScrollView scrollView = new ScrollView(this);

        wordList = new LinearLayout(this);
        wordList.setOrientation(LinearLayout.VERTICAL);

        scrollView.addView(wordList);

        main.addView(
                scrollView,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        0,
                        1
                )
        );

        setContentView(main);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWord();
            }
        });

        searchBox.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(
                            TextView v,
                            int actionId,
                            android.view.KeyEvent event) {

                        searchWord();
                        return true;
                    }
                }
        );

        showAllWords();
    }

    private void searchWord() {

        String word = searchBox.getText()
                .toString()
                .trim()
                .toLowerCase();

        if (word.isEmpty()) {
            resultText.setText("✏️ Аввал калима нависед.");
            return;
        }

        String translation = dictionary.get(word);

        if (translation != null) {

            resultText.setText(
                    "🇬🇧 " + word +
                    "\n\n🇹🇯 " + translation
            );

        } else {

            resultText.setText(
                    "❌ Калима ёфт нашуд.\n\n" +
                    "Кӯшиш кунед калимаро дуруст нависед."
            );
        }
    }

    private void showAllWords() {

        wordList.removeAllViews();

        for (Map.Entry<String, String> entry :
                dictionary.entrySet()) {

            final String english = entry.getKey();
            final String tajik = entry.getValue();

            TextView item = new TextView(this);

            item.setText(
                    "🇬🇧 " + english +
                    "  →  🇹🇯 " + tajik
            );

            item.setTextSize(18);
            item.setPadding(12, 15, 12, 15);

            wordList.addView(item);

            item.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            searchBox.setText(english);

                            resultText.setText(
                                    "🇬🇧 " + english +
                                    "\n\n🇹🇯 " + tajik
                            );
                        }
                    }
            );
        }
    }

    private void createDictionary() {

        add("hello", "салом");
        add("goodbye", "хайр");
        add("thanks", "раҳмат");
        add("please", "лутфан");
        add("sorry", "мебахшед");
        add("yes", "ҳа");
        add("no", "не");
        add("welcome", "хуш омадед");
        add("morning", "субҳ");
        add("evening", "шом");
        add("night", "шаб");
        add("today", "имрӯз");
        add("tomorrow", "фардо");
        add("yesterday", "дирӯз");

        add("father", "падар");
        add("mother", "модар");
        add("brother", "бародар");
        add("sister", "хоҳар");
        add("family", "оила");
        add("friend", "дӯст");
        add("man", "мард");
        add("woman", "зан");
        add("boy", "писар");
        add("girl", "духтар");
        add("child", "кӯдак");
        add("person", "шахс");
        add("people", "мардум");

        add("school", "мактаб");
        add("teacher", "муаллим");
        add("student", "хонанда");
        add("book", "китоб");
        add("pen", "қалам");
        add("pencil", "қалам");
        add("lesson", "дарс");
        add("class", "синф");
        add("question", "савол");
        add("answer", "ҷавоб");
        add("word", "калима");
        add("language", "забон");

        add("house", "хона");
        add("home", "хона");
        add("room", "ҳуҷра");
        add("door", "дар");
        add("window", "тиреза");
        add("wall", "девор");
        add("floor", "фарш");
        add("table", "миз");
        add("chair", "курсӣ");
        add("bed", "кат");
        add("kitchen", "ошхона");
        add("garden", "боғ");

        add("water", "об");
        add("bread", "нон");
        add("milk", "шир");
        add("tea", "чой");
        add("coffee", "қаҳва");
        add("meat", "гӯшт");
        add("rice", "биринҷ");
        add("soup", "шӯрбо");
        add("apple", "себ");
        add("banana", "банан");
        add("orange", "афлесун");
        add("grape", "ангур");
        add("potato", "картошка");
        add("tomato", "помидор");
        add("salt", "намак");
        add("sugar", "шакар");

        add("eat", "хӯрдан");
        add("drink", "нӯшидан");
        add("go", "рафтан");
        add("come", "омадан");
        add("run", "давидан");
        add("walk", "роҳ рафтан");
        add("read", "хондан");
        add("write", "навиштан");
        add("learn", "омӯхтан");
        add("teach", "омӯзондан");
        add("work", "кор кардан");
        add("play", "бозӣ кардан");
        add("sleep", "хобидан");
        add("sit", "нишастан");
        add("stand", "истодан");
        add("open", "кушодан");
        add("close", "бастан");
        add("look", "нигоҳ кардан");
        add("listen", "гӯш кардан");
        add("speak", "гап задан");
        add("say", "гуфтан");
        add("ask", "пурсидан");
        add("answer", "ҷавоб додан");
        add("help", "ёрӣ додан");
        add("understand", "фаҳмидан");
        add("know", "донистан");
        add("think", "фикр кардан");
        add("want", "хостан");
        add("need", "лозим доштан");
        add("like", "писандидан");
        add("love", "дӯст доштан");

        add("good", "хуб");
        add("bad", "бад");
        add("big", "калон");
        add("small", "хурд");
        add("long", "дароз");
        add("short", "кӯтоҳ");
        add("new", "нав");
        add("old", "кӯҳна");
        add("young", "ҷавон");
        add("beautiful", "зебо");
        add("easy", "осон");
        add("difficult", "душвор");
        add("fast", "тез");
        add("slow", "оҳиста");
        add("hot", "гарм");
        add("cold", "хунук");
        add("happy", "хушбахт");
        add("sad", "ғамгин");
        add("strong", "қавӣ");
        add("weak", "заиф");

        add("red", "сурх");
        add("blue", "кабуд");
        add("green", "сабз");
        add("yellow", "зард");
        add("black", "сиёҳ");
        add("white", "сафед");
        add("brown", "қаҳваранг");
        add("orange", "норанҷӣ");
        add("pink", "гулобӣ");
        add("purple", "бунафш");

        add("one", "як");
        add("two", "ду");
        add("three", "се");
        add("four", "чор");
        add("five", "панҷ");
        add("six", "шаш");
        add("seven", "ҳафт");
        add("eight", "ҳашт");
        add("nine", "нӯҳ");
        add("ten", "даҳ");
        add("eleven", "ёздаҳ");
        add("twelve", "дувоздаҳ");
        add("twenty", "бист");
        add("hundred", "сад");
        add("thousand", "ҳазор");

        add("day", "рӯз");
        add("week", "ҳафта");
        add("month", "моҳ");
        add("year", "сол");
        add("time", "вақт");
        add("hour", "соат");
        add("minute", "дақиқа");
        add("second", "сония");

        add("sun", "офтоб");
        add("moon", "моҳ");
        add("star", "ситора");
        add("sky", "осмон");
        add("cloud", "абр");
        add("rain", "борон");
        add("snow", "барф");
        add("wind", "шамол");
        add("tree", "дарахт");
        add("flower", "гул");
        add("river", "дарё");
        add("mountain", "кӯҳ");
        add("sea", "баҳр");

        add("car", "мошин");
        add("bus", "автобус");
        add("train", "қатора");
        add("plane", "ҳавопаймо");
        add("road", "роҳ");
        add("street", "кӯча");
        add("city", "шаҳр");
        add("village", "деҳа");
        add("country", "кишвар");
        add("world", "ҷаҳон");

        add("phone", "телефон");
        add("computer", "компютер");
        add("internet", "интернет");
        add("program", "барнома");
        add("code", "код");
        add("file", "файл");
        add("camera", "камера");
        add("photo", "акс");
        add("video", "видео");
        add("music", "мусиқӣ");
        add("game", "бозӣ");
        add("screen", "экран");

        add("money", "пул");
        add("bank", "бонк");
        add("market", "бозор");
        add("shop", "мағоза");
        add("price", "нарх");
        add("buy", "харидан");
        add("sell", "фурӯхтан");
        add("pay", "пардохт кардан");
        add("cheap", "арзон");
        add("expensive", "қимат");

        add("head", "сар");
        add("face", "рӯй");
        add("eye", "чашм");
        add("ear", "гӯш");
        add("nose", "бинӣ");
        add("mouth", "даҳон");
        add("hand", "даст");
        add("foot", "пой");
        add("hair", "мӯй");
        add("heart", "дил");

        add("doctor", "духтур");
        add("hospital", "беморхона");
        add("medicine", "дору");
        add("health", "саломатӣ");
        add("pain", "дард");
        add("food", "хӯрок");
        add("sleep", "хоб");

        add("start", "оғоз кардан");
        add("finish", "тамом кардан");
        add("stop", "истодан");
        add("begin", "сар кардан");
        add("continue", "давом додан");
        add("change", "иваз кардан");
        add("make", "сохтан");
        add("use", "истифода бурдан");
        add("find", "ёфтан");
        add("give", "додан");
        add("take", "гирифтан");
        add("bring", "овардан");
        add("send", "фиристодан");
        add("call", "занг задан");

        add("true", "дуруст");
        add("false", "нодуруст");
        add("right", "дуруст");
        add("wrong", "хато");
        add("same", "якхела");
        add("different", "гуногун");
        add("first", "якум");
        add("last", "охирин");
        add("next", "оянда");
        add("important", "муҳим");
    }

    private void add(String english, String tajik) {
        dictionary.put(english.toLowerCase(), tajik);
    }
            }
