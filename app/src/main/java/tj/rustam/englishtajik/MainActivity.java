package tj.rustam.englishtajik;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle b) {
super.onCreate(b);
TextView t=new TextView(this);
t.setText("Салом Рустам! Build сабз шуд!");
t.setTextSize(22);
setContentView(t);
}
}
