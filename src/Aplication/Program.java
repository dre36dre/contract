package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contract;
import Entities.Installment;
import Services.ContractService;
import Services.OnlinePaymentService;
import Services.PaypalService;

public class Program {
public static void main(String[] args) throws ParseException {
	 
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	Locale.setDefault(Locale.US);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter contract data");
	
	System.out.print("Number: ");
	Integer number=sc.nextInt();
	
	System.out.print("Date (dd/MM/YYYY):  ");
	Date date=sdf.parse(sc.next());
	
	System.out.print("Contract value: ");
	Double totalValue= sc.nextDouble();
	
	Contract contract=new Contract(number,date, totalValue);
	
	System.out.print("Enter number instalments: ");
	int N=sc.nextInt();
	ContractService cs=new ContractService(new PaypalService());
	cs.processContract(contract, N);
	
	
	System.out.println("Instalments:");
	
	for(Installment it : contract.getInstallments()) {
		System.out.println(it);
	}
	
	
sc.close();

}
}
