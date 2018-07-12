package c.detta.blank;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class Bayer extends MainActivity {
    //input
    EditText name;
    EditText surname;
    TextView cod_country;
    EditText phone_operator;
    EditText phone_1;
    EditText phone_2;
    EditText phone_3;
    EditText email;
    EditText poroda;
    EditText city;
    EditText dataDay;
    EditText dataMouth;
    EditText dataYear;
    EditText col_dog_number;
    EditText food;
    DatePicker simpleDatePicker;
    //error
    TextView errorName;
    TextView errorSurname;
    TextView errorPhone;
    TextView errorCity;
    TextView errorDate;
    TextView errorPoroda;

    //button
    Button save;

    String[] error;
    final Tools tools = new Tools();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Анкета покупателя");
        setContentView(R.layout.activity_bayer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        //initialization input
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        cod_country = findViewById(R.id.cod_country);
        phone_operator = findViewById(R.id.phone_operator);
        phone_1 = findViewById(R.id.phone1);
        phone_2 = findViewById(R.id.phone2);
        phone_3 = findViewById(R.id.phone3);
        email = findViewById(R.id.email);
        city = findViewById(R.id.autoCompleteTextViewCity);
        dataDay = findViewById(R.id.dataDay);
        dataMouth = findViewById(R.id.dataMouth);
        dataYear = findViewById(R.id.dataYear);
        poroda = findViewById(R.id.autoCompleteTextViewDog);
        food = findViewById(R.id.food);
        col_dog_number = findViewById(R.id.col_dog_number);

        //initialization error
        errorName = findViewById(R.id.errorName);
        errorSurname = findViewById(R.id.errorSurname);
        errorPhone = findViewById(R.id.errorPhone);
        errorCity = findViewById(R.id.errorCity);
        errorDate = findViewById(R.id.errorDate);
        errorPoroda = findViewById(R.id.errorPoroda);

        //initialization and create massiv error
        error = new String[6];

        //initialization button
        save = findViewById(R.id.Button_Bayer);

        // initiate the date picker and a button
        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);


        AutoCompleteTextView autoCompleteTextViewDog = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewDog);
        String[] catsDog = getResources().getStringArray(R.array.dog_names);
        List<String> catListDog = Arrays.asList(catsDog);
        ArrayAdapter<String> adapterDog = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, catListDog);
        autoCompleteTextViewDog.setAdapter(adapterDog);

        AutoCompleteTextView autoCompleteTextViewCity = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewCity);
        String[] catsCity = getResources().getStringArray(R.array.city_names);
        List<String> catListCity = Arrays.asList(catsCity);
        ArrayAdapter<String> adapterCity = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, catListCity);
        autoCompleteTextViewCity.setAdapter(adapterCity);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tools.ClearArray(error);
                tools.ClearTextError(errorName, errorSurname, errorPhone, errorCity, errorDate, errorPoroda);


                if(name.getText().length() == 0){
                    error[0] += "Введите имя";
                }
                if (surname.getText().length() == 0){
                    error[1] += "Введите фамилию";
                }
                if (phone_operator.getText().length() == 0 || phone_1.getText().length() == 0 || phone_2.getText().length() == 0 || phone_3.getText().length() == 0){
                    error[2] += "Введите телефон";
                }
                if (city.getText().length() == 0){
                    error[3] += "Введите город";
                }
                if (dataDay.getText().length() == 0 || dataMouth.getText().length() == 0 || dataYear.getText().length() == 0){
                    error[4] += "Введите дату";
                }
                if (poroda.getText().length() == 0){
                    error[5] += "Введите породу";
                }

                if (error[0] == "" && error[1] == "" && error[2] == "" && error[3] == "" && error[4] == "" && error[5] == ""){

                    String day = "Day = " + simpleDatePicker.getDayOfMonth();
                    String month = "Month = " + (simpleDatePicker.getMonth() + 1);
                    String year = "Year = " + simpleDatePicker.getYear();


                    WriteFile writeFile = new WriteFile();
                    String phone = cod_country.getText().toString() + phone_operator.getText().toString() + phone_1.getText().toString() + phone_2.getText().toString() + phone_3.getText().toString();
                    String data = dataDay.getText().toString()+"."+dataMouth.getText().toString()+"."+dataYear.getText().toString();
                    writeFile.writeFileSD(name, surname, phone, email, city, data, poroda, col_dog_number,food);
                    //System.out.print(aSwitch.getTextOn().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(Bayer.this);
                    builder.setTitle("")
                            .setMessage("Информация записана!")
                            .setCancelable(false)
                            .setNegativeButton("ОК",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                    tools.ClearEditText(name, surname, phone_operator,phone_1,phone_2,phone_3, city, dataDay, dataMouth, dataYear, poroda, col_dog_number, food);
                }else {
                    for (int i = 0; i < error.length; i++) {
                        if (i == 0) {
                            errorName.setText(error[i]);
                            //System.out.println(error[i]);
                        }
                        if (i == 1) {
                            errorSurname.setText(error[i]);
                            // System.out.println(error[i]);
                        }
                        if (i == 2) {
                            errorPhone.setText(error[i]);
                            //System.out.println(error[i]);
                        }
                        if (i == 3) {
                            errorCity.setText(error[i]);
                            //System.out.println(error[i]);
                        }
                        if (i == 4) {
                            errorDate.setText(error[i]);
                            //System.out.println(error[i]);
                        }
                        if (i == 5) {
                            errorPoroda.setText(error[i]);
                            //System.out.println(error[i]);
                        }
                    }
                }
            }
        });

    }


}
