package c.detta.blank;

import android.os.Environment;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/**
 * Created by BX on 17.11.2017.
 */

public class WriteFile {
    final String FILENAME = "file";
    final String LOG_TAG = "myLogs";
    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD.txt";



    public void writeFileSD(EditText name,
                            EditText surname,
                            String phone,
                            EditText email,
                            EditText city,
                            String data,
                            EditText dog,
                            EditText col_dog,
                            EditText food) {
        // проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        // получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        // добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        // создаем каталог
        sdPath.mkdirs();
        // формируем объект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile, true));
            // пишем данные
            bw.append(name.getText().toString()+ "; "
                    + surname.getText().toString()+ "; "
                    + phone + "; "
                    + email.getText().toString() + "; "
                    + city.getText().toString() + "; "
                    + data + "; "
                    + dog.getText().toString() + "; "
                    + col_dog.getText().toString() + "; "
                    + food.getText().toString() + "; "
                    + "\n");
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
