package beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
	private static String fileName="log.txt";
	
	public static void writeLog(String username, LocalDateTime time, String descrizione) {
		String rigaDaScrivere = "UTENTE: "+username + "; TIME: "+time.toString()+"; DESCRIZIONE: "+descrizione+".";
		
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(rigaDaScrivere);
            bufferedWriter.newLine(); // Aggiungi una nuova riga dopo il contenuto

            bufferedWriter.close(); // Chiudi il BufferedWriter

            System.out.println("Contenuto scritto nel file con successo.");
			
		}catch(IOException e) {
			System.out.println("Si è verificato un errore sulla scrittura del log");
		}
		
	}
	
	public static void resetLog() {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("");

            bufferedWriter.close(); // Chiudi il BufferedWriter

            System.out.println("File Resettato");
			
		}catch(IOException e) {
			System.out.println("Si è verificato un errore sulla scrittura del log");
		}
	}
	
}
