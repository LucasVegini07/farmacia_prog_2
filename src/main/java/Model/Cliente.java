/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")

public class Cliente extends Pessoa {

    private float valorGasto;

    public Cliente(String nome, String cpf, float valorGasto) {

        super(nome, cpf);
        this.valorGasto = valorGasto;

    }

    public Cliente() {

    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    @Override
    public String toString() {
        String info = super.toString();
        String inforCompleta = info + " valorGasto: " + this.valorGasto + System.lineSeparator();
        return inforCompleta;
    }

}
