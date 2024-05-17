// Classe
abstract class Progression {
    protected long current;

    public Progression() {
        this.current = 0;
    }

    public abstract long next();

    public void reset() {
        this.current = 0;
    }
}

// Progressão Aritmética
class Aritmetica extends Progression {
    private long increment;

    public Aritmetica(long increment) {
        super();
        this.increment = increment;
    }

    public long next() {
        long nextValue = current;
        current += increment;
        return nextValue;
    }
}

// Progressão Geométrica
class Geometrica extends Progression {
    private long base;
    private long initial;

    public Geometrica(long base, long initial) {
        super();
        this.base = base;
        this.initial = initial;
        this.current = initial;
    }

    public long next() {
        long nextValue = current;
        current *= base;
        return nextValue;
    }
}

// Progressão Fibonacci
class Fibonacci extends Progression {
    private long prev;

    public Fibonacci() {
        super();
        prev = 0;
    }

    public long next() {
        if (current == 0) {
            current = 1;
            return 0;
        } else {
            long temp = current;
            current += prev;
            prev = temp;
            return prev;
        }
    }
}

// Execução
public class Main {
    public static void main(String[] args) {
        Progression arithProg = new Aritmetica(5); //Valor escolhido para a progresão (5)
        Progression geoProg = new Geometrica(2, 1);
        Progression fiboProg = new Fibonacci();

        System.out.println("Progressão Aritmética:");
        for (int i = 0; i < 5; i++) { //Quantas vezes terá de progressão (5)
            System.out.println(arithProg.next());
        }

        System.out.println("\nProgressão Geométrica:");
        for (int i = 0; i < 5; i++) {
            System.out.println(geoProg.next());
        }

        System.out.println("\nProgressão Fibonacci:");
        for (int i = 0; i < 10; i++) {
            System.out.println(fiboProg.next());
        }
    }
}
