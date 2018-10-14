package io.github.fernandasj.connection;

public class DaoFactory {

    public static DaoFactoryIF createFactory() {
        return new DaoFactoryBD();
    }
}
