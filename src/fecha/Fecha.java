/*
 * Clase que comprueba si una fecha es correcta o no
 */
package fecha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Tania Santirso
 */
public class Fecha {

    InputStreamReader flujo = new InputStreamReader(System.in);
    BufferedReader teclado = new BufferedReader(flujo);

    /**
     * nºdia del mes
     */
    private int dia;
    /**
     * nºmes
     */
    private int mes;
    /**
     * nºaño
     */
    private int anno;

    //SE PUEDE PONER STATIC: private static int []diasMes={31,28,31,30,31,30,31,31,30,31,30,31};
    /**
     * Constructor que inicializa los valores por defecto
     */
    public Fecha() {
    }

    /////////////////////GETS Y SETS////////////////////////////
    /**
     * Visualiza el valor de dia
     *
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Modifica el valor de dia por otro
     *
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Visualiza el valor del mes
     *
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Modifica el valor del mes por otro
     *
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Visualiza el valor del año
     *
     * @return the anno
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Modifica el valor del año por otro
     *
     * @param anno the anno to set
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }

    ////////////////////METODOS////////////////////
    /**
     * Metodo que comprueba si el año es bisiesto o no, para saber los dias que
     * tiene el mes de febrero
     *
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto() {
        int dias = 28;
        if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
            dias = 29;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si el año es bisiesto o no, para saber los dias que
     * tiene el mes de febrero
     *
     * @param a usa el atributo año
     * @return devuelve si el mes de febrero tiene 28 o 29 dias
     */
    public int bisiesto(int a) {
        int dias = 28;
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            dias = 29;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si el año es bisiesto, para saber cuantos dias tiene
     * ese año
     *
     * @param a usa el atributo año
     * @return devuelve si el año tiene 365 o 366 dias
     */
    public int diasAño(int a) {
        int dias = 365;
        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            dias = 366;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si el año es bisiesto, para saber cuantos dias tiene
     * ese año
     *
     * @return devuelve si el año tiene 365 o 366 dias
     */
    public int diasAño() {
        int dias = 365;
        if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
            dias = 366;

        }
        return dias;
    }

    /**
     * Metodo que comprueba si la fecha es correcta o no
     *
     * @param d usa el atributo dia
     * @param m usa el atributo mes
     * @param a usa el atributo año
     * @return devuelve si la fecha es correcta o no(true o false)
     */
    public boolean comprobarFecha(int d, int m, int a) {
        boolean resultado = true;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//declaramos un array. Lo ponemos asi pq sabemos todos los datos
        /*
         tambien se puede poner el array de esta forma:
         int[]diasMes=new int[12];
         diasMes[0]=31;
         diasMes[1]=28;
         diasMes[2]=31;
         .
         .
         .
         .
         diasMes[11]=31;
         */

        if (a < 0) {//año menor que 0
            resultado = false;
        }//año menor que 0
        else {//año no menor que 0
            if (m < 1 || m > 12) {//mes menor q 1 o mayor q 12
                resultado = false;
            }//mes menor q 1 o mayor q 12
            else {//mes no menor q 1 o mayor q 12
                diasMes[1] = bisiesto(a);//la posicion 1 es febrero pq los arrays siempre empiezan por el 0
                if (d < 1 || d > diasMes[m - 1])//se pone m-1 pq los meses estan guardados como array y este empieza
                //a guardar posiciones desde 0, por eso al mes q se introduzca hay q restarle una posicion
                {//dia menor q 1 o mayor q los dias guardados en ese mes
                    resultado = false;
                }//dia menor q 1 o mayor q los dias guardados en ese mes
            }//mes no menor q 1 o mayor q 12
        }//año no menor que 0
        return resultado;
    }

    /**
     * Metodo que calcula los dias q han pasado desde el inicio del año, en una
     * determinada fecha. Ej:los dias q han pasado hasta el 25-6-2016
     *
     * @return devuelve el numero de dias transcurridos
     */
    public int calcularNumeroDeOrden() {
        int orden = 0;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();//usa el metodo bisiesto para comprobar si el año es bisiesto
        for (int m = 0; m < mes - 1; m++) {
            orden = orden + diasMes[m];//suma el orden mas el valor q ocupa la posicion de ese mes      
        }
        /**
         * tambien se puede poner el for asi: for(int m=1; m<mes; m++){
         * orden=orden+diasMes[m-1]; orden=orden+dia; }
         */
        orden = orden + dia;
        return orden;
    }

    /**
     * Metodo que calcula los dias q han pasado desde el inicio del año, en una
     * determinada fecha.
     *
     * @param fecha doy los datos de la fecha
     * @return devuelve el numero de dias transcurridos
     */
    public int calcularNumeroDeOrden(Fecha fecha) {
        int orden = 0;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();//usa el metodo bisiesto para comprobar si el año es bisiesto
        for (int m = 0; m < mes - 1; m++) {
            orden = orden + diasMes[m];//suma el orden mas el valor q ocupa la posicion de ese mes      
        }
        /**
         * tambien se puede poner el for asi: for(int m=1; m<mes; m++){
         * orden=orden+diasMes[m-1]; orden=orden+dia; }
         */
        orden = orden + dia;
        return orden;
    }

    /*
     public static void cambiar(int[] diasMes){//lo cambia en los dos objetos
     diasMes[1]=88888;
     }
     */
    /**
     * Metodo que averigua los dias q quedan para q acabe el año
     *
     * @return devuelve los dias q quedan hasta el fin del año
     */
    public int diasFinAño() {
        int dias;
        dias = diasAño() - calcularNumeroDeOrden();
        return dias;
    }

    /**
     * Metodo que averigua los dias q quedan para q acabe el año
     *
     * @param a doy el año
     * @return devuelve los dias q quedan hasta el fin del año
     */
    public int diasFinAño(int a) {
        int dias;
        dias = diasAño() - calcularNumeroDeOrden();
        return dias;
    }

    /**
     * Metodo para comparar dos fechas
     *
     * @param fecha la segunda fecha para compararla
     * @return 0 si es igual, 1 si es menor y 2 si es mayor
     */
    public int compararFechas(Fecha fecha) {
        int resultado;
        if (anno < fecha.getAnno()) {//año menor
            resultado = 1;
        }//año menor
        else {//año no menor
            if (this.anno > fecha.getAnno()) {//año mayor
                resultado = 2;
            }//año mayor
            else {//mes
                if (mes < fecha.getMes()) {//mes menor
                    resultado = 1;
                }//mes menor
                else {//mes no menor
                    if (mes > fecha.getMes()) {//mes mayor
                        resultado = 2;
                    }//mes mayor
                    else {//dias
                        if (dia < fecha.getDia()) {//dia menor
                            resultado = 1;
                        }//dia menor
                        else {//dia no menor
                            if (dia > fecha.getDia()) {//dia mayor
                                resultado = 2;
                            }//dia mayor
                            else {//igual
                                resultado = 0;
                            }//igual
                        }//dia no menor
                    }//dias
                }//mes no menor
            }//mes
        }//año no menor
        return resultado;
    }

    /**
     * Metodo para averiguar el nº de dias que pasan de una fecha a otra
     *
     * @param f2 doy los datos de la fecha2
     * @param m doy el mes
     */
    public int calcularDias(Fecha f2) {
        int dias = 0;
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();//usa el metodo bisiesto para comprobar si el año es bisiesto

        if (anno == f2.getAnno()) {//si el año de las dos fechas es igual
            if (mes == f2.getMes()) {//si el mes de las dos fechas es igual
                dias = f2.getDia() - dia;
            }//si el mes de las dos fechas es igual
            else {//si el mes de las dos fechas no coincide
                dias = diasMes[mes - 1] - dia;//resta el nºde dias de ese mes con el dia dado en la fecha
                mes = mes;
                while (mes < f2.getMes() - 1) {//mientras el mes de la fecha1 sea menor que el mes de la fecha2
                    dias = dias + diasMes[mes];
                    mes++;
                }
                /*
                 tambien se puede usar el for:
                 for(m=mes;m<f2.getMes()-1;m++;){
                 dias=dias+diasMes[m];
                 }
                 */
                dias = dias + f2.getMes();
            }//si el mes de las dos fechas no coincide
        }//si el año de las dos fechas es igual
        else {//si el año de las dos fechas es distinto
            if (anno != f2.getAnno()) {
                anno = anno + 1;
                int diasTrans = 0;
                while (anno < f2.getAnno()) {
                    diasTrans = diasTrans + diasAño(anno);
                    anno++;
                }
                diasTrans = diasTrans + diasFinAño(anno) + calcularNumeroDeOrden(f2);
                dias = diasTrans;
            }
        }//si el año de las dos fechas es distinto
        return dias;
    }

    ////ejercicio 5:
    /////////////////////1ºMETODO//////////////////////////
    /**
     * 
     * Metodo que a partir de la fecha que se tiene almacenada, pide al usuario
     * los días de vencimiento y calcula la nueva fecha.
     * @param fecha doy los datos de la fecha
     * @throws IOException 
     */
    public void calcularNuevaFecha(Fecha fecha) throws IOException {
        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();

        int diasVencimiento;
        System.out.println("Dias de vencimiento: ");
        diasVencimiento = Integer.parseInt(teclado.readLine());

        int nDia;//nuevo dia
        int nMes = mes;//nuevo mes
        int nAño = anno;//nuevo año

        nDia = dia + diasVencimiento;
        while (nDia > diasMes[nMes - 1]) {
            nDia = nDia - diasMes[nMes - 1];
            nMes =nMes + 1;
            if (nMes > diasMes.length) {
                nMes = nMes - diasMes.length;
                nAño = nAño + 1;
            } 
        }
    
        System.out.println("Fecha nueva: " + nDia + "\t" + nMes + "\t" + nAño);
    }

    /////////////////////2ºMETODO////////////////////////
    /**
     * Metodo que nos devuelve la fecha con el formato día/mes(en letra)/año.
     */
    public void formatoFecha() {
        //se va a usar un metodo visualizarletra           
        String[] nombresMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        System.out.println("Fecha: " + dia + "\t" + nombresMes[mes] + "\t" + anno);
    }

    //////////////////////3ºMETODO/////////////////////////////  
    /**
     * Método que a partir del orden (número de días transcurridos desde
     * principio de año) y un año, calcula de que fecha se trata.
     *
     * @throws IOException
     */
    public void calcularFecha() throws IOException {
        int diasTrans;//dias transcurridos desde el inicio del año
        System.out.println("Dias transcurridos: ");
        diasTrans = Integer.parseInt(teclado.readLine());

        int año;
        System.out.println("Año: ");
        año = Integer.parseInt(teclado.readLine());

        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        diasMes[1] = bisiesto();
        int nDia = diasTrans;//nuevo dia

        int mes = 0;
        while (nDia > diasMes[mes]) {//mientras los dias trancurridos sean mayores q los dias del mes
            nDia = diasTrans - diasMes[mes];//saco el dia
            mes++;
        }

        if (mes + 1 > diasMes.length) {//si mes es mayor que 12
            mes = mes - diasMes.length;//saco el mes
            año = año + 1;//saco el año
        }

        System.out.println("Fecha " + nDia + "\t" + (mes+1) + "\t" + año);
    }

}
