package com.jmedinilla.offering;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.jmedinilla.offering.interfaces.IConfigurationPresenter;
import com.jmedinilla.offering.models.Configuration;
import com.jmedinilla.offering.presenters.ConfigurationPresenter;


/**
 * @author Andrés Espino López
 * Esta clase es la primera activity de la aplicación y permite elegir que tipos de ofertas se quieren visualizar
 */
public class MainActivity extends AppCompatActivity{

    private CheckBox cbHome,
    cbElectronic,
    cbSport,
    cbImportance;

    private TextView header;

    private IConfigurationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView) findViewById(R.id.main_txv_header);
        cbHome = (CheckBox) findViewById(R.id.main_cb_hogar);
        cbSport = (CheckBox) findViewById(R.id.main_cb_deportes);
        cbElectronic = (CheckBox) findViewById(R.id.main_cb_electronica);
        cbImportance = (CheckBox) findViewById(R.id.main_cb_mostrarimportancia);

        presenter = new ConfigurationPresenter();

      //  header.setTypeface(Typeface.createFromAsset(¿?,"gloriahallelujah.ttf"));

    }

    public void accept(View v){
        if(presenter.validateData(cbHome.isChecked(), cbElectronic.isChecked(), cbSport.isChecked())){
            Intent i = new Intent(MainActivity.this, OfferingListActivity.class);
            i.putExtra(Configuration.CONFIG, new Configuration(cbHome.isChecked(), cbElectronic.isChecked(), cbSport.isChecked(), cbImportance.isChecked()));
            startActivity(i);
        }
        else
            Toast.makeText(getApplicationContext(), R.string.error_configuration, Toast.LENGTH_SHORT).show();
    }

}
