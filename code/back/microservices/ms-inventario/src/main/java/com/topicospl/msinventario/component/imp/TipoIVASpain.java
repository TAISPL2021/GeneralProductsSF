package com.topicospl.msinventario.component.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.topicospl.msinventario.component.ITipoIVA;

@Component
@Qualifier("spain")
public class TipoIVASpain implements ITipoIVA {

    @Override
    public double calcular(double importe) {
        // TODO Auto-generated method stub
        return importe *1.25;
    }

}