import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String atualizarDatas(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Erro: As datas devem ser datas futuras";
        }
        if (!checkOut.after(checkIn)) {
            return "Erro: Data de checkOut tem que ser posterior a data de checkIn";
        } else {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return null;
        }

    }

    public long duracao() {
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + getNumeroQuarto() + ", CheckIn: " + format.format(checkIn) + ", CheckOut: "
                + format.format(checkOut)
                + ", " + duracao() + " dias. \n";
    }
}
