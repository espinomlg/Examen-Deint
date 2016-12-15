package com.jmedinilla.offering.interfaces;

/**
 * Created by usuario on 14/12/16.
 */

public interface IAddOfferPresenter {

    boolean validateData(String name, String store, String date, byte type, byte importance);
}
