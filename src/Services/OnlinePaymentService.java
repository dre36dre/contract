package Services;

public interface OnlinePaymentService {
Double paymentFee(Double amount);
double interest(double amount, int months);
}
