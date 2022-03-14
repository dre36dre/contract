package Services;

import java.util.Calendar;
import java.util.Date;

import Entities.Contract;
import Entities.Installment;

//Inversão de controle   / injeção de dependencia
 public class ContractService {

private OnlinePaymentService OnlinePaymentService;


public ContractService(OnlinePaymentService OnlinePaymentService) {
	this.OnlinePaymentService=OnlinePaymentService;
}


public void processContract(Contract contract, int month) {
	double basicQuota=contract.getTotalValue()/ month;
	
for(int i=1;i<=month;i++) {
	double updateQuota=basicQuota+OnlinePaymentService.interest(basicQuota,i);
	double fullQuota=updateQuota+OnlinePaymentService.paymentFee(updateQuota);
	Date duoDate= addMonth(contract.getDate(), i);
	contract.getInstallments().add(new Installment(duoDate, fullQuota));
}
		
	}

private Date addMonth(Date date, int N) {
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(date);
	calendar.add(Calendar.MONTH, N);
	
	
	
	return calendar.getTime();
	
}
}
