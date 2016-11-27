package br.com.insure.utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Wesley on 10/09/2016.
 */
public class FuncoesData {

    public static final String DDMMYYYY = "dd/MM/yyyy";
    public static final String DDMMYYYY_HHMM = "dd/MM/yyyy HH:mm";
    public static final String DDMMYYYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
    public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String HHMM = "HH:mm";

    public static String formatDate(Date data, String formatData) {
        return new SimpleDateFormat(formatData).format(data);
    }

    public static Date toDate(String data, String formatData){
        if(data.length() > 19){
            data = data.replace("T", " ").substring(0, 19);
        }
        try {
            return new SimpleDateFormat(formatData).parse(data);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static int getDiferencaDataDias(Date primeiroDia, Date segundoDia){
        return (int)(((primeiroDia.getTime() - segundoDia.getTime()) / 86400000));
    }

    public static int getDiferencaDiasNoMes(Date primeiroDia, Date segundoDia){
        return primeiroDia.getDay() - segundoDia.getDay();
    }

    public static boolean getDiferencaDataDiferenteHoje(Date dia){
        Date hoje = new Date();
        return getDiferencaDataDias(hoje, dia) == 0 && getDiferencaDiasNoMes(hoje, dia) == 0;
    }

    public static Date getPrimeiroDia(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    public static Date getUltimoDia(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return c.getTime();
    }

    public static int comparaDatas(Date d1, Date d2){
        return d1.compareTo(d2);
    }
}
