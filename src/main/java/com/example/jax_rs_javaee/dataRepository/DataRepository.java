package com.example.jax_rs_javaee.dataRepository;

import com.example.jax_rs_javaee.entity.AbstractEntity;
import com.example.jax_rs_javaee.entity.Message;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author toyewole
 */
@Stateless
@Named
public class DataRepository {


    @PersistenceContext(unitName = "message")
    EntityManager entityManager;

    public List<Message> getMessages() {

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
            Root<Message> root = criteriaQuery.from(Message.class);

            criteriaQuery.select(root);

            return entityManager.createQuery(criteriaQuery).getResultList();


        } catch (Exception e) {
          //  log.error("")
        }
        return Collections.emptyList();
    }


    public <T> void persist(T object) {
        updateLastModified(object);
        entityManager.persist(object);

    }

    public <T> void update(T object) {
        updateLastModified(object);
        entityManager.merge(object);
    }

    public Message findMessge(long id) {
        return entityManager.find(Message.class, id);
    }

    private <T> void updateLastModified(T object) {
        if (object instanceof AbstractEntity) {
            ((AbstractEntity) object).setLastModified(LocalDate.now());
        }
    }


}
