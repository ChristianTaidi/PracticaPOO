package IO;

import java.io.File;
import java.io.IOException;

public interface IOStream {

    abstract public void abrir(File fich) throws IOException;
    abstract public void cerrar(File fich) throws IOException;
}
