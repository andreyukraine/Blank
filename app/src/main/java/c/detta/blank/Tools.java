package c.detta.blank;

import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by BX on 04.12.2017.
 */

public class Tools {
    public void ClearEditText(EditText name,
                              EditText surname,
                              EditText phone_operator,
                              EditText phone_1,
                              EditText phone_2,
                              EditText phone_3,
                              EditText city,
                              EditText dataDay,
                              EditText dataMouth,
                              EditText dataYear,
                              EditText dog,
                              EditText col_dog,
                              EditText food){
        name.setText("");
        surname.setText("");
        phone_operator.setText("");
        phone_1.setText("");
        phone_2.setText("");
        phone_3.setText("");
        city.setText("");
        dataDay.setText("");
        dataMouth.setText("");
        dataYear.setText("");
        dog.setText("");
        col_dog.setText("");
        food.setText("");
    }
    public void ClearTextError(TextView errorName,
                               TextView errorSurname,
                               TextView errorPhone,
                               TextView errorCity,
                               TextView errorData,
                               TextView errorPoroda){
        errorName.setText("");
        errorSurname.setText("");
        errorPhone.setText("");
        errorCity.setText("");
        errorData.setText("");
        errorPoroda.setText("");
    }
    public void ClearArray(String[] mass){
        for (int i = 0; i < mass.length ; i++) {
            mass[i] = "";
        }
    }
}
