/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao;

import campos.model.EstadoCampo;
import java.util.Optional;

/**
 * Interfaz para los DAO referidos a la entidad EstadoCampo
 *
 * @author George
 */
public interface EstadoCampoDAO {

    /**
     * Busca un EstadoCampo por nombre
     *
     * @param nombre El nombre a buscar
     * @return Optional con el campo si se encontró, o empty en caso contrario
     * @throws DAOException Ante un problema de acceso a datos
     */
    Optional<EstadoCampo> buscarPorNombre(String nombre) throws DAOException;
}
