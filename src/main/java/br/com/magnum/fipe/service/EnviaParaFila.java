package br.com.magnum.fipe.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnviaParaFila {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void envia(String topico, Object object) {
        rabbitTemplate.convertAndSend(topico, object);
    }
}
