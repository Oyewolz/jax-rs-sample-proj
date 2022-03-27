package com.example.jax_rs_javaee.pojo;

import com.example.jax_rs_javaee.entity.Message;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author toyewole
 */
@Getter
@Setter
public class MessageResponse extends Response{
    private List<Message>  messages;
}
