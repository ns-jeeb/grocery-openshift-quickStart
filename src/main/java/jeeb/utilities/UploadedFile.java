package jeeb.utilities;

import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * Created by Jeeb on 11/23/2015.
 */
public class UploadedFile implements Resource {
    File mFile;
    public UploadedFile(File file){
        mFile = file;
    }

    @Override
    public boolean exists () {
        return false;
    }

    @Override
    public boolean isReadable () {
        return false;
    }

    @Override
    public boolean isOpen () {
        return false;
    }

    @Override
    public URL getURL () throws IOException {
        return null;
    }

    @Override
    public URI getURI () throws IOException {
        return null;
    }

    @Override
    public File getFile () throws IOException {
        return mFile;
    }

    @Override
    public long contentLength () throws IOException {
        return 0;
    }

    @Override
    public long lastModified () throws IOException {
        return 0;
    }

    @Override
    public Resource createRelative (String relativePath) throws IOException {
        return null;
    }

    @Override
    public String getFilename () {
        return null;
    }

    @Override
    public String getDescription () {
        return null;
    }

    @Override
    public InputStream getInputStream () throws IOException {
        return null;
    }
}
