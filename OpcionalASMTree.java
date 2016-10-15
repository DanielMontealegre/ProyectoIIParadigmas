import java.util.*;
import java.util.stream.*;

class ArbolASM<T> {

    protected Optional<List<ArbolASM<T>>> hijos;    //Opcional con lista de arboles
    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean esHoja() {
        return !hijos.isPresent();
    }

    String toStringDatos() {
        return data.toString();
    }

    public String toStringHijos() {
        return (this.hijos.isPresent())
                ? (this.hijos.get().stream()
                        .map(e -> e.toStringDatos())
                        .reduce("", (s, e) -> s += " " + e))
                : "";
    }

    public Optional<List<ArbolASM<T>>> getHijos() {
        return hijos;
    }

    public void setHijos(List<ArbolASM<T>> hijos) {
        this.hijos = Optional.ofNullable(hijos); // If izquierdo == null sets to Optional.empty()
    }

    public void addHijo(ArbolASM<T> hijo) {
        if (!hijos.isPresent()) {
            List<ArbolASM<T>> ListaArboles = new ArrayList<>();
            ListaArboles.add(hijo);
            hijos = Optional.ofNullable(ListaArboles);
        } else {
            hijos.get().add(hijo);
        }
    }

    public ArbolASM(T data) {
        this.data = data;
        this.hijos = Optional.empty(); // not using null
    }

    public ArbolASM(T data, ArbolASM<T> hijo) {
        this.data = data;
        this.addHijo(hijo);
    }

    public ArbolASM(T data, List<ArbolASM<T>> hijos) {
        this.data = data;
        this.hijos = Optional.ofNullable(hijos);
    }
}


public class OpcionalASMTree{

	public static void main(String[] args){
      ArbolASM<String> a= new ArbolASM<>("HOLA");
	}

}
