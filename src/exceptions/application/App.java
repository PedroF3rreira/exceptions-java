package exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.model.entities.Reservation;
import exceptions.model.exceptions.DomainExceptions;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o numero do quarto: ");
		int roomNumber = sc.nextInt();
		
		System.out.print("Digite a data de entrada(dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next()); 
		
		System.out.print("Digite a data de saída: (dd/mm/yyyy)");
		Date checkout = sdf.parse(sc.next());
		
		Reservation rev = null;
		try {
			
			rev = new Reservation(roomNumber, checkin, checkout);
			System.out.println(rev);
			
			System.out.println("--------Atualização de estadia do cliente--------");
			
			System.out.print("Digite a nova data de entrada: ");
			Date newCheckin = sdf.parse(sc.next());
			
			System.out.print("Digite a nova data de saída: ");
			Date newCheckout = sdf.parse(sc.next());
			
			System.out.println("--------Dados atualizados--------");
			
			rev.updateDates(newCheckin, newCheckout);
			System.out.println(rev);
		}
		catch(DomainExceptions e) {
			System.out.println(e.getMessage());
		}

		
		sc.close();	
	}

}
