/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.io.File;

/**
 *
 * @author Sammy
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Convenience utility to create a FilenameFilter, based on a list of extensions
 */
public class FileExtensionFilter implements FilenameFilter {
    private Set<String> exts = new HashSet<String>();

    /**
     * @param extensions
     *            a list of allowed extensions, without the dot, e.g.
     *            <code>"xml","html","rss"</code>
     */
    public FileExtensionFilter(String... extensions) {
        for (String ext : extensions) {
            exts.add("." + ext.toLowerCase().trim());
        }
    }

    public boolean accept(File dir, String name) {
        final Iterator<String> extList = exts.iterator();
        while (extList.hasNext()) {
            if (name.toLowerCase().endsWith(extList.next())) {
                return true;
            }
        }
        return false;
    }
}