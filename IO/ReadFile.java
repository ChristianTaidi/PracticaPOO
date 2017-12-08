package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile implements IOStream {
    private FileInputStream stream;

    @Override
    public void abrir(File fich) throws IOException {
        stream= new FileInputStream(fich);
    }



    @Override
    public void cerrar(File fich) throws IOException{
        stream.close();
    }
}
