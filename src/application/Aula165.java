package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Aula165 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		
		int i = 1;
		
		do {
			System.out.println("TAX PAYER #" + i + " DATA");
			
			System.out.print("Individual(i) or Company(c)? Press (x) to quit ");
			char ic = sc.next().charAt(0);
			
			while (ic != 'i' && ic != 'I' && ic != 'c' && ic != 'C' && ic != 'x' && ic != 'X') {
				System.out.print("Please enter valid value: ");
				ic = sc.next().charAt(0);
			}
			if (ic == 'x' || ic == 'X') {
				break;
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual income: ");
			double anualInc = sc.nextDouble();
			
			if (ic == 'i' || ic == 'I') {
				System.out.print("Health expenditures: ");
				double healthExp = sc.nextDouble();
				Individual ind = new Individual(name, anualInc, healthExp);
				list.add(ind);
			} else {
				System.out.print("Number of employees: ");
				int numEmp = sc.nextInt();
				Company com = new Company(name, anualInc, numEmp);
				list.add(com);
			}
			
			System.out.println();
			i++;
		} while (i > 0);
		
		System.out.println("\nTAXES PAID");
		
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + String.format("%.2f", tp.tax()));
		}

		double totalTaxes = 0.0;
		for (TaxPayer tp : list) {
			totalTaxes += tp.tax();
		}
		System.out.print("Total taxes: $" + String.format("%.2f", totalTaxes));
		
		sc.close();
	}

}