package com.example.wilinux.proyectow;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Contacts;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Txt1;
    private String contactId;
    private static Cursor contactsCursor;

    //String projection []=
            //{
                //Data._ID,
                //Data.MIMETYPE,
                //Data.DATA1,
                //Data.DATA2,
                //Data.DATA3,
                //Data.DATA4,
                //Data.DATA5,
                //Data.DATA6,
                //Data.DATA7,
                //Data.DATA8,
                //Data.DATA9,
                //Data.DATA10,
                //Data.DATA11,
                //Data.DATA12,
                //Data.DATA13,
                //Data.DATA14,
                //Data.DATA15
            //};

    //String selectionClause = Contacts.LOOKUP_KEY+" = ? ";
    //String selectionArgs[] = new String[]{ contactId };
    //String sortOrder = Data.MIMETYPE;

    String[] projection =
            {
                    Phone._ID,
                    Phone.NUMBER,
                    Phone.NAME_RAW_CONTACT_ID
            };

    String selectionClause =
            Data.LOOKUP_KEY + " = ?" +
                    " AND " +
                    Data.MIMETYPE + " = " +
                    "'" + Phone.CONTENT_ITEM_TYPE + "'";

    String[] selectionArgs = { contactId };

    String sortOrder = Phone.TYPE + " DESC ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsCursor = getContentResolver().query(
                Contacts.CONTENT_URI,   // URI de contenido para los contactos
                projection,                        // Columnas a seleccionar
                selectionClause,                  // Condición del WHERE
                selectionArgs,                     // Valores de la condición
                sortOrder);                        // ORDER BY columna [ASC|DESC]

    }
}
