package exceptions.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.model.entities.Reservation;

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
		
		if(checkout.after(checkin)) {
			 rev = new Reservation(roomNumber, checkin, checkout);
			 System.out.println(rev);
		}
		else {
			System.out.println("Erro data de saida e menor que data de entrada");
		}
		
		sc.close();	
	}

}
