package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter the data of contract: ");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(), fmt);
        System.out.print("Value contract: ");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter the data of installment: ");
        int installment = scanner.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installment);
        System.out.println("Installments:");
        for (Installment installment1: contract.getInstallments())
            System.out.println(installment1);

       scanner.close();
    }
}
