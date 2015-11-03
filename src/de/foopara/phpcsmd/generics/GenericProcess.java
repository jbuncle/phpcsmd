package de.foopara.phpcsmd.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.netbeans.api.extexecution.ExternalProcessBuilder;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

import de.foopara.phpcsmd.debug.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author nspecht
 */
public class GenericProcess 
{

    public static GenericOutputReader run(ExternalProcessBuilder builder) {
        GenericOutputReader output = new GenericOutputReader();

        ExecutionDescriptor descriptor = new ExecutionDescriptor()
                .frontWindow(false)
                .controllable(false)
                .outProcessorFactory(output);

        ExecutionService service = ExecutionService
                .newService(builder, descriptor, "PHP Violations");
        Future<Integer> task = service.run();

        try {
            task.get();
        } catch (InterruptedException ex) {
            Logger.getInstance().log(ex);
            Exceptions.printStackTrace(ex);
        } catch (ExecutionException ex) {
            Logger.getInstance().log(ex);
            Exceptions.printStackTrace(ex);
        }

        return output;
    }

    public static GenericOutputReader[] run(String cmd, String outputFile, GenericTopComponent topComponent, Lookup lkp) {
        if (outputFile == null || outputFile.compareTo("") == 0) {
            return GenericProcess.run(cmd, new File[]{}, topComponent, lkp);
        }
        return GenericProcess.run(cmd, new File[]{new File(outputFile)}, topComponent, lkp);

    }

    public static GenericOutputReader[] run(String cmd, File[] outputFiles, GenericTopComponent topComponent, Lookup lkp) {
        FileInputStream fis = null;
        try {
            Process child = Runtime.getRuntime().exec(cmd);
            InputStream in = child.getInputStream();

            if (outputFiles.length == 0) {
                final StringBuilder tmp = new StringBuilder();
                tmp.append(getXmlStringFromInputStream(in, Charset.forName("UTF-8")));
                return new GenericOutputReader[]{new GenericOutputReader(tmp)};
            } else {
                InputStream err = child.getErrorStream();

                if (topComponent != null) {
                    final StringBuilder tmp = new StringBuilder();
                    tmp.append(getXmlStringFromInputStream(in, Charset.forName("UTF-8")));
                    topComponent.setCommandOutput(tmp.toString());
                }
                while ((err.read()) != -1) {
                } //Ich muss das auslesen, damit der Prozess wartet

                child.waitFor();
                child.exitValue();

                final HashSet<GenericOutputReader> reader = new HashSet<GenericOutputReader>();
                for (final File outputFile : outputFiles) {
                    if (GenericHelper.isDesirableFile(outputFile, lkp, false)) {
                        final StringBuilder tmp = new StringBuilder();
                        fis = new FileInputStream(outputFile);
                        tmp.append(getXmlStringFromInputStream(fis, Charset.forName("UTF-8")));
                        reader.add(new GenericOutputReader(tmp));
                        fis.close();
                    }
                }

                Object[] tmpReader = reader.toArray();
                GenericOutputReader[] res = new GenericOutputReader[tmpReader.length];
                for (int i = 0; i < tmpReader.length; i++) {
                    res[i] = (GenericOutputReader) tmpReader[i];
                }

                return res;
            }
        } catch (InterruptedException ex) {
            Logger.getInstance().log(ex);
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Logger.getInstance().log(ex);
            Exceptions.printStackTrace(ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getInstance().log(ex);
                }
            }
        }
        return new GenericOutputReader[]{};
    }

    private static String getXmlStringFromInputStream(InputStream is, Charset cs)
            throws IOException {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            InputStreamReader isr = new InputStreamReader(is, cs);
            boolean xmlstart = false;
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (xmlstart) {
                    sb.append(line);
                } else if (line.trim().startsWith("<")) {
                    xmlstart = true;
                }
            }

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

}
