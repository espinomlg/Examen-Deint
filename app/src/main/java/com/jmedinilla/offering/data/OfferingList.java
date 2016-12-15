package com.jmedinilla.offering.data;

import com.jmedinilla.offering.models.Offering;
import com.jmedinilla.offering.models.TypeOffer;

import java.util.ArrayList;

/**
 * @author Andrés Espino López
 * Esta clase crea el repositorio que contendrá los datos de la lista y permite acceder a él. Utiliza el patrón singleton
 */

public class OfferingList {
    private static OfferingList instance;
    private static ArrayList<Offering> list;

    private OfferingList(){
        list = new ArrayList<>();

        list.add(new Offering("ps4","MediaMark","15-12-2016", TypeOffer.TYPE_HOME, Offering.IMPORTANCE_HIGH, TypeOffer.IMG_HOME));
        list.add(new Offering("xboxOne","MediaMark","15-12-2016", TypeOffer.TYPE_HOME, Offering.IMPORTANCE_HIGH, TypeOffer.IMG_HOME));
        list.add(new Offering("TV super grande","MediaMark","15-12-2016", TypeOffer.TYPE_HOME, Offering.IMPORTANCE_HIGH, TypeOffer.IMG_HOME));
        list.add(new Offering("Iphone 7 ","IPhoneStore","26-12-2016", TypeOffer.TYPE_ELECTRONIC, Offering.IMPORTANCE_NORMAL, TypeOffer.IMG_ELECTRONIC));
        list.add(new Offering("Mp4","FNAC","25-12-2016", TypeOffer.TYPE_ELECTRONIC, Offering.IMPORTANCE_NORMAL, TypeOffer.IMG_ELECTRONIC));
        list.add(new Offering("Lavadora","El corte inglés","23-12-2016", TypeOffer.TYPE_ELECTRONIC, Offering.IMPORTANCE_NORMAL, TypeOffer.IMG_ELECTRONIC));
        list.add(new Offering("Zapatos running","Decathlón","18-12-2016", TypeOffer.TYPE_SPORT, Offering.IMPORTANCE_LOW, TypeOffer.IMG_SPORT));
        list.add(new Offering("Piés de gato","Decathlón","20-12-2016", TypeOffer.TYPE_SPORT, Offering.IMPORTANCE_LOW, TypeOffer.IMG_SPORT));
        list.add(new Offering("Pack submarinismo","Decathlón","23-12-2016", TypeOffer.TYPE_SPORT, Offering.IMPORTANCE_LOW, TypeOffer.IMG_SPORT));
        list.add(new Offering("Sofa super cómodo","MediaMark","15-12-2016", TypeOffer.TYPE_HOME, Offering.IMPORTANCE_HIGH, TypeOffer.IMG_HOME));
    }

    public static OfferingList getInstance(){
        if(instance == null)
            instance = new OfferingList();

        return instance;
    }

    public ArrayList<Offering> getList(){
        return list;
    }
}
