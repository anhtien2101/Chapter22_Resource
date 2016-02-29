package com.example.activity.chapter22_resourcexml;

import android.app.ListActivity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ListActivity {
    ArrayList<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            XmlResourceParser xpp = getResources().getXml(R.xml.myxml);
            String item = null;
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                int evenType = xpp.getEventType();
                switch (evenType) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        item = xpp.getText();
//                        items.add(item);
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equals("id")) {
                            Log.d("", "id: " + item);
                        } else if (tagName.equals("word")) {
                            items.add(item);
                        }
                }
                xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(MainActivity.this, items.get(position), Toast.LENGTH_SHORT).show();
    }
}
