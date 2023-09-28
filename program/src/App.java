import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero do quarto: ");
        Integer numero = sc.nextInt();
        sc.nextLine();
        System.out.print("CheckIn: ");
        Date checkIn = formato.parse(sc.nextLine());
        System.out.print("CheckOut: ");
        Date checkOut = formato.parse(sc.nextLine());
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro. Data de checkOut tem que ser posterior a data de checkIn");

        } else {
            Reserva reserva = new Reserva(numero, checkIn, checkOut);
            System.out.println(reserva);

            System.out.println("Entre com a data de alteração da reserva");
            System.out.print("CheckIn: ");
            checkIn = formato.parse(sc.nextLine());
            System.out.print("CheckOut: ");
            checkOut = formato.parse(sc.nextLine());
            String erro = reserva.atualizarDatas(checkIn, checkOut);

            if (erro == null) {
                System.out.println("Reserva atualizada com sucesso!");
                System.out.println(reserva);
            } else {
                System.out.println("ERRO. " + erro);
            }

            System.out.println("...");

        }

    }
}