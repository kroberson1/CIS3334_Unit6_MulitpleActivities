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
    Double num1;
    Double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewData = (TextView) findViewById(R.id.textViewData);

        Bundle extras = getIntent().getExtras();
        num1 = extras.getDouble("MainNumber1");
        num2 = extras.getDouble("MainNumber2");
        textViewData.setText("Width is : " + num1 + " And the Length is " + num2 + " and the flooring needs to be " + num1 * num2);
        setupReturnButton();

    }

    private void setupReturnButton() {
        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Return button clicked");   // log button click for debugging using "CIS 3334" tag
                Intent intent = new Intent();
                intent.putExtra("NewName", num1 +"@css.edu");
                intent.putExtra("NewNum", num2 * 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}