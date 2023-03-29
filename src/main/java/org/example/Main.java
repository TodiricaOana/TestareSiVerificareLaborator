package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /*
    Se dau trei numere intregi a, b si c cuprinse intre 10 si 999999.
    Sa se verifice daca cmmdc dintre suma cifrelor lui a si b este mai mare decat c.
    Sa se verifice daca numerele a si b sunt date in ordine crescatoare.
    Programul va intoarce un string astfel:
     - daca a, b sau c nu sunt in intervalul mentionat se va afisa un mesaj de eroare;
     - "Cmmdc-ul sumei cifrelor primelor doua numere este/nu este mai mare decat al treilea." daca respecta sau nu prima cerinta.
     - "Primele doua numere sunt/nu sunt in ordine crescatoare." daca respecta sau nu a doua cerinta
     */


    static Integer cmmdc(Integer a, Integer b) {
        while(a != b) {
            if(a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    static Integer sumaCifrelor(Integer a) {
        Integer sum = 0;

        while(a > 0){
            sum += a % 10;
            a = a / 10;
        }
        return sum;

    }

    static Boolean respectaInterval(Integer a) {
        if(a >= 10 && a <= 999999) {
            return true;
        }
        return false;
    }

    static String cerinta1(Integer a, Integer b, Integer c) {
        if(cmmdc(sumaCifrelor(a), sumaCifrelor(b)) > c) {
            return "Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.";
        }
        return "Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.";
    }

    static String cerinta2(Integer a, Integer b) {
        if(a < b) {
            return "Primele doua numere sunt in ordine crescatoare.";
        }
        return "Primele doua numere nu sunt in ordine crescatoare.";
    }

    public static String[] calculeaza(Integer a, Integer b, Integer c) {
        String[] result;

        if(respectaInterval(a) && respectaInterval(b) && respectaInterval(c)) {
            result = new String[2];
            result[0] = cerinta1(a, b, c);
            result[1] = cerinta2(a, b);
        } else {
            result = new String[1];
            result[0] = "Cel putin un numar din input nu este in intervalul dorit.";
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti valoarea lui a: ");
        int a = scanner.nextInt();

        System.out.println("Introduceti valoarea lui b:");
        int b = scanner.nextInt();

        System.out.println("Introduceti valoarea lui c: ");
        int c = scanner.nextInt();
        scanner.close();

        System.out.println("Rezultatul este:\n" + Arrays.stream(calculeaza(a, b, c)).collect(Collectors.joining("\n")));
    }
}
