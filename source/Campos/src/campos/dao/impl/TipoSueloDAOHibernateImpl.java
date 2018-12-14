/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao.impl;

import campos.dao.DAOException;
import campos.dao.TipoSueloDAO;
import campos.model.TipoSuelo;
import campos.utils.HibernateUtils;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author George
 */
public class TipoSueloDAOHibernateImpl 
    implements TipoSueloDAO{

    @Override
    public List<TipoSuelo> buscarTodos() throws DAOException {
        try(Session session = HibernateUtils.openSession()){
            TypedQuery<TipoSuelo> q = session.createQuery(
                    "SELECT t FROM TipoSuelo t", 
                    TipoSuelo.class
            );
            return q.getResultList();
        }catch(PersistenceException he){
            throw new DAOException("Problema al buscar Tipos de Suelo", he);
        }
    }
    
    
    
}
