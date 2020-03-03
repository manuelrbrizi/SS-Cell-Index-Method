package interfaces;

import java.util.List;

public interface Grid {
    void setCells(List<Cell> cellList);
    double getRc();
    double getL();
    double getM();
    List<Cell> getCells();
}
