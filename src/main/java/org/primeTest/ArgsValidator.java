package org.primeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class ArgsValidator implements AutoCloseable {
    private final FileInputStream stream;
    public FileInputStream getStream(){
        return stream;
    }
    public ArgsValidator(String[] args) throws ProgramException {
        if (args.length != 1)
            throw new ProgramException("Invalid command line parameters");
        try{
            stream = new FileInputStream(args[0]);
        }
        catch (FileNotFoundException e){
            throw new ProgramException("Can't open input file", e);
        }
    }

    @Override
    public void close() throws Exception {
        stream.close();
    }
}
