package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
private Integer numberContract;
private Date date;
private Double totalValue; 


List<Installment> installments=new ArrayList<Installment>();

public Contract() {
	
}

public Contract(Integer numberContract, Date date, Double totalValue) {
	super();
	this.numberContract = numberContract;
	this.date = date;
	this.totalValue = totalValue;
}

public Integer getNumberContract() {
	return numberContract;
}

public Date getDate() {
	return date;
}

public Double getTotalValue() {
	return totalValue;
}

public void setNumberContract(Integer numberContract) {
	this.numberContract = numberContract;
}

public void setDate(Date date) {
	this.date = date;
}

public void setTotalValue(Double totalValue) {
	this.totalValue = totalValue;
}

public List<Installment> getInstallments() {
	return installments;
}



}//fim classe
