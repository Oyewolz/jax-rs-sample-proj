package com.example.jax_rs_javaee.service;

import com.example.jax_rs_javaee.dataRepository.DataRepository;
import com.example.jax_rs_javaee.entity.Message;
import com.example.jax_rs_javaee.pojo.Messagepojo;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author toyewole
 */
@Stateless
@Named
public class MessageService {

    @Inject
    private DataRepository dataRepository ;

    public Message findMessage(Long id) {
        return dataRepository.findMessge(id);
    }


    public List<Message> getMessages() {
        return dataRepository.getMessages();
    }

    public boolean createMessage(Messagepojo messagepojo) {
        Message message = new Message();
        message.setValue(messagepojo.getValue());
        message.setAuthor(messagepojo.getAuthor());

        dataRepository.persist(message);
        return true;
    }
}
