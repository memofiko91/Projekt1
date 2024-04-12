package figures;

public abstract class Figure {
    protected char[][] symbol = new char[3][3];
    protected int size;

    public Figure(int size) {
        this.size = size;
    }


    @Override
    /* erstellt eine String-Repräsentation eines 3x3-Symbolrasters
       Anzahl der Wiederholungen jedes Symbols basiert auf Wert von size */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        switch (size) {
            case 1:
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        sb.append(symbol[col][row]);
                    }
                    sb.append('\n');
                }
                break;
            case 2:
                for (int row = 0; row < 3; row++) {
                    for (int i = 0; i < size; i++) {
                        for (int col = 0; col < 3; col++) {
                            sb.append(symbol[col][row]);
                            sb.append(symbol[col][row]);
                        }
                        sb.append('\n');
                    }
                }
                break;
            case 3:
                for (int row = 0; row < 3; row++) {
                    for (int i = 0; i < size; i++) {
                        for (int col = 0; col < 3; col++) {
                            sb.append(symbol[col][row]);
                            sb.append(symbol[col][row]);
                            sb.append(symbol[col][row]);
                        }
                        sb.append('\n');
                    }
                }
                break;
            }
            return sb.toString();


        }
    }