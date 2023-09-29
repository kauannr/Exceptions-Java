package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Numero do quarto: ");
            Integer numero = sc.nextInt();
            sc.nextLine();
            System.out.print("CheckIn: ");
            Date checkIn = formato.parse(sc.nextLine());
            System.out.print("CheckOut: ");
            Date checkOut = formato.parse(sc.nextLine());

            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println(reserva);

            System.out.println("Entre com a data de alteração da reserva");
            System.out.print("CheckIn: ");
            checkIn = formato.parse(sc.nextLine());
            System.out.print("CheckOut: ");
            checkOut = formato.parse(sc.nextLine());
            reserva.atualizarDatas(checkIn, checkOut);
        } catch (ParseException e) {

            System.out.println("Erro no formato da data");

        } catch (DomainException e) {

            e.printStackTrace();

        } catch (RuntimeException e) {
            System.out.println("Erro inesperado");
        }

        sc.close();

    }
}