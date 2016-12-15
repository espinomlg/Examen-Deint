package com.jmedinilla.offering;

import android.content.Intent;
import android.icu.text.DisplayContext;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.jmedinilla.offering.models.Offering;
import com.jmedinilla.offering.models.TypeOffer;
import com.jmedinilla.offering.presenters.AddOfferPresenter;

/**
 * @author Andrés Espino López
 * Esta clase es la activity que contiene los campos para crear una nueva oferta. Al pulsar el botón se validará que los datos sean validos
 */
public class AddOffer extends AppCompatActivity{

    private EditText name,store,date;
    private Spinner type, importance;
    private AddOfferPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoffer);

        presenter = new AddOfferPresenter();

        name = (EditText) findViewById(R.id.addoffer_edt_name);
        store =  (EditText) findViewById(R.id.addoffer_edt_store);
        date = (EditText) findViewById(R.id.addoffer_edt_date);
        type = (Spinner) findViewById(R.id.addoffer_spn_type);
        importance = (Spinner) findViewById(R.id.addoffer_spn_importance);

        type.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.types,
                android.R.layout.simple_spinner_dropdown_item));
        importance.setAdapter(ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.importance,
                android.R.layout.simple_spinner_dropdown_item));

    }

    public void add(View v){
        if(presenter.validateData(name.getText().toString(), store.getText().toString(), date.getText().toString(),
                (byte)type.getSelectedItemPosition(), (byte)importance.getSelectedItemPosition())){
            Intent i = new Intent();
            int img = -1;
            switch (type.getSelectedItemPosition()) {
                case TypeOffer.TYPE_HOME:
                    img = TypeOffer.IMG_HOME;
                    break;
                case TypeOffer.TYPE_ELECTRONIC:
                    img = TypeOffer.IMG_ELECTRONIC;
                    break;
                case TypeOffer.TYPE_SPORT:
                    img = TypeOffer.IMG_SPORT;
                    break;


            }
            i.putExtra(Offering.OFFER,  new Offering(name.getText().toString(), store.getText().toString(),
                    date.getText().toString(), (byte)type.getSelectedItemPosition(), (byte)importance.getSelectedItemPosition(),img));

            setResult(OfferingListActivity.ADD, i);
            finish();
        }
        else{
            AlertDialog.Builder dialog = new AlertDialog.Builder(AddOffer.this);
            dialog.setTitle(getResources().getString(R.string.dialog_title));
            dialog.setMessage(getResources().getString(R.string.dialog_error_message));
            dialog.setPositiveButton(getResources().getString(R.string.btn_aceptar), null);
            dialog.show();
        }
    }
}
