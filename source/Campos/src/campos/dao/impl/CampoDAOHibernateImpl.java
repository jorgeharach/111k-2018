/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao.impl;

import campos.dao.CampoDAO;
import campos.dao.DAOException;
import campos.model.Campo;
import campos.utils.HibernateUtils;
import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author George
 */
public class CampoDAOHibernateImpl
        implements CampoDAO {

    @Override
    public Optional<Campo> buscarPorNombre(String nombre) throws DAOException {
        try (Session session = HibernateUtils.openSession()) {
            TypedQuery<Campo> q = session.createQuery(
                    "SELECT c FROM Campo c WHERE LOWER(c.nombre) = LOWER(:nombre)"
            );
            q.setParameter("nombre", nombre);
            List<Campo> result = q.getResultList();
            return result.isEmpty()
                    ? Optional.empty()
                    : Optional.of(result.get(0));
        } catch (PersistenceException he) {
            throw new DAOException("Problema al buscar Campo por nombre", he);
        }
    }

    @Override
    public void guardar(Campo c) throws DAOException {

        Transaction tx = null;
        try (Session session = HibernateUtils.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(c);
            tx.commit();
        } catch (PersistenceException he) {
            if (tx != null) {
                tx.rollback();
            }
            throw new DAOException("Problema al guardar Campo", he);
        }
    }

}
