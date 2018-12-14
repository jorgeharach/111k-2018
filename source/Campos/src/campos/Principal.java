/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos;

import campos.controller.GestorCampos;
import campos.utils.HibernateUtils;

/**
 *
 * @author George
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HibernateUtils.initHibernate();
        GestorCampos gc = new GestorCampos();
        gc.iniciar();
    }
    
}
