/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.controller;

import campos.dao.CampoDAO;
import campos.dao.DAOException;
import campos.dao.DAOFactory;
import campos.dao.EstadoCampoDAO;
import campos.dao.TipoSueloDAO;
import campos.model.Campo;
import campos.model.EstadoCampo;
import campos.model.Lote;
import campos.model.TipoSuelo;
import campos.view.PantallaDetalleCampo;
import campos.view.PantallaRegistrarCampo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author George
 *
 * Esta clase hace las veces de controlador para los casos de uso relacionados a
 * la gestión de los campos.
 *
 * Contiene referencias a los diferentes DAO, para la actualización de las
 * entidades que gestiona, y a las vistas que pueden ser direccionadas desde
 * este gestor
 */
public class GestorCampos {

    // DAOs necesarios para la búsqueda y actualización de las entidades
    private final TipoSueloDAO tipoSueloDAO;
    private final CampoDAO campoDAO;
    private final EstadoCampoDAO estadoCampoDAO;

    // Vista para la implementación del caso de uso "Registrar Campo"
    private final PantallaRegistrarCampo vistaRegistrarCampo;

    // Referencia al campo con el que se está trabajando en un momento dado
    private Campo campoActual = null;

    /**
     * Constructor por defecto. Instancia la implementación correcta de los
     * distintos DAO
     */
    public GestorCampos() {
        DAOFactory daoFactory = new DAOFactory();

        this.tipoSueloDAO = daoFactory.createTipoSueloDAO();
        this.campoDAO = daoFactory.createCampoDAO();
        this.estadoCampoDAO = daoFactory.createEstadoCampoDAO();
        this.vistaRegistrarCampo = new PantallaRegistrarCampo(this);
    }

    /**
     * Método de inicio de trabajo del Gestor. 
     * 
     * Para el caso de uso implementado, direcciona a la vista de 
     * Registrar Campo, lista para un campo nuevo
     */
    public void iniciar() {
        this.vistaRegistrarCampo.setVisible(true);
        this.vistaRegistrarCampo.iniciar();
    }

    /**
     * Método llamado al momento de la generación de un nuevo campo.
     * 
     * Este método puede ser llamado, tanto cuando se quiere trabajar para 
     * registrar un nuevo campo, como cuando se quiere descartar el estado
     * de un campo en creación. 
     * 
     * @throws GestorException Ante problemas de acceso a datos (Cualquier
     * implementación con la que se trabaje) o cuando la configuración de la
     * aplicacióin no es suficiente para trabajar (No existen los estados 
     * necesarios para crear un nuevo campo)
     */
    public void nuevoCampo() throws GestorException {
        try {
            /* Se busca el estado "Creado", por ser el que corresponde a un
            campo recién creado */
            Optional<EstadoCampo> creado
                    = this.estadoCampoDAO.buscarPorNombre("CREADO");
            /* Si no existe este estado, no se puede operar en la creación de
            un nuevo campo */
            if (!creado.isPresent()) {
                throw new GestorException(
                        "Problema de configuración de la aplicación\n"
                        + "(No existe el estado \"Creado\" en la base de datos)"
                );
            }
            // Se actualiza el campo actual 
            this.campoActual = new Campo(creado.get());
            /* Se registra a la vista como observador, para que pueda reaccionar
            ante los cambios del modelo*/
            this.campoActual.addObserver(vistaRegistrarCampo);
        } catch (DAOException ex) {
            throw new GestorException(
                    "No se pueden obtener los estados de campo",
                    ex
            );
        }
    }

    /**
     * Getter del Campo Actual
     * @return El campo con el que se está trabajando
     */
    public Campo getCampoActual() {
        return this.campoActual;
    }

    /**
     * Busca todos los tipos de suelo
     * @return List de TipoSuelo con todos los disponibles
     * @throws GestorException En caso de haber un problema al recuperar
     * los tipos de Suelo
     */
    public List<TipoSuelo> buscarTiposDeSuelo() throws GestorException {
        try {
            return this.tipoSueloDAO.buscarTodos();
        } catch (DAOException ex) {
            throw new GestorException(
                    "No se pueden obtener los tipos de suelo",
                    ex
            );
        }
    }

    /**
     * Comprueba si un nombre está disponible para un nuevo campo, o si el mismo
     * ya está en uso por otro campo
     * @param nombrePropuesto El nombre a comprobar
     * @return boolean true si el nombre está disponible, false si no
     * @throws GestorException Ante un problema al recuperar los campos
     */
    public boolean nombreDisponible(String nombrePropuesto) throws GestorException {
        try {
            return !this.campoDAO.buscarPorNombre(nombrePropuesto).isPresent();
        } catch (DAOException de) {
            throw new GestorException("No se puede validar el nombre", de);
        }
    }

    /**
     * Consulta al campo actual si el número de lote propuesto ya existe para
     * ese campo
     * @param numeroPropuesto
     * @return true si el número se puede utilizar, false en caso contrario
     */
    public boolean nroLoteDisponible(Integer numeroPropuesto) {
        boolean loteExistente = this.campoActual.obtenerLote(numeroPropuesto).isPresent();
        return !loteExistente;
    }

    /**
     * Agrega un Lote al campo con el que se está trabajando
     * @param nroLote Número de Lote del Lote a agregar
     * @param superficie Superficie en Hectáreas del lote
     * @param tipoSuelo Uno de los tipos de suelo existentes
     */
    public void agregarLote(Integer nroLote, Double superficie, TipoSuelo tipoSuelo) {
        Lote l = new Lote(nroLote, superficie, tipoSuelo);
        this.campoActual.agregarLote(l);
    }

    /**
     * Quita el Lote pasado por parámetro al Campo Actual
     * @param l El lote a quitar
     */
    public void quitarLote(Lote l) {
        this.campoActual.quitarLote(l);
    }

    /**
     * Almacena el Campo con el que se está trabajando
     * @param nombre El nombre del campo a registrar
     * @throws GestorException Ante inconvenientes al almacenar el nuevo campo
     */
    public void registrarCampo(String nombre) throws GestorException {
        this.campoActual.setNombre(nombre);
        try {
            this.campoDAO.guardar(this.campoActual);
        } catch (DAOException de) {
            throw new GestorException("No se  pudo guardar el Campo", de);
        }
        this.campoActual.deleteObservers();
        new PantallaDetalleCampo(vistaRegistrarCampo, campoActual).setVisible(true);
        this.vistaRegistrarCampo.iniciar();
    }

}
