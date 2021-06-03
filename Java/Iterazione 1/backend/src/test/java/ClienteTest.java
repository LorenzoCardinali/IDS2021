import Amuber.Carrello;
import Amuber.Viste.ICliente;
import Amuber.Users.Cliente;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClienteTest {

    @Test
    void test() throws IOException {
        /** Simulo login utilizzando la mail "germano.biagi@gmail.com" (cliente) **/
        Cliente cli1 = new Cliente("germano.biagi@gmail.com", "Germano", "Biagi", "3344564574", "Via le mani dal naso", new Carrello());

        ICliente inter = new ICliente();

        inter.ricercaProdotto(cli1);
    }


}