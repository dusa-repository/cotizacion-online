package componentes.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Convertidor {

	public static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");
	public static DateFormat df = new SimpleDateFormat("HH:mm:ss");

	public static Date transformarJulianaAGregoria(BigDecimal valor) {
		String j = "";
		Date date = new Date();
		if (valor != null) {
			j = valor.toString();
			String primerValor = "";
			if (j.length() == 5) {
				try {
					date = new SimpleDateFormat("yyD").parse(j);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				primerValor = j.substring(0, 1);
				if (primerValor.equals("1")) {
					String anno = j.substring(1, 3);
					date.setYear(Integer.valueOf("20" + anno) - 1900);
					String s = j.substring(3);
					Date fecha = new Date();
					try {
						fecha = new SimpleDateFormat("D").parse(s);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fecha.setYear(date.getYear());
					return fecha;
				}
			}
		}
		return date;
	}

	public static Date transformarJulianaAGregoriadeLong(Long valor) {
		String j = valor.toString();
		Date date = new Date();
		String primerValor = "";
		if (j.length() == 5) {
			try {
				date = new SimpleDateFormat("yyD").parse(j);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			primerValor = j.substring(0, 1);
			if (primerValor.equals("1")) {
				String anno = j.substring(1, 3);
				date.setYear(Integer.valueOf("20" + anno) - 1900);
				String s = j.substring(3);
				Date fecha = new Date();
				try {
					fecha = new SimpleDateFormat("D").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fecha.setYear(date.getYear());
				return fecha;
			}
		}
		return date;
	}
	
	public static BigDecimal transformarGregorianoAJulia(Date fecha) {
		String valor = "";

		Calendar calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		String dia = "";
		if (calendario.get(Calendar.DAY_OF_YEAR) < 10)
			dia = "00";
		else {
			if (calendario.get(Calendar.DAY_OF_YEAR) >= 10
					&& calendario.get(Calendar.DAY_OF_YEAR) < 100)
				dia = "0";
		}
		if ((calendario.get(Calendar.YEAR) + 1900) < 2000)
			valor = "";
		else
			valor = "1";
		long al = Long.valueOf(valor
				+ String.valueOf(calendario.get(Calendar.YEAR)).substring(2)
				+ dia + String.valueOf(calendario.get(Calendar.DAY_OF_YEAR)));
		BigDecimal a = BigDecimal.valueOf(al);
		return a;
	}

}
