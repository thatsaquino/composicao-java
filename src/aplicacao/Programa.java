package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.HoraContrato;
import entidade.Trabalhador;
import entidade.enums.Senioridade;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
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
		
		System.out.println("Quantos contratos esse trabalhador tem? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre com o contrato #" + i);
			
			System.out.print("Data (DD/MM/AAAA");
			Date dataContrato = sdf.parse(sc.next());
			
			System.out.print("Valor por hora: ");
			Double valorHora = sc.nextDouble();
			
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, horas);
			
			trabalhador.adicionaContrato(contrato);			
		}
		
		
		sc.close();

	}

}
