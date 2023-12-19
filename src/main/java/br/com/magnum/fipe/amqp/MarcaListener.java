package br.com.magnum.fipe.amqp;

import br.com.magnum.fipe.model.Marca;
import br.com.magnum.fipe.service.ConsumoApi;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcaListener {
    @Autowired
    private ConsumoApi consumo;
    private final String URL_MODELOS = "http://localhost:8080/modelos/";

    @RabbitListener(queues = "marcas.recebidas")
    public void recebeMensagem(Marca marca) {
        consumo.chamarApi(URL_MODELOS + marca.getTipoVeiculo() + "/" + marca.getCodigo().toString());
    }
}
