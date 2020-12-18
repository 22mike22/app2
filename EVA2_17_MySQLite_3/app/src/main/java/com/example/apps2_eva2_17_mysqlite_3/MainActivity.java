package com.example.apps2_eva2_17_mysqlite_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstDatos;
    SQLiteDatabase sqlDB;
    final String NOMBRE_DB = "mi_base_datos";
    List<String> nombre = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqlDB = openOrCreateDatabase(NOMBRE_DB, MODE_PRIVATE, null);

        try{
            sqlDB.execSQL("create table mitabla(id integer primary key autoincrement," +
                    "nombre text," +
                    "apellido text);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ContentValues cvDatos = new ContentValues();
        cvDatos.put("nombre","RUBEN ALONSO");
        cvDatos.put("apellido","HERNANDEZ CHAVEZ");
        sqlDB.insert("mitabla",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","JUAN");
        cvDatos.put("apellido","PEREZ JOLOTE");
        sqlDB.insert("mitabla",null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre","PEDRO");
        cvDatos.put("apellido","PÁRAMO");
        sqlDB.insert("mitabla",null,cvDatos);
        cvDatos.clear();
        long iClave;
        cvDatos.put("nombre","JUAN");
        cvDatos.put("apellido","RULFO");
        iClave=sqlDB.insert("mitabla",null,cvDatos);
        Toast.makeText(this,iClave+"",Toast.LENGTH_LONG).show();

        //UPDATE
        cvDatos.clear();
        cvDatos.put("nombre","JUANELO");
        String[] args = {iClave+""};
        sqlDB.update("mitabla",cvDatos,"id=?",args);

        //DELETE
        String[] args2 = {"PEDRO"};
        sqlDB.delete("mitabla","nombre = ?",args2);

        String[] columns={"id","nombre","apellido"};
        String[] args3 = {"JUAN"};
        Cursor cursor = sqlDB.query("mitabla",columns,"nombre like ?",args3,null,null,"apellido");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            nombre.add(cursor.getString(cursor.getColumnIndex("id"))+" "+
                    cursor.getString(cursor.getColumnIndex("nombre"))+" "
                    +cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }
        lstDatos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombre));
    }
}
