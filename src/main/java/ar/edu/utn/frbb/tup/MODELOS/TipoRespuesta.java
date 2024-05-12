package ar.edu.utn.frbb.tup.MODELOS;

public enum TipoRespuesta {
    SI("S"),
    NO("N");

    private final String descripcion;
    TipoRespuesta(String descripcion){
        this.descripcion=descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public static TipoRespuesta fromString(String text){
        for(TipoRespuesta tipo : TipoRespuesta.values()){
            if (tipo.descripcion.equalsIgnoreCase(text)) {
                return tipo;                
            }
        }
        throw new IllegalArgumentException("No se pudo encontrar un TipoRespuesta con la descripcion: " + text);
    }
}
