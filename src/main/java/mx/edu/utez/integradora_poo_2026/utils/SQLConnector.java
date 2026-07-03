package mx.edu.utez.integradora_poo_2026.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnector {

    private static HikariDataSource dataSource;

    static {
        try {
            // 1. Localizar la carpeta de la Wallet en resources
            ClassLoader classLoader = SQLConnector.class.getClassLoader();
            URL walletUrl = classLoader.getResource("Wallet.wallet/");

            if (walletUrl == null) {
                throw new RuntimeException("No se encontró la carpeta 'wallet' en resources.");
            }

            String walletPath = new File(walletUrl.toURI()).getAbsolutePath();
            walletPath = walletPath.replace("\\", "/");

            // 2. Intentar leer credenciales y nombre de BD desde el entorno
            String dbUser = System.getenv("DB_USER");
            String dbPass = System.getenv("DB_PASS");
            String dbName = System.getenv("DB_NAME");

            // 3. Si falta alguno en el entorno, buscamos en el archivo .properties
            if (dbUser == null || dbPass == null || dbName == null) {
                System.out.println("Cargando credenciales desde credentials.properties...");
                Properties creds = new Properties();
                try (InputStream is = classLoader.getResourceAsStream("credentials.properties")) {
                    if (is == null) {
                        throw new RuntimeException("No se encontró el archivo credentials.properties.");
                    }
                    creds.load(is);

                    if (dbUser == null) dbUser = creds.getProperty("db.user");
                    if (dbPass == null) dbPass = creds.getProperty("db.pass");
                    if (dbName == null) dbName = creds.getProperty("db.name");
                }
            }

            if (dbName == null) {
                throw new RuntimeException("El nombre de la base de datos (db.name) no está configurado.");
            }

            // 4. Configuración de HikariCP para Oracle
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("oracle.jdbc.OracleDriver");

            // Concatenación de la URL usando TNS_ADMIN
            config.setJdbcUrl("jdbc:oracle:thin:@" + dbName + "?TNS_ADMIN=" + walletPath);
            config.setUsername(dbUser);
            config.setPassword(dbPass);

            // Configuraciones del Pool
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setIdleTimeout(30000);
            config.setConnectionTimeout(20000);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            dataSource = new HikariDataSource(config);
            System.out.println("¡Conexión a Oracle Cloud establecida con éxito!");

        } catch (Exception e) {
            System.err.println("Error al inicializar la base de datos");
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeConnection() {
        if(dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}