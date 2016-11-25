package shaileshrawat.mvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by shailesh.rawat on 11/22/2016.
 */

public class modipersonal extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modipersonal);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Personal Information");
        listDataHeader.add("Career and Political Info");
        listDataHeader.add("Policies");

        List<String> pinfo = new ArrayList<String>();
        pinfo.add(getString(R.string.Modiper1));
        pinfo.add(getString(R.string.Modiper2));
        pinfo.add(getString(R.string.Modiper3));
        pinfo.add(getString(R.string.Modiper4));
        pinfo.add(getString(R.string.Modiper5));
        pinfo.add(getString(R.string.Modiper6));
        pinfo.add(getString(R.string.Modiper7));


        List<String> cInfo = new ArrayList<String>();

        cInfo.add(getString(R.string.Modicar1));
        cInfo.add(getString(R.string.Modicar2));
        cInfo.add(getString(R.string.Modicar3));
        cInfo.add(getString(R.string.Modicar4));
        cInfo.add(getString(R.string.Modicar5));
        cInfo.add(getString(R.string.Modicar6));

        List<String> politicalInfo = new ArrayList<String>();
        politicalInfo.add(getString(R.string.Modipol1));
        politicalInfo.add(getString(R.string.Modipol2));
        politicalInfo.add(getString(R.string.Modipol3));
        politicalInfo.add(getString(R.string.Modipol4));
        politicalInfo.add(getString(R.string.Modipol5));

        listDataChild.put(listDataHeader.get(0), pinfo); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cInfo);
        listDataChild.put(listDataHeader.get(2), politicalInfo);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}