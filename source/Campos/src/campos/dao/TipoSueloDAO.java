/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao;

import campos.model.TipoSuelo;
import java.util.List;

/**
 * Interfaz para los DAO de la entidad TipoSuelo
 * @author George
 */
public interface TipoSueloDAO {
    /**
     * Recupera todos los tipos de suelo en el almacenamiento de la aplicación
     * @return List con todos los Tipos de Suelo
     * @throws DAOException Ante un problema de acceso a datos
     */
    List<TipoSuelo> buscarTodos() throws DAOException;
}
