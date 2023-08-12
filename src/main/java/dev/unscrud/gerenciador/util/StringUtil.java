package dev.unscrud.gerenciador.util;

public final class StringUtil {
    public static String CapitalizarPrimeiraLetra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
