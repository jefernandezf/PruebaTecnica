package com.prueba.fernandez.tipo.cambio.service;

import com.prueba.fernandez.tipo.cambio.model.TipoCambio;
import com.prueba.fernandez.tipo.cambio.model.TipoCambioRequest;
import com.prueba.fernandez.tipo.cambio.model.TipoCambioResponse;
import com.prueba.fernandez.tipo.cambio.repository.TipoCambioRepository;
import com.prueba.fernandez.tipo.cambio.util.Constante;
import com.prueba.fernandez.tipo.cambio.util.ExceptionMessagesEnum;
import com.prueba.fernandez.tipo.cambio.util.IncorrectOrderRequestException;
import com.prueba.fernandez.tipo.cambio.util.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class TipoCambioService {

    @Autowired
    TipoCambioRepository tipoCambioRepository;

    DecimalFormat df = new DecimalFormat("#.00");

    public TipoCambio save(TipoCambio tipoCambio) {
        return tipoCambioRepository.saveAndFlush(tipoCambio);
    }


    public TipoCambioResponse convert(TipoCambioRequest tipoCambioRequest) {
        double monto = 0.0;
        Long id = tipoCambioRepository.buscarId(tipoCambioRequest.getOrigen(), tipoCambioRequest.getDestino());
        if (id == null ) {
            throw new IncorrectOrderRequestException(ExceptionMessagesEnum.INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
        }
        Optional<TipoCambio> tipoCambio = tipoCambioRepository.findById(id);
        TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
        if (tipoCambio.isPresent()) {
            TipoCambio tipCambio = tipoCambio.get();
            if (tipCambio.getSigno().equals(Constante.multiplicacion)) {
                monto = tipoCambioRequest.getMonto() * tipCambio.getValor();
            } else {
                monto = tipoCambioRequest.getMonto() / tipCambio.getValor();
            }
            tipoCambioResponse.setMonedaOrigen(tipCambio.getMonedaOrigen());
            tipoCambioResponse.setMonedaDestino(tipCambio.getMonedaDestino());
            tipoCambioResponse.setTipoCambio(tipCambio.getValor());
            tipoCambioResponse.setMonto(tipoCambioRequest.getMonto());
            tipoCambioResponse.setValor(Double.parseDouble(df.format(monto)));
        }
        return tipoCambioResponse;
    }

    public Optional<TipoCambio> findById(long id) {
        return tipoCambioRepository.findById(id);
    }
}
