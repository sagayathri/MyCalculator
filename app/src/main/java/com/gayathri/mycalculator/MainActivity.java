package com.gayathri.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String result = "";
    Character op = 'q';
    float num = 0, numtemp = 0;
    TextView editText;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnadd,btnminus,
            btnmultiply,btndivide,btnsqrt,btnpower,btnpoint,btnequals,btnclear,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.edittext);
        btn0 = (Button)findViewById(R.id.zero);
        btn1 = (Button)findViewById(R.id.one);
        btn2 = (Button)findViewById(R.id.two);
        btn3 = (Button)findViewById(R.id.three);
        btn4 = (Button)findViewById(R.id.four);
        btn5 = (Button)findViewById(R.id.five);
        btn6 = (Button)findViewById(R.id.six);
        btn7 = (Button)findViewById(R.id.seven);
        btn8 = (Button)findViewById(R.id.eight);
        btn9 = (Button)findViewById(R.id.nine);
        btnadd = (Button)findViewById(R.id.badd);
        btnminus = (Button)findViewById(R.id.bminus);
        btnmultiply = (Button)findViewById(R.id.bmultiply);
        btndivide = (Button)findViewById(R.id.bdivide);
        btnsqrt = (Button)findViewById(R.id.bsqrt);
        btnpower = (Button)findViewById(R.id.bpower);
        btnpoint = (Button)findViewById(R.id.bpoint);
        btnequals = (Button)findViewById(R.id.bequals);
        btnclear = (Button)findViewById(R.id.bclear);
        btnback = (Button)findViewById(R.id.bbksp);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(0);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(3);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(4);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(5);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(6);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(7);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(9);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(0);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '+';
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '-';
            }
        });
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '*';
            }
        });
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '/';
            }
        });
        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '√';
            }
        });
        btnpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op = '^';
            }
        });
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdot();
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
            }
        });
        btnequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void insertdot() {
        result = editText.getText().toString();
        String str = result.concat(".");
        editText.setText(str);
        result = str;
    }

    private void backspace() {
        result = (String) editText.getText();
        if(result.length() > 0){
            String str = result.substring(0,result.length()-1);
            editText.setText(str);
            result = str;
        }
    }

    private void reset() {
        result = "";
        op ='q';
        num = 0;
        numtemp = 0;
        editText.setText("");
    }
    private void insert(int i) {
        result = result+String.valueOf(i);
        num = Float.parseFloat(result);
        editText.setText(result);
    }

    private void perform() {
        numtemp = num;
        result ="";
    }

    private void calculate() {
        if(op =='+')
            num = numtemp + num;
        else if(op =='-')
            num = numtemp - num;
        else if(op =='*')
            num = numtemp * num;
        else if(op =='/')
            num = numtemp / num;
        else if(op =='^')
            num = (float) Math.pow(numtemp,num);
        else if(op =='√')
            num = (float) Math.sqrt((num));

       editText.setText(""+num);
    }
}
