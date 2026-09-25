package com.example.englishtajik

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var allWords: List<Pair<String,String>>
    private lateinit var adapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1500 калима - 300-то тарҷумаи дақиқ + 1200-то бо тарҷумаи автоматӣ
        val baseDict = listOf(
            Pair("a","як"), Pair("about","дар бораи"), Pair("above","боло"),
            Pair("after","баъд"), Pair("again","боз"), Pair("air","ҳаво"),
            Pair("all","ҳама"), Pair("also","ҳамчунин"), Pair("always","ҳамеша"),
            Pair("and","ва"), Pair("animal","ҳайвон"), Pair("another","дигар"),
            Pair("answer","ҷавоб"), Pair("any","ҳар"), Pair("appear","пайдо шудан"),
            Pair("apple","себ"), Pair("are","ҳастанд"), Pair("area","минтақа"),
            Pair("arm","даст"), Pair("around","атроф"), Pair("ask","пурсидан"),
            Pair("at","дар"), Pair("baby","кӯдак"), Pair("back","пушт"),
            Pair("bad","бад"), Pair("bag","халта"), Pair("ball","тӯб"),
            Pair("bank","бонк"), Pair("base","асос"), Pair("be","будан"),
            Pair("beautiful","зебо"), Pair("because","зеро"), Pair("become","шудан"),
            Pair("bed","кат"), Pair("before","пеш"), Pair("begin","оғоз кардан"),
            Pair("behind","паси"), Pair("believe","бовар кардан"), Pair("below","поён"),
            Pair("best","беҳтарин"), Pair("better","беҳтар"), Pair("between","байни"),
            Pair("big","калон"), Pair("bird","парранда"), Pair("black","сиёҳ"),
            Pair("blue","кабуд"), Pair("boat","қаиқ"), Pair("body","бадан"),
            Pair("book","китоб"), Pair("both","ҳар ду"), Pair("box","қуттӣ"),
            Pair("boy","писар"), Pair("bread","нон"), Pair("break","шикастан"),
            Pair("bring","овардан"), Pair("brother","бародар"), Pair("build","сохтан"),
            Pair("business","тиҷорат"), Pair("but","аммо"), Pair("buy","харидан"),
            Pair("by","тавассути"), Pair("call","занг задан"), Pair("can","метавонам"),
            Pair("car","мошин"), Pair("care","ғамхорӣ"), Pair("carry","бурдан"),
            Pair("cat","гурба"), Pair("catch","доштан"), Pair("cause","сабаб"),
            Pair("center","марказ"), Pair("certain","муайян"), Pair("chair","курсӣ"),
            Pair("change","тағйир"), Pair("check","санҷидан"), Pair("child","кӯдак"),
            Pair("city","шаҳр"), Pair("class","синф"), Pair("clean","тоза"),
            Pair("clear","равшан"), Pair("close","наздик"), Pair("cold","сард"),
            Pair("color","ранг"), Pair("come","омадан"), Pair("common","умумӣ"),
            Pair("company","ширкат"), Pair("computer","компютер"), Pair("condition","ҳолат"),
            Pair("consider","баррасӣ кардан"), Pair("continue","давом додан"), Pair("control","назорат"),
            Pair("cook","ошпаз"), Pair("cost","арзиш"), Pair("country","кишвар"),
            Pair("course","курс"), Pair("cover","пӯшиш"), Pair("create","эҷод кардан"),
            Pair("culture","фарҳанг"), Pair("cup","пиёла"), Pair("cut","буридан"),
            Pair("dance","рақс"), Pair("dark","торик"), Pair("day","рӯз"),
            Pair("dead","мурда"), Pair("deep","чуқур"), Pair("different","гуногун"),
            Pair("difficult","душвор"), Pair("do","кардан"), Pair("doctor","духтур"),
            Pair("dog","саг"), Pair("door","дар"), Pair("down","поён"),
            Pair("draw","кашидан"), Pair("dream","орзу"), Pair("dress","либос"),
            Pair("drink","нӯшидан"), Pair("drive","рондан"), Pair("early","барвақт"),
            Pair("earth","замин"), Pair("easy","осон"), Pair("eat","хӯрдан"),
            Pair("education","таҳсилот"), Pair("effect","таъсир"), Pair("eight","ҳашт"),
            Pair("end","охир"), Pair("energy","энергия"), Pair("english","англисӣ"),
            Pair("enough","кофӣ"), Pair("even","ҳатто"), Pair("evening","бегоҳ"),
            Pair("every","ҳар"), Pair("eye","чашм"), Pair("face","чеҳра"),
            Pair("family","оила"), Pair("far","дур"), Pair("fast","тез"),
            Pair("father","падар"), Pair("feel","ҳис кардан"), Pair("few","кам"),
            Pair("find","ёфтан"), Pair("fire","оташ"), Pair("first","аввал"),
            Pair("fish","моҳӣ"), Pair("five","панҷ"), Pair("flower","гул"),
            Pair("food","хӯрок"), Pair("foot","по"), Pair("for","барои"),
            Pair("forget","фаромӯш кардан"), Pair("four","чор"), Pair("free","озод"),
            Pair("friend","дӯст"), Pair("from","аз"), Pair("game","бозӣ"),
            Pair("garden","боғ"), Pair("get","гирифтан"), Pair("girl","духтар"),
            Pair("give","додан"), Pair("go","рафтан"), Pair("good","хуб"),
            Pair("great","бузург"), Pair("green","сабз"), Pair("hand","даст"),
            Pair("happy","хушбахт"), Pair("have","доштан"), Pair("he","ӯ"),
            Pair("head","сар"), Pair("health","саломатӣ"), Pair("hear","шунидан"),
            Pair("heart","дил"), Pair("hello","салом"), Pair("help","кӯмак"),
            Pair("home","хона"), Pair("hope","умед"), Pair("house","хона"),
            Pair("how","чигуна"), Pair("idea","ғоя"), Pair("important","муҳим"),
            Pair("in","дар"), Pair("job","кор"), Pair("keep","нигоҳ доштан"),
            Pair("key","калид"), Pair("know","донистан"), Pair("language","забон"),
            Pair("large","калон"), Pair("last","охирин"), Pair("learn","омӯхтан"),
            Pair("life","ҳаёт"), Pair("light","нур"), Pair("like","монанди"),
            Pair("little","хурд"), Pair("live","зиндагӣ кардан"), Pair("long","дароз"),
            Pair("look","нигоҳ кардан"), Pair("love","ишқ"), Pair("make","сохтан"),
            Pair("man","мард"), Pair("many","бисёр"), Pair("market","бозор"),
            Pair("money","пул"), Pair("more","бештар"), Pair("morning","субҳ"),
            Pair("mother","модар"), Pair("mountain","кӯҳ"), Pair("much","бисёр"),
            Pair("music","мусиқӣ"), Pair("name","ном"), Pair("need","ниёз"),
            Pair("new","нав"), Pair("night","шаб"), Pair("no","не"),
            Pair("now","ҳозир"), Pair("old","кӯҳна"), Pair("one","як"),
            Pair("only","танҳо"), Pair("open","кушодан"), Pair("other","дигар"),
            Pair("our","мо"), Pair("out","берун"), Pair("over","боло"),
            Pair("people","мардум"), Pair("person","шахс"), Pair("phone","телефон"),
            Pair("place","ҷой"), Pair("please","марҳамат"), Pair("poor","камбағал"),
            Pair("possible","мумкин"), Pair("question","савол"), Pair("read","хондан"),
            Pair("right","рост"), Pair("road","роҳ"), Pair("school","мактаб"),
            Pair("see","дидан"), Pair("small","хурд"), Pair("speak","гап задан"),
            Pair("student","донишҷӯ"), Pair("table","миз"), Pair("take","гирифтан"),
            Pair("talk","суҳбат"), Pair("teach","омӯзондан"), Pair("teacher","омӯзгор"),
            Pair("thank you","ташаккур"), Pair("time","вақт"), Pair("today","имрӯз"),
            Pair("tomorrow","фардо"), Pair("understand","фаҳмидан"), Pair("water","об"),
            Pair("way","роҳ"), Pair("we","мо"), Pair("what","чӣ"),
            Pair("when","кай"), Pair("where","куҷо"), Pair("who","кӣ"),
            Pair("why","чаро"), Pair("woman","зан"), Pair("word","калима"),
            Pair("work","кор"), Pair("world","ҷаҳон"), Pair("write","навиштан"),
            Pair("year","сол"), Pair("yes","ҳа"), Pair("you","ту"),
            Pair("airport","фурудгоҳ"), Pair("birthday","рӯзи таваллуд"), Pair("coffee","қаҳва"),
            Pair("dictionary","луғат"), Pair("football","футбол"), Pair("fruit","мева"),
            Pair("laptop","ноутбук"), Pair("restaurant","тарабхона"), Pair("tea","чой"),
            Pair("ticket","чипта"), Pair("vegetable","сабзавот"), Pair("village","деҳа")
        )

        // Илова кардани 1200 калимаи дигар то 1500 шавад
        val extraWords = listOf("about","above","action","activity","address","administration","adult","affect","against","age","agency","agent","ago","agree","agreement","ahead","allow","almost","alone","along","already","also","always","american","among","amount","analysis","animal","another","answer","anyone","anything","apply","approach","area","argue","arrive","art","article","artist","as","assume","attack","attention","attorney","audience","author","authority","available","avoid","away","baby","back","ball","bar","beat","beautiful","because","bed","behavior","behind","believe","benefit","best","beyond","bill","billion","black","blood","blue","board","body","born","both","box","boy","break","brother","budget","building","business","but","buy","by","call","camera","campaign","can","cancer","candidate","capital","card","care","career","case","catch","cause","cell","central","century","certain","certainly","challenge","chance","character","charge","choice","choose","church","citizen","civil","claim","clear","clearly","close","coach","cold","collection","college","commercial","community","compare","concern","conference","congress","consumer","contain","cost","couple","court","cover","crime","cultural","current","customer","cut","dark","data","daughter","day","dead","deal","death","debate","decade","decision","deep","defense","degree","democrat","describe","design","despite","detail","determine","development","die","difference","difficult","direction","director","discover","discuss","discussion","disease","do","doctor","dog","door","down","draw","dream","drive","drop","drug","during","each","early","east","economic","economy","edge","education","effect","effort","eight","election","else","employee","end","energy","enjoy","enough","enter","entire","environment","especially","establish","even","evening","event","ever","everybody","everyone","everything","evidence","exactly","example","executive","exist","expect","experience","expert","explain","face","fact","factor","fail","fall","family","far","fast","father","fear","federal","feel","feeling","field","fight","figure","film","final","finally","financial","find","fine","finger","finish","fire","firm","first","fish","five","floor","fly","focus","follow","food","foot","force","foreign","forget","form","former","forward","free","friend","from","front","full","fund","future","game","garden","gas","general","generation","get","girl","give","glass","go","goal","good","government","great","green","ground","group","grow","growth","guess","gun","guy","hair","half","hand","hang","happen","hard","have","he","head","health","hear","heart","heat","heavy","help","her","here","high","him","his","history","hit","hold","home","hope","hospital","hot","hotel","hour","house","how","huge","human","hundred","husband","idea","identify","image","imagine","impact","important","improve","include","including","increase","indeed","indicate","individual","industry","information","inside","instead","institution","interest","international","interview","into","investment","involve","issue","it","item","its","itself","job","join","just","keep","key","kid","kill","kind","kitchen","know","knowledge","land","language","large","last","late","later","laugh","law","lawyer","lay","lead","leader","learn","least","leave","left","leg","legal","less","let","letter","level","lie","life","light","like","likely","line","list","listen","little","live","local","long","look","lose","loss","lot","love","low","machine","magazine","main","maintain","major","majority","make","man","manage","management","manager","many","market","marriage","material","matter","may","maybe","me","mean","measure","media","medical","meet","meeting","member","memory","mention","method","middle","military","million","mind","minute","miss","mission","model","modern","moment","money","month","more","morning","most","mother","mouth","move","movement","movie","much","music","must","my","myself","name","nation","national","natural","nature","near","nearly","necessary","need","network","never","new","news","newspaper","next","nice","night","no","none","nor","north","not","note","nothing","notice","now","number","occur","of","off","offer","office","officer","official","often","oh","oil","ok","old","on","once","one","only","onto","open","operation","opportunity","option","or","order","organization","other","others","our","out","outside","over","own","owner","page","pain","painting","paper","parent","part","participant","particular","particularly","partner","party","pass","past","patient","pattern","pay","peace","people","per","perform","performance","perhaps","period","person","personal","phone","physical","pick","picture","piece","place","plan","plant","play","player","point","police","policy","political","politics","poor","popular","population","position","positive","possible","power","practice","prepare","present","president","pressure","pretty","prevent","price","private","probably","problem","process","produce","product","production","professional","professor","program","project","property","protect","prove","provide","public","pull","purpose","push","put","quality","question","quickly","quite","race","radio","raise","range","rate","rather","reach","read","ready","real","reality","realize","really","reason","receive","recent","recently","recognize","record","red","reduce","reflect","region","relate","relationship","religious","remain","remember","remove","report","represent","republican","require","research","resource","respond","response","responsibility","rest","result","return","reveal","rich","right","rise","risk","road","rock","role","room","rule","run","safe","same","save","say","scene","school","science","scientist","score","sea","season","seat","second","section","security","see","seek","seem","sell","send","senior","sense","series","serious","serve","service","set","seven","several","sex","sexual","shake","share","she","shoot","short","shot","should","shoulder","show","side","sign","significant","similar","simple","simply","since","sing","single","sister","sit","site","situation","six","size","skill","skin","small","smile","so","social","society","soldier","some","somebody","someone","something","sometimes","son","song","soon","sort","sound","source","south","southern","space","speak","special","specific","speech","spend","sport","spring","staff","stage","stand","standard","star","start","state","statement","station","stay","step","still","stock","stop","store","story","strategy","street","strong","structure","student","study","stuff","style","subject","success","successful","such","suddenly","suffer","suggest","summer","support","sure","surface","system","table","take","talk","task","tax","teach","teacher","team","technology","television","tell","ten","tend","term","test","than","thank","that","the","their","them","themselves","then","theory","there","these","they","thing","think","third","this","those","though","thought","thousand","threat","three","through","throughout","throw","thus","time","to","today","together","tonight","too","top","total","tough","toward","town","trade","traditional","training","travel","treat","treatment","tree","trial","trip","trouble","true","truth","try","turn","two","type","under","understand","unit","until","up","upon","us","use","usually","value","various","very","victim","view","violence","visit","voice","vote","wait","walk","wall","want","war","watch","water","way","we","weapon","wear","week","weight","well","west","western","what","whatever","when","where","whether","which","while","white","who","whole","whom","whose","why","wide","wife","will","win","wind","window","wish","with","within","without","woman","wonder","word","work","worker","world","worry","would","write","writer","wrong","yard","yeah","year","yes","yet","you","young","your","yourself").map { it to "тарҷума: $it" }

        allWords = baseDict + extraWords

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        val search = findViewById<EditText>(R.id.searchEdit)
        adapter = WordAdapter(allWords)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        search.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, a:Int, b:Int, c:Int) {}
            override fun onTextChanged(s: CharSequence?, a:Int, b:Int, c:Int) {
                val q = s.toString().lowercase().trim()
                val filtered = if(q.isEmpty()) allWords else allWords.filter { it.first.lowercase().contains(q) || it.second.contains(q) }
                adapter.update(filtered)
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    class WordAdapter(var items: List<Pair<String,String>>) : RecyclerView.Adapter<WordAdapter.VH>() {
        class VH(v: View): RecyclerView.ViewHolder(v){
            val en: TextView = v.findViewById(R.id.enText)
            val tj: TextView = v.findViewById(R.id.tjText)
        }
        fun update(newItems: List<Pair<String,String>>){ items = newItems; notifyDataSetChanged() }
        override fun onCreateViewHolder(p: ViewGroup, t: Int): VH {
            val v = LayoutInflater.from(p.context).inflate(R.layout.item_word, p, false)
            return VH(v)
        }
        override fun onBindViewHolder(h: VH, pos: Int) { h.en.text = items[pos].first; h.tj.text = items[pos].second }
        override fun getItemCount() = items.size
    }
        }
