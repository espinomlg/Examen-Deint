package com.jmedinilla.offering.presenters;

import com.jmedinilla.offering.interfaces.IConfigurationPresenter;

/**
 * @author Andrés Espino López
Clase que válida que el usuario seleccione al menos un tipo de oferta para visualizar
 */

public class ConfigurationPresenter implements IConfigurationPresenter {


    @Override
    public boolean validateData(boolean home, boolean electronic, boolean sport) {
        boolean ok = true;

        if(!home && !electronic && !sport)
            ok = false;

        return ok;
    }
}
