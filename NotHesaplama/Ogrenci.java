/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotHesaplama;

/**
 *
 * @author akpin
 */
public class Ogrenci {

    String harfnotu;
    int donemSonu;

    public void setDonemSonuNotu(int vize_not, int final_not, int lab_not) {
        this.donemSonu = (int) ((0.3 * vize_not) + (0.5 * final_not) + (0.2 * lab_not));
    }

    public int getDonemSonuNotu() {
        return this.donemSonu;
    }

    public String getHarfNotu() {
        return this.harfnotu;
    }

    public void setHarfNotu(int donemSonuNotu) {
        if (donemSonuNotu >= 90) {
            this.harfnotu = "AA";
        } else if (donemSonuNotu >= 85) {
            this.harfnotu = "BA";
        } else if (donemSonuNotu >= 80) {
            this.harfnotu = "BB";
        } else if (donemSonuNotu >= 75) {
            this.harfnotu = "CB";
        } else if (donemSonuNotu >= 65) {
            this.harfnotu = "CC";
        } else if (donemSonuNotu >= 60) {
            this.harfnotu = "DC";
        } else if (donemSonuNotu <= 59) {
            this.harfnotu = "FF";
        }

    }
}
