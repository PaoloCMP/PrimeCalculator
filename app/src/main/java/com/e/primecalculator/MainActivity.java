package com.e.primecalculator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonC;

    Button lBtn_isPrime, Lbtn_numbprime, Lbtn_fact,
            lBtn_Eulero, lbtn_twinprimes, lbtn_nthprimes;

    TextView Display, Result, tvName;

    List<String[]> fileData= null;

    boolean checker = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new twinPrime().execute();


        button0 = findViewById(R.id.btn_0);
        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn_7);
        button8 = findViewById(R.id.btn_8);
        button9 = findViewById(R.id.btn_9);
        buttonC = findViewById(R.id.btn_C);

        lBtn_isPrime = findViewById(R.id.lBtn_isPrime);
        Lbtn_numbprime = findViewById(R.id.Lbtn_numbprime);
        Lbtn_fact = findViewById(R.id.Lbtn_fact);
        lBtn_Eulero = findViewById(R.id.lBtn_Eulero);
        lbtn_twinprimes = findViewById(R.id.lbtn_twinprimes);
        lbtn_nthprimes = findViewById(R.id.lbtn_nthprimes);

        Display = findViewById(R.id.tvDisplay);
        Result = findViewById(R.id.tvResult);


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker){
                Display.setText(Display.getText() + "0");
            }
                else{
                    checker = true;
                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "0");
                }
        }});

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker){
                    Display.setText(Display.getText() + "1");}
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "1");}
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker){
                    Display.setText(Display.getText() + "2");}
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "2");}

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "3");
                else{
                    checker = true;


                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "3");}
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "4");
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "4");}
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "5");
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "5");}
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "6");
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "6");
            }}
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "7");
                else{
                    checker = true;

                    Display.setText("");
                    Result.setText("");
                    Display.setText(Display.getText() + "7"); }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "8");
                else{
                    checker = true;

                     Display.setText("");
                     Result.setText("");
                     Display.setText(Display.getText() + "8");}
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker)
                    Display.setText(Display.getText() + "9");
                else{

                    checker = true;

                     Display.setText("");
                     Result.setText("");
                     Display.setText(Display.getText() + "9");}
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display.setText("");
                Result.setText("");
                checker = true;

            }
        });

        lBtn_isPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checker = false;

                if (Display.getText()==""){
                    Result.setText(R.string.insNumber);
                }else{
                    if (Long.parseLong((String) Display.getText())==0){
                        Result.setText(getString(R.string.noprime));
                        return;
                    }else{

                    new isPrime().execute();

            }}


        }});

        lBtn_Eulero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = false;


                if (Display.getText()==""){
                    Result.setText(R.string.insNumber);
                }else{

                double result;
                result = Float.parseFloat((String) Display.getText());
                long i = Long.parseLong((String) Display.getText());
                for (int p = 2; p * p <= i; p++) {
                    if (i % p == 0) {
                        while (i % p == 0) {
                            i /= p;
                        }
                        result *= (1.0 - (1.0 / (float) p));


                    }
                }
                if (i > 1) {
                    result *= (1.0 - (1.0 / (float) i));
                }
                Result.setText(Long.toString((int) result));
            }
        }});

        Lbtn_fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checker = false;

                if (Display.getText()==""){
                    Result.setText(R.string.insNumber);
                }else
                {
                new Factorize().execute();
            }



        }});

        Lbtn_numbprime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = false;

                if (Display.getText() == "") {
                    Result.setText(getString(R.string.insNumber));
                } else {
                    if (Long.parseLong((String) Display.getText()) > 400800000) {
                        Result.setText(getString(R.string.bigN));
                    } else {

                        Result.setText(getString(R.string.charging));
                        new HowManyBeforeN().execute();
                    }
                }
            }
        });

        lbtn_nthprimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = false;


                if (Display.getText() == "") {
                    Result.setText(R.string.insNumber);
                } else {
                    if (Long.parseLong((String) Display.getText()) > 100099999) {
                        Result.setText(R.string.bigN);
                    } else {

                        Result.setText(R.string.charging);
                        new NthPrime().execute();
                    }
                }
            }
        });

        lbtn_twinprimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = false;

                if (Display.getText() == "") {
                    Result.setText(R.string.insNumber);
                } else {
                    if (Long.parseLong((String) Display.getText())==0){
                        Result.setText(getString(R.string.notvalid));
                    }else{
                    if (Long.parseLong((String) Display.getText()) > 440312) {
                        Result.setText(R.string.bigN);
                    } else {

                        Result.setText(R.string.charging);
                        int n = Integer.parseInt((String) Display.getText());
                        Result.setText((fileData.get(n-1))[0] +"  "+ (fileData.get(n-1))[1]);
                        //
                    }

                }
            }
        }});

    }

    public class twinPrime extends AsyncTask <Void, Void, Void>{




        @Override
        protected Void doInBackground(Void... voids) {

            try {
                InputStream is = getAssets().open("gemelli.csv");
                InputStreamReader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
                fileData = new CSVReader(reader).readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


                    }
    }


    public class isPrime extends AsyncTask<Void,Void,Void>{

        long n;
        boolean flag = false;



        @Override
        protected Void doInBackground(Void... voids) {

            for (long i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    flag = true;
                    break;
                }
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            n=Long.parseLong((String) Display.getText());
            Result.setText(R.string.charging);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (!flag) {
                Result.setText(getString(R.string.prime));
            } else
                Result.setText(getString(R.string.noprime));
        }
    }






    public class HowManyBeforeN extends AsyncTask<Void, Void, Void> {
        int n;
        int count;


        @Override
        protected Void doInBackground(Void... voids) {

           boolean [] isPrime = new boolean[n+1];
           for(int i=2; i<=n; i++){
               isPrime[i]= true;
                          }
           for (int factor = 2; factor*factor<=n; factor++){
               if (isPrime[factor]){
                   for (int j=factor; factor*j<=n; j++){
                       isPrime[factor*j]=false;
                   }
               }
           }

           for (int i=2; i<=n; i++){
               if (isPrime[i]){
                   count++;
               }
           }


            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            n = Integer.parseInt((String) Display.getText());
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Result.setText(Integer.toString(count));
        }
    }

    public class NthPrime extends AsyncTask<Void,Void,Void>{

        int n;

        int result = 0;

        public int popCount(int n2){
            n2 -= (n2 >>> 1) & 0x55555555;
            n2 = ((n2 >>> 2) & 0x33333333) + (n2 & 0x33333333);
            n2 = ((n2 >> 4) & 0x0F0F0F0F) + (n2 & 0x0F0F0F0F);
            return (n2 * 0x01010101) >> 24;
        }

        @Override
        protected Void doInBackground(Void... voids) {



                if (n<2){
                    result = 2;
                    return null;}
                if (n==2) {
                    result = 3;
                    return null;}
                if (n==3) {
                    result = 5;
                    return null;}
                int limit, root, count = 2;
                limit = (int) (n*(Math.log(n)+ Math.log(Math.log(n))))+3;
                root = (int) Math.sqrt(limit);
                switch (limit%6){
                    case 0:
                        limit = 2*(limit/6)-1;
                        break;
                    case 5:
                        limit = 2*(limit/6)+1;
                        break;
                    default:
                        limit = 2*(limit/6);

                }
                switch (root%6){
                    case 0:
                        root = 2*(root/6)-1;
                        break;
                    case 5:
                        root = 2*(root/6)+1;
                        break;
                    default:
                        root = 2*(root/6);
                }
                int dim = (limit+31)>> 5;
                int [] sieve = new int [dim];
                for (int i = 0; i<root; i++){
                    if ((sieve[i>>5] & (1<<(i&31)))==0){
                        int start, s1, s2;
                        if ((i&1)==1){
                            start= i*(3*i+8)+4;
                            s1= 4*i+5;
                            s2= 2*i+3;
                        }
                        else{
                            start=i*(3*i+10)+7;
                            s1=2*i+3;
                            s2=4*i+7;
                        }
                        for (int j=start; j<limit; j+=s2){
                            sieve[j>>5]|= 1<<(j&31);
                            j+=s1;
                            if (j>=limit)
                                break;
                            sieve[j>>5] |= 1<<(j&31);
                        }
                    }
                }
                int i;
                for (i=0; count<n; i++){
                    count += popCount(~sieve[i]);
                }
                --i;
                int mask= ~sieve[i];
                int p;
                for (p=31; count>=n; --p){
                    count-=(mask>>p)&1;
                }
                result = 3*(p+(i<<5))+7+(p&1);
            return null;
        }





        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            n = Integer.parseInt((String) Display.getText());

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Result.setText(Integer.toString(result));
        }
    }




    public class Factorize extends AsyncTask<Void, Void,Void>{
        long number ;
        String j ;

        @Override
        protected Void doInBackground(Void... voids) {
            for(long i = 2; i< number; i++) {
                while(number%i == 0) {
                    j = j + Long.toString(i)+ " ";
                    number = number/i;
                }
            }
            if(number >2) {
                j = j + Long.toString(number);
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            number = Long.parseLong((String) Display.getText());
            j = "";


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Result.setText(j);
        }


    }}
