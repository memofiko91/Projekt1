
import figures.*;

import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private final Scanner input;
    private final PrintStream output;
    private boolean exit = false;
    private int figureNr;
    private int figureSize;
    private Figure figure;


    // Konstruktor
    // input wird verwendet um Daten vom Benutzer einzulesen (verwendet scanner)
    // output wird verwendet um Text auf der Konsole auszugeben (verwendet sysout)
    public App(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }


    // -- die Gameloop --
    public void Run() {
        initialize();
        printState();

        while (!exit) {
            // SChleife wird wiederholt solange User das Programm nicht beenden möchte
            readUserInput();
            updateState();
            printState();
            //Exit Abfrage nach jeder Figurausgabe
            output.println("Möchten Sie das Programm beenden? J/N ?");
            String wantExit = input.next();
            while (!wantExit.equalsIgnoreCase("J") && !wantExit.equalsIgnoreCase("N")) {
                output.println("Bitte geben Sie eine gültige Antwort ein: [J]a / [N]ein ");
                wantExit = input.next();
            }
            if (wantExit.equalsIgnoreCase("J")) {
                exit = true;
            }
        }
    }


    private void initialize() {
        output.println("Willkommen beim Grafik-Generator!");
        output.println();
        // Verzögerung bis zur nächsten Ausgabe
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    private void readUserInput() {
        // Art und Größe der Figur werden vom Benutzer eingelesen
        inputFigure();
        inputSize();
    }


    private void updateState() {
        // gewählte Figur wird mit gewählter Größe erstellt
        switch (figureNr) {
            case 1:
                figure = new FigureH(figureSize);
                break;
            case 2:
                figure = new FigureL(figureSize);
                break;
            case 3:
                figure = new FigureO(figureSize);
                break;
            case 4:
                figure = new FigureO2(figureSize);
                break;
            case 5:
                figure = new FigureI(figureSize);
                break;
            case 6:
                figure = new FigureMinus(figureSize);
                break;
            default:
                break;
        }
    }


    private void printState() {
        if (figure != null) {
            output.println(figure);
        }
    }


    private void inputFigure() {
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt (nur Zahlen!!)
        do {
            output.println("Welche Grafik möchten Sie anzeigen? (1-6)");
            figureNr = input.nextInt();
            if (figureNr < 1 || figureNr > 6) {
                output.println("Dies ist keine gültige Grafik!");
            } else {
                break;
            }
        } while (true);
    }


    private void inputSize() {
        // Solange kein gültiger Wert eingegeben wurde, wird die Eingabe wiederholt (nur Zahlen!!)
        do {
            output.println("Bitte wählen Sie eine Größe (1-3)");
            figureSize = input.nextInt();
            if (figureSize < 1 || figureSize > 3) {
                output.println("Dies ist keine gültige Größe!");
            } else {
                break;
            }
        } while (true);
    }
}
