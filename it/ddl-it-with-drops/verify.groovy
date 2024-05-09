import java.nio.file.Files
import java.nio.file.Paths
import java.nio.charset.StandardCharsets

def dialects = ["hsql", "mariadb", "postgresql"]

for (def dialect : dialects) {
    def file = new File(
        basedir, 
        String.format(
            "target/generated-resources/sql/ddl/auto/%s.sql", 
            dialect.toLowerCase()
        )
    );

    if (!file.exists()) {
        throw new FileNotFoundException(
            String.format(
                "DDL file '%s' for dialect '%s' does not exist.",
                file.getAbsolutePath(),
                dialect.toLowerCase()
            )
        )
    }

    def ddlScriptBytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
    def ddlScript = new String(ddlScriptBytes, StandardCharsets.UTF_8);

    def tables = ["persons", "reports", "companies"];

    for (def table : tables) {
        if (!ddlScript.toLowerCase().contains(
            String.format("create table %s", table)
        )) {
            throw new RuntimeException(
                String.format(
                    "DDL script does contain a create statement for table '%s'.",
                    table
                )
            )
        }

        if (
            !ddlScript.toLowerCase().contains(
                String.format("drop table if exists %s", table)
            ) 
            && !ddlScript.toLowerCase().contains(
                String.format("drop table %s if exists", table)
            )
        ) {
            throw new RuntimeException(
                String.format(
                    "DDL script %s does not contain a drop statement for table '%s'.",
                    ddlScript,       
                    table
                )
            )
        }
    }
}
