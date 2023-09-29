package br.com.amanda.dao.generic;

import java.util.HashMap;
import java.util.Map;

//Classe Singleton que garante que o map será único em toda a vita da aplicação.
public class SingletonMap {

    private static SingletonMap singletonMap;

    //Contém todos os registros da aplicação. Simula o banco de dados
    protected Map<Class, Map<?, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    //garante o retorno de apenas uma instância desse objeto
    public static SingletonMap getInstance() {
        if (singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class, Map<?, ?>> getMap() {
        return this.map;
    }
}
