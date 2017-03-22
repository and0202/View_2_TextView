package sz6636.view_2_textview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sz6636.view_2_textview.view.LincolnTextView;

public class MainActivity extends AppCompatActivity {
    private LincolnTextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextView();
    }


    public void initTextView(){
        textView = (LincolnTextView) findViewById(R.id.lincolnTextView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("BBBB");
                textView.setTextSize(20);
            }
        });
    }
}
