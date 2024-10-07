import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Caixa implements Comparable<Caixa> {
    private int comprimento;
    private int largura;
    private int altura;

    public Caixa(int comprimento, int largura, int altura){
        //Cria um arraylist caixa pra guardar as medidas de cada caixa
        List<Integer> caixa = new ArrayList<>();
        caixa.add(comprimento);
        caixa.add(largura);
        caixa.add(altura);

        //Ordena as medidas em ordem crescente, sendo a menor a altura, a do meio a largura e a maior o comprimento
        Collections.sort(caixa);
        this.altura = caixa.get(0);
        this.largura = caixa.get(1);
        this.comprimento = caixa.get(2);
    }

    public int getComprimento(){
        return comprimento;
    }

    public int getLargura(){
        return largura;
    }

    public int getAltura(){
        return altura;
    }

    @Override
    public int compareTo(Caixa other) {
        if (this.comprimento != other.comprimento) return Integer.compare(this.comprimento, other.comprimento);
        if (this.largura != other.largura) return Integer.compare(this.largura, other.largura);
        return Integer.compare(this.altura, other.altura);
    }

    public boolean canFitInside(Caixa other) {
        return this.comprimento < other.comprimento && this.largura < other.largura && this.altura < other.altura;
    }

    @Override
    public String toString() {
        return "Comprimento: " + comprimento + ", Largura: " + largura + ", Altura: " + altura;
    }
}

