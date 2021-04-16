/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = -299569408537971270L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float valor;
    private String nomeCliente;
    private String cpfCliente;
    private String cpfFuncionario;

    public Pedido(float valor, String nomeCliente, String cpfFuncionario, String cpfCliente) {
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.cpfFuncionario = cpfFuncionario;
        this.cpfCliente = cpfCliente;
    }

    public Pedido() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getcpfFuncionario() {
        return cpfFuncionario;
    }

    public void setcpfFuncionario(String nomeFuncionario) {
        this.cpfFuncionario = nomeFuncionario;
    }

    @Override
    public String toString() {
        return "Valor: " + valor + ", Nome cliente: " + nomeCliente + ", Cpf funcionário=" + cpfFuncionario + System.lineSeparator();
    }

}
