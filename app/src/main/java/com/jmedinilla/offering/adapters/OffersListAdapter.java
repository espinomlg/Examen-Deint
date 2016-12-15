package com.jmedinilla.offering.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmedinilla.offering.R;
import com.jmedinilla.offering.data.OfferingList;
import com.jmedinilla.offering.models.Configuration;
import com.jmedinilla.offering.models.Offering;
import com.jmedinilla.offering.models.TypeOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Andrés Espino López
 * Adapter para la lista de las ofertas. Utiliza una copia local del repositorio para trabajar con los datos sin modificar el original.
 */
public class OffersListAdapter extends ArrayAdapter<Offering> {


    private ArrayList<Offering> list;
    private Configuration config;

    public OffersListAdapter(Context context, Configuration config) {
        super(context, R.layout.listitem_offer, new ArrayList<Offering>());
        list =  new ArrayList<>();
        this.config = config;
        setList();
        Collections.sort(list, Offering.alphabetic_order);
        clear();
        addAll(list);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OfferHolder holder = null;

        if(convertView == null){

            holder = new OfferHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_offer, parent, false);

            holder.name = (TextView) convertView.findViewById(R.id.offeritem_txv_name);
            holder.store = (TextView) convertView.findViewById(R.id.offeritem_txv_store);
            holder.date = (TextView) convertView.findViewById(R.id.offeritem_txv_date);
            holder.img = (ImageView) convertView.findViewById(R.id.offeritem_img);

            convertView.setTag(holder);

        }else
            holder = (OfferHolder) convertView.getTag();

        holder.name.setText(getItem(position).getName());
        holder.store.setText(getItem(position).getStore());
        holder.date.setText(getItem(position).getDate());
        holder.img.setImageResource(getItem(position).getImg());
        if(config.isShowImportance()){
            switch (getItem(position).getImportance()){
                case Offering.IMPORTANCE_LOW:
                    convertView.setBackgroundColor(getContext().getResources().getColor(R.color.background0));
                    break;
                case Offering.IMPORTANCE_NORMAL:
                    convertView.setBackgroundColor(getContext().getResources().getColor(R.color.background1));
                    break;
                case Offering.IMPORTANCE_HIGH:
                    convertView.setBackgroundColor(getContext().getResources().getColor(R.color.background2));
                    break;
            }
        }

        return convertView;
    }

    private void setList(){

        for(Offering offer: OfferingList.getInstance().getList()){
            if(config.isHome() && offer.getType() == TypeOffer.TYPE_HOME)
                list.add(offer);
            if(config.isElectronic() && offer.getType() == TypeOffer.TYPE_ELECTRONIC)
                list.add(offer);
            if(config.isSports() && offer.getType() == TypeOffer.TYPE_SPORT)
                list.add(offer);
        }

    }

    public void addNew(Offering offer){

        OfferingList.getInstance().getList().add(offer);
        switch (offer.getType()){
            case TypeOffer.TYPE_HOME:
                if(config.isHome()){
                    list.add(offer);
                    add(offer);
                }
                break;
            case TypeOffer.TYPE_ELECTRONIC:
                if(config.isElectronic()){
                    list.add(offer);
                    add(offer);
                }
                break;
            case TypeOffer.TYPE_SPORT:
                if(config.isSports()){
                    list.add(offer);
                    add(offer);
                }
                break;
        }


    }

    public void setOrder(int id){

        switch (id){
            case R.id.menuitem_sortAlphabetically:
                Collections.sort(list, Offering.alphabetic_order);
                clear();
                addAll(list);
                break;
            case R.id.menuitem_sortAlphabeticallyInverse:
                Collections.sort(list, Offering.alphabetic_inverse);
                clear();
                addAll(list);
                break;
            case R.id.menuitem_sortbytype:
                Collections.sort(list, Offering.type_order);
                clear();
                addAll(list);
                break;
        }
    }


    private static class OfferHolder{
        private TextView name, store, date;
        private ImageView img;
    }
}
