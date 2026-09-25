package tj.rustam.englishtajik;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends Activity {
@Override
protected void onCreate(Bundle b) {
super.onCreate(b);
TextView t=new TextView(this);
t.setText("Salom Rustam! Build sabz shud! 700 kalima tayyor!");
t.setTextSize(24);
setContentView(t);
}
}
