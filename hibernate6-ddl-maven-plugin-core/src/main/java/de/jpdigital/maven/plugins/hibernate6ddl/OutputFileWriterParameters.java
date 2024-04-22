/*
 * Copyright (C) 2024 Jens Pelzetter
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
package de.jpdigital.maven.plugins.hibernate6ddl;

import java.io.File;

/**
 *
 * @author <a href="mailto:jens.pelzetter@googlemail.com">Jens Pelzetter</a>
 */
public class OutputFileWriterParameters {

    private File outputDirectory;

    private String outputFileNamePrefix;

    private String outputFileNameSuffix;

    private boolean omitDialectFromFileName;

    protected OutputFileWriterParameters() {
        outputFileNamePrefix = "";
        outputFileNameSuffix = "";
        omitDialectFromFileName = false;
    }
    
    public File getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(final File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    public String getOutputFileNamePrefix() {
        return outputFileNamePrefix;
    }

    public void setOutputFileNamePrefix(final String outputFileNamePrefix) {
        this.outputFileNamePrefix = outputFileNamePrefix;
    }

    public String getOutputFileNameSuffix() {
        return outputFileNameSuffix;
    }

    public void setOutputFileNameSuffix(final String outputFileNameSuffix) {
        this.outputFileNameSuffix = outputFileNameSuffix;
    }

    public boolean isOmitDialectFromFileName() {
        return omitDialectFromFileName;
    }

    public void setOmitDialectFromFileName(final boolean omitDialectFromFileName) {
        this.omitDialectFromFileName = omitDialectFromFileName;
    }

}
