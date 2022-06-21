package tugasbesar;
public class NB extends base {

	String NB(double temp, double humid, double winds) {
        double hasilC = 0;
        double hasilCB = 0;
        double hasilB = 0;
        double hasilHR = 0;
        
        //temp 0 = temp <= 25
        //temp 1 = temp > 25
        //hum 0 = humid <=79
        //hum 1 = humid > 79
        //wind 0 = winds <= 12
        //wind 1 = winds > 12
        
        
        if (temp <= 25 && humid <=79 && winds <= 12) {
            hasilC = Pcerah000 * totalC / pembagi;
            hasilCB = Pcerahberawan000 * totalCB / pembagi;
            hasilB = Pberawan000 * totalB / pembagi;
            hasilHR = Phujanringan000 * totalHR / pembagi;

        } else if (temp <= 25 && humid <=79 && winds > 12) {
            hasilC = Pcerah001 * totalC / pembagi;
            hasilCB = Pcerahberawan001 * totalCB / pembagi;
            hasilB = Pberawan001 * totalB / pembagi;
            hasilHR = Phujanringan001 * totalHR / pembagi;
        } else if (temp <= 25 && humid > 79 && winds <= 12) {
            hasilC = Pcerah010 * totalC / pembagi;
            hasilCB = Pcerahberawan010 * totalCB / pembagi;
            hasilB = Pberawan010 * totalB / pembagi;
            hasilHR = Phujanringan010 * totalHR / pembagi;

        } else if (temp <= 25 && humid > 79 && winds > 12) {
            hasilC = Pcerah011 * totalC / pembagi;
            hasilCB = Pcerahberawan011 * totalCB / pembagi;
            hasilB = Pberawan011 * totalB / pembagi;
            hasilHR = Phujanringan011 * totalHR / pembagi;

        } else if (temp > 25 && humid <=79 && winds <= 12) {
            hasilC = Pcerah100 * totalC / pembagi;
            hasilCB = Pcerahberawan100 * totalCB / pembagi;
            hasilB = Pberawan100 * totalB / pembagi;
            hasilHR = Phujanringan100 * totalHR / pembagi;

        } else if (temp > 25 && humid <=79 && winds > 12) {
            hasilC = Pcerah101 * totalC / pembagi;
            hasilCB = Pcerahberawan101 * totalCB / pembagi;
            hasilB = Pberawan101 * totalB / pembagi;
            hasilHR = Phujanringan101 * totalHR / pembagi;
        } else if (temp > 25 && humid > 79 && winds <= 12) {
            hasilC = Pcerah110 * totalC / pembagi;
            hasilCB = Pcerahberawan110 * totalCB / pembagi;
            hasilB = Pberawan110 * totalB / pembagi;
            hasilHR = Phujanringan110 * totalHR / pembagi;

        } else if (temp > 25 && humid > 79 && winds > 12) {
            hasilC = Pcerah111 * totalC / pembagi;
            hasilCB = Pcerahberawan111 * totalCB / pembagi;
            hasilB = Pberawan111 * totalB / pembagi;
            hasilHR = Phujanringan111 * totalHR / pembagi;

        } else {
            return "Inputan tidak valid";
        }
        System.out.println("=====Cuaca=====");
        System.out.println("Cerah = " + hasilC);
        System.out.println("Cerah Berawan = " + hasilCB);
        System.out.println("Berawan = " + hasilB);
        System.out.println("Hujan Ringan = " + hasilHR);

        if (hasilC > hasilB && hasilC > hasilCB && hasilC > hasilB && hasilC > hasilHR) {
            return "Cerah";
        } else if (hasilB > hasilC && hasilB > hasilCB && hasilB > hasilC && hasilB > hasilHR) {
            return "Berawan";
        } else if (hasilCB > hasilC && hasilCB > hasilB && hasilCB > hasilC && hasilCB > hasilHR) {
            return "Cerah Berawan";
        } else if (hasilHR > hasilC && hasilHR > hasilB && hasilHR > hasilCB && hasilHR > hasilC) {
            return "Hujan Ringan";
        } else {
            return "Inputan tidak valid";
        }
    }
}
