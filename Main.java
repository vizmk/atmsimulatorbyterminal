import java.util.Scanner;

public class Main {
    static float saldo;//var static per tutti i metodi

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        pin();
        int index;
        do {
            select();
            index = scanner.nextInt();
            switch (index) {
                case 1:
                    deposito();
                    break;
                case 2:
                    prelievo();
                    break;
                case 3:
                    totSaldo();
                    break;
                case 4:
                    simInt();
                    break;
                default:
                    if(index!=0) {
                        System.out.println("Inserire il codice corretto.");
                        System.out.println();
                        System.out.println();
                    }
                    break;
            }
        } while (index != 0);
        scanner.close();


    }

    //Inserimento Pin
    static void pin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire la carta ed il Pin,grazie.");
        int codice;
        do {
            codice = scanner.nextInt();
            //Il pin autorizzato e' 9999
            if (codice == 9999) {
                System.out.println("PIN corretto! Selezioni il servizio desiderato.");
            } else {
                System.out.println("PIN ERRATO!,inserisca il PIN corretto.");
            }
        } while (codice != 9999);

    }

    static void select() {//Metodo per dare istruzioni menu ad utente
        System.out.println("Selezioni la sua operazione: ");
        System.out.println("1. Deposito.");
        System.out.println("2. Prelievo.");
        System.out.println("3. Stampa del saldo corrente.");
        System.out.println("4. Simulazione interessi.");
        System.out.println("0. Fine Operazioni.");
    }

    static void deposito() {//Deposito in saldo
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserire quanto vuole depositare.");
        float depSaldo = scanner.nextInt();
        saldo = depSaldo + saldo;
        System.out.printf("Il saldo corrente e'%.2f $",saldo);
        System.out.println();
        System.out.println();

    }

    static void prelievo() {//Prelievo in saldo
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserire quanto si vuole prelevare.");
        float preSaldo = scanner.nextInt();
        if (preSaldo > saldo) {//controllo saldo prelievo
            System.out.println("non disponi di fondi sufficienti");
            System.out.println();
            System.out.println();
        } else {
            saldo = saldo - preSaldo;
            System.out.printf("Il saldo corrente e' %.2f $",saldo);
            System.out.println();
            System.out.println();


        }
    }

    static void totSaldo() {//Stampa il saldo corrente
        System.out.printf("Il saldo corrente e' %.2f $:",saldo);
        System.out.println();
        System.out.println();
    }

    static void simInt() {//Metodo per calcolare interesse
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci la tipologia d’interesse: ");
        System.out.println("1. Interesse Semplice");
        System.out.println("2. Interesse Composto");
        System.out.println("0. Ritorna alla selezione dei Servizi.");

        int index2;
        do {
            index2 = scanner.nextInt();

            switch (index2) {
                case 1://interesse semplice [interesse semp=capitale*tasso*Anni] [saldof=capitale+interesse]
                    System.out.println("Inserisci il capitale iniziale:");
                    int capitale = scanner.nextInt();
                    System.out.println("inserisci il tasso annuo:");
                    double tassoPerc = scanner.nextDouble();
                    double tasso = tassoPerc / 100;
                    System.out.println("inserisci il numero di anni:");
                    int anniTas = scanner.nextInt();
                    double interesse = capitale * tasso * anniTas;
                    double saldoFin = capitale + interesse;
                    System.out.printf("Saldo Maturato:%.2f$\n", interesse);
                    System.out.printf("saldo finale dopo %danni: %.2f" + "$", anniTas, saldoFin);
                    System.out.println();
                    System.out.println();
                    System.out.println("premere 0 per tornare alla selezione servizi");//ritorno servizi
                    break;
                case 2://interesse composto formula saldo finale=capitale*(1+tasso)^tempo
                    System.out.println("Inserisci il capitale iniziale:");
                    int nCapitale = scanner.nextInt();
                    System.out.println("inserisci il tasso annuo:");
                    double nTassoPerc = scanner.nextDouble();
                    double nTasso = nTassoPerc / 100;
                    System.out.println("inserisci il numero di anni:");
                    int nAnniTas = scanner.nextInt();
                    double nSaldoFinale = nCapitale * Math.pow(1 + nTasso, nAnniTas);//metodo math.pow per elevazione potenza
                    System.out.printf("dopo %d anni, il saldo sara':%.2f" + "$", nAnniTas, nSaldoFinale);
                    System.out.println();
                    System.out.println();
                    System.out.println("premere 0 per tornare alla selezione servizi");//ritorno servizi
                    break;
            }


        } while (index2 != 0);//se input index2  uguale a 0 allora esce
    }
}