package javapiechart;

import java.awt.Color;

// This class maintains information about each slice colour and value
class PieChartSlice {
   
    double value;
    Color color;
   
    // The custom constructor
    public PieChartSlice(double value, Color color) {  
       this.value = value;
       this.color = color;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}