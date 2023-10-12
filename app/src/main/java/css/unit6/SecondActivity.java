package css.unit6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewData;
    Button buttonReturn;
    String name;
    Double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewData = (TextView) findViewById(R.id.textViewData);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("MainName");
        num = extras.getDouble("MainNumber");
        textViewData.setText("Name : " + name + " Number : " + num);
        setupReturnButton();

    }

    private void setupReturnButton() {
        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Return button clicked");   // log button click for debugging using "CIS 3334" tag
                Intent intent = new Intent();
                intent.putExtra("NewName", name+"@css.edu");
                intent.putExtra("NewNum", num * 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}