/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.dao;

import campos.model.Campo;
import java.util.Optional;

/**
 * Interfaz para los DAO referidos a la entidad Campo
 * @author George
 */
public interface CampoDAO {
    /**
     * Busca un Campo por nombre
     * @param nombre El nombre a buscar
     * @return Optional con el campo si se encontró, o empty en caso contrario
     * @throws DAOException Ante un problema de acceso a datos
     */
    Optional<Campo> buscarPorNombre(String nombre) throws DAOException;
    /**
     * Guarda una nueva entidad Campo, o actualiza la misma
     * @param c La entidad a guardar
     * @throws DAOException Ante un problema de acceso a Datos
     */
    void guardar(Campo c) throws DAOException;
}
