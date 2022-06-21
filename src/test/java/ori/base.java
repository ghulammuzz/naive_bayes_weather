package ori;
public class base{
    
	protected double pembagi;
    
    static int jumlahC; //jumlah cerah dari dataset
    static int jumlahCB;
    static int jumlahB;
    static int jumlahHR;

    static double totalC; //
    static double totalCB;
    static double totalB;
    static double totalHR;

    static double Pc;//probabilitas semua cerah
    static double Pcb;
    static double Pb;
    static double Phr;

    static double Pcerah000; //Probabilitas Berawan jika Temp=0 dan Humid=0 dan Winds=0
    static double Pcerah100;
    static double Pcerah010;
    static double Pcerah001;
    static double Pcerah011;
    static double Pcerah101;
    static double Pcerah110;
    static double Pcerah111;

    static double Pcerahberawan000; //Probabilitas cerah Berawan jika Temp=0 dan Humid=0 dan Winds=0
    static double Pcerahberawan100;
    static double Pcerahberawan010;
    static double Pcerahberawan001;
    static double Pcerahberawan011;
    static double Pcerahberawan101;
    static double Pcerahberawan110;
    static double Pcerahberawan111;

    static double Pberawan000;//Probabilitas Berawan jika Temp=0 dan Humid=0 dan Winds=0
    static double Pberawan100;
    static double Pberawan010;
    static double Pberawan001;
    static double Pberawan011;
    static double Pberawan101;
    static double Pberawan110;
    static double Pberawan111;

    static double Phujanringan000;//Probabilitas Hujan Ringan jika Temp=0 dan Humid=0 dan Winds=0
    static double Phujanringan100;
    static double Phujanringan010;
    static double Phujanringan001;
    static double Phujanringan011;
    static double Phujanringan101;
    static double Phujanringan110;
    static double Phujanringan111;

    private static double[] TemperatureRaw = {
    		23.0,
    		30.0,
    		24.0,
    		22.0,
    		20.0,
    		23.0,
    		30.0,
    		20.0,
    		23.0,
    		23.0,
    		30.0,
    		19.0,
    		24.0,
    		24.0,
    		24.0,
    		23.0,
    		23.0,
    		20.0,
    		23.0,
    		30.0,
    		24.0,
    		23.0,
    		30.0,
    		30.0,
    		23.0,
    		30.0,

    		};
	private static double[] HumidityRaw =    {
			85.0,
			60.0,
			85.0,
			85.0,
			95.0,
			75.0,
			55.0,
			95.0,
			70.0,
			80.0,
			55.0,
			90.0,
			80.0,
			80.0,
			90.0,
			85.0,
			85.0,
			95.0,
			85.0,
			65.0,
			90.0,
			95.0,
			65.0,
			65.0,
			85.0,
			60.0,

			};
    private static double[] WindSpeedRaw =   {
    		3,704,
    		27,78,
    		9,26,
    		9,26,
    		9,26,
    		3,704,
    		27,78,
    		9,26,
    		3,704,
    		3,704,
    		27,78,
    		0,
    		27,78,
    		3,704,
    		18,52,
    		9,26,
    		9,26,
    		9,26,
    		9,26,
    		3,704,
    		3,704,
    		9,26,
    		27,78,
    		18,52,
    		3,704,
    		27,78

    		};
    private static String[] Class ={
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"cerah berawan",
    		"berawan",
    		"berawan",
    		"hujan ringan"
    		};
    
    public static double[] Temperature = arrDataTemp();
	public static double[] Humidity = arrDataHum();
	public static double[] WindSpeed = arrDataWind();
    
	public double getPembagi() {
		return this.pembagi;
	}
	
	public static double[] arrDataTemp() {//mengambil nilai dari data mentah yang kemudian didefinisikan 0 apabila kurang dari 25 dan sebaliknya
		for (int i = 0; i <= 25; i++) {
			if (TemperatureRaw[i] <= 25) 
				TemperatureRaw[i] = 0;
			
			else if (TemperatureRaw[i] > 25) 
				TemperatureRaw[i] = 1;
		}
		return TemperatureRaw;
	}
	public static double[] arrDataHum() {
		for (int i = 0; i <=25; i++) {
			if (HumidityRaw[i] <= 79) 
				HumidityRaw[i] =0;
			
			else if (HumidityRaw[i] > 79) 
				HumidityRaw[i] =1;
		}
		return HumidityRaw;
	}
	public static double[] arrDataWind() {
		for (int i = 0; i <= 25; i++) {
			if (WindSpeedRaw[i] <= 12) 
				WindSpeedRaw[i] =0;
			
			else if (WindSpeedRaw[i] > 12) 
				WindSpeedRaw[i] =1;
		}
		return WindSpeedRaw;
	}
	
    public void hitung(){//polymorpisme
        jumlahC = hitung(Class, "cerah");//menghitung Jumlah cuaca yang diujikan
        jumlahCB = hitung(Class, "cerah berawan");
        jumlahB = hitung(Class, "berawan");
        jumlahHR = hitung(Class, "hujan ringan");

            Pc = P_class(jumlahC);//probabilitas setiap cuaca pada semua kondisi TKA
            Pcb = P_class(jumlahCB);
            Pb = P_class(jumlahB);
            Phr = P_class(jumlahHR);

        int jumlahC000 = hitung(0, 0, 0, "cerah");//menghiung jumlah cuaca cerah saat TKA-> 000
        int jumlahCB000 = hitung(0, 0, 0, "cerah berawan");
        int jumlahB000 = hitung(0, 0, 0, "berawan");
        int jumlahHR000 = hitung(0, 0, 0, "hujan ringan");

        int jumlahC100 = hitung(1, 0, 0, "cerah");
        int jumlahCB100 = hitung(1, 0, 0, "cerah berawan");
        int jumlahB100 = hitung(1, 0, 0, "berawan");
        int jumlahHR100 = hitung(1, 0, 0, "hujan ringan");
        
        int jumlahC010 = hitung(0, 1, 0, "cerah");
        int jumlahCB010 = hitung(0, 1, 0, "cerah berawan");
        int jumlahB010 = hitung(0, 1, 0, "berawan");
        int jumlahHR010 = hitung(0, 1, 0, "hujan ringan");

        int jumlahC001 = hitung(0, 0, 1, "cerah");
        int jumlahCB001 = hitung(0, 0, 1, "cerah berawan");
        int jumlahB001 = hitung(0, 0, 1, "berawan");
        int jumlahHR001 = hitung(0, 0, 1, "hujan ringan");

        int jumlahC011 = hitung(0, 1, 1, "cerah");
        int jumlahCB011 = hitung(0, 1, 1, "cerah berawan");
        int jumlahB011 = hitung(0, 1, 1, "berawan");
        int jumlahHR011 = hitung(0, 1, 1, "hujan ringan");

        int jumlahC101 = hitung(1, 0, 1, "cerah");
        int jumlahCB101 = hitung(1, 0, 1, "cerah berawan");
        int jumlahB101 = hitung(1, 0, 1, "berawan");
        int jumlahHR101 = hitung(1, 0, 1, "hujan ringan");

        int jumlahC110 = hitung(1, 1, 0, "cerah");
        int jumlahCB110 = hitung(1, 1, 0, "cerah berawan");
        int jumlahB110 = hitung(1, 1, 0, "berawan");
        int jumlahHR110 = hitung(1, 1, 0, "hujan ringan");

        int jumlahC111 = hitung(1, 1, 1, "cerah");
        int jumlahCB111 = hitung(1, 1, 1, "cerah berawan");
        int jumlahB111 = hitung(1, 1, 1, "berawan");
        int jumlahHR111 = hitung(1, 1, 1, "hujan ringan");

            Pcerah000 = P_atribut(jumlahC000, jumlahC);//Probabilitas cerah 000 = (jumlah ketika cerah 000) / jumlahcerah (exp)
            Pcerahberawan000 = P_atribut(jumlahCB000, jumlahCB);
            Pberawan000 = P_atribut(jumlahB000, jumlahB);
            Phujanringan000 = P_atribut(jumlahHR000, jumlahHR);

            Pcerah001 = P_atribut(jumlahC001, jumlahC);
            Pcerahberawan001 = P_atribut(jumlahCB001,jumlahCB);
            Pberawan001 = P_atribut(jumlahB001,jumlahB);
            Phujanringan001 = P_atribut(jumlahHR001, jumlahHR);

            Pcerah010  = P_atribut(jumlahC010 , jumlahC);
            Pcerahberawan010  = P_atribut(jumlahCB010 ,jumlahCB);
            Pberawan010 = P_atribut(jumlahB010 ,jumlahB);
            Phujanringan010  = P_atribut(jumlahHR010 , jumlahHR);

            Pcerah011  = P_atribut(jumlahC011 , jumlahC);
            Pcerahberawan011  = P_atribut(jumlahCB011 ,jumlahCB);
            Pberawan011  = P_atribut(jumlahB011 ,jumlahB);
            Phujanringan011  = P_atribut(jumlahHR011 , jumlahHR);

            Pcerah100 = P_atribut(jumlahC100, jumlahC);
            Pcerahberawan100 = P_atribut(jumlahCB100,jumlahCB);
            Pberawan100 = P_atribut(jumlahB100,jumlahB);
            Phujanringan100 = P_atribut(jumlahHR100, jumlahHR);

            Pcerah101  = P_atribut(jumlahC101 , jumlahC);
            Pcerahberawan101  = P_atribut(jumlahCB101 ,jumlahCB);
            Pberawan101  = P_atribut(jumlahB101 ,jumlahB);
            Phujanringan101  = P_atribut(jumlahHR101 , jumlahHR);

            Pcerah110  = P_atribut(jumlahC110 , jumlahC);
            Pcerahberawan110  = P_atribut(jumlahCB110 ,jumlahCB);
            Pberawan110 = P_atribut(jumlahB110 ,jumlahB);
            Phujanringan110  = P_atribut(jumlahHR110 , jumlahHR);

            Pcerah111 = P_atribut(jumlahC111, jumlahC);
            Pcerahberawan111 = P_atribut(jumlahCB111,jumlahCB);
            Pberawan111 = P_atribut(jumlahB111,jumlahB);
            Phujanringan111 = P_atribut(jumlahHR111, jumlahHR);

        totalC = Pcerah000 + Pcerah001 + Pcerah010 + Pcerah011 + Pcerah100 + Pcerah101 + Pcerah110 + Pcerah111; //ORANGE menghitung semua probabilitas cerah dari semua kondisii  TKA
        totalCB = Pcerahberawan000 + Pcerahberawan001 + Pcerahberawan010 + Pcerahberawan011 + Pcerahberawan100 + Pcerahberawan101 + Pcerahberawan110 + Pcerahberawan111;
        totalB = Pberawan000 + Pberawan001 + Pberawan010 + Pberawan011 + Pberawan100 + Pberawan101 + Pberawan110 + Pberawan111;
        totalHR = Phujanringan000 + Phujanringan001 + Phujanringan010 + Phujanringan011 + Phujanringan100 + Phujanringan101 + Phujanringan110 + Phujanringan111;

        pembagi = (totalC * (Pcerah000 + Pcerah001 + Pcerah010 + Pcerah011 + Pcerah100 + Pcerah101 + Pcerah110 + Pcerah111)) + (totalCB * (Pcerahberawan000 + Pcerahberawan001 + Pcerahberawan010 + Pcerahberawan011 + Pcerahberawan100 + Pcerahberawan101 + Pcerahberawan110 + Pcerahberawan111)) + (totalB * (Pberawan000 + Pberawan001 + Pberawan010 + Pberawan011 + Pberawan100 + Pberawan101 + Pberawan110 + Pberawan111)) + (totalHR * (Phujanringan000 + Phujanringan001 + Phujanringan010 + Phujanringan011 + Phujanringan100 + Phujanringan101 + Phujanringan110 + Phujanringan111));

    }

    public static int hitung(String[] arrVariabel, String nilaiVar) {//method untuk menghitung jumlah cuaca tertentu ( cerah ada berapa )
        int hitung = 0;
        for (int a = 0; a < arrVariabel.length; a++) {
            if (arrVariabel[a]==nilaiVar) {
                hitung++;
            }
        }
        return hitung;
    }//mencari frekuensi kondisi cerah dsb
    							//Temp			//Hum			//wind			//cuaca
    public static int hitung(int nilaiVar, int nilaiVar2, int nilaiVar3, String nilaiClass) {//
        int hitung = 0;
        for (int a = 0; a < Class.length; a++) {
            if (Temperature[a]==nilaiVar && Humidity[a]==nilaiVar2 && WindSpeed[a]==nilaiVar3 && Class[a]==nilaiClass) {
                hitung++;
            }
            //method untuk mencari frekuensi jika TKA 000 sampai 111
            //cerah tapi 010 ada berapa
        }
        return hitung;
    }//error
    								//jumlahc
    public static double P_class(int jumlah_a) {// jumlahc = frekuensi cerah
        double Pclass = (double) jumlah_a / (jumlahC + jumlahB + jumlahCB + jumlahHR);// x dibagi total sampel
        return Pclass;
        //peluang cerah cb 
    }
    								//jumlahc000, //jumlahc
    public static double P_atribut(int jumlah_a, int jumlah_b) {//menghitung probabilitas spesifik
        double Patribut = (double) jumlah_a / (jumlah_b);
        return Patribut;
        //spesifik
    }
   
}

