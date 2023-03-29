import org.example.MainMutantNeechivalent1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainMutantNeechivalent1Test {
        /*
    Equivalence partitioning

Intrare a, b, c

Domeniul pt a, b, c:
D1 = {n | n < 10}
D2 = {n | n >= 10 && n <= 999999}
D3 = {n | n > 999999}

Iesiri:
I1 = {["Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."]}
I2 = {["Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."]}
I3 = {["Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."]}
I4 = {["Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."]}
I5 = {"Cel putin un numar din input nu este in intervalul dorit."}

Clasele:
C11 = { (a, b, c) | a in D1 si iesirea I5} -----> a = 0, b = 100, c = 100
C12 = { (a, b, c) | b in D1 si iesirea I5} -----> a = 100, b = 0, c = 100
C13 = { (a, b, c) | c in D1 si iesirea I5} -----> a = 100, b = 100, c = 0
C21 = { (a, b, c) | a, b, c in D2 si iesirea I1} -----> a = 65, b = 146, c = 10
C22 = { (a, b, c) | a, b, c in D2 si iesirea I2} -----> a = 146, b = 65, c = 10
C23 = { (a, b, c) | a, b, c in D2 si iesirea I3} -----> a = 65, b = 146, c = 20
C24 = { (a, b, c) | a, b, c in D2 si iesirea I4} -----> a = 146, b = 65, c = 20
C41 = { (a, b, c) | a in D3 si iesirea I5} -----> a = 1000000, b = 100, c = 100
C42 = { (a, b, c) | b in D3 si iesirea I5} -----> a = 100, b = 1000000, c = 100
C43 = { (a, b, c) | c in D3 si iesirea I5} -----> a = 100, b = 100, c = 1000000

     */

    @Test
    void equivalence(){
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(0, 100, 100)[0]);
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 0, 100)[0]);
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 100, 0)[0]);

        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(65, 146, 10));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(146, 65, 10));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(65, 146, 20));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(146, 65, 20));

        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(1000000, 100, 100)[0]);
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 1000000, 100)[0]);
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 100, 1000000)[0]);
    }

        /*
    Boundary value analysis

    Valorile ce trebuie testate pentru a, b, c:
    9, 10, 999999, 1000000

     */

    @Test
    void boundaries() {
        // testam pentru a, iar b si c le consideram ca fiind valori corecte din interval
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(9, 100, 100)[0]);
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(10, 100, 100));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(999999, 100, 100));
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(1000000, 100, 100)[0]);

        // testam pentru b, iar a si c le consideram ca fiind valori corecte din interval
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 9, 100)[0]);
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(100, 10, 100));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(100, 999999, 100));
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 1000000, 100)[0]);

        // testam pentru c, iar a si b le consideram ca fiind valori corecte din interval
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 100, 9)[0]);
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(100, 100, 10));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(100, 100, 999999));
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(100, 100, 1000000)[0]);
    }


    @Test
    void causeEffectGraphing() {
        Assertions.assertEquals("Cel putin un numar din input nu este in intervalul dorit.", MainMutantNeechivalent1.calculeaza(0, 100, 100)[0]);
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(65, 146, 10));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(146, 65, 10));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(65, 146, 20));
        Assertions.assertArrayEquals(new String[]{"Cmmdc-ul sumei cifrelor primelor doua numere nu este mai mare decat al treilea.", "Primele doua numere nu sunt in ordine crescatoare."}, MainMutantNeechivalent1.calculeaza(146, 65, 20));
    }
}
