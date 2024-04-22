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
public class OutputFileWriterBuilder implements OutputFileWriterBuildStep {

    private final OutputFileWriterParameters parameters;

    protected OutputFileWriterBuilder(final File outputDirectory) {
        parameters = new OutputFileWriterParameters();
        parameters.setOutputDirectory(outputDirectory);
    }

    public static OutputFileWriterBuildStep withOutputDirectory(
        final File outputDirectory
    ) {
        return new OutputFileWriterBuilder(outputDirectory);
    }

    @Override
    public OutputFileWriterBuildStep withFileNamePrefix(final String prefix) {
        parameters.setOutputFileNamePrefix(prefix);
        return this;
    }

    @Override
    public OutputFileWriterBuildStep withFileNameSuffix(final String suffix) {
        parameters.setOutputFileNameSuffix(suffix);
        return this;
    }

    @Override
    public OutputFileWriterBuildStep omitDialectFromFileFile(
        boolean omitDialectFromFileName
    ) {
        parameters.setOmitDialectFromFileName(omitDialectFromFileName);
        return this;
    }

    @Override
    public OutputFileWriter build() {
        return new OutputFileWriter(parameters);
    }

}
