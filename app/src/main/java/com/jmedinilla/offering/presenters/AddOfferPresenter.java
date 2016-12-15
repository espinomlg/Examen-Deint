package com.jmedinilla.offering.presenters;

import android.text.TextUtils;

import com.jmedinilla.offering.data.OfferingList;
import com.jmedinilla.offering.interfaces.IAddOfferPresenter;
import com.jmedinilla.offering.models.Offering;


/**
 * @author Andrés Espino López
Clase que válida que los datos de la nueva oferta sean válidos
 */

public class AddOfferPresenter implements IAddOfferPresenter{


    @Override
    public boolean validateData(String name, String store, String date, byte type, byte importance) {
        boolean ok = true;

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(store) || TextUtils.isEmpty(date))
            ok = false;

        if(ok){
            for(Offering offer : OfferingList.getInstance().getList()){
                if(offer.getName().compareTo(name) == 0 && type == offer.getType())
                    ok = false;
            }
        }

        return ok;
    }
}
