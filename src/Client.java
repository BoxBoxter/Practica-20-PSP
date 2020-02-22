import pojo.Persona;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    private static Persona persona = new Persona("Fabio", "Cardoso");
    public static void main(String[] args) {

        try {
            enviar(persona);
        }catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage() + e.getStackTrace());
        }

    }

    private static void enviar(Persona persona) throws IOException, ClassNotFoundException {
        // Convertim objecte a bytes
        System.out.println("*Client es prepara per enviar\n[" + persona + "]");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(persona); // escrivim objecte Persona en el stream
        out.close();

        byte[] enviarDatos = baos.toByteArray(); // objecte en bytes Per convertir els bytes rebuts pel datagrama en un objecte Persona escrivim:
        InetAddress ip = InetAddress.getByName("127.0.0.1"); //Ip a la qual volem enviar
        DatagramSocket enviar = new DatagramSocket(); //Cream Objecte DatagramSocket
        DatagramPacket dp = new DatagramPacket(enviarDatos, enviarDatos.length, ip, 3000);
        //Se envien bytes aixi que transformam el misatge a un DatagramPacket que es el format que s'ha de enviar
        enviar.send(dp); //Enviam
        enviar.close(); //Tancam
        System.out.println("*Client ha enviat s'objecte.");
        recibir(); //Pasam a ara noltros escoltar
    }

    private static void recibir() throws IOException, ClassNotFoundException {
        //Recibir
        System.out.println("*Client espera resposta del servidor...");
        DatagramSocket recibir = new DatagramSocket(3001); //Escolam al port en la direccio que estic
        byte[] rebut = new byte[1024];
        DatagramPacket datagrama2 = new DatagramPacket(rebut,rebut.length);
        recibir.receive(datagrama2); // rep el datagrama
        // cal convertir array de bytes a objecte
        ByteArrayInputStream bais = new ByteArrayInputStream(rebut);
        ObjectInputStream in = new ObjectInputStream(bais);
        persona = (Persona) in.readObject(); // obtenim objecte
        System.out.println("Client rep l'bjecte\n[" + persona +"]");
        in.close();
        recibir.close(); //Tancam
    }

}
