/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.wandora.topicmap.packageio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.wandora.utils.IObox;

/**
 *
 * @author akikivela
 */
public class DirectoryPackageOutput implements PackageOutput {

    private String directory = null;
    private OutputStream out;
    
    
    public DirectoryPackageOutput(String directory) {
        this.directory = directory;
    }
    
    
    @Override
    public void nextEntry(String name) throws IOException {
        if(out != null) {
            out.flush();
            out.close();
        }
        String entryName = this.directory + File.separator + name;
        File file = new File(entryName);
        IObox.createPathFor(file.getParentFile());
        out = new FileOutputStream(file);
    }

    @Override
    public void close() throws IOException {
        if(out != null) {
            out.flush();
            out.close();
        }
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                out.write(b);
            }
            @Override
            public void write(byte[] b,int off,int len) throws IOException {
                out.write(b,off,len);
            }
            @Override
            public void write(byte[] b) throws IOException {
                out.write(b);
            }
        };
    }
    
    
}
