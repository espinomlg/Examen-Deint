package com.jmedinilla.offering;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.jmedinilla.offering.adapters.OffersListAdapter;
import com.jmedinilla.offering.data.OfferingList;
import com.jmedinilla.offering.models.Configuration;
import com.jmedinilla.offering.models.Offering;


/**
 * @author Andrés Espino López
Actividad que contiene la lista con las ofertas disponibles
 */
public class OfferingListActivity  extends AppCompatActivity{

    public static final byte ADD = 0;

    private TextView empty;
    private ListView list;
    private OffersListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offeringlist);

        empty = (TextView) findViewById(android.R.id.empty);
        list = (ListView) findViewById(android.R.id.list);
        adapter = new OffersListAdapter(getApplicationContext(), (Configuration)getIntent().getParcelableExtra(Configuration.CONFIG));

        list.setEmptyView(empty);
        list.setAdapter(adapter);

        registerForContextMenu(list);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.contextmenu_info) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(OfferingListActivity.this);
            dialog.setTitle(getResources().getString(R.string.dialog_title));
            dialog.setMessage(getResources().getString(R.string.dialog_message));
            dialog.setPositiveButton(getResources().getString(R.string.btn_aceptar), null);
            dialog.show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        adapter.setOrder(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void addOffer(View v){
        startActivityForResult(new Intent(OfferingListActivity.this, AddOffer.class), ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD && data != null){
            Offering offer = data.getParcelableExtra(Offering.OFFER);
            adapter.addNew(offer);
        }
    }
}
