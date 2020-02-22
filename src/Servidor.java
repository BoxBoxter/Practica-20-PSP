import pojo.Adreça;
import pojo.Persona;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    private static Persona novaPersona = null;

    public static void main(String[] args) {
        try {
            recibir();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void recibir() throws IOException {

        try {
            //Recibir
            System.out.println("-Servidor a la escolta de peticions...");
            DatagramSocket recibir = new DatagramSocket(3000); //Escolam al port en la direccio que estic
            byte[] rebut = new byte[1024];
            DatagramPacket datagrama2 = new DatagramPacket(rebut,rebut.length);
            recibir.receive(datagrama2); // rep el datagrama
            // cal convertir array de bytes a objecte
            ByteArrayInputStream bais = new ByteArrayInputStream(rebut);
            ObjectInputStream in = new ObjectInputStream(bais);
            novaPersona = (Persona) in.readObject(); // obtenim objecte
            System.out.println("-Servidor rep l'objecte\n[" + novaPersona + "]");
            in.close();
            recibir.close(); //Tancam
            enviar();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void enviar() throws IOException {
        novaPersona.setEdat(20);
        novaPersona.setTelèfon(698745236);
        novaPersona.setCorreu("fabio@gmail.com");
        novaPersona.setAdreça(new Adreça("Carrer calle", "25", "Inca", 07300, "España"));
        System.out.println("-Servidor a afegir les noves dades ara enviara\n[" + novaPersona + "]");
        InetAddress ip = InetAddress.getByName("127.0.0.1"); //Ip a la qual volem enviar
        DatagramSocket enviar = new DatagramSocket(); //Cream Objecte DatagramSocket

        // Convertim objecte a bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(novaPersona); // escrivim objecte Persona en el stream
        out.close();
        byte[] enviarDatos = baos.toByteArray(); // objecte en bytes Per convertir els bytes rebuts pel datagrama en un objecte Persona escrivim:

        DatagramPacket dp = new DatagramPacket(enviarDatos, enviarDatos.length, ip, 3001);
        //Se envien bytes aixi que transformam el misatge a un DatagramPacket que es el format que s'ha de enviar
        enviar.send(dp); //Enviam
        enviar.close(); //Tancam
    }
}
