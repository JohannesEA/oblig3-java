package oppgaver;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class UnikeTall2 {
    // Deklarasjon av array for lagring av tilfeldige heltall
    int[] arrayForLagringAvTilfeldigeTall;
    int øvreGrense = 1000;
    int nedreGrense = 100;

    /*
     * Konstruktør som mottar arrayets lengde som parameter og oppretter arrayet.
     */
    public UnikeTall2(int lengde) {
        arrayForLagringAvTilfeldigeTall = new int[lengde];
    }

    /*
     * Metode som skal undersøke om et gitt tall finnes i arrayet fra før. Tallet
     * det letes etter skal mottas som parameter. Metoden skal returnere true hvis
     * tallet finnes i arrayet. Hvis ikke skal metoden returnere false.
     */
    public boolean finnesTall(int tall) {

        for (int i = 0; i < arrayForLagringAvTilfeldigeTall.length; i++) {
            if (i == tall) {
                return true;
            }
        }

        return false;
    }

    /*
     * Metode som skal fylle arrayet med tilfeldige tall mellom 100 og 999, begge
     * grenser inkludert. Metoden skal gjøre dette på en måte som sikrer at alle
     * tallene er forskjellige. Metoden skal ikke ha parametre og heller ikke
     * returnere noen verdi. Tips bruk (int)(Math.random()*(900)+100); for å
     * generere tallene mellom 100 og 999
     */

    public void fyllArrayMedTilfeldigeTall() {
        Random randomGenerator = new Random();

        int random = 0;
        for (int i = 0; i < arrayForLagringAvTilfeldigeTall.length; i++) {
            random = randomGenerator.nextInt((øvreGrense - nedreGrense + 1) + nedreGrense);

            if (finnesTall(random) == true) {
                continue;
            } else {
                arrayForLagringAvTilfeldigeTall[i] = random;
            }

        }
    }

    // Metode som finner og returnerer det minste tallet i arrayet.
    public int finnLavesteTall() {
        Arrays.sort(arrayForLagringAvTilfeldigeTall);
        return arrayForLagringAvTilfeldigeTall[0];
    }

    // Metode som finner og returnerer det største tallet i arrayet.
    public int finnStørsteTall() {
        // Kan også skrive:
        // Arrays.sort(arrayForLagringAvTilfeldigeTall)
        // return arrayForLagringAvTilfeldigeTall[arrayForLagringAvTilfeldigeTall-1]

        int størsteTall = 0;
        for (int i = 0; i < arrayForLagringAvTilfeldigeTall.length; i++) {
            if (størsteTall < arrayForLagringAvTilfeldigeTall[i]) {
                størsteTall = arrayForLagringAvTilfeldigeTall[i];
            }
        }
        return størsteTall;
    }

    /*
     * Metode som beregner og returnerer den gjennomstnittlige verdien
     * (double-verdi) av tallene i arrayet.
     */
    public double beregnGjennomsnittsVerdien() {
        double gjennomsnittsverdien = 0;
        for (int i = 0; i < arrayForLagringAvTilfeldigeTall.length; i++) {
            gjennomsnittsverdien = gjennomsnittsverdien + arrayForLagringAvTilfeldigeTall[i];
        }
        gjennomsnittsverdien = (double) gjennomsnittsverdien / arrayForLagringAvTilfeldigeTall.length;
        return gjennomsnittsverdien;
    }

    /*
     * Metode som viser tallene i arrayet i en meldngsboks. I tillegg skal det, i
     * meldingsboks, skrives ut opplysninger om hvilket tall som er minst, hvilket
     * som er størst, og hva som er gjennomsnittsverdien, jfr bildet over.
     * Gjennomsnittverdien skal skrives ut med en desimal. Bruk gjerne
     * String.format("%.2f,tall) til dette. Legg inn mellomrom mellom tallene og
     * skriv ut et passende antall tall per linje.
     */
    public void visTall() {
        fyllArrayMedTilfeldigeTall();

        String heleArrayet = Arrays.toString(arrayForLagringAvTilfeldigeTall);
        int størsteTall = finnStørsteTall();
        int minsteTall = finnLavesteTall();
        double gjennomsnittsverdien = beregnGjennomsnittsVerdien();
        String gjennomsnittsverdienFormattert = String.format("%.2f", gjennomsnittsverdien);
        String utskrift = heleArrayet + "\n" + "Største tall: " + størsteTall + "\nMinste tall: " + minsteTall
                + "\nGjennomsnittet: " + gjennomsnittsverdienFormattert;

        JOptionPane.showMessageDialog(null, utskrift);
    }

}
