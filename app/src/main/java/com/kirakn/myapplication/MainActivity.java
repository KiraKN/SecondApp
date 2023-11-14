package com.kirakn.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float coat = 70;
    private int coatDiscount = 77;
    private float hat = 25;
    private int hatDiscount = 37;
    private float businessSuit = 53;
    private int businessSuitDiscount = 44;
    private float shirt = 19;
    private float shoes = 41;
    private int shoesDiscount = 32;
    private float account = 312;

    private TextView possibilityOut;
    private TextView balanceOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else {
            possibilityOut.setText("Недостаточно средств для покупки");
            balanceOut.setText("-");
        }
    }
    private float calculation() {
        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + businessSuit * (100 - businessSuitDiscount) + shoes * (100 - shoesDiscount)) / 100 + shirt;
        return count;
    }
    private boolean possibility() {
        if (calculation() <= account) {
            return true;
        } else {
            return false;
        }
    }
    private float balance() {
        if (possibility()) {
            return account - calculation();
        } else {
            return -1;
        }
    }
}