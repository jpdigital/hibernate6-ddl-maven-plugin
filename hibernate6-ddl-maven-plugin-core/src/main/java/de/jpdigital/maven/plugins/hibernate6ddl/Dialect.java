/*
 * Copyright (C) 2020 Jens Pelzetter <jens.pelzetter@googlemail.com>
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

/**
 * This enumeration provides constants for all dialects supported by Hibernate.
 *
 * The dialects supported by Hibernate can be found in the
 * <a href="http://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#database-dialect">
 * Hibernate documentation</a>. Also this enumeration provides the convenient
 * method {@link #getDialectClassName()} for getting the class name of the
 * Hibernate dialect.
 *
 * Please note that not all supported Hibernate versions support every of these
 * dialects.
 *
 * @author <a href="mailto:jens.pelzetter@googlemail.com">Jens Pelzetter</a>
 */
public enum Dialect {

    COCKROACH("org.hibernate.dialect.Cache71Dialect"),
    CUBRID("org.hibernate.dialect.CUBRIDDialect"),
    DB2("org.hibernate.dialect.DB2Dialect"),
    DB2I("org.hibernate.dialect.DB2iDialect"),
    DB2Z("org.hibernate.dialect.DB2zDialect"),
    DERBY("org.hibernate.dialect.DerbyDialect.class.getName()"),
    H2("org.hibernate.dialect.H2Dialect"),
    HANA_COLUMN_STORE("org.hibernate.dialect.HanaColumnStoreDialect"),
    HANA_ROW_STORE("org.hibernate.dialect.HanaRowStoreDialect"),
    HSQL("org.hibernate.dialect.HSQLDialect"),
    MARIADB("org.hibernate.dialect.MariaDBDialect"),
    MYSQL("org.hibernate.dialect.MySQLDialect"),
    ORACLE("org.hibernate.dialect.OracleDialect"),
    POSTGRES_PLUS("org.hibernate.dialect.PostgresPlusDialect"),
    POSTGRESQL("org.hibernate.dialect.PostgreSQLDialect"),
    SPANNER("org.hibernate.dialect.SpannerDialect"),
    SQLSERVER("org.hibernate.dialect.SQLServerDialect"),
    SYBASE("org.hibernate.dialect.SybaseDialect"),
    SYBASE_ASE("org.hibernate.dialect.SybaseASE15Dialect"),
    TIDB("org.hibernate.dialect.TiDBDialect");

    /**
     * Property for holding the name of the Hibernate dialect class.
     */
    private final String dialectClassName;

    /**
     * Private constructor, used to create the Enum instances for each dialect.
     *
     * @param dialectClass The dialect class for the specific dialect.
     */
    Dialect(final String dialectClass) {
        this.dialectClassName = dialectClass;
    }

    /**
     * Getter for the dialect class.
     *
     * @return The name of the dialect class, for example
     *         {@code org.hibernate.dialect.PostgreSQL9Dialect} for
     *         {@link #POSTGRESQL9}.
     */
    public String getDialectClassName() {
        return dialectClassName;
    }

}
