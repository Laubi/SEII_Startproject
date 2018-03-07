package at.laubi.palindromchecker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textInput;
    private TextView messages;
    @SuppressWarnings("FieldCanBeLocal")
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textInput = this.findViewById(R.id.tvText);
        this.btnSubmit = this.findViewById(R.id.btnCheckString);
        this.messages = this.findViewById(R.id.tvMessages);

        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPalindrome();
            }
        });
    }

    public static boolean isPalindrome(String str)	{
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    private void checkPalindrome() {
        String input = this.textInput.getText().toString();

        if(input.length() == 0) {
            setMessage("You have to input data");
        } else if(input.length() < 5) {
            setMessage("Input is to short");
        } else {
            if(isPalindrome(input)) {
                setMessage("Yes, the input is a palindrom");
            } else {
                setMessage("No, the input is not a palindrom");
            }
        }
    }

    private void setMessage(String str) {
        this.messages.setText(str);
    }
}
