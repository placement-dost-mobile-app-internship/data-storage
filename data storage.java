import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Load saved preferences
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");

        // Update the UI to reflect the saved preferences
        nameEditText.setText(name);
        emailEditText.setText(email);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Save user preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameEditText.getText().toString());
        editor.putString("email", emailEditText.getText().toString());
        editor.apply();

        Toast.makeText(this, "Preferences saved", Toast.LENGTH_SHORT).show();
    }
}
