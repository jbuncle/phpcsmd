package de.foopara.phpcsmd.exec.phpcpd;

import de.foopara.phpcsmd.ViolationRegistry;
import de.foopara.phpcsmd.debug.Logger;
import de.foopara.phpcsmd.generics.GenericHelper;
import de.foopara.phpcsmd.generics.GenericOutputReader;
import de.foopara.phpcsmd.generics.GenericViolation;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 *
 * @author nspecht
 */
public class PhpcpdParser extends GenericPhpcpdParser {

    public PhpcpdResult parse(GenericOutputReader reader, boolean updateDependencies, FileObject fo) {
        List<GenericViolation> cpdErrors = new ArrayList<GenericViolation>();
        List<GenericViolation> cpdNoTask = new ArrayList<GenericViolation>();
        Lookup lookup =  GenericHelper.getFileLookup(fo);

        try {
            char[] tmp = new char[1024];
            StringBuilder buf = new StringBuilder();
            Reader r = reader.getReader();
            while (r.read(tmp) > 0) {
                buf.append(tmp);
            }
            Logger.getInstance().logPre(buf.toString(), "Phpcpd output");
            String[] sections = buf.toString().replaceAll("\r", "").trim().split("\n\n");

            if (sections.length < 3) {
                return new PhpcpdResult(null, null, null);
            }
            if (!sections[1].trim().startsWith("Found ")) {
                return new PhpcpdResult(null, null, null);
            }
            for (int i=2; i < sections.length - 2; i++) {
                if (!sections[i].contains("duplicated lines out of")
                    && !sections[i].contains("Time: ")
                    && !sections[i].contains("Memory: ")
                    && !sections[i].contains(",")
                    && sections[i].contains("\n")
                    && sections[i].contains(":")
//                    && sections[i].matches(".*:[0-9]+-[0-9]+$")
                    && sections[i].contains("-")
                ) {
                    String[] lines = sections[i].split("\n");

                    String[] info1 = lines[0].trim().split(":");
                    StringBuilder f1 = new StringBuilder(info1[0].replaceFirst("-", "").trim());
                    for (int sectionCounter = 1; sectionCounter < info1.length - 1; sectionCounter++) {
                        f1.append(":").append(info1[sectionCounter]);
                    }
                    String[] cpdLines1 = info1[info1.length - 1].split("-");

                    String[] info2 = lines[1].trim().split(":");
                    StringBuilder f2 = new StringBuilder(info2[0].trim());
                    for (int sectionCounter = 1; sectionCounter < info2.length - 1; sectionCounter++) {
                        f2.append(":").append(info1[sectionCounter]);
                    }
                    String[] cpdLines2 = info2[info2.length - 1].split("-");

                    int start1 = Integer.parseInt(cpdLines1[0]);
                    int start2 = Integer.parseInt(cpdLines2[0]);
                    int end1 = Integer.parseInt(cpdLines1[1]);
                    int end2 = Integer.parseInt(cpdLines2[1]);
                    this.add(FileUtil.toFile(fo).getPath(), lookup, cpdErrors, cpdNoTask, f1.toString(), start1, end1, f2.toString(), start2, end2);

                    if (updateDependencies && f1.toString().compareTo(f2.toString()) != 0) {
                        ViolationRegistry.getInstance().addPhpcpdDependency(FileUtil.toFileObject(new File(f1.toString())), FileUtil.toFileObject(new File(f2.toString())));
                    }
                } else {
                    Logger.getInstance().logPre(sections[i], "malformed cpd violation");
                }
            }
        } catch (IOException ex) {
            Logger.getInstance().log(ex);
            Exceptions.printStackTrace(ex);
        } catch (Exception ex) {
            Logger.getInstance().log(ex);
        }
        return new PhpcpdResult(null, cpdErrors, cpdNoTask);
    }


}
