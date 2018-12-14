/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao;

import campos.dao.impl.CampoDAOHibernateImpl;
import campos.dao.impl.EstadoCampoHibernateImpl;
import campos.dao.impl.TipoSueloDAOHibernateImpl;

/**
 * Clase Factory para la construcción de los distintos DAO de la aplicación
 * En este caso en particular, crea la única implementación de los DAO disponible
 * @author George
 */
public class DAOFactory {

    public DAOFactory() {

    }

    /**
     * Crea un CampoDAO
     * @return Implementación Hibernate de CampoDAO
     */
    public CampoDAO createCampoDAO(){
        return new CampoDAOHibernateImpl();
    }
    
    /**
     * Crea un EstadoCampoDAO
     * @return Implementación Hibernate de EstadoCampoDAO
     */
    public EstadoCampoDAO createEstadoCampoDAO(){
        return new EstadoCampoHibernateImpl();
    }
    
    /**
     * Crea un TipoSueloDAO
     * @return Implementación Hibernate de TipoSueloDAO
     */
    public TipoSueloDAO createTipoSueloDAO(){
        return new TipoSueloDAOHibernateImpl();
    }
}
