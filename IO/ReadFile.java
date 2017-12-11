package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile implements IOStream {
    private FileInputStream stream;
    ObjectInputStream objectIn;
    @Override
    public void abrir(File fich) throws IOException {
        stream= new FileInputStream(fich);
        objectIn = new ObjectInputStream(stream);
    }

    public Entity read(){
        try {
            return (Entity) objectIn.read();
        }catch(IOException e){
            System.out.println("Error al leer el fichero");
            e.printStackTrace();
        }
    }

    @Override
    public void cerrar(File fich) throws IOException{
        objectIn.close();
    }
}
