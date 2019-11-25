package controlador;

import modelo.Hombre;
import modelo.Mujer;
import modelo.Persona;

import java.io.*;
import java.util.ArrayList;

public class ControlLectura {

	private static final String ubicacionBinario = "Data/binario.txt";

	public static ArrayList<Persona> lectura() throws IOException, ClassNotFoundException{
		ArrayList<Persona> lista = new ArrayList<>();
		ObjectInputStream file = new ObjectInputStream(new FileInputStream(ubicacionBinario));
		lista = (ArrayList<Persona>)file.readObject();
		file.close();
		return lista;
	}

	public static void escritura(ArrayList<Persona> arreglo) throws IOException{
		ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(ubicacionBinario));
		file.writeObject(arreglo);
	}
	//En teoria este metodo lo podriamos borrar, por que ya pasamos la informacion al binario
	public static void lecturaInicial(){
		String cadena;
		ArrayList<Persona> lista = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Data/datos.csv"), "UTF-8"));
			while((cadena = br.readLine())!=null) {
				String[] separado = cadena.split(";");
				Persona nueva = null;
        String contraseña = null;
				String[] fixed = new String[16];
				int aux = 0;
				if(separado[6].charAt(0) == '\"'){
					if (!separado[7].contains("\"") && !separado[8].contains("\"") && !separado[9].contains("\"") && separado[10].contains("\"")) {
            contraseña = separado[6] + ";" + separado[7] + ";" + separado[8] + ";" + separado[9] + ";" + separado[10];
						aux = 4;
            System.out.println(contraseña + " " + aux);
					} else if (!separado[7].contains("\"") && !separado[8].contains("\"") && separado[9].contains("\"")) {
            contraseña = separado[6] + ";" + separado[7] + ";" + separado[8] + ";" + separado[9];
						aux = 3;
            System.out.println(contraseña + " " + aux);
					} else if (!separado[7].contains("\"") && separado[8].contains("\"")) {
            contraseña = separado[6] + ";" + separado[7] + ";" + separado[8];
						aux = 2;
            System.out.println(contraseña + " " + aux);
					} else if(separado[7].contains("\"")){
            contraseña = separado[6] + ";" + separado[7];
						aux = 1;
            System.out.println(contraseña + " " + aux);

					}
				} else {
          contraseña = separado[6];
				}

				for (int i =0; i<6; i++){
					fixed[i] = separado[i];
					System.out.println(fixed[i]);
				}
        fixed[6] = contraseña;
				for (int i=7; i<16; i++){
					fixed[i] = separado[i+aux];
				}

				// 0=id
				// 1=nombre
				// 2=apellido1
				// 3=apellido2
				// 4=Sexo
				// 5=usuario
				// 6=contrase
				// 7=correo
				// 8=fecha
				// 9=edad
				// 10=ingresos
				// 11=divorcios
				// 12=recibidos
				// 13=otorgados
				// 14=matches
				// 15=estado


				if(separado[4].equals("H")){
					nueva = new Hombre(fixed[1],
							Integer.parseInt(fixed[9]),
							Integer.parseInt(fixed[0]),
							fixed[2],
							fixed[3],
							fixed[4].charAt(0),
							fixed[5],
							fixed[6],
							fixed[7],
							fixed[8],
							Integer.parseInt(fixed[12]),
							Integer.parseInt(fixed[13]),
							Integer.parseInt(fixed[14]),
							fixed[15].charAt(0),
							Double.parseDouble(fixed[10]),
							Math.random()*2);
				} else if(fixed[4].equals("M")){
					nueva = new Mujer(
							fixed[1],
							Integer.parseInt(fixed[9]),
							Integer.parseInt(fixed[0]),
							fixed[2],
							fixed[4],
							fixed[4].charAt(0),
							fixed[5],
							fixed[6],
							fixed[7],
							fixed[8],
							Integer.parseInt(fixed[12]),
							Integer.parseInt(fixed[13]),
							Integer.parseInt(fixed[14]),
							fixed[15].charAt(0),
							(fixed[11].equals("SI")));
				}
				lista.add(nueva);
			}
			escritura(lista);
			br.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
