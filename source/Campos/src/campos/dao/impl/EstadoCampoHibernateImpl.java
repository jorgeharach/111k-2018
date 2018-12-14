/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao.impl;

import campos.dao.DAOException;
import campos.dao.EstadoCampoDAO;
import campos.model.EstadoCampo;
import campos.utils.HibernateUtils;
import java.util.List;
import java.util.Optional;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author George
 */
public class EstadoCampoHibernateImpl
        implements EstadoCampoDAO {

    @Override
    public Optional<EstadoCampo> buscarPorNombre(String nombre) throws DAOException {
        try (Session session = HibernateUtils.openSession()) {
            TypedQuery<EstadoCampo> q = session.createQuery(
                    "SELECT ec FROM EstadoCampo ec WHERE LOWER(ec.nombre) = LOWER(:nombre)"
            );
            q.setParameter("nombre", nombre);
            List<EstadoCampo> result = q.getResultList();
            return result.isEmpty()
                    ? Optional.empty()
                    : Optional.of(result.get(0));
        } catch (PersistenceException he) {
            throw new DAOException("Problema al buscar EstadoCampo por nombre", he);
        }
    }

}
