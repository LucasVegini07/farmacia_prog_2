/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 */
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Funcionario")

public class Funcionario extends Pessoa {

    private float salario;
    private int matricula;
    private String password;

    public Funcionario(float salario, int matricula, String nome, String cpf, String password) {
        super(nome, cpf);
        this.salario = salario;
        this.matricula = matricula;
        this.password = password;

    }

    public Funcionario() {
        
    }

    public float getSalario() {
        return salario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        String info = super.toString();
        String inforCompleta = info + " Salário: " + this.salario + System.lineSeparator();
        return inforCompleta;
    }

}
