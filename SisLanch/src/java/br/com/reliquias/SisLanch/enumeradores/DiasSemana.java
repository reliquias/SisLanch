/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.reliquias.SisLanch.enumeradores;

import br.com.reliquias.SisLanch.util.Keyable;

/**
 *
 * @author Windows Vista
 */
public enum DiasSemana implements Keyable {

    Todos("Todos os dias"),
    Domingo("Domingo"),
    Segunda("Segunda Feira"),
    Terça  ("Terça Feira"),
    Quarta ("Quarta Feira"),
    Quinta ("Quinta Feira"),
    Sexta  ("Sexta Feira"),
    Sabado ("Sabado");

    private String key;

    private DiasSemana(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
