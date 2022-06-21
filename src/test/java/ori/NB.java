package ori;

public class NB extends base {//inhearitence
	
//	totalC / pembagi; //bayes
	//implementasi probabilitas bersyarat
	//P(a|b) =p(a.b)/p(b)
	String hitung(double temp, double humid, double winds) {
        double hasilC = 0;
        double hasilCB = 0;
        double hasilB = 0;
        double hasilHR = 0;
        
        //total cerah
        if (temp <= 25 && humid <=79 && winds <= 12) {
        			//pab		//
            hasilC = Pcerah000 / totalC;
            hasilCB = Pcerahberawan000 / totalCB;
            hasilB = Pberawan000 / totalB;
            hasilHR = Phujanringan000 / totalHR;

        } else if (temp <= 25 && humid <=79 && winds > 12) {
            hasilC = Pcerah001 / totalC;
            hasilCB = Pcerahberawan001 / totalCB;
            hasilB = Pberawan001 / totalB;
            hasilHR = Phujanringan001 / totalHR;
        } else if (temp <= 25 && humid > 79 && winds <= 12) {
            hasilC = Pcerah010 / totalC;
            hasilCB = Pcerahberawan010 / totalCB;
            hasilB = Pberawan010 /totalB;
            hasilHR = Phujanringan010 /totalHR;

        } else if (temp <= 25 && humid > 79 && winds > 12) {
            hasilC = Pcerah011 / totalC;
            hasilCB = Pcerahberawan011 / totalCB;
            hasilB = Pberawan011 /totalB;
            hasilHR = Phujanringan011 /totalHR;
//pb 000
        } else if (temp > 25 && humid <=79 && winds <= 12) {
            hasilC = Pcerah100 /totalC;
            hasilCB = Pcerahberawan100 /totalCB;
            hasilB = Pberawan100 /totalB;
            hasilHR = Phujanringan100 / totalHR;
//probabilitaas 000-111 ke semua kondisi
        } else if (temp > 25 && humid <=79 && winds > 12) {
            hasilC = Pcerah101 /totalC;
            hasilCB = Pcerahberawan101 / totalCB;
            hasilB = Pberawan101 /totalB;
            hasilHR = Phujanringan101 /totalHR;
        } else if (temp > 25 && humid > 79 && winds <= 12) {
            hasilC = Pcerah110 / totalC;
            hasilCB = Pcerahberawan110 /totalCB;
            hasilB = Pberawan110 /totalB;
            hasilHR = Phujanringan110 / totalHR;

        } else if (temp > 25 && humid > 79 && winds > 12) {
            hasilC = Pcerah111 / totalC;
            hasilCB = Pcerahberawan111 / totalCB;
            hasilB = Pberawan111 / totalB;
            hasilHR = Phujanringan111 /totalHR;

        } else {
            return "Inputan tidak valid";
        }
        System.out.println("=====Probabilitas Bersyarat=====");
        System.out.println("* Temperatur "+temp);
        System.out.println("* Kelembapan "+humid);
        System.out.println("* Kecepatan Angin "+ winds);
        System.out.println("Cerah== "+hasilC);
        System.out.println("Cerah Berawan=="+hasilCB);
        System.out.println("Berawan=="+hasilB);
        System.out.println("Hujan Ringan=="+hasilHR);
//        System.out.println("Probabilitas Bersyaratnya adalah : ");
        
        if (hasilC > hasilB && hasilC > hasilCB && hasilC > hasilB && hasilC > hasilHR) {
            return "Cerah";
        } else if (hasilB > hasilC && hasilB > hasilCB && hasilB > hasilC && hasilB > hasilHR) {
            return "Berawan";
        } else if (hasilCB > hasilC && hasilCB > hasilB && hasilCB > hasilC && hasilCB > hasilHR) {
            return "Cerah Berawan";
        } else if (hasilHR > hasilC && hasilHR > hasilB && hasilHR > hasilCB && hasilHR > hasilC) {
            return "Hujan Ringan";
        }
        else if ((hasilC == hasilB )&&(hasilC > hasilHR)){
            return "Cerah dan Berawan memiliki Probabilitas yang sama";
        }
        else if ((hasilC == hasilCB)&&(hasilCB > hasilHR)) {
            return "Cerah dan Cerah Berawan memiliki Probabilitas yang sama";
        }else if ((hasilC == hasilHR)&&(hasilHR > hasilCB)) {
            return "Cerah dan Hujan Ringan memiliki Probabilitas yang sama";
        } else if ((hasilB == hasilCB)&&(hasilB > hasilHR)) {
            return "Berawan dan Cerah Berawan memiliki Probabilitas yang sama";
        } else if ((hasilB == hasilHR)&&(hasilB > hasilC)) {
            return "Berawan dan Hujan Ringan memiliki Probabilitas yang sama";
        } else if ((hasilCB == hasilHR)&&(hasilCB > hasilC)) {
            return "Cerah Berawan dan Hujan Ringan memiliki Probabilitas yang sama";
        }else if (hasilC == 0 && hasilCB ==0 && hasilB == 0 && hasilHR ==0){
            return "Data Tidak Ada";
        }
        else {
            return "Inputan tidak valid";
        }
    }
	String hitung(double temp, double humid, double winds, String info) {
        double hasilC = 0;
        double hasilCB = 0;
        double hasilB = 0;
        double hasilHR = 0;
        
        //total cerah
        if (temp <= 25 && humid <=79 && winds <= 12) {
        			//pab
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
//pb 000
        } else if (temp > 25 && humid <=79 && winds <= 12) {
            hasilC = Pcerah100 * totalC / pembagi;
            hasilCB = Pcerahberawan100 * totalCB / pembagi;
            hasilB = Pberawan100 * totalB / pembagi;
            hasilHR = Phujanringan100 * totalHR / pembagi;
//probabilitaas 000-111 ke semua kondisi
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
        System.out.println("=====Bayes=====");
        System.out.println("Cerah = "+hasilC);
        System.out.println("Cerah Berawan = "+hasilCB);
        System.out.println("Berawan = "+hasilB);
        System.out.println("Hujan Ringan = "+hasilHR);
//        System.out.println("Probabilitas Bersyaratnya adalah : ");
        
        if (hasilC > hasilB && hasilC > hasilCB && hasilC > hasilB && hasilC > hasilHR) {
            return "Cerah";
        } else if (hasilB > hasilC && hasilB > hasilCB && hasilB > hasilC && hasilB > hasilHR) {
            return "Berawan";
        } else if (hasilCB > hasilC && hasilCB > hasilB && hasilCB > hasilC && hasilCB > hasilHR) {
            return "Cerah Berawan";
        } else if (hasilHR > hasilC && hasilHR > hasilB && hasilHR > hasilCB && hasilHR > hasilC) {
            return "Hujan Ringan";
        }
        else if ((hasilC == hasilB )&&(hasilC > hasilHR)){
            return "Cerah dan Berawan memiliki Probabilitas yang sama";
        }
        else if ((hasilC == hasilCB)&&(hasilCB > hasilHR)) {
            return "Cerah dan Cerah Berawan memiliki Probabilitas yang sama";
        }else if ((hasilC == hasilHR)&&(hasilHR > hasilCB)) {
            return "Cerah dan Hujan Ringan memiliki Probabilitas yang sama";
        } else if ((hasilB == hasilCB)&&(hasilB > hasilHR)) {
            return "Berawan dan Cerah Berawan memiliki Probabilitas yang sama";
        } else if ((hasilB == hasilHR)&&(hasilB > hasilC)) {
            return "Berawan dan Hujan Ringan memiliki Probabilitas yang sama";
        } else if ((hasilCB == hasilHR)&&(hasilCB > hasilC)) {
            return "Cerah Berawan dan Hujan Ringan memiliki Probabilitas yang sama";
        }else if (hasilC == 0 && hasilCB ==0 && hasilB == 0 && hasilHR ==0){
            return "Data Tidak Ada";
        }
        else {
            return "Inputan tidak valid";
        }
    }
}
