import java.net.*;

import javax.swing.JOptionPane;

public class Controller {

    public static String ipRMI;
    public static int puertoRMI;

    /**
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args){
        int puerto = -1;
        int maxPeticiones = -1;
        String aux = null;

        try{

            //Recibe y establece el puerto de escucha del controlador
            aux=JOptionPane.showInputDialog("Introduce el puerto de escucha del controlador\n\n*Por defecto el 8081\n");
            if(aux == null){
                System.exit(1);
            }
            else if(aux.equals("")){
                //TODO comprobar puerto por defecto
                puerto = 8081;
            }
            else{
                puerto = Integer.parseInt(aux);
            }

            //Recibe y establece el numero maximo de peticiones simultaneas
            aux = JOptionPane.showInputDialog("Introduce el numero maximo de peticiones simultaneas\n\n*Por defecto 10\n");
			if(aux==null){
				System.exit(1);
			}
			else if (aux.contentEquals("")){
				maxPeticiones = 10;
			}
			else{
				maxPeticiones = Integer.parseInt(aux);
			}

            //Recibe y establece la ip del RMI
			aux = JOptionPane.showInputDialog("Introduce la ip del RMI\n\n*Por defecto la del localhost\n");
			if(aux==null){
				System.exit(1);
			}
			else if (aux.contentEquals("")){
				ipRMI = "localhost";
			}
			else{
				ipRMI = aux;
			}

            //Recibe y establece el puerto del RMI
			aux = JOptionPane.showInputDialog("Introduce el puerto del rmi\n\n*Por defecto 1099\n");
			if(aux==null){
				System.exit(1);
			}
			else if (aux.contentEquals("")){
				puertoRMI = 1099;
			}
			else{
				puertoRMI = Integer.parseInt(aux);
			}

            ServerSocket skServidor = new ServerSocket(puerto);
            System.out.println("Escucho el puerto: " + puerto);
			System.out.println("Numero maximo de peticiones: " + maxPeticiones);
			JOptionPane.showMessageDialog(null, "Escucho el puerto: " + puerto + "\nNumero maximo de peticiones: " + maxPeticiones);

			for(;;){

				if(ControllerThread.contador < maxPeticiones){
					Socket skCliente = skServidor.accept();
					System.out.println("Sirviendo cliente...");

					Thread t = new ControllerThread(skCliente);
					t.start();
				}
            }

        }catch(Exception e){
            System.out.println("Error: " + e.toString());
        }

    }
}