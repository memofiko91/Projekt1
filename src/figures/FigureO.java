package figures;

public class FigureO extends Figure {

    public FigureO(int size) {
        super(size);
        symbol[0][0] = 'X';
        symbol[1][0] = 'X';
        symbol[2][0] = 'X';

        symbol[0][1] = 'X';
        symbol[1][1] = ' ';
        symbol[2][1] = 'X';

        symbol[0][2] = 'X';
        symbol[1][2] = 'X';
        symbol[2][2] = 'X';
    }
}
