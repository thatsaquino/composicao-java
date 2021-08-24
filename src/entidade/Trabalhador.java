package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.Senioridade;

public class Trabalhador {
	
	//atributos básicos:
	private String nome;
	private Senioridade nivel;
	private double salarioBase;
	
	//associações
	private Departamento departamento;
	private List<HoraContrato> contrato = new ArrayList<>();
	
	public Trabalhador() {}

	public Trabalhador(String nome, Senioridade nivel, double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Senioridade getNivel() {
		return nivel;
	}

	public void setNivel(Senioridade nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContrato() {
		return contrato;
	}
	
	public void adicionaContrato(HoraContrato contrato) {
		this.contrato.add(contrato);
	}

	public void removeContrato(HoraContrato contrato) {
		this.contrato.remove(contrato);
	}
	
	public double calculo(int ano, int mes) {
		
		double soma = salarioBase;
		
		//para pegar data atual:
		Calendar cal = Calendar.getInstance();
		
		for(HoraContrato c : contrato) {
			
			//pega getData de classe HoraContrato;
			cal.setTime(c.getData());
			//pega este ano do metodo Calendar:
			int c_ano = cal.get(Calendar.YEAR);
			//pega mês do metodo Calendar(aqui soma +1 porque ele inicia no mês 0):
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}
	
	
}
