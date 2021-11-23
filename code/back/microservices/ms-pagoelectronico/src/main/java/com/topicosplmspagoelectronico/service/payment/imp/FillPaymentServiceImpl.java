package com.topicosplmspagoelectronico.service.payment.imp;

import com.payu.sdk.PayU;
import com.payu.sdk.model.Currency;
import com.payu.sdk.model.Language;
import com.payu.sdk.model.PaymentCountry;
import com.topicosplmspagoelectronico.bean.ApiProperties;
import com.topicosplmspagoelectronico.bean.Payment;
import com.topicosplmspagoelectronico.service.payment.FillPaymentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FillPaymentServiceImpl implements FillPaymentService {

    @Setter(onMethod = @__(@Autowired))
    private ApiProperties apiProperties;

    @Override
    public Map<String, String> fillMap(Payment payment) {
        fillProperties();
        Map<String, String> parameters = new HashMap<>();
        fillMapTransaction(parameters, payment);
        fillMapBuyer(parameters, payment);
        fillMapPayer(parameters, payment);
        fillMapCreditCard(parameters, payment);
        return parameters;
    }

    private void fillProperties() {
        PayU.paymentsUrl = apiProperties.getPaymentsUrl();
        PayU.apiKey = apiProperties.getApiKey();
        PayU.apiLogin = apiProperties.getApiLogin();
        PayU.isTest = false;
        PayU.language = Language.es;
    }

    private Map<String, String> fillMapTransaction(Map<String, String> parameters, Payment payment) {
        //Ingrese aquí el identificador de la cuenta.
        parameters.put(PayU.PARAMETERS.ACCOUNT_ID, "" + apiProperties.getAccountId());
        //Ingrese aquí el código de referencia.
        parameters.put(PayU.PARAMETERS.REFERENCE_CODE, "" + apiProperties.getReference());
        //Ingrese aquí la descripción.
        parameters.put(PayU.PARAMETERS.DESCRIPTION, "" + apiProperties.getDescription());
        // -- Valores --
        //Ingrese aquí el valor de la transacción.
        parameters.put(PayU.PARAMETERS.VALUE, "" + payment.getPaymentValue());
        //Ingrese aquí el valor del IVA (Impuesto al Valor Agregado solo valido para Colombia) de la transacción,
        //si se envía el IVA nulo el sistema aplicará el 19% automáticamente. Puede contener dos dígitos decimales.
        //Ej: 19000.00. En caso de no tener IVA debe enviarse en 0.
        parameters.put(PayU.PARAMETERS.TAX_VALUE, "" + taxValue(payment.getPaymentValue()));
        //Ingrese aquí el valor base sobre el cual se calcula el IVA (solo valido para Colombia).
        //En caso de que no tenga IVA debe enviarse en 0.
        parameters.put(PayU.PARAMETERS.TAX_RETURN_BASE, "" + taxBase(payment.getPaymentValue()));
        //Ingrese aquí la moneda.
        parameters.put(PayU.PARAMETERS.CURRENCY, "" + Currency.COP.name());
        //Session id del device.
        parameters.put(PayU.PARAMETERS.DEVICE_SESSION_ID, "vghs6tvkcle931686k1900o6e1");
        return parameters;
    }

    private Map<String, String> fillMapBuyer(Map<String, String> parameters, Payment payment) {
        // -- Comprador --
        //Ingrese aquí el id del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_ID, String.valueOf(payment.getClient().getDni()));
        //Ingrese aquí el nombre del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_NAME, payment.getClient().getFullName());
        //Ingrese aquí el email del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_EMAIL, payment.getClient().getEmail());
        //Ingrese aquí el teléfono de contacto del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_CONTACT_PHONE, payment.getPhone());
        //Ingrese aquí el documento de contacto del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_DNI, payment.getClient().getDni());
        //Ingrese aquí la dirección del comprador.
        parameters.put(PayU.PARAMETERS.BUYER_STREET, payment.getStreet());
        parameters.put(PayU.PARAMETERS.BUYER_STREET_2, payment.getStreet2());
        parameters.put(PayU.PARAMETERS.BUYER_CITY, payment.getCity());
        parameters.put(PayU.PARAMETERS.BUYER_STATE, payment.getState());
        parameters.put(PayU.PARAMETERS.BUYER_COUNTRY, apiProperties.getCountry());
        parameters.put(PayU.PARAMETERS.BUYER_POSTAL_CODE, payment.getPostalCode());
        parameters.put(PayU.PARAMETERS.BUYER_PHONE, payment.getPhone());
        return parameters;
    }

    private Map<String, String> fillMapPayer(Map<String, String> parameters, Payment payment) {
        // -- Pagador --
        //Ingrese aquí el id del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_ID, String.valueOf(payment.getClient().getDni()));
        //Ingrese aquí el nombre del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_NAME, payment.getClient().getFullName());
        //Ingrese aquí el email del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_EMAIL, payment.getClient().getEmail());
        //Ingrese aquí el teléfono de contacto del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_CONTACT_PHONE, payment.getPhone());
        //Ingrese aquí el documento de contacto del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_DNI, payment.getClient().getDni());
        //Ingrese aquí la dirección del pagador.
        parameters.put(PayU.PARAMETERS.PAYER_STREET, payment.getStreet());
        parameters.put(PayU.PARAMETERS.PAYER_STREET_2, payment.getStreet2());
        parameters.put(PayU.PARAMETERS.PAYER_CITY, payment.getCity());
        parameters.put(PayU.PARAMETERS.PAYER_STATE, payment.getState());
        parameters.put(PayU.PARAMETERS.PAYER_COUNTRY, "CO");
        parameters.put(PayU.PARAMETERS.PAYER_POSTAL_CODE, payment.getPostalCode());
        parameters.put(PayU.PARAMETERS.PAYER_PHONE, payment.getPhone());
        return parameters;
    }

    private Map<String, String> fillMapCreditCard(Map<String, String> parameters, Payment payment) {
        // -- Datos de la tarjeta de crédito --
        //Ingrese aquí el número de la tarjeta de crédito
        parameters.put(PayU.PARAMETERS.CREDIT_CARD_NUMBER, payment.getCreditCard().getCardNumber());
        //Ingrese aquí la fecha de vencimiento de la tarjeta de crédito
        parameters.put(PayU.PARAMETERS.CREDIT_CARD_EXPIRATION_DATE, payment.getCreditCard().getExpirationDate());
        //Ingrese aquí el código de seguridad de la tarjeta de crédito
        parameters.put(PayU.PARAMETERS.CREDIT_CARD_SECURITY_CODE, payment.getCreditCard().getSecurityCode());
        //Ingrese aquí el nombre de la tarjeta de crédito
        parameters.put(PayU.PARAMETERS.PAYMENT_METHOD, payment.getCreditCard().getPaymentMethod());
        //Ingrese aquí el número de cuotas.
        parameters.put(PayU.PARAMETERS.INSTALLMENTS_NUMBER, "" + apiProperties.getInstallments());
        //Ingrese aquí el nombre del pais.
        parameters.put(PayU.PARAMETERS.COUNTRY, PaymentCountry.CO.name());
        return parameters;
    }

    private String taxValue(int value) {
        int taxValue = ((value * 19) / 119);
        return String.valueOf(taxValue);
    }

    private String taxBase(int value) {
        int taxBase = ((value * 100) / 119);
        return String.valueOf(taxBase);
    }
}
