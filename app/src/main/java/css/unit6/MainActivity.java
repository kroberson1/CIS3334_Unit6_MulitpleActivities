package css.unit6;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextNumber;
    TextView textView;
    Button button;

    // constant to determine which sub-activity returns
    private static final int CIS3334_REQUEST_CODE = 1001;
    // Create an ActivityResultLauncher to handle the result from SecondActivity
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        textView = (TextView) findViewById(R.id.textView);
        setupButton();

        // Initialize the ActivityResultLauncher
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Log.d("CIS 3334", "Return from second activity");   // log button click for debugging using "CIS 3334" tag

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String newNameString = data.getStringExtra("NewName");
                            Log.d("CIS 3334", "NewName = "+newNameString);   // log button click for debugging using "CIS 3334" tag
                            textView.setText(newNameString);
                        }
                    }
                }
        );
    }
// editTextName IS THE WIDTH
    private void setupButton() {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the second activity
                Double num1 = Double.parseDouble( editTextName.getText().toString() );
                Double num2 = Double.parseDouble( editTextNumber.getText().toString() );
                Intent secActIntent = new Intent(MainActivity.this, SecondActivity.class);
                secActIntent.putExtra("MainNumber1", num1);
                secActIntent.putExtra("MainNumber2", num2);
                startActivity(secActIntent);
            }
        });
    }







}