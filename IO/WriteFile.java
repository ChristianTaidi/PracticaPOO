package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile implements IOStream {
    FileOutputStream stream;

    @Override
    public void abrir(File fich) throws IOException{
        stream=new FileOutputStream(fich);
    }

    @Override
    public void cerrar(File fich) throws IOException{
        stream.close();
    }
}
