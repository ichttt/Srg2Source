package net.minecraftforge.srg2source.util.io;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public interface InputSupplier extends Closeable
{
    /**
     * The absolute path of the root entity of the given resource, be it a file or directory.
     * The passed resource may only be useful when there are resources from multiple roots.
     * @param resource The resource to find the root for
     * @return The absolute path of the root entity of the given resource, be it a file or directory.
     */
    String getRoot(String resource);

    /**
     * Opens an input stream to the specified resource. You are expected to close this stream yourself.
     * Returns null if the resource does not exist.
     * @param relPath Reative path seperated with '/' and having no preceding slash.
     * @return InputStream for the specified path
     */
    InputStream getInput(String relPath);

    /**
     * Gathers all the names of all the resources with the given ending in their name.
     * These paths are gaurnateed to be relative. This will never reeturn null, and return an emtpy list instead.
     * @param endFilter Filter to match the end of files names
     * @return A list containing all files matching the filter
     */
    List<String> gatherAll(String endFilter);

    /**
     * Get the encoding to be used when processing this specified resource as code.
     * If you do not know this resource, return null.
     * Returning null will default to UTF_8.
     *
     * @param resouce The resource that we will be reading.
     * @return Encoding charset, or Null if unknown.
     */
    default Charset getEncoding(String resource)
    {
        return null;
    }
}
