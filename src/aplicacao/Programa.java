package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.Trabalhador;
import entidade.enums.Senioridade;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.print("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeFuncionario = sc.nextLine();
		
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		
		System.out.print("Salário base: ");
		Double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeFuncionario, //pega dado digitado
									Senioridade.valueOf(nivel), //pega enum e recebe dado digitado comparando com variavel constante
									salarioBase, //pega valor digitado
									new Departamento(nomeDepartamento)); //instancia o objeto departamento e aplica como argumento o que foi digitado
		
		
		
		
		sc.close();

	}

}
